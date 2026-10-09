# Micro Donation Platform

A Spring Boot web application for crowdfunding college initiatives and projects.

## Features
- User registration and management
- Campaign creation and management
- Micro-donation processing
- Progress tracking with visual indicators
- Summary reports and analytics

## Tech Stack
- **Backend**: Spring Boot (Web, Data JPA)
- **Database**: MySQL
- **Frontend**: Thymeleaf
- **Build Tool**: Maven
- **Additional**: Lombok

## Setup Instructions

### Prerequisites
- Java 17+
- MySQL Server
- Maven

### Database Setup
1. Create MySQL database:
```sql
CREATE DATABASE micro_donation_db;
```

2. Update `application.properties` with your MySQL credentials if different from:
   - Username: root
   - Password: Bharani9342

### Running the Application
1. Clone/download the project
2. Navigate to project directory
3. Run: `mvn spring-boot:run`
4. Access: http://localhost:8080

## API Endpoints

### Users
- `POST /api/users` - Create user
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID

### Campaigns
- `POST /api/campaigns` - Create campaign
- `GET /api/campaigns` - Get all campaigns
- `GET /api/campaigns/active` - Get active campaigns
- `GET /api/campaigns/{id}` - Get campaign by ID

### Donations
- `POST /api/donations` - Create donation
- `GET /api/donations` - Get all donations
- `GET /api/donations/campaign/{campaignId}` - Get donations by campaign
- `GET /api/donations/user/{userId}` - Get donations by user

## Database Schema
- **users**: User information
- **campaigns**: Donation campaigns
- **donations**: Individual donations with relationships

## Sample Usage
1. Create users via API
2. Create campaigns via API
3. Make donations via API
4. View progress on web interface at "/"