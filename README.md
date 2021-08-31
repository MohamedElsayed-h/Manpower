# Document

#### I will explaint the project

# Manpower Spring Boot Projekt:
*Uppgiften:
 Är gruppsarbete för att bygga Webservers app. Vi är överens att skapa HR Management System.

## I projektet finns 4 klasser:
* Employee klass.
* Department klass.
* Branch klass.
* User klass.
  *OBS*:-
* User klass skapas för att registrera användare eller logga i systemet direkt.

## Uppgiften består av:
* projektet + kod: projektet ska ha backend, frontend och MySQL.
* Dokumentation + UML.

# Dependencies i projektet:
* Spring Web:
* Thymeleaf.
* MySQL Drive.
* Spring Data JPA.  
* Koder i pom.xml är:
***
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

***

***
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

***

***
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

***

***
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

***


###Programmet ska kunna:
* spara data i MySQL (registrera sig i databasen).
* logga i med usernamn och lösenord (bekräfta logga i).
* använda frontendlogik.
* visa användarensdata liksom (medarbetare, avdelningar & branscher).


#### Scenarium:
* registrera eller logga i  användare.
* registrera en medarbetare, en avdelning eller en bransch.
* uppdatera en medarbetare, en avdelning eller en bransch.
* Ta bort en medarbetare, en avdelning eller en bransch.
* Läsa medarbetare, avdelningar eller branscher.


##### Use Cases:
* Use case 1: Användaren kan registrera sig.
* Use case 2: Användaren kan Logga in.
* Use case 3: Läsa. 
* Use case 4: Uppdatera.
* Use case 5: Skapa.
* Use case 6: Radera.

* JUnitTest:
** Spring Boot tillhandahåller en @SpringBootTest-annotering 
  som kan användas som ett alternativ till den vanliga vårtestet @ContextConfiguration-annotering
  när du behöver Spring Boot-funktioner.

***
      
      public class JunitTestUser {@Test
      public void testCreateEmployee(){
      User user=new User();
      user.setUserName("Dalila");
      user.setPassword("test");
     user.setEmail("dalila@gmail.com");
     user.setFirstname("Dalila");
     user.setLastname("Ericsson");
     User savedUser= userRepository.save(user);
    User existEmployee=testEntityManager.find(User.class,savedUser.getId() );

    }

***



