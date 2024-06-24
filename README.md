# Online Shooping System Using Springboot

This is a Spring Boot application that provides a RESTful API for managing a supermarket. It includes features such as customer registration, login, and product management.

Features
Customer Registration: Register new customers.
Customer Login: Authenticate customers and generate JWT tokens.
Product Management: CRUD operations for managing products (to be implemented).
Technologies Used
Spring Boot: Framework for building Java applications.
Spring Security: For securing the application.
JWT (JSON Web Tokens): For authentication and authorization.
MariaDB: Database for storing application data.
Swagger: For API documentation.
Setup and Installation
Clone the repository

git clone https://github.com/yourusername/supermarket.git
cd supermarket
Database Configuration

Ensure MariaDB is installed and running.
Create a database named supermarket.
Update the database configuration in application.properties if necessary:
spring.datasource.url=jdbc:mariadb://localhost:3306/supermarket
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Run the application

./mvnw spring-boot:run
Access the API documentation

The Swagger UI is available at http://localhost:8080/swagger-ui/index.html.
API Endpoints
Customer Endpoints
Register a new customer

POST /customers/register
Request Body:
{
  "firstname": "John",
  "phone": "1234567890",
  "email": "john@example.com",
  "password": "yourpassword"
}
Login a customer

POST /customers/login
Request Body:
{
  "email": "john@example.com",
  "password": "yourpassword"
}
Response:
{
  "jwt": "your.jwt.token"
}
Get customer details by email

GET /customers/{email}
Response:
{
  "id": 1,
  "firstname": "John",
  "email": "john@example.com",
  "phone": "1234567890"
}
Security
The application uses JWT for securing endpoints. After logging in, use the JWT token in the Authorization header for accessing protected endpoints.

Contributing
Fork the repository
Create your feature branch (git checkout -b feature/new-feature)
Commit your changes (git commit -m 'Add new feature')
Push to the branch (git push origin feature/new-feature)
Open a pull request
License
This project is licensed under the MIT License. See the LICENSE file for details.
