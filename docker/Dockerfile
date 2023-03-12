FROM adoptopenjdk/openjdk11

RUN mkdir  /app
COPY ./target/*.jar /app/kruger-0.0.1-SNAPSHOT.jar

WORKDIR /app
ENTRYPOINT java -jar /app/kruger-0.0.1-SNAPSHOT.jar