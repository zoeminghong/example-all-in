# spring-boot-docker-service

## 使用说明

```$xslt

mvn clean package docker:build

docker run -p 8080:8080 -t gejx/spring-boot-docker-service --name docker-service 

```