FROM java:8-jre
MAINTAINER shirx <shirx@qq.com>
ADD ./target/microservice-eureka-talk-0.0.1-SNAPSHOT.jar \
         /app/microservice-eureka-talk.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-talk.jar"]
EXPOSE 8140
