# User authentication prototype
Simple project to learn basic **Kotlin + Spring Framework** features. It was not meant to be used for any other reasons, thus none security is provided. **Serious projects must use [Spring Security](https://spring.io/projects/spring-security) and other frameworks**.

## Routes

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | / | Gets all users on database
| GET | /hello| Writes a hello message on screen |
| GET | /:id | Checks for existing user with the provided id |
| DELETE | /:id | Deletes user with provided id |
| GET | /users/:username | Checks for existing user with the provided username |
| POST | /signup | Add a new user document on database |
| POST | /login | Attempt to login using information provided via request body |

## Notes
- Every `POST` request must contain a body with a valid JSON with `username` and `password`;
- The header content-type must be `application/json`.
