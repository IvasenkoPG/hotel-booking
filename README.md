1. Install java using terminal commands:
"sudo add-apt-repository ppa:webupd8team/java",
"sudo apt-get update -y",
"sudo apt-get install oracle-java8-installer"

2. Install MySQL using terminal commands:
"sudo apt-get update",
"sudo apt-get install mysql-server"
User name: root
Password: admin

3. Install Maven using the commands in the terminal:
"cd ~/Downloads/"
"wget http://apache.mirror.digitalpacific.com.au/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz",
"cd /opt/ && sudo tar -xzvf ~/Downloads/apache-maven-3.3.9-bin.tar.gz",
"sudo update-alternatives --install /usr/bin/mvn maven /opt/apache-maven-3.3.9/bin/mvn 1001"

From the project folder:

4. In the terminal, run the command "mvn clean package"

5. Run a command in the terminal "java -jar target/hotel-booking-0.0.1-SNAPSHOT.jar"

Run through docker:

Install the docker on the machine:





Tech stack: Java 8 , Spring Boot, Spring MVC, Spring Data, Hibernate, MySql, maven.

REST application Hotel booking

1. View list of available rooms for specified dates.
2. View rooms filtered by category.
3. Create user.
4. User can book the room for specified days.
5. User can view his booking.
6. User can get the total price of the booking for dates period.
7. View all bookings for the hotel.


*************************** Request on Endpoint ***********************************

*** Create Profile ***

Url: http://localhost:9991/api/profile

Method: Post

{
   "lastName":"Smit",
   "firstName":"Jon",
   "passport":"CG 345876",
   "email":"jon@jon.com",
   "address":"Kyiv",
   "telephone":"0457489390"
}

*** View rooms filtered by category ***

Url: http://localhost:9991/api/hotelRooms?typeRoom={category}
category = standard or comfort or lux or premium-lux

Method: Get

*** View reserved rooms filtered by category ***

Url: http://localhost:9991/api/hotelRooms/reserved?typeRoom={category}
category = standard or comfort or lux or premium-lux

Method: Get

*** View All rooms ***

Url: http://localhost:9991/api/hotelAllRooms

Method: Get

*** View Profile room ***

http://localhost:9991/api/hotelRooms/profile?passport={profile passport}

example passport = VD 345765

Method: Get

*** View Profile cost room ***

http://localhost:9991/api/hotelRooms/cost/profile?passport={profile passport}

example passport = VD 345765

Method: Get

