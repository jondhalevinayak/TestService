FROM openjdk:17-jdk-slim as build
EXPOSE 8080
ADD target/test-service.jar test-service.jar
ENTRYPOINT ["java", "-jar", "test-service.jar"]



#to run docker image fromm terminal use below command
#docker build -t test-service.jar .

#to run the docker image use below command
#docker run -p 9090:8080 test-service.jar

