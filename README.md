# userservice-spring-security-and-jwt

//Spring Security and JWT Implementation


//Docker commands

abhilashgd@abhilashs-Air resources % docker container run --name mysqldb -e MYSQL_ROOT_PASSWORD=letmein -d -p 3306:3306 mysql   
bc07fb86ac15a3445d2b5d78f0e090f40633e0c5d94642fc5b075525fd31584c
abhilashgd@abhilashs-Air resources % docker ps

docker exec -it bc07fb86ac15a3445d2b5d78f0e090f40633e0c5d94642fc5b075525fd31584c /bin/sh
abhilashgd@abhilashs-Air ~ % docker exec -it bc07fb86ac15a3445d2b5d78f0e090f40633e0c5d94642fc5b075525fd31584c /bin/sh

# mysql -uroot -pletmein

mysql> create database userservice;
Query OK, 1 row affected (0.03 sec)

mysql> create user 'testuser'@'%' identified by 'testpassword';
Query OK, 0 rows affected (0.03 sec)

mysql> grant all on userservice.* to 'testuser'@'%';
Query OK, 0 rows affected (0.01 sec)
