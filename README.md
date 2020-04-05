# spring-boot-spock
This project is spock test for spring boot.

## how to use
If you are using intellij idea, clone this project and open this by intellij. That way, automatically, set up.
Please prepare mysql, create application.yml rewritten where necessary.
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/store
    username: username
    password: password
    driverClassName: com.mysql.jdbc.Driver
  jpa:
    database: MYSQL
    hibernate:
      ddl-auto: update

```
