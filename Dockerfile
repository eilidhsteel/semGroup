FROM openjdk:latest
COPY ./target/semGroup-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semGroup-0.1.0.2-jar-with-dependencies.jar"]