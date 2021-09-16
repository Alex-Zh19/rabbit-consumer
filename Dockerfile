FROM openjdk:16-alpine3.13

WORKDIR /rabbit-consumer

COPY target/*.jar RabbitConsumer.jar

ENTRYPOINT ["java","-jar","/rabbit-consumer/RabbitConsumer.jar"]