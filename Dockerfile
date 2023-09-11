FROM openjdk:17

WORKDIR /app

EXPOSE 8080

COPY /build/libs/pink_project-0.0.1-SNAPSHOT.jar /app/pink_project.jar

ENTRYPOINT ["java", "-jar", "pink_project.jar"]
