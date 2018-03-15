FROM openjdk:8-jre-alpine
COPY ./target/eureka-server-1.0.0-SNAPSHOT.jar /usr/src/eureka/
WORKDIR /usr/src/eureka
EXPOSE 8760-8770
CMD ["java", "-jar", "eureka-server-1.0.0-SNAPSHOT.jar"]
