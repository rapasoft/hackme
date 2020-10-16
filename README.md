# Hackable Java application

The purpose of this application is to show how not following the best practices for security can lead to exposure of confidential information to unauthorized user (e.g. hacker).

This is a simple Spring Boot application, also containing some frontend. What can be showcased here is:

- reading user entered information due to missing encryption (e.g. no SSL)
- performing SQL injection
- obtaining user admin password (weak/no password policy, inferior hashing function)
- etc.

## Running the application

Build using `mvn clean package` and run using `java -jar hackme*.jar`. There's a in-memory database created (see `data.sql`). You can then open browser at `http://localhost:8080` and login using username: `hframe` and password: `P4SSW0RD`.