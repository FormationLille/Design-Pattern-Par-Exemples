# Mon tutoriel de Design Pattern - Facade

***
* Auteur : Antoine Storme
* Date de derni�re maj : 03/06/2019
* DesignPattern : Structure
***

***
    According to the Gang of Four:
Provide a unified interface to a set of interfaces in a subsystem. 
Façade defines a higher-level interface that makes the subsystem easier to use.
***
    Facade permet de rendre simple d'utilisation un (sous-)syst�me tr�s complexe.
    Pour cela, nous ajoutons une interface aux systèmes créés. Il est très fréquemment utilisé.

# Implementation

    Voici quelques exemples de la vie courante repr�sentant l'usage d'un adaptateur:
    - Vous entrez dans votre voiture. Où est la "facade" ?
    - Vous d�marrez votre ordinateur. Vous n'avez pas à gérer tous les starters.
    - Vous souhaitez changer la température chez vous, via votre superbe IHM fixée au mur, qui rend votre
    maison hyper connectée ! "Click" = température changée. On comprend vite l'intérêt d'une facade, non ?
    - 3 stations météorologiques, avec chacune leur point fort.
    On veut l'information, pas la source --> Facade.    
    Mettre le diagramme de classes


### Etape 1

    Dans l'exemple ci-dessous, nous allons �tudier une agence de voyage voulant cr�er un site
    de réservation simplifié pour le client.
    Nous allons avoir 4 classes, 4 interface, et 1 run.

    ![DiagrammeDeClasseFacade](https://user-images.githubusercontent.com/50745455/58859998-6693c280-86ab-11e9-8f1f-3264423a7db9.PNG)

### Etape 2 : Création du premier sous-système de réservation.

    Cr�er votre premi�re classe pour réserver l'avion, ainsi que son interface.

    Classe FlightBooking: FlightBooking.java
    ```java
    public class FlightBooking implements FlightBookingInterface{

        @Override
        public void book() {
            
            System.out.println("Flight booked successfully");
        }

    }
    ```

    Interface: FlightBookingInterface.java
    ```java
    public interface FlightBookingInterface {

        public void book();
    }
    ```

### Etape 3 : Création des sous-système de réservation 2 et 3.

    Cr�ation des réservation d'hotel et de taxi:

    Classe de reservation d'hotel: HotelBooking.java
    ```java
    public class HotelBooking implements HotelBookingInterface{

        @Override
        public void book() {
        
            System.out.println("Hotel booked successfully");
        }

    }
    ```

    Interface: HotelBookingInterface.java
    ```java
    public interface HotelBookingInterface {

        public void book();
    }
    ```

    Classe de reservation du taxi: TransfertBooking.java
    ```java
    public class TransfertBooking implements TransfertBookingInterface{

        @Override
        public void book() {
            
            System.out.println("Transfert booked successfully");
        }

    }
    ```

    Interface: TransfertBookingInterface.java
    ```java
    public interface TransfertBookingInterface {

        public void book();
    }
    ```

    Notre agence de voyage est satisfaite... Mais pas entièrement... Ne serait-ce pas idéal de
    pouvoir regrouper toutes ces réservations au même endroit ?

### Etape 4 : Création de notre facade.

    Nous allons donc maintenant regrouper nos fonctionnalités:

    Classe du reroupement: TravelPackageFacade.java
    ```java
    public class TravelPackageFacade implements TravelPackageInterface{

        @Override
        public void book() {
            TransfertBookingInterface transfertBookingInterface = new TransfertBooking();
            transfertBookingInterface.book();
            
            HotelBookingInterface hotelBookingInterface = new HotelBooking();
            hotelBookingInterface.book();
            
            FlightBookingInterface flightBookingInterface = new FlightBooking();
            flightBookingInterface.book();
            System.out.println("Travel package booked successfully");
        }

    }
    ```

    Et son Interface: TravelPackageInterface.java
    ```java
    public interface TravelPackageInterface {

        public void book();
    }
    ```
    
    Maintenant, nous savons que lorsqu'un TravelPackage est effectué, toutes les réservations
    sont créés. C'est quand même plus sympa comme ça non ? Et pour le client alors, ça change quoi ?

### Etape 5 

    On cr�e le main: FacadeClient.java

    ```java
    public class FacadeClient {

        public static void main(String[] args) {

            TravelPackageInterface travelPackageInterface = new TravelPackageFacade();
            travelPackageInterface.book();
        }

    }
    ```

    À la poubelle les 3 réservations différentes ! Le client n'a qu'à réserver son TravelPackage
    et le voilà prêt pour les Caraïbes !

### Etape 6

    Le r�sultat consolitique:

    ```java
    Transfert booked successfully
    Hotel booked successfully
    Flight booked successfully
    Travel package booked successfully
    ```

### Etape 7 : Avez-vous remarqu� ?

    À priori, toutes nos interfaces ne sont pas forcément utiles... Elles implémentent toutes
    uniquement la méthode "book()". Nous pourrions donc facilement ne créer qu'une interface et
    l'implémenter partout. En revanche, si par la suite les réservations venaient à évoluer
    un peu, le système est prêt à accueillir les changements, sans modifications préalables.

### Etape 8

    Vous trouverez ici les liens m'ayant permis de travailler sur ce DesignPattern:

    https://www.dineshonjava.com/facade-design-pattern/
    https://javapapers.com/design-patterns/facade-design-pattern/
    https://www.youtube.com/watch?v=nn5KGOkBIyo 
    http://www.tutorialspoint.com/design_pattern/facade_pattern.htm 
    https://www.youtube.com/watch?v=dLjJo2v2re8