# Bookshelf Java API

---

#### Description:

 * Java Bookshelf API written with Spring Boot
 * Provides Interfaces to store, get, update and delete Books from a user bookshelf

---

#### Run the application on local server (default port: 8080)

Requirements:

* Java runtime
  * MySQL installed (create a database called "bookshelf")
    * save your MySQL user and password in env variables
    ```shell
    export SQL_USER= <your mysql username>
    export SQL_PASSWORD= <your msql password>   
    ```
---
1. Download the ```target/bookshelf_spring-0.0.1-SNAPSHOT.jar``` file
2. In a terminal navigate to the directory where the file is and run:
   ```shell
   java -jar bookshelf_spring-0.0.1-SNAPSHOT.jar
   
   Or
   
   # to start the server on a specific port
   java -jar bookshelf_spring-0.0.1-SNAPSHOT.jar --server.port=<port number>
    
   ```
3. To check if the application is running: open
   [localhost:8080](http://localhost:8080) in your browser (or the same address with the port number that was used above)
---