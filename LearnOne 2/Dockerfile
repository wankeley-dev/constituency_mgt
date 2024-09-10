From maven:3.8.5-opendk-17 As build
COPY..
RUN mvn clean package -DskipTests


FROM opendk:17.0.1-jdk-slim
COPY --from=build /target/LearnOne-0.0.1-SNAPSHOT.jar LearnOne.jar
EXPOSE 8080
ENTRYPOINT["java","-jar","LearnOne.jar"]