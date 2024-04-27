stop running containers

```shell
docker compose down
```

build project

```shell
mvn -f ./person-service-grpc-common/pom.xml clean install
```

```shell
mvn clean package
```

run docker compose

```shell
docker compose up -d --build
```
