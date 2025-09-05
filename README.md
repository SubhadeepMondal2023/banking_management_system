# Banking Management System

A modern full-stack banking application built with Spring Boot and React, featuring secure JWT authentication, comprehensive account management, and real-time transaction processing.

## 🏗️ Architecture

### Backend
- **Framework**: Spring Boot 3.3.2 with Java 21
- **Security**: JWT-based authentication with Spring Security
- **Database**: PostgreSQL with Spring Data JPA
- **Build Tool**: Maven

### Frontend  
- **Framework**: React with Redux Toolkit
- **Styling**: Modern CSS with Roboto font
- **State Management**: Redux for transaction and user state

## 🚀 Features

### 🔐 User Authentication & Security
- **Secure Registration**: User registration with encrypted password storage using BCrypt hashing  
- **JWT-based Login**: Stateless authentication with 24-hour token expiration and Bearer token authorization  
- **Role-based Access**: User roles management with Spring Security integration  
- **Protected Endpoints**: All banking operations require valid JWT authentication except registration and login  

### 🏦 Account Management
- **Multi-Currency Accounts**: Create and manage accounts in different currencies with unique account numbers  
- **Account Retrieval**: View all user-owned accounts with detailed balance information  
- **Account Validation**: Secure account lookup by currency code and owner verification  

### 💸 Transaction Processing
- **Fund Transfers**: Secure money transfers between accounts with sender/receiver validation  
- **Currency Conversion**: Real-time currency exchange with live exchange rates  
- **Transaction History**: Paginated transaction records with 10 transactions per page, sorted by creation date  
- **Transaction Types**: Support for account transactions, card transactions, and currency conversions with proper type classification  

### 💳 Card Services
- **Card Management**: Debit/credit card creation and management linked to user accounts  
- **Card Transactions**: Process card-based payments with transaction fee calculation  
- **Card Transaction History**: View paginated transaction history filtered by specific card ID  

### 📊 Frontend Features
- **Redux State Management**: Centralized state management for transactions with async data fetching  
- **Real-time Updates**: Automatic transaction list updates with optimistic UI updates  
- **Session Management**: JWT token storage in `sessionStorage` for persistent authentication  

## 🛠️ Technology Stack

| Component | Technology | Version |
|-----------|------------|---------|
| Backend Framework | Spring Boot | 3.3.2 |
| Java Version | OpenJDK | 21 |
| Database | PostgreSQL | Latest |
| Authentication | JWT (jjwt) | 0.12.6 |
| Frontend | React | Latest |
| State Management | Redux Toolkit | Latest |
| Build Tool | Maven | 3.x |

## 📁 Project Structure

```
banking_management_system/
├── banking/                    # Spring Boot backend
│   ├── src/main/java/com/project/banking/
│   │   ├── config/            # Security and app configuration
│   │   ├── controller/        # REST API endpoints
│   │   ├── entity/           # JPA entities
│   │   ├── repository/       # Data access layer
│   │   ├── service/          # Business logic
│   │   └── filters/          # JWT authentication filter
│   └── pom.xml               # Maven dependencies
└── client/                   # React frontend
    ├── public/               # Static assets
    ├── src/
    │   ├── features/         # Redux slices
    │   └── api/             # API integration
    └── package.json         # NPM dependencies
```

## 🔧 Setup & Installation

### Prerequisites
- Java 21 or higher
- Node.js 16+ and npm
- PostgreSQL database
- Maven 3.x

### Backend Setup
1. Clone the repository
2. Configure PostgreSQL database connection in `application.properties`
3. Navigate to the banking directory:
   ```bash
   cd banking
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the client directory:
   ```bash
   cd client
   npm install
   npm start
   ```

## 🔐 Security Features

- **JWT Authentication**: Stateless token-based authentication with HMAC SHA-256 signing
- **Password Encryption**: BCrypt password hashing with Spring Security integration
- **CORS Configuration**: Permissive CORS settings for development with all origins allowed
- **Protected Routes**: Authentication required for all banking operations with custom JWT filter

## 📊 API Endpoints

### Authentication
- `POST /user/register` - User registration with password encryption
- `POST /user/auth` - User login with JWT token generation

### Protected Endpoints (Require JWT)
- `GET /transactions?page={page}` - Paginated transaction history (10 per page)
- `GET /transactions/card/{cardId}?page={page}` - Card-specific transaction history
- `GET /transactions/account/{accountId}?page={page}` - Account-specific transaction history
- Account management endpoints for creation and retrieval
- Fund transfer and currency conversion operations

## 🗄️ Database Schema

The application uses PostgreSQL with JPA entities for:
- **Users**: Authentication, profile management, and role-based access control
- **Accounts**: Multi-currency bank accounts with unique identifiers and balances
- **Transactions**: Complete transaction history with pagination, fees, and status tracking
- **Cards**: Debit/credit card management with account linkage

## 🔄 Transaction Processing

- **Paginated History**: 10 transactions per page with descending date sorting for optimal performance
- **Multiple Types**: Account transfers, card transactions, currency conversion with proper type enumeration
- **Status Tracking**: All transactions automatically marked as COMPLETED with comprehensive audit trail
- **Fee Calculation**: Transaction fees calculated and stored for each operation

## 🚦 Getting Started

1. Ensure PostgreSQL is running and create a database named `bank_db`
2. Start the Spring Boot backend (runs on port 8080 by default)
3. Start the React frontend (runs on port 3000 by default)
4. Access the application at `http://localhost:3000`

## 📝 Development Notes

- The backend uses Lombok for reducing boilerplate code with constructor injection
- All services are transactional with proper dependency injection and error handling
- Frontend state management handled through Redux Toolkit with async thunks
- JWT tokens stored in sessionStorage for authentication persistence

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request
```
