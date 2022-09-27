# Bookshelf Java API

## Description:

 * Java Bookshelf API written with Spring Boot
 * Provides Interfaces to store, get, update and delete Books from a user bookshelf

## Installation
### Requirements:
* Docker 

### Set up

In a terminal 

1. navigate to the project directory 

2. Start the docker daemon (e.g. Docker Desktop or Rancher Desktop)
   * If you are running the app for the first time, run `make build`
   

  * If the images already exist, the run `make start` to update the spring boot app and start the services


  * Run `make stop` to stop the services


## API Endpoints

API is available at `http://localhost:8086`


### Get all users

GET `/api/users`

Allows you to get a list of all users

Response Example
```json
[
  {
    "uuid": "009BVWKVgHb0ERn3edblbJgAXwI2",
    "books": []
  },
  {
    "uuid": "AwIfVh5nQge00jnfzxVtwL81tS42",
    "books": []
  }
]
```

### Add new user

POST `/api/users/add`
Allows you to add a new user

Needs a request body in JSON format with the following properties:


All properties are **Required**:

* `uuid` - String

Example
```json
{
  "uuid": "pfdHKkSHvJf8pbHnb0OEXcCg2k4L"
}
```

### Add new book to a users bookshelf

POST `/api/bookshelf/:id/add`

Allows you to a new book to a users bookshelf



Required Header:  
* Content-Type: application/json

Required path variable
* id - uuid of a user

Needs a request body in JSON format with the following properties:

All properties are **Required**:

* `title` - String


* `authors` - Array of Strings: [String, String, ...]


* `genres` - Array of Strings: [String, String, ...]


* `publisher` - String


* `dateOfPubliscation` - String - Format: YYYY-MM-DD 


* `isbn` - String

Example
```json
{
  "title": "Osmosis (Osmose)",
  "authors": ["Evania Rollett", "testAuthor1"],
  "genres": ["Comedy", "Drama", "Romance"],
  "publisher": "Thoughtbridge",
  "dateOfPublication": "2019-03-08",
  "isbn": "168923674-4"
}
```

### Get all bookshelf entries of a user

GET `/api/bookshelf/:id`

Returns a list of all bookshelf entries of a user = all books of a user

Response Example
```json
[
   {
      "readingStatus": 0,
      "onWishlist": false,
      "book": {
         "isbn": "168923674-4",
         "title": "Osmosis (Osmose)",
         "authors": [
            "testAuthor1",
            "Evania Rollett"
         ],
         "dateOfPublication": "08-03-2019",
         "genres": [
            "Drama",
            "Romance",
            "Comedy"
         ],
         "publisher": "Thoughtbridge"
      }
   }
]
```

### Delete bookshelf entries

DELETE `/api/bookshelf/:id/:isbn/delete`

Required path variables
   * `id` - uuid of user
   * `isbn` - book isbn

Removes a book from a users bookshelf


### Get all books

GET `/api/books`

Allows you to get a list of all books 

Response Example
```json
[
   {
      "isbn": "168923674-4",
      "title": "Osmosis (Osmose)",
      "authors": [
         "testAuthor1",
         "Evania Rollett"
      ],
      "dateOfPublication": "08-03-2019",
      "genres": [
         "Drama",
         "Romance",
         "Comedy"
      ],
      "publisher": "Thoughtbridge"
   }
]
```