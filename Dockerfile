FROM maven:3-jdk-11 as BUILDER
WORKDIR /build
COPY . .
RUN mvn package

FROM azul/zulu-openjdk-alpine:11-jre
ARG JAR_FILE_NAME
COPY --from=BUILDER /build/target/$JAR_FILE_NAME.jar /app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]