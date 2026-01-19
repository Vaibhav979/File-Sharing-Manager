# 🔁 flows.md — Request & Data Flow

## 1. Overview

This document describes how requests move through the File Sharing Manager system, from the client to persistence and back.

All flows follow a synchronous request–response model and pass through the layered architecture:

### Client → Controller → Service → Repository → Database

## 2. Authentication Flow (OAuth2)

### Flow

Browser → OAuth Provider (Google/GitHub)
→ Spring Security
→ Application

### Steps

- User accesses a protected route.
- Spring Security redirects the user to Google or GitHub.
- User authenticates with the provider.
- OAuth2 provider returns an authorization token.
- Spring Security validates the token and establishes an authenticated session.
- User is allowed access to application features.

### Notes

- The application does not store passwords.
- Authentication state is handled externally by OAuth2.
- If the provider is unavailable, login fails.

## 3. File Upload Flow

### Endpoint

POST /files/upload

### Flow

Browser
→ FileController
→ FileService
→ FileRepository
→ MySQL

### Steps

- User submits a multipart form with a file.
- FileController receives the request.
- Controller forwards the file to FileService.

### Service:

- Reads file bytes
- Sets uploadTime
- Calculates expiryTime = uploadTime + 24 hours
- Creates a FileEntity
- Repository persists the entity.
- Database stores file bytes and metadata.
- Controller redirects user to the "share link" page.

### Key Characteristics

- File data and metadata are stored in a single transaction.
- Upload is blocking and synchronous.
- File expiry is time-based, not request-based.

## 4. File Download Flow

### Endpoint

GET /files/download/{id}

### Flow

Browser → FileController → FileService → FileRepository → SQL ← ← Browser (file stream)

### Steps

- User clicks a download link.
- Controller extracts file ID from the URL.
- Service fetches file data from the database.
- File bytes are wrapped in a ResponseEntity.
- HTTP headers are set:
  - Content-Disposition: attachment
- Browser downloads the file.

### Key Characteristics

- File is streamed directly from DB to client.
- No caching layer exists.
- Large files increase memory and DB load.

## 5. List Files Flow

### Endpoint

GET /files/home

### Flow

Browser → FileController → FileService → FileRepository → MySQL ←
← Thymeleaf Template → Browser

### Steps

- User visits the home page.
- Controller calls the service to retrieve all files.
- Service fetches records from the database.
- Entities are converted into DTOs.
- Controller passes data to Thymeleaf.
- HTML page is rendered and returned.

### Key Characteristics

- All records are fetched synchronously.
- No pagination or filtering.
- Performance degrades as file count grows.

## 6. Scheduled Cleanup Flow (Expiry)

### Trigger

@Scheduled task (periodic)

### Flow

Scheduler → FileService → FileRepository → MySQL

### Steps

- Scheduler runs at a fixed interval.
- Service identifies files where:
- expiryTime < currentTime
- Repository deletes expired records.
- Database removes file data and metadata.

### Important Distinction

- Files expire logically after 24 hours.
- Files are physically deleted during the next scheduler run.
- There may be a short delay between expiry and deletion.

## 7. Error Flow

### Database Failure

Controller → Service → Repository → ❌ DB

- Requests fail immediately.
- No retries or fallbacks.
- Errors propagate back to the user.

### OAuth Failure

Browser → OAuth Provider ❌

- Login fails.
- Protected routes become inaccessible.
- Application remains running.

## 8. Summary

The system uses simple, predictable request flows that are easy to reason about and debug.

This clarity comes at the cost of:

- Performance under load
- Graceful failure handling
- Scalability

These limitations are intentional and documented, making the system suitable as a learning-grade and small-scale backend system.
