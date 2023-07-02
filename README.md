# Short URL Generator API

The Short URL Generator API is a Spring Boot application that allows users to generate short URLs and automatically redirects them to the original URLs.

## Requirements

- Java 11 
- Maven 3.6.3 or higher

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database
- Spring Web
- Swagger

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

1. Clone the repository:

```bash
git https://github.com/yunusakin/shorten-url.git
```

2. Navigate to the project directory:

```bash
cd shorten-url
```

3. Build the project using Maven:

```bash
mvn clean package
```

4. Run the application:

```bash
mvn spring-boot:run
```

The application will start running on `http://localhost:8182`.

## API Documentation

The API endpoints are auto-documentable using Swagger. You can access the API documentation by visiting `http://localhost:8182/doc/swagger-ui/index.html` in your web browser.

## API Documentation

Data will be stored in h2 database. You can access H2 Panel by visiting `http://localhost:8182/su/h2-panel` in your web browser. You can find user and password in application.properties files.

## Usage

### Generate Short URL

Endpoint: `POST /api/shorten`

This endpoint generates a short URL for the provided original URL.

Request Body:

```json
{
  "originalUrl": "https://www.example.com/long-url"
}
```

Response:

```json
{
  "shortenUrl": "abc123"
}
```

### Redirect Short URL

Endpoint: `GET /api/{shortUrl}`

This endpoint redirects the user to the original URL associated with the short URL.

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.

Feel free to customize the README file further according to your project's specific details and guidelines.
