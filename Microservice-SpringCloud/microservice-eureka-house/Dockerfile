FROM java:8-jre
MAINTAINER shirx <shirx@qq.com>
ADD ./target/microservice-eureka-house-0.0.1-SNAPSHOT.jar \
         /app/microservice-eureka-house.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-house.jar"]
EXPOSE 8090
