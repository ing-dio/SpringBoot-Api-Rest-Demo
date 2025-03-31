# Spring Boot REST API Demo

This demo project demonstrates how to create a RESTful API using the Spring Boot framework. It includes examples of `@GetMapping`, `@PutMapping`, `@PatchMapping`, and `@DeleteMapping`, proper use of `ResponseEntity` for error handling, and the use of externalized configuration for managing API properties.

## Features

- **RESTful Endpoints**: CRUD operations for managing a list of demo customers.
- **Error Handling**: Use of `ResponseEntity` to handle API errors gracefully.
- **Externalized Configuration**: Centralized management of application properties.
- **Palindrome Check**: A utility endpoint to check how can be passed words through url with GetMapping.

## API Endpoints

### 1. Get All Customers
**Endpoint**: `GET /customers`  
**Description**: Retrieves a list of all customers.  
**Example**:
```bash
curl -X GET http://localhost:8080/customers
```

### 2. Get Customer by Name
**Endpoint**: `GET /customers/{name}`  
**Description**: Retrieves a customer by their name.  
**Example**:
```bash
curl -X GET http://localhost:8080/customers/John
```

### 3. Add a New Customer
**Endpoint**: `POST /customers`  
**Description**: Adds a new customer to the list.  
**Example**:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"id":126,"name":"Alice","email":"alice@test.com","address":"123 Main St","phone":"1234567890","password":"secure"}' http://localhost:8080/customers
```

### 4. Update an Existing Customer
**Endpoint**: `PUT /customers`  
**Description**: Updates all fields of an existing customer.  
**Example**:
```bash
curl -X PUT -H "Content-Type: application/json" -d '{"id":123,"name":"John Updated","email":"john.updated@test.com","address":"New Address","phone":"9876543210","password":"newpassword"}' http://localhost:8080/customers
```

### 5. Partially Update a Customer
**Endpoint**: `PATCH /customers`  
**Description**: Updates specific fields of an existing customer.  
**Example**:
```bash
curl -X PATCH -H "Content-Type: application/json" -d '{"id":123,"email":"john.newemail@test.com"}' http://localhost:8080/customers
```

### 6. Delete a Customer
**Endpoint**: `DELETE /customers/{id}`  
**Description**: Deletes a customer by their ID.  
**Example**:
```bash
curl -X DELETE http://localhost:8080/customers/123
```

### 7. Check Palindrome
**Endpoint**: `GET /customers/palindrome/{word}`  
**Description**: Checks if a given word is a palindrome.  
**Example**:
```bash
curl -X GET http://localhost:8080/customers/palindrome/radar
```

## Error Handling

The API uses `ResponseEntity` to handle errors. For example:
- If a customer is not found, the API returns a `404 Not Found` status with an appropriate error message.
- For invalid input, the API returns a `400 Bad Request` status.

## Externalized Configuration

The application uses `application.properties` for externalized configuration. You can customize the following properties:
```properties
server.port=8080
spring.application.name=demo
```

To override these properties, create a `application.properties` or `application.yml` file in the `src/main/resources` directory.
