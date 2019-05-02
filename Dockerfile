FROM java:8

MAINTAINER ivasenko.pg@gmail.com

COPY target/hotel-booking.jar .

EXPOSE 9991
ENTRYPOINT ["java","-jar","hotel-booking.jar"]



