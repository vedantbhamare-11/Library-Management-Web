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
```

### Running the Application

1.  Clone the repository:

```
git clone https://github.com/yourusername/library-management.git
cd library-management
```

2.  Build and run the application using Maven:

```
mvn spring-boot:run
```

3.  Open your browser and navigate to `http://localhost:8080`.

Project Structure
-----------------

```
library-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/librarymanagement/
│   │   │       ├── controller/
│   │   │       │   ├── BookController.java
│   │   │       │   ├── UserController.java
│   │   │       │   └── SubjectController.java
│   │   │       ├── model/
│   │   │       │   ├── Book.java
│   │   │       │   ├── User.java
│   │   │       │   └── Subject.java
│   │   │       ├── repository/
│   │   │       │   ├── BookRepository.java
│   │   │       │   ├── UserRepository.java
│   │   │       │   └── SubjectRepository.java
│   │   │       ├── service/
│   │   │       │   ├── BookService.java
│   │   │       │   ├── UserService.java
│   │   │       │   └── SubjectService.java
│   │   │       └── LibraryManagementApplication.java
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   │   ├── books.html
│   │   │   │   ├── users.html
│   │   │   │   ├── subjects.html
│   │   │   └── application.properties
│   └── test/
│       └── java/
│           └── com/example/librarymanagement/
│               └── LibraryManagementApplicationTests.java
├── .gitignore
├── pom.xml
└── README.md
```

Usage
-----

### Managing Books

1.  **Add a Book**: Click on the "Add Book" button and fill in the form.
2.  **View Books**: Click on the "View All Books" button to see all books.
3.  **Edit a Book**: Click on the "Edit Book" button, enter the book ID, and modify the details.
4.  **Delete a Book**: Click on the "Delete Book" button and enter the book ID.

### Managing Users

1.  **Add a User**: Click on the "Add User" button and fill in the form.
2.  **View Users**: Click on the "View All Users" button to see all users.
3.  **Edit a User**: Click on the "Edit User" button, enter the user ID, and modify the details.
4.  **Delete a User**: Click on the "Delete User" button and enter the user ID.

### Managing Subjects

1.  **Add a Subject**: Click on the "Add Subject" button and fill in the form.
2.  **View Subjects**: Click on the "View All Subjects" button to see all subjects.
3.  **Edit a Subject**: Click on the "Edit Subject" button, enter the subject ID, and modify the details.
4.  **Delete a Subject**: Click on the "Delete Subject" button and enter the subject ID.

