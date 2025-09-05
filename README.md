# Banking Management System

A comprehensive **Banking Management System** built with **Spring Boot**, providing secure user authentication, account management, transaction processing, and real-time currency conversion capabilities.

---

## Features

### Core Banking Operations
- **User Management**: Secure user registration with **BCrypt password encryption** and **JWT-based authentication**.  
  ![Register](client/public/register.png)

- **Account Services**: Create and manage **multi-currency accounts** with unique account numbers.  
  ![Dashboard](client/public/dashboard.png)

- **Fund Transfers**: Secure money transfers between accounts with sender/receiver validation.  
  ![Transfer Funds](client/public/transfer_funds.png)

- **Transaction History**: List of recent transactions with details.  
  ![Recent Transactions](client/public/recent_transactions.png)

- **Currency Conversion**: Real-time currency exchange using live rates.  
  ![Convert](client/public/convert.png)

- **Account Card**: Visual card-based display for accounts.  
  ![Card](client/public/card.png)



### Security Features
- **JWT Token-based Stateless Authentication**: Ensures secure access to endpoints.
- **Password Encryption**: Using Spring Security’s BCrypt encoder.
- **Role-based Access Control**: Fine-grained access to resources.

---

## Tech Stack

### Backend Framework
- **Spring Boot 3.3.2** – Main application framework
- **Java 21** – Runtime platform

### Security & Authentication
- **Spring Security** – Authentication and authorization
- **JWT (jjwt 0.12.6)** – Token-based authentication

### Data Layer
- **Spring Data JPA** – ORM and repository abstraction
- **PostgreSQL** – Primary relational database

### Development Tools
- **Lombok** – Code generation and boilerplate reduction
- **Maven** – Build tool and dependency management

---

## Architecture

- **Layered Architecture**: Follows **Controller → Service → Repository** pattern for modularity.
- **Transactional Services**: Database transaction management ensures data integrity.
