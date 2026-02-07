# 📁 File Sharing Manager

A secure full-stack file sharing system built with Spring Boot and OAuth2, enabling authenticated users to upload, share, and manage files with controlled access and automatic expiry.

---

## 🚀 Overview

File Sharing Manager is a web-based platform that allows users to securely upload and share files with other authenticated users.  
The system enforces access control, supports time-based file expiry, and automatically cleans up expired data to optimize storage and performance.

This project focuses on backend system design, security, and reliability, while providing a simple frontend interface using HTML, CSS, and JavaScript.

---

## 🏗 Architecture

Client (HTML/CSS/JS)
↓
Spring Boot Backend (REST APIs)
↓
Authentication (OAuth2 / Spring Security)
↓
MySQL Database + File Storage


- Frontend communicates with backend via REST APIs
- Spring Security handles authentication and authorization
- Files and metadata are stored securely
- Background jobs manage expiry and cleanup

---

## ⚙️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security (OAuth2)
- Spring Data JPA
- MySQL

### Frontend
- HTML
- CSS
- JavaScript

### Tools
- Maven
- Git
- REST APIs

---

## ✨ Features

- 🔐 Secure authentication using OAuth2
- 📤 File upload and download
- 👥 Controlled file sharing with access permissions
- ⏳ Time-based file expiry
- 🧹 Automated background cleanup jobs
- 📊 Optimized database usage
- 🌐 Simple and responsive web interface

---

## 🚀 Getting Started

### Prerequisites

Make sure you have:

- Java 17+
- Maven
- MySQL
- Git

---

### Installation

1. Clone the repository:

git clone https://github.com/Vaibhav979/File-Sharing-Manager.git
cd File-Sharing-Manager

Configure database in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/file_manager
spring.datasource.username=your_username
spring.datasource.password=your_password

Build and run:

mvn clean install
mvn spring-boot:run
Open in browser:

http://localhost:8080

---

## 🔒 Security Design

- OAuth2-based authentication
- Role-based access control
- Protected API endpoints
- Secure file access validation
- Prevention of unauthorized downloads

---

## 🛠 Background Cleanup System

The system runs scheduled jobs to:

- Identify expired files
- Remove unused file records
- Delete physical files from storage
- Optimize database space
- This ensures long-term stability and storage efficiency.

---

## 📈 Use Cases

- Secure document sharing
- Temporary file distribution
- Academic project submission
- Internal team file exchange

---

## 🧪 Testing

- Manual API testing using Postman
- Authentication flow validation
- Expiry and cleanup verification
- Database integrity checks

---

##🔮 Future Improvements

- Cloud storage integration (S3)
- File encryption at rest
- Admin dashboard
- Activity logging
- Dockerized deployment

## 👨‍💻 Author

Vaibhav Singh Khati
GitHub: https://github.com/Vaibhav979
LinkedIn: https://www.linkedin.com/in/vaibhav-singh-khati
