
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/adm-asz-shipping-1.0-SNAPSHOT.jar /app/adm-asz-shipping.jar


CMD ["java", "-jar", "adm-asz-shipping.jar"]
