FROM openjdk:16-alpine3.13

WORKDIR /rabbit-listener

COPY target/*.jar RabbitConsumer.jar

CMD ["java","-jar","/RabbitConsumer.jar"]