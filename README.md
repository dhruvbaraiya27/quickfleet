# 🚚 QuickFleet - Courier Management Platform

QuickFleet is a secure, role-based courier management backend platform built with **Spring Boot**, **MySQL**, **JWT**, **Spring Security**, and **Docker**. It allows users to register, authenticate, book and track courier orders, while enabling admins and couriers to manage and fulfill deliveries efficiently.

---

## 🔧 Tech Stack

* **Backend**: Spring Boot, Spring Security, JWT
* **Database**: MySQL (Dockerized)
* **Build Tool**: Maven
* **Testing**: JUnit, Mockito
* **DevOps**: Jenkins, Docker
* **API Testing**: Postman
* **Version Control**: GitHub

---

## 🧠 Features Implemented

### ✅ User Authentication & Authorization

* User registration and login with **JWT-based token system**
* **Role-based access control** using `Spring Security`
* Supported roles: `CUSTOMER`, `COURIER`, `ADMIN`

### ✅ Courier Order Management APIs

* `POST /api/orders/book` — Customer books a courier
* `GET /api/orders/my` — Customer views their orders
* `PUT /api/orders/{id}/assign?courierId=` — Admin assigns a courier
* `GET /api/orders/assigned` — Courier views assigned orders
* `PUT /api/orders/{id}/status?status=` — Courier updates delivery status

### ✅ CI/CD and DevOps (as part of internship)

* Wrote Dockerfile for MySQL containerized DB
* Wrote Jenkins and Docker configuration files to assist DevOps team with automation
* Gained hands-on exposure to containerized deployments and pipeline setup

### ✅ Database Optimization

* Optimized schema structure and added indexes to reduce query time by \~10%

### ✅ Testing

* 30+ unit and integration tests using **JUnit** and **Mockito**
* Manual testing of API endpoints with **Postman**

---

## 🗂️ Project Structure

```
QuickFleet/
├── controller/              # All REST controllers
├── model/                   # JPA Entities like User, Role, CourierOrder
├── repository/              # JPA Repositories (DAO layer)
├── service/                 # Business logic, JWT, AuthService
├── config/                  # Security & JWT config
├── dto/                     # Request/response payloads
├── application.properties   # DB and app settings
├── JwtUtil.java             # Token generation & validation
└── Dockerfile (MySQL)       # Containerized database setup
```

---

## 🔑 Roles Explained

| Role     | Permissions                                      |
| -------- | ------------------------------------------------ |
| CUSTOMER | Register, Login, Book courier, View own bookings |
| COURIER  | View assigned orders, Update delivery status     |
| ADMIN    | Assign orders to couriers                        |

---

## 🚀 Running the Project

### 🛠️ Prerequisites

* Docker installed
* MySQL Workbench (optional)
* Java 17+
* Maven

### 🐳 Start MySQL using Docker

```bash
docker build -t custom-mysql .
docker run --name quickfleet-db -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 custom-mysql
```

### ▶️ Run Spring Boot App

```bash
./mvnw spring-boot:run
```

---

## 📬 Postman Collection

* Use `POST /api/auth/register` to register with roles
* Then login via `POST /api/auth/login` and use the token in `Authorization: Bearer <token>`

---

## 📌 Future Enhancements

* Email notifications for order updates
* Admin dashboard with analytics
* Frontend using React
* Cloud deployment (AWS EC2 + RDS)

---

## 👨‍💻 Author

**Dhruv Baraiya**
Backend Developer Intern @ MD Tech Services
[LinkedIn](https://www.linkedin.com/in/dhruvbaraiya27) | [GitHub](https://github.com/dhruvbaraiya27)

---

