# Smart Finance Portal
A comprehensive system built with **Spring Boot**, providing secure user authentication, account management, transaction processing, and real-time currency conversion capabilities.

---

## 🎥 Demo Video

<a href="https://www.youtube.com/watch?v=CXwYpBrCdMo&cc_load_policy=1" target="_blank">
▶ Watch Demo Video on YouTube (with Subtitles)
</a>

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


## Project Overview

A secure and user-friendly banking application built with **Spring Boot** (backend) and **React** (frontend). It provides secure user authentication, account and card management, transactions, and real-time currency conversion. Use the sections below to get started and contribute.


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

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher  
- PostgreSQL database  
- Node.js (for frontend)  
- Maven (for backend build)  

### Backend Setup
```bash
# Clone repository
git clone <repo_url>

# Move to backend
cd banking

# Configure DB in application.properties
# Run application
mvn spring-boot:run
```

### Frontend Setup
```bash
cd client
npm install
npm start
```

## Contributing
Fork the repository  
Create a feature branch  
Make your changes  
Submit a pull request
