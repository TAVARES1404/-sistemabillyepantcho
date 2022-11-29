FROM maven:3.6.3-adoptopenjdk-11 as buildstage
WORKDIR /workspace/app
COPY . .
RUN mvn clean install

FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
WORKDIR /app
COPY --from=buildstage /workspace/app/target/DSI2022.jar /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/DSI2022.jar"]