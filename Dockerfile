FROM java:8

MAINTAINER ivasenko.pg@gmail.com

COPY target/home-security-0.0.1-SNAPSHOT.jar .

EXPOSE 9991
ENTRYPOINT ["java","-jar","hotel-booking-0.0.1-SNAPSHOT.jar"]



