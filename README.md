
# TaskFlow - Task Management REST API

A lightweight, high-performance RESTful web service built with
Spring Boot and Spring Data JPA to simplify daily workflow tracking.

## Features

- Create, retrieve, update, and delete tasks
- Toggle task completion status
- Filter tasks by priority
- Filter tasks by completion status
- Automatic database persistence using Spring Data JPA
- In-memory H2 database for lightweight development and testing
- Input validation for task data

## Technology Stack

- Java 21
- Spring Boot 4.0.8
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Prerequisites

- JDK 21
- Git

## Run Locally

Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/TaskFlow-SpringBoot-REST-API.git
cd TaskFlow-SpringBoot-REST-API
```

Run the application on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The API runs at:

http://localhost:8080

## REST API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/tasks | Create a task |
| GET | /api/tasks | Get all tasks |
| GET | /api/tasks/{id} | Get task by ID |
| PUT | /api/tasks/{id} | Update a task |
| PATCH | /api/tasks/{id}/toggle | Toggle task status |
| GET | /api/tasks/priority/{priority} | Filter by priority |
| GET | /api/tasks/status/{completed} | Filter by completion |
| DELETE | /api/tasks/{id} | Delete a task |

## Example Request

Create a task using POST /api/tasks:

```json
{
  "title": "Complete Java Project",
  "description": "Build and submit TaskFlow REST API",
  "priority": "HIGH"
}
```

## Database

TaskFlow uses an H2 in-memory database.
Data is temporary and normally resets when the application stops.

## Author

Ilamurugan N