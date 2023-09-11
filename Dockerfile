FROM openjdk:17

WORKDIR /app

EXPOSE 8080

COPY /build/libs/pink_project-0.0.1-SNAPSHOT.jar /app/pink_project.jar

RUN apt-get update && apt-get install -y postgresql

ENTRYPOINT ["java", "-jar", "pink_project.jar"]
