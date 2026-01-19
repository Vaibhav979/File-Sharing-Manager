# 📐 Architecture — File Sharing Manager

## 1. System Overview

The File Sharing Manager is a Spring Boot–based web application that allows authenticated users to upload, store, share, and download files through a secure interface.

The system is built as a layered monolithic architecture with a clear separation between:

- Web/API layer
- Business logic
- Data persistence
- External authentication

It is designed to be simple, consistent, and easy to reason about, while exposing realistic scalability and reliability trade-offs.

## 2. High-Level Architecture
   [ Client Browser ]
   |
   v
   [ Spring Boot Application ]
   |
   v
   [ FileController ] ← HTTP requests, views, downloads
   |
   v
   [ FileService ] ← Business logic (upload, expiry, sharing)
   |
   v
   [ FileRepository ] ← JPA (CRUD abstraction)
   |
   v
   [ MySQL Database ] ← File bytes + metadata

Supporting components:

[ OAuth2 Providers ] → Google, GitHub
[ Thymeleaf Views ] → HTML rendering
[ Scheduler ] → Periodic expiry cleanup

## 3. Architectural Style

This system uses a Layered Monolith pattern. Each responsibility is separated into a dedicated layer:

- Controller: HTTP routing, request validation, view rendering, file download responses.
- Service: Core business logic: file storage, expiry, sharing Repository Database access via Spring Data JPA
- Database: Persistent system state (files and metadata)
- External: Auth User identity via OAuth2 providers

This structure keeps the codebase organized while remaining easy to debug and extend.

## 4. Core Components
### 4.1 Controller Layer

#### FileController

Handles:

- File upload requests
- File download responses
- Listing files for the UI

View rendering via Thymeleaf

This layer translates HTTP requests into service calls and returns either:

- HTML pages (for UI)
- Binary file responses (for downloads)

### 4.2 Service Layer

#### FileServiceImpl

Contains all system logic:

- Storing files
- Calculating expiry
- Retrieving files
- Converting entities to DTOs
- Running scheduled cleanup

### 4.3 Persistence Layer

#### FileRepository (JPA)

Responsible for:

- Saving file records
- Querying metadata
- Retrieving file bytes

It abstracts SQL and allows the system to remain database-agnostic at the code level.

### 4.4 Database

####  MySQL

Stores:

- File bytes (LONGBLOB)
- File name
- Upload time
- Expiry time
- Ownership and metadata

The database is the single source of truth for the system.

### 4.5 External Authentication

Spring Security with OAuth2 integrates:

- Google
- GitHub

The system does not manage passwords directly, reducing security risk.

### 4.6 Scheduler

A background job runs every 24 hour to:

- Delete expired files from the database
- This keeps storage usage bounded over time.
