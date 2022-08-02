# Bookshelf Java API

---

#### Description:

 * Java Bookshelf API written with Spring Boot
 * Provides Interfaces to store, get, update and delete Books from a user bookshelf

---

#### Api Documentation with Swagger:
   * [Api Doc](http://localhost:8080/swagger-ui.html)

    
The Book Model in the swagger doc are not correct. Use this book model instead (for POST & GET):
````
{
  "authors": ["string"],
  "dateOfPublication": "string",
  "genres": ["string"],
  "isbn": "string",
  "publisher": "string",
  "title": "string"
}
````

---

[//]: # (#### Run the application on local server &#40;default port: 8080&#41;)

[//]: # ()
[//]: # (Requirements:)

[//]: # ()
[//]: # (* Java runtime)

[//]: # (  * MySQL installed &#40;create a database called "bookshelf"&#41;)

[//]: # (    * save your MySQL user and password in env variables)

[//]: # (    ```shell)

[//]: # (    export SQL_USER= <your mysql username>)

[//]: # (    export SQL_PASSWORD= <your msql password>   )

[//]: # (    ```)

[//]: # (---)

[//]: # (1. Download the ```target/bookshelf_spring-0.0.1-SNAPSHOT.jar``` file)

[//]: # (2. In a terminal navigate to the directory where the file is and run:)

[//]: # (   ```shell)

[//]: # (   java -jar bookshelf_spring-0.0.1-SNAPSHOT.jar)

[//]: # (   )
[//]: # (   Or)

[//]: # (   )
[//]: # (   # to start the server on a specific port)

[//]: # (   java -jar bookshelf_spring-0.0.1-SNAPSHOT.jar --server.port=<port number>)

[//]: # (    )
[//]: # (   ```)

[//]: # (3. To check if the application is running: open)

[//]: # (   [localhost:8080]&#40;http://localhost:8080&#41; in your browser &#40;or the same address with the port number that was used above&#41;)

[//]: # (---)