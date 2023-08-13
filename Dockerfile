FROM openjdk:17

WORKDIR /app

COPY /build/libs/pink_project-0.0.1-SNAPSHOT.jar /app/pink_project.jar

EXPOSE 8080

CMD java -jar pink_project.jar
