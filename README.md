# abdul-tomcat-10-java-crud

Modified from https://github.com/IsuruX98/Basic-Java-CRUD.git to support maven build and tomcat 10.1.x

Run a mariaDB instance and as root user (for now), Execute the following commands (Replace the Variable <DATABASE_NAME> with some ame of your choice :

MariaDB> CREATE DATABASE <DATABASE_NAME>;

MariaDB> USE <DATABASE_NAME>;

> CREATE TABLE users(userid INT NOT NULL AUTO_INCREMENT,uname VARCHAR(50) NOT NULL,upwd VARCHAR(60) NOT NULL,uemail VARCHAR(30) NOT NULL,umobile VARCHAR(10) NOT NULL, type VARCHAR(5) NOT NULL DEFAULT 'user', PRIMARY KEY(userid));

==
Clone this repository

==

Then edit the file java-crud-new/src/main/java/registration/DBConnect.java

and replace the following variables as per their suitable run-time values :

<DB_SERVER_NAME_OR_IP>
<DB_PORT>
<DB_NAME>
<MYSQL_ROOT_PASSWD>

==============

Finally, build the War file to be deployed in Tomcat 10.1.x webapps/folder


$ cd java-crud-new
$ mvn package

Check for the war file in java-crud-new/target folder and deploy that to Tomcat 10.1.x

