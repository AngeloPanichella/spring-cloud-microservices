FROM openjdk
MAINTAINER Angelo Panichella <angelo.panichella@gmail.com>
ADD target/authentication-service.jar authentication-service.jar
ENTRYPOINT ["java", "-jar", "/authentication-service.jar"]
EXPOSE 4444