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

In application.properties commit row 10

From the project folder:


4. In the terminal, run the command "mvn clean package"

5. Run a command in the terminal "java -jar target/hotel-booking-0.0.1-SNAPSHOT.jar"

Run through docker:

Install the docker on the machine:
Docker:
https://docs.docker.com/install/linux/docker-ce/ubuntu/

1. In application.properties commit row 9

Run docker:
docker run --name db -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=hotelDB -e MYSQL_USER=root -e MYSQ_PASSWORD=admin -d mysql:5.7

docker build . -t hotel-booking

sudo docker run -p 9991:9991 --name hotel-booking --link db:mysql hotel-booking




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

*** View list of available rooms ***

Url: http://localhost:9991/api/hotelRooms/free?startDateClient = '2019-09-05'&finishDateClient = '2019-09-13'

example startDateClient = '2019-09-05'
        finishDateClient = '2019-09-13'
        
Method: Get

*** View rooms filtered by category ***

Url: http://localhost:9991/api/hotelRooms?typeRoom={category}
category = standard or comfort or lux or premium-lux

Method: Get

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


*** Profile booking the room for specified days ***

Url: http://localhost:9991/api/reservation

Method: Post

{
   "startDate":"2019-11-23",
   "finishDate":"2019-11-30",
   "priceRoomCount":3500,
   "additionalPriceForOptionCount":406,
   "hotelRooms":{"id":10},
   "profiles":{"id":6}
}

*** View Profile room ***

Url:http://localhost:9991/api/hotelRooms/profile?passport={profile passport}

example passport = VD345765

Method: Get

*** View Profile cost room ***

Url:http://localhost:9991/api/hotelRooms/cost/profile?passport={profile passport}

example passport = VD345765

Method: Get

*** View All rooms ***

Url: http://localhost:9991/api/hotelAllRooms

Method: Get

*** View All profile ***

Url: http://localhost:9991/api/profiles

Method: Get

*** View Profile By passport ***

Url: http://localhost:9991/api/profile/{passport}

example passport = VD345765

Method: Get

*** Update Profile By passport ***

Url: http://localhost:9991/api/profile

Method: Get

{
    "id": 1,
    "lastName": "Hatson",
    "firstName": "David",
    "passport": "VD345765",
    "email": "david@david.com",
    "address": "London",
    "telephone": "380479873409"
}

*** Delete Profile By passport ***

Url: http://localhost:9991/api/profile/{passport}

example passport = VD345765

Method: Delete



