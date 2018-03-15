FROM openjdk:8-jre-alpine
COPY ./target/eureka-client-1.0.0-SNAPSHOT.jar /usr/src/eureka/
WORKDIR /usr/src/eureka
EXPOSE 8080-8090
CMD ["java", "-jar", "eureka-client-1.0.0-SNAPSHOT.jar"]
