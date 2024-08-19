# Coding Assignment for Lucksmith

## Project Description
This is a Java Spring Boot application that reads Drools rules from an XLS file and returns permissions via a REST API based on those rules.

## Prerequisites
- Java 8 (getestet mit `1.8.0_202`)
- Maven 3.8.6
- Docker 24.0.7

## Running the Application
1. Clone the project: `git clone https://github.com/Robert-IX/codingassignment-lucksmith.git`
2. Navigate to the project directory: `cd codingassignment-lucksmith`
3. Run Maven build: `mvn clean package`
4. Start the application: `java -jar target/codingassignment-lucksmith-0.0.1-SNAPSHOT.jar`

## Building and Running the Docker Container
1. Build the Docker image: `docker build -t codingassignment-lucksmith .`
2. Start the Docker container: `docker run -p 8080:8080 codingassignment-lucksmith`

## REST API Endpoint
- **POST** `/api/rules/execute`
    - Example Request:
      ```json
      {
        "name":"Order-01",
        "cardType":"A",
        "price":100000
      }
      ```
    - Example Response:
      ```json
      {
        "name": "Order-01",
        "cardType": "A",
        "discount": 10,
        "price": 100000
      }
      ```

## Task Description

### Test Task: Java Spring Boot with Drools and Docker

#### Task:
Create a Java Spring Boot application that reads Drools rules from an XLS file and provides permissions via a REST API. Then package the application into a Docker container.

#### Requirements:
1. **Java Spring Boot Application:**
    - Use Spring Boot to create the application.
    - Integrate Drools for rule processing.
    - Rules should be read from an XLS file.
    - The XLS file should not contain Salience.
    - Rules must be read from bottom to top.

2. **REST API:**
    - Implement a REST API that returns permissions based on the Drools rules.
    - Endpoint: `/api/rules/execute`
    - The endpoint should accept a sample request and return the corresponding permissions.

3. **Docker:**
    - Create a Dockerfile for the application.
    - Ensure the application can run in a Docker container.

#### Steps:
1. **Project Setup:**
    - Set up a new Spring Boot project.
    - Add the necessary dependencies (Spring Web, Drools, Drools Decision Tables).

2. **XLS File:**
    - Create a sample XLS file with Drools rules.

3. **Drools Configuration:**
    - Load the rules from the XLS file into the application.

4. **REST Controller:**
    - Implement a REST Controller that executes the rules and returns permissions.

5. **Docker:**
    - Create a Dockerfile and package the application into a Docker container.

#### Submission:
- Upload the complete project to a public GitHub repository.
- Ensure that a README file is present, describing the project and providing instructions for running the application and building the Docker container.
- Send the link to the GitHub repository to the following email address: [Your Email Address].

#### Bonus (Optional):
- Implement database integration (e.g., H2) and store the results of the rule processing.
- Write unit tests for the REST Controller and rule processing.

Good luck!
