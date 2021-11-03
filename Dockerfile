FROM openjdk:16-alpine3.13

WORKDIR /rabbit-consumer

COPY build/libs/*SNAPSHOT.jar rabbit-consumer/RabbitConsumer.jar

ENTRYPOINT ["java","-jar","rabbit-consumer/RabbitConsumer.jar"]
