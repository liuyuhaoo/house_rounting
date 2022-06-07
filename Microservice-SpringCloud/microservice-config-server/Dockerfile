FROM java:8-jre
MAINTAINER shirx <shirx@qq.com>
ADD ./target/microservice-config-server-0.0.1-SNAPSHOT.jar \
         /app/microservice-config-server.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-config-server.jar"]
EXPOSE 8888
