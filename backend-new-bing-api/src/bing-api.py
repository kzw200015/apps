import asyncio

from EdgeGPT import Chatbot, ConversationStyle
from sanic import Sanic, json, empty

bot = Chatbot(proxy="socks5://127.0.0.1:7890", cookiePath=r"..\cookie.json")
app = Sanic("bing-api")
local_port = 1337


async def ask_bing(prompt: str) -> list[bool]:
    msgs = (await bot.ask(prompt=prompt, conversation_style=ConversationStyle.creative,
                          wss_link="wss://sydney.bing.com/sydney/ChatHub"))["item"]["messages"][1:]
    texts = []
    for msg in msgs:
        for card in msg["adaptiveCards"]:
            for body in card["body"]:
                if body["type"] == "TextBlock":
                    texts.append(body["text"])
    return texts


@app.post("/ask")
async def ask(request):
    prompt = request.json["prompt"]
    return json(await ask_bing(prompt))


@app.post("/reset")
async def reset(request):
    await bot.reset()
    return empty()


@app.post("/close")
async def close(request):
    await bot.close()
    return empty()


async def main():
    app.run(host='0.0.0.0', port=local_port)
    # await bot.close()


if __name__ == "__main__":
    asyncio.run(main())
