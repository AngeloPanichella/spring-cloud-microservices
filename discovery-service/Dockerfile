FROM openjdk
MAINTAINER Angelo Panichella <angelo.panichella@gmail.com>

ADD "target/discovery-service.jar" app.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]