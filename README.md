# PersonDetail_SB_Rest_API

# First create schema in mysql with name persondetail

This is spring boot with maven application 
Once run this application 

# Swagger URL to verify rest endpoints

 http://localhost:9091/swagger-ui.html

# Postman also can use for testing rest endpoints

# Request URL (GET, POST, PUT, DELETE)

# To INSERT record in DB

Method Name : POST 
URL : http://localhost:9091/person/addPersonDetail

Request Body :

{ 
    "firstName": "Virat",
    "lastName": "Kohli" 
}

**************************************************

# To GET count of records in db

Method Name : GET
URL : http://localhost:9091/person/count

Response Body : 

Total Persons in PersonDetails Table : 1

***********************************************************

# To DELETE the record in db

Method Name : DELETE
URL : http://localhost:9091/person/delete/1

Response Body : 

Person Id removed from the PersonDetail ID :1

***********************************************************

# To GET all the records in db

Method Name : GET
URL : http://localhost:9091/person/personDetails

Response Body : 

[
  {
    "id": 1,
    "firstName": "Virat",
    "lastName": "Kohli"
  },
  {
    "id": 2,
    "firstName": "Rohit",
    "lastName": "Sharma"
  }
]

***********************************************************

# To UPDATE record in DB

Method Name : PUT
URL : http://localhost:9091/person/updatePersonDetail

Response Body :

{ 
    "id": 1,
    "firstName": "Shikhar",
    "lastName": "Dhavan" 
}

**************************************************


