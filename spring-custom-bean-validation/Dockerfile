FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/spring-custom-bean-validation*.jar spring-bean-validation.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-bean-validation.jar"]
