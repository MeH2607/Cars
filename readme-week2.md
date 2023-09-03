## What are the benefits of using a RESTful API
Restful api makes it very easy to set up API endpoints. With http methods like GET or PUT, it's easy to set up endpoints with CRUD functionalities.
Rest lets you have a stateless database that makes it easily expandable with distributed database systems.

## What is JSON, and why does JSON fit so well with REST?
JSON is a text based format to send and recieve data. The structure of JSON fits well with Rest cause you're able to send and recieve lists of data together and you can costumize what data you want to send or recieve for ressources.

## How you have designed simple CRUD endpoints using spring boot and DTOs to separate api from data  -> Focus on your use of DTO's
I've made 2 controller classes, for Cars and Members, which are annotated with the @Controller annotation. I label every endpoint in my controller class with an HTTP method that descripes what CRUD operation it's handling. In the endpoints I call on the Service class for the respective entities which will call the respective Repository methods that handle the calls to the database. 

I use DTOs is to have a "response" and a "request" DTO for each entity to customize the exact data that's being sent to and from my database. 
The request DTO is the data that I send to my backend, for example when I wanna make a new data entry for my car table. The DTO doesn't include the Id attribute, since that will be created in the database when it recieves the request.
The response DTO is what we'll recieve back from the database. In this program, we include a boolean variable that determines whether information such as user metadata or data about car deals should be visible.

## What is the advantage of using using DTOs to separate api from data structure when designing rest endpoints

## Explain shortly the concept mocking in relation to software testing

## How did you mock database access in your tests, using an in-memory database and/or mockito → Refer to your code

## Explain the concept Build Server and the role Github Actions play here

## Explain maven, relevant parts in maven, and how maven is used in our CI setup. Explain where maven is used by your GitHub Actions Script(s)

## Understand and chose cloud service models (IaaS, PaaS, SaaS, DBaaS)for your projects -> Just explain what you have used for this handin

