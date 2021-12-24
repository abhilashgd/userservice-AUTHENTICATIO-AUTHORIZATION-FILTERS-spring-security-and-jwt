# userservice-spring-security-and-jwt
//Spring Security and JWT Implementation

//Docker commands

abhilashgd@abhilashs-Air resources % docker container run --name mysqldb -e MYSQL_ROOT_PASSWORD=letmein -d -p 3306:3306 mysql
bc07fb86ac15a3445d2b5d78f0e090f40633e0c5d94642fc5b075525fd31584c abhilashgd@abhilashs-Air resources % docker ps

docker exec -it bc07fb86ac15a3445d2b5d78f0e090f40633e0c5d94642fc5b075525fd31584c /bin/sh abhilashgd@abhilashs-Air ~ % docker exec -it bc07fb86ac15a3445d2b5d78f0e090f40633e0c5d94642fc5b075525fd31584c /bin/sh
---------------------------------------------------------------------------------------------------
//mySQL Commands inside docker container
# mysql -uroot -pletmein
mysql> create database userservice; Query OK, 1 row affected (0.03 sec)

mysql> create user 'testuser'@'%' identified by 'testpassword'; Query OK, 0 rows affected (0.03 sec)

mysql> grant all on userservice.* to 'testuser'@'%'; Query OK, 0 rows affected (0.01 sec)

mysql> show databases; // displays all databases inside the mysql container
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| userservice        |
+--------------------+

mysql> use userservice; //to connect to userservice database
Database changed

mysql> show tables; to display tables inside userservice
+-----------------------+
| Tables_in_userservice |
+-----------------------+
| hibernate_sequence    |
| role                  |
| user                  |
| user_roles            |

---------------------------------------------------------------------------------------------------
# application.properties config
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/userservice
spring.datasource.username=testuser
spring.datasource.password=testpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

#JWT AUTHENTICATION DEPENDENCY
https://mvnrepository.com/artifact/com.auth0/java-jwt

<dependency>
			<groupId>com.auth0</groupId>
			<artifactId>java-jwt</artifactId>
			<version>3.18.2</version>
		</dependency>
