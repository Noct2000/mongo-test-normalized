# MongoDb test REST API

This API provides a CRUD interface for a Student model, which includes two separate documents (Subject and Department). </br>
This API uses normalized relationships in mongodb. This project uses gradle instead of maven for artifact building. </br>
Gradle improves building speed.
You can easily clone and build the project using Docker, and it doesn't require any additional tools except Docker Compose. </br>
**Note**: [Here you can explore project with maven and embedded documents relationship](https://github.com/Noct2000/mongo-test)

### How to run
1) clone repository
2) run follow command in project root directory
```shell
docker compose up --build
```
3) go to http://localhost:8080/api/swagger-ui/index.html#/
