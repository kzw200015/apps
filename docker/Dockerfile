FROM maven:3-eclipse-temurin-17-alpine as builder

WORKDIR /build

COPY . /build

RUN mvn --batch-mode --update-snapshots package


FROM eclipse-temurin:17-jre-alpine as backend-note

COPY --from=builder /build/backend-note/target/backend-note-*.jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM eclipse-temurin:17-jre-alpine as backend-auth

COPY --from=builder /build/backend-auth/target/backend-auth-*.jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM eclipse-temurin:17-jre-alpine as backend-bot

COPY --from=builder /build/backend-bot/target/backend-bot-*.jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM eclipse-temurin:17-jre-alpine as backend-comment

COPY --from=builder /build/backend-comment/target/backend-comment-*.jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]


FROM eclipse-temurin:17-jre-alpine as backend-gateway

COPY --from=builder /build/backend-gateway/target/backend-gateway-*.jar app.jar

ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]