FROM java:8-jre
MAINTAINER shirx <shirx@qq.com>
ADD ./target/microservice-eureka-userhouserelation-0.0.1-SNAPSHOT.jar \
         /app/microservice-eureka-userhouserelation.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-userhouserelation.jar"]
EXPOSE 8081
