FROM gradle:8-jdk17-alpine as builder

WORKDIR /build

COPY . /build

RUN gradle build


FROM ibm-semeru-runtimes:open-17-jre as backend-auth

COPY --from=builder /build/backend-auth/build/libs/backend-auth-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM ibm-semeru-runtimes:open-17-jre as backend-bot

COPY --from=builder /build/backend-bot/build/libs/backend-bot-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM ibm-semeru-runtimes:open-17-jre as backend-gateway

COPY --from=builder /build/backend-gateway/build/libs/backend-gateway-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM ibm-semeru-runtimes:open-17-jre as backend-sub

COPY --from=builder /build/backend-sub/build/libs/backend-sub-[0-9].[0-9].[0-9].jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]