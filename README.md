# Bookshelf Java API

---

#### Description:

 * Java Bookshelf API written with Spring Boot
 * Provides Interfaces to store, get, update and delete Books from a user bookshelf

---

#### Routes:
#### All Books (GET):
* localhost:8080/api/books

Json response:

Response -> Array of Book Objects
````
[
    {
        "id": 1,
        "title": "Thrive",
        "authors": [
        {
        "id": 1,
        "name": "Zolly Gallyon"
        }
        ],
        "dateOfPublication": "24-07-2012",
        "genres": [],
        "publisher": null,
    "isbn": "938323406-7"
}
]
````

#### Add Book to User(POST)
* localhost:8080/api/{userId}/add


Example:

````
    POST http://localhost:8080/api/books/BNPW5oKLRhXD2UG11EpEndBdBzy2/add
    Content-Type: application/json
    
    {
      "title": "Osmosis (Osmose)",
      "authors": ["Evania Rollett", "testAuthor1"],
      "genres": ["Comedy", "Drama", "Romance"],
      "publishers": "Thoughtbridge",
      "dateOfPublication": "2007-03-08",
      "isbn": "168923674-4"
    }
````

#### All Users (GET):
* localhost:8080/api/users

Response -> Array of User Objects

````
[
  {
    "uuid": "009BVWKVgHb0ERn3edblbJgAXwI2",
    "books": []
  }
]
````

* Add new User (POST):
* localhost:8080/api/users/add


Example:

````
    POST http://localhost:8080/api/users/add
    Content-Type: application/json
    
    {
      "uuid": "TzOF19jkvPUzEg5rWtrSHQ49Esg2"
    }
````

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