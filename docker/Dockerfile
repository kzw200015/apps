# Use a temurin image with jdk17 and alpine to build the jar files
FROM maven:3-eclipse-temurin-17-alpine as builder
WORKDIR /build
COPY . /build
RUN mvn --batch-mode --update-snapshots package

# Use a temurin image with jre17 and alpine to run the backend-blog jar file
FROM eclipse-temurin:17-jre-alpine as backend-blog
COPY --from=builder /build/backend-blog/target/backend-blog-*.jar app.jar
ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]

# Use a temurin image with jre17 and alpine to run the backend-auth jar file
FROM eclipse-temurin:17-jre-alpine as backend-auth
COPY --from=builder /build/backend-auth/target/backend-auth-*.jar app.jar
ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]

# Use a temurin image with jre17 and alpine to run the backend-bot jar file
FROM eclipse-temurin:17-jre-alpine as backend-bot
COPY --from=builder /build/backend-bot/target/backend-bot-*.jar app.jar
ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]

# Use a temurin image with jre17 and alpine to run the backend-comment jar file
FROM eclipse-temurin:17-jre-alpine as backend-comment
COPY --from=builder /build/backend-comment/target/backend-comment-*.jar app.jar
ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]

# Use a temurin image with jre17 and alpine to run the backend-gateway jar file
FROM eclipse-temurin:17-jre-alpine as backend-gateway
COPY --from=builder /build/backend-gateway/target/backend-gateway-*.jar app.jar
ENTRYPOINT ["java","--add-opens=java.base/java.lang.invoke=ALL-UNNAMED","-jar","/app.jar"]