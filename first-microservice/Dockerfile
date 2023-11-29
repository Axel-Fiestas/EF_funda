FROM openjdk:17-alpine
COPY ./target/first-microservice-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch first-microservice-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/first-microservice-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /first-microservice-0.0.1-SNAPSHOT.jar