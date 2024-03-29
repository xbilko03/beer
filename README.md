# Beer
## SYNOPSIS
Simple app that stores data about various beers and allows user to submit and read reviews about the stored beer

## DESCRIPTION
Beer is a Spring Boot (extension of the Spring framework) application for storing data about beer using Spring Data MongoDB user can also submit, view, edit and delete user-defined reviews which are stored in the same database. (limited to one review per beer)

User can interact with the application via REST API (running at localhost:8080), the initial data are loaded and saved to the database on start of the app via external source (https://random-data-api.com/api/v2/beers?size=100).

## MINIMUM REQUIREMENTS
The following versions of listed technologies are known to work:
* Sprint Boot	- 3.2.2.
* Java		- 21.0.2 (Oracle Corporation 21.0.2+13-LTS-58)
* Gradle		- 8.6

## OPERATIONS
show list of all beers:

      /beers
      
show the review of a beer with id 'x' (if it exists):

      /beers/review?id=x
      
create a new review of a beer with id 'x' with 'y'/5 stars rating and 'z' review commentary:

      /beers/review/new?id=x&rating=y&text=z
      
edit an existing review of a beer with id 'x' with 'y'/5 stars rating and 'z' review commentary:

       /beers/review/edit?id=x&rating=y&text=z
       
remove the review of a beer with id 'x':

       /beers/review/remove?id=x
       

## USE-EXAMPLE
http://localhost:8080/beers/review?id=64

## DEMONSTRATION
https://youtu.be/qaMazmFHTYU
      
## BONUS
In case we want to implement the support of multiple users (not taking authentication or authorization into account),
all the REST API operations which interact with reviews should contain a user-id parameter. This would allow the app to distinguish users. 

Also, a ReviewItem's attributes (object we store in database representing a user review) 
would also be different:

The FK (Foreign key) would no longer represent beer the user is reviewing, it would be just an identifier of the particular review. The relation of the review to a beer would be stored in a new separate attribute (i.e. beerID), the review should also keep the relation to the user that created it (i.e. userID).

It should suffice, however, for the sake of future use, we should also consider storing a list of users in our database.

## AUTHOR
Jozef Bilko (xbilko03)

## LAST-UPDATE
02/09/2024
