FROM openjdk:11-jre-slim
WORKDIR /cleaning-service-app
COPY target/cleaning-service-app.jar app.jar
CMD ["java", "-jar", "app.jar"]