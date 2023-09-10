## - Where and why you have used a @OneToMany annotation 
I have used the @OneToMany annotation in the Entity classes for Car and Member to indicate their relation to the Reservation entity. 
I annotate the reservation list attribute in the entity classes and add the "mappedBy" parameter to indicate how the entities are mapped in the Reservation class.
Here's an example from the Car entity class:
```java
   @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;
``` 
where "car" matches the Car attribute in reservations.
By using @OneToMany I indicate that a Member and a Car can be in many reservations, but a reservation can only hold a single car and a single member. 

## - Where and why you have used a @ManyToOne annotation
I have used @ManyToOne to indicate Many-To-Ione relations to Car and Member. The name I give the Car and Member attributes are used to map the entities from the other classes with the @OneToMany annotation. 
```java
  @ManyToOne
    private Member member;

    @ManyToOne
    private Car car;

``` 
By using @ManyToOne I indicate that there can only be one member and one car in a reservation.

## - The purpose of the CascadeType, FetchType and mappedBy attributes you can use with one-to-many
### CascadeType
CascadeType is used to make sure that a change in a parent entity will affect an associated child entity. For example, adding CascadeType.persist to the Member entity, if you run "memberRepository.save(Member m), the associated reservation will automatically be saved as well.
### FetchType
FetchType determines whether you recieve all the related data for an entity when you request it from the databases. FetchType.Lazy() doesn't get the related data, while FetchType.Eager() recieves everything. 
The default value for Fetchtype depends on the association:
- Lazy: @OneToMany & @ManyToMany
- Eager: @ManyToOne & @OneToOne
### MappedBy
By using MappedBy, we can have bidirectional relationships between entities. In the entities with a @OneToMany annotation, you can use mappedBy as a parameter to indicate how it's mapped to the related entity. An example from the Car entity:
```java
   @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;
``` 
Here, the Car entity is mapped to the Reservations entity through the "car" attribute in Reservations.

## - How/where you have (if done) added user defined queries to you repositories
In the repository classes, you can define custom queries by extending the repository class with the JpaRepository interface.
For example, in ReservationRepository I define a query that checks if a reservation with a certain car ID and date exists. This is done by simply naming if with the right convention that JPA defines. 
```java
     boolean existsByCar_idAndReservationDate(int carId, LocalDate reservationDate);
``` 

## - a few words, explaining what you had to do on your Azure App Service in order to make your Spring Boot App connect to your Azure MySqlDatabase
To connect our database to azure, we make sure to define the url for the database, corresponding to the connection ive've made in workbench, with the format: jdbc:mysql://xyz.xyz.xyz.xyz:3306/name_of_db. You also add your login info for the database connection. 


## - a few words about where you have used inheritance in your project, and how it's reflected in your database
I've used inheritance to add security when handling member data. The Member class inherets from the newly made UserWithRoles class. UserWithRoles handles private data such as username and password, and metadata like the creation timestamp. This class also handles the encryption for passwords. 
This results in the UserWithRoles and Member entities sharing a table in database.

## - What are the pros & cons of using the Single Table Strategy for inheritance?
Using single table strategy allows us to keep the structure of the database simple, so that you don't need to handle even more foreign keys between tables and having to use joins to get all the info for users and members.

The con is that we get a mixed table with both UserWithRoles and Members entities which means there will be a lot of null attributes since the 2 entities store different data. This gives a rather messy table. ![table](https://github.com/MeH2607/Cars/assets/113069009/8fb80eb6-cfdb-4bfa-92f0-4c4d9578d419)


## - how are passwords stored in the database with the changes suggested in part-6 of the exercise
I use BCryptPasswordEncoder to encrypt the passwords before sending them to the database. The encryption is handled by the application, which means the database will never get the unencrypted password. 
As an example, the users in DeveloperData are initialised with the password "test12", which looks like this in the database.

![image](https://github.com/MeH2607/Cars/assets/113069009/58379e93-5ede-42d8-8695-2884d45e92d4)
 
