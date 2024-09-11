FROM maven:3-amazoncorretto-21 as corretto-jdk

COPY ./ ./

RUN mvn -Dspring.profiles.active=production  clean package

FROM amazoncorretto:21-alpine

COPY --from=corretto-jdk ./target/containerize2-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]