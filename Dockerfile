FROM openjdk:latest
COPY ./target/semGroup-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semGroup-0.1.0.1-jar-with-dependencies.jar"]