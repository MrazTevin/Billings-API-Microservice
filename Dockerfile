FROM amazoncorretto:11
ADD target/springbootbackend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
