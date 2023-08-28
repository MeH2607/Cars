## The idea with, and reasons for why to use, a ORM-mapper
 ORM is a good tool to make your work more effecient. By using an ORM Mapper, you can reduce your workload by not having to manually map out your database if you already made your entities in your code.
   
## The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected
   JPA is a set of specifications on how the entities in the code should be mapped in the database

   Hipernate is an implementation of JPA with some extra features.

   Spring Data JPA adds an extra layer on top of the JPA implementation. Spring Data JPA supplies a lot of features and code that streamlines working with JPA and reduce boilerplate code.
   
## How to create simple Java entities and map them to a database via the Spring Data API
   When making an entity class, you annotate the class with the @Entity tag. By annotating with the @Table tag, you can make and name the table belonging to the entity.
   
## How to control the mapping between individual fields in an Entity class and their matching columns in the database
   N/A
   
## How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it (Auto Increment in our case for  MySQL)
   After tagging your ID with @Id, you tag it with the @GeneratedValue tag and add a strategy that dertimnes the way IDs are generated. in our case we use the IDENTIFY tag which makes an auto incremented ID.
   
## How to use and define repositories and relevant query methods using Spring Data JPAs repository pattern
   You make a repository for an entity and have it implement the JpaRepository interface. This lets you implement several query methods from Spring Data JPA such as findById().
   
## How to write simple "integration" tests, using H2 as a mock-database instead of MySQL
   How you did that in your code
   
## How to add (dev) connection details for you local MySQL database
   How you did that
