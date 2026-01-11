# Java Search Service Project

## Overview

This project is a **Java Spring Boot microservices application** consisting of two services:

1. **Inventory Service**
   - Stores a list of products with `name` and `price`.
   - Provides a REST API endpoint `/products` to fetch all products.
   - Preloads sample products on startup using `DataLoader`.

2. **Search Service**
   - Calls the Inventory Service to fetch all products.
   - Filters products priced under $50 using **Java Streams**.
   - Returns a **sorted list of product names** via `/search/cheap`.

---

## Technical Stack

- **Language:** Java 8+  
- **Framework:** Spring Boot  
- **Architecture:** Microservices  
- **Database:** H2 (in-memory, JPA-compatible)  
- **HTTP Client:** Spring WebFlux WebClient  

---

## Project Ports

| Service          | Port  | Endpoint              |
|-----------------|-------|---------------------|
| Inventory Service | 8080 | `/products`          |
| Search Service    | 8181 | `/search/cheap`      |

---

## Running the Project in Eclipse

### Steps

1. **Import the Projects**
   - Open Eclipse → File → Import → Existing Maven Projects (or Java Projects if not using Maven)  
   - Select **Inventory Service** and **Search Service** folders.

2. **Run Inventory Service**
   - Right-click `InventoryServiceApplication.java` → Run As → Spring Boot App  
   - Service starts on [http://localhost:8080/products](http://localhost:8080/products)

3. **Run Search Service**
   - Right-click `SearchServiceApplication.java` → Run As → Spring Boot App  
   - Service starts on [http://localhost:8181](http://localhost:8181)

4. **Test Search API**
   - Open a browser or Postman → `GET http://localhost:8181/search/cheap`  
   - Response will be a **sorted list of product names under $50**.

---

## Example Responses

### Inventory Service

`GET http://localhost:8080/products`

```json
[
  { "id": 1, "name": "Mouse", "price": 25 },
  { "id": 2, "name": "Keyboard", "price": 45 },
  { "id": 3, "name": "Monitor", "price": 120 },
  { "id": 4, "name": "USB Cable", "price": 10 }
]
http://localhost:8181/search/cheap
[
  "Keyboard",
  "Mouse",
  "USB Cable"
]
