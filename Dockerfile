FROM openjdk:latest
COPY ./target/SEM-CW.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM-CW.jar", "db:3306"]