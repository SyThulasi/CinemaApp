# Cinema Ticket Reservation App

## Introduction

The Cinema Ticket Reservation App is designed to facilitate the reservation of movie tickets at your cinema. It allows you to create and manage cinema profiles, add and edit movies, update seat inventory for showtimes on different days, and validate and confirm reservations. This application is built using Java 8, Spring Boot, and Gradle on the back end and Ant Design Pro with React on the front end. It follows a micro-service architecture for scalability and robustness.


## Functionalities

- **Create / Edit Cinema Profile:** As a cinema operator, you can create and edit your cinema's profile, providing essential information to customers.

- **Cinema Login:** Secure login functionality using Spring Security to protect sensitive information and functionalities.

- **Create / Edit Movies:** Easily add and edit movie details, such as titles, descriptions, release dates, and more.

- **Manage Seat Inventory:** Update seat availability for different showtimes on various show days, ensuring accurate bookings.

- **Validate and Confirm Reservations:** Implement reservation validation processes and confirm bookings to guarantee a seamless customer experience.

## Technologies and Architecture

- **Back end:** Developed using Java 8 and Spring Boot, providing a robust and scalable server-side solution.

- **Database:** PostgreSQL is used for data storage, ensuring data integrity and reliability.

- **Front end:** React is used to create an intuitive and responsive user interface.

- **Inter-back-end Communication:** Apache Kafka is employed for asynchronous communication between microservices.

- **Deployment:** Docker is used to containerize all back-end services and front-end applications, simplifying deployment and scaling.

- **Version Control:** Git.

  ## You can use docker to run this web

  - ** Front end: **docker pull sythulasi/cinema-app-front-end:v2.0 docker  **(port : 8090)
  - ** Back end: ** docker pull sythulasi/cinema-app:v2.0 **(port : 3000)
  



our app is divided into two parts: the cinema side and the user side. I have completed the cinema side, while my college has worked on the user side. These two parts are implemented as microservices, and we have connected them using apache kafka

Git Links
[Back end ](https://github.com/SathsaraniAththanayaka/CinemaApp_Customer_Backend.git)
[Front end ](https://github.com/SathsaraniAththanayaka/CinemaApp_Customer_Frontend.git)


