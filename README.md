# Library Management System

## Description

The Library Management System is a web application designed to manage a library's collection of books, users, and subjects. It allows for the addition, deletion, and modification of books, users, and subjects. The application is built using Spring Boot, Thymeleaf, and MySQL.

## Features

- **Books Management**: Add, view, edit, and delete books.
- **Users Management**: Add, view, edit, and delete users.
- **Subjects Management**: Add, view, edit, and delete subjects.

## Technologies Used

- **Backend**: Spring Boot, Spring Data JPA
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript (jQuery)
- **Database**: MySQL

## Setup Instructions

### Prerequisites

- Java 17
- Maven
- MySQL

### Database Setup

1. Create a MySQL database named `library`.
2. Update the database configurations in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
