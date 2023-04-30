FROM gradle:8-jdk17-alpine as builder

WORKDIR /build

COPY . /build

RUN gradle build


FROM eclipse-temurin:17-jre-alpine as backend-note

COPY --from=builder /build/backend-note/build/libs/backend-note-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM eclipse-temurin:17-jre-alpine as backend-auth

COPY --from=builder /build/backend-auth/build/libs/backend-auth-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM eclipse-temurin:17-jre-alpine as backend-bot

COPY --from=builder /build/backend-bot/build/libs/backend-bot-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM eclipse-temurin:17-jre-alpine as backend-gateway

COPY --from=builder /build/backend-gateway/build/libs/backend-gateway-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]