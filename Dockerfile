FROM openjdk:11

RUN mvn clean package
COPY target/uno-game-0.0.1-SNAPSHOT.jar uno-game-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/uno-game-0.0.1.jar"]