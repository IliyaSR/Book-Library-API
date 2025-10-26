# 📚 Book Library API

**Book Library API** is a RESTful backend application built with **Spring Boot** for managing books, authors, and categories.  
It demonstrates key backend development concepts such as **Spring Data JPA**, **entity relationships**, **validation**, and **RESTful API design**.

---

## 🚀 Features
- CRUD operations for **Books**, **Authors**, and **Categories**
- Entity relationships (`Author → Book`, `Category → Book`)
- Input validation using Bean Validation
- Global exception handling
- Proper HTTP status codes (200, 201, 204, 400, 404, 409)
- DTO layer to separate API models from database entities
- Optional Swagger UI for API documentation

---

## 🧱 Technologies Used

| Category | Technology |
|-----------|-------------|
| Language | Java 17+ |
| Framework | Spring Boot 3+ |
| Web | Spring Web |
| ORM | Spring Data JPA (Hibernate) |
| Database | PostgreSQL / MySQL |
| Validation | Jakarta Bean Validation |
| Utilities | Lombok |
| Documentation | Springdoc OpenAPI / Swagger UI |

---

## 🗂 Project Structure
```text
com.example.library
┣ 📂 controller → REST controllers
┣ 📂 service → business logic
┣ 📂 repository → data access layer
┣ 📂 dto → request/response models
┣ 📂 entity → JPA entities
┗ 📂 exception → global error handling
```

---

## 📘 API Endpoints

### Books
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/books` | Get all books |
| `GET` | `/api/books/{id}` | Get book by ID |
| `POST` | `/api/books` | Create a new book |
| `PUT` | `/api/books/{id}` | Update an existing book |
| `DELETE` | `/api/books/{id}` | Delete a book |

### Authors
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/authors` | Get all authors |
| `GET` | `/api/authors/{id}` | Get author by ID |
| `POST` | `/api/authors` | Create a new author |
| `PUT` | `/api/authors/{id}` | Update author info |
| `DELETE` | `/api/authors/{id}` | Delete an author |
| `GET` | `/api/authors/{id}/books` | Get books by author |

### Categories
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/categories` | Get all categories |
| `POST` | `/api/categories` | Create a new category |
| `DELETE` | `/api/categories/{id}` | Delete a category |

---

## 🧾 Example JSON (Book)

### ➕ Create Book Request
```json
POST /api/books
{
  "title": "Harry Potter and the Philosopher's Stone",
  "description": "Fantasy novel by J.K. Rowling",
  "publishYear": 1997,
  "authorId": 1,
  "categoryId": 2
}
```

### 📄 Example Response
```json
{
  "title": "Harry Potter and the Philosopher's Stone",
  "description": "Fantasy novel by J.K. Rowling",
  "publishYear": 1997,
  "author": {
    "name": "J.K. Rowling",
    "country": "England"
  },
  "category": {
    "name": "Fantasy"
  }
}
```

---

## ⚙️ Setup and Run

### 1️⃣ Clone the repository
```bash
git clone https://github.com/yourusername/book-library-api.git
cd book-library-api
```

### 2️⃣ Configure the database
Edit the `application.properties` (or `.yml`) file:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the application
```bash
./mvnw spring-boot:run
```
or start it directly from your IDE (IntelliJ IDEA / Eclipse / VS Code).

---

## ✅ HTTP Status Codes

| Code | Meaning |
|------|----------|
| `200 OK` | Successful request |
| `201 Created` | Resource created successfully |
| `204 No Content` | Resource deleted successfully |
| `400 Bad Request` | Invalid input data |
| `404 Not Found` | Resource not found |
| `409 Conflict` | Duplicate or dependent data conflict |

---

## 👨‍💻 Author
**Your Name**  
📧 *your.email@example.com*  
🔗 [GitHub Profile](https://github.com/yourusername)

---
