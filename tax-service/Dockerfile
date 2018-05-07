FROM openjdk
MAINTAINER Angelo Panichella <angelo.panichella@gmail.com>
ADD target/tax-service.jar tax-service.jar
ENTRYPOINT ["java", "-jar", "/tax-service.jar"]
EXPOSE 8888