FROM java:8-jre
MAINTAINER shirx <shirx@qq.com>
ADD ./target/microservice-eureka-user-0.0.1-SNAPSHOT.jar \
         /app/microservice-eureka-user.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-user.jar"]
EXPOSE 8081
