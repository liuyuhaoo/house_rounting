FROM java:8-jre
MAINTAINER shirx <shirx@qq.com>
ADD ./target/microservice-eureka-comment-0.0.1-SNAPSHOT.jar \
         /app/microservice-eureka-comment.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-comment.jar"]
EXPOSE 8130
