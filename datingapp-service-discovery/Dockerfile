FROM java:8-jre
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/datingapp-service-discovery-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/datingapp-service-discovery-0.0.1-SNAPSHOT.jar"]

EXPOSE 6000