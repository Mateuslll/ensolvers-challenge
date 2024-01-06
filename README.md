# Note Creation API

This API is part of the challenge for Full Stack Implementation Exercise for developers.


## Technologies Used

- Vue.js
- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI 3
- MySQL

## Adopted Practices

- SOLID, DRY, YAGNI, KISS Principles
- RESTful API
- Queries with Spring Data JPA
- Dependency Injection
- Error Response Handling
- Automatic Swagger Generation with OpenAPI 3

## How to Run BACK-END

1. **Clone Git Repository**
    ```bash
    git clone <URL_repository>
    ```

2. **Build the Project**
    ```bash
    ./mvnw clean package
    ```

3. **Run the Application**
    ```bash
    java -jar target/ensolvers-challenge-0.0.1-SNAPSHOT.jar
    ```
#### FRONT-END
1. **Run the Application**
    ```bash
    npm i
    npm run dev
    ```
The Front-End can be acessed at `http://localhost:5173/home`
The API can be accessed at `http://localhost:8080`. The Swagger documentation can be viewed at `http://localhost:8080/swagger-ui.html`.

## API Endpoints

To interact with the API, you can use the following examples with the tool `Postman` or any other API client:

### Create Note

Use this endpoint to create a new note:

#### Endpoint
```bash
$POST http://localhost:8080/notes/
{
  "id": 1,
  "name": "Plan Trip",
  "description": "Create itinerary for the next vacation",
  "confirmed": true,
  "priority": 4,
  "category": "Leisure"
}
```
Use this endpoint to List actives notes:

#### Endpoint
```bash
$GET http://localhost:8080/notes/
```

Use this endpoint to Update actives notes:

#### Endpoint
```bash
$PUT http://localhost:8080/notes/{id}
{
    "id": 3,
    "name": "Team Meeting",
    "description": "Prepare agenda for the upcoming team meeting",
    "confirmed": true,
    "priority": 3,
    "category": "Work"
}
```
Use this endpoint to Delete actives notes:

#### Endpoint
```bash
$DELETE http://localhost:8080/notes/{id}
```

Use this endpoint to List archived notes:

#### Endpoint
```bash
$GET http://localhost:8080/notes/archived
```

Use this endpoint to archive a note

#### Endpoint
```bash
$PUT http://localhost:8080/notes/archive/{id}
```
Use this endpoint to unarchive a note

#### Endpoint
```bash
$PUT http://localhost:8080/notes/unarchive/{id}
```

Use this endpoint to filter a note by category

#### Endpoint
```bash
$GET http://localhost:8080/notes/category/{category}
    example: http://localhost:8080/notes/category/Work

    {
    "id": 3,
    "name": "Team Meeting",
    "description": "Prepare agenda for the upcoming team meeting",
    "confirmed": true,
    "priority": 3,
    "category": "Work"
    }
```
Use this endpoint to remove the category from the note

#### Endpoint
```bash
$PUT http://localhost:8080/notes/{id}/remove-category
    {
    "id": 3,
    "name": "Team Meeting",
    "description": "Prepare agenda for the upcoming team meeting",
    "confirmed": true,
    "priority": 3,
    }
```

Use this endpoint to remove the category from the note

#### Endpoint
```bash
$PUT http://localhost:8080/notes/{id}/add-category/{category}
Result:
    {
    "id": 3,
    "name": "Team Meeting",
    "description": "Prepare agenda for the upcoming team meeting",
    "confirmed": true,
    "priority": 3,
    "category": "Work"
    }
```

Use this endpoint to List archive notes by category
#### Endpoint
```bash
$GET http://localhost:8080/notes/archive/{category}
Result:
    {
    "id": 3,
    "name": "Team Meeting",
    "description": "Prepare agenda for the upcoming team meeting",
    "confirmed": true,
    "priority": 3,
    "category": "Work"
    }
```

Use this endpoint to List unarchive notes by category
#### Endpoint
```bash
$GET http://localhost:8080/notes/unarchive/{category}
Result:
    {
    "id": 3,
    "name": "Team Meeting",
    "description": "Prepare agenda for the upcoming team meeting",
    "confirmed": true,
    "priority": 3,
    "category": "Work"
    }
```


















