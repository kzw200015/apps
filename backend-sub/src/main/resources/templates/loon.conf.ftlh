#default config
#Date: 2022.06.01
#Author: udp_bbr

[General]
sni-sniffing = true
ipv6 = false
skip-proxy = 192.168.0.0/16,10.0.0.0/8,172.16.0.0/12,localhost,*.local,e.crashlynatics.com
bypass-tun = 10.0.0.0/8,100.64.0.0/10,127.0.0.0/8,169.254.0.0/16,172.16.0.0/12,192.0.0.0/24,192.0.2.0/24,192.88.99.0/24,192.168.0.0/16,198.51.100.0/24,203.0.113.0/24,224.0.0.0/4,255.255.255.255/32
dns-server = system,119.29.29.29,114.114.114.114,223.5.5.5
allow-wifi-access = false
wifi-access-http-port = 7222
wifi-access-socks5-port = 7221
proxy-test-url = http://www.gstatic.com/generate_204
test-timeout = 3
interface-mode = auto

[Proxy]

[Remote Proxy]
${name} = <#noautoesc>${url}</#noautoesc>

[Proxy Group]
节点选择 = select,常用
漏网之鱼 = select,节点选择,全球直连
全球直连 = select,DIRECT
全球拦截 = select,REJECT

[Remote Filter]
常用 = NameRegex, FilterKey = "<#noautoesc>${filter}</#noautoesc>"

[Rule]
DOMAIN-SUFFIX,skytech.io,全球直连
DOMAIN-SUFFIX,steamcommunity.com,节点选择
GEOIP,CN,全球直连
FINAL,漏网之鱼

[Remote Rule]
https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/LocalAreaNetwork.listr_parser.list, policy=全球直连, tag=本地网络, enabled=true
https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/Ruleset/Steam.listr_parser.list, policy=全球直连, tag=Steam, enabled=true
https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/Ruleset/Apple.listr_parser.list, policy=全球直连, tag=Apple, enabled=true
https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/ProxyLite.listr_parser.list, policy=节点选择, tag=代理, enabled=true

[Rewrite]

[Script]

[Plugin]
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/Google.plugin, enabled=false
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/Amap_remove_ads.plugin, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/Zhihu_remove_ads.plugin, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/Remove_splash_screen_ads.plugin, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/BaiduNetDisk_remove_ads.plugin, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/WexinMiniPrograms_Remove_ads.plugin, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/Weixin_Official_Accounts_remove_ads.plugin, enabled=true
https://raw.githubusercontent.com/Xm798/Tools/main/QuanX/Rewrite/Slidebox.confqx?i=, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/Tieba_remove_ads.plugin, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/YouTube_remove_ads.plugin, enabled=true
https://raw.githubusercontent.com/BiliUniverse/ADBlock/main/modules/BiliBili.ADBlock.plugin, enabled=true
https://raw.githubusercontent.com/BiliUniverse/Enhanced/main/modules/BiliBili.Enhanced.plugin, enabled=true
https://raw.githubusercontent.com/chavyleung/scripts/master/box/rewrite/boxjs.rewrite.loon.plugin, policy=节点选择, enabled=true
https://raw.githubusercontent.com/Peng-YM/Loon-Gallery/master/loon-gallery.plugin, enabled=true
https://gitlab.com/lodepuly/vpn_tool/-/raw/main/Tool/Loon/Plugin/RemoteResourceConverter.plugin, tag=远程资源转换器, enabled=true

[Mitm]
ca-p12 = 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
ca-passphrase = U055G97P
skip-server-cert-verify = false