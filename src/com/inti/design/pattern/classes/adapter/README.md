# Mon tutoriel de Design Pattern - Adapter

***
* Auteur : Antoine Storme
* Date de dernière maj : 03/06/2019
* DesingPattern : Structure
***


    "Adapter" permet à plusieurs entités incompatibles de s'utiliser ensemble, en créant un pont, 
    une relation artificielle entre  ces entités. Il est très fréquemment utilisé.

# Implementation

    Voici quelques exemples de la vie courante représentant l'usage d'un adaptateur:
    - Vous voyagez au Royaume-Uni et voulez brancher votre téléphone. La prise murale est différente de
    votre prise "française" --> vous achetez un adaptateur.
    - Vous souhaitez transferer des photos de votre carte mémoire microSD vers votre ordinateur --> Vous
    insérez la carte dans un support adapté, permettant la lecture de la carte par l'ordinateur.
    - Vous souhaitez savoir comment se déplace un chien, un oiseau et un humain. L'un court, l'autre conduis
    alors que le dernier vole... Mais vous ne vous souvenez plus de qui fait quoi ! Un adaptateur avec un
    nom de méthode "déplacement", qui vous renvois le moyen de déplacement, peu importe le nom spécifique
    des méthodes.
    - Un lecteur média pouvant lire des fichiers .mp3, .mp4, .avi, etc.
    
![AdapterDesignPattern](https://user-images.githubusercontent.com/50745455/58863002-33a0fd00-86b2-11e9-9a28-4538e63ec623.jpg)

    
### Etape 1

    Dans l'exemple ci-dessous, nous allons étudier une entreprise voulant créer un chargeur
    universel pour téléphone. Notons cependant que tous les téléphones n'ont pas forcément les mêmes besoins...
    Je vous laisse trouver la subtilité dans l'exemple ;).

    Nous allons avoir 5 classes, 1 interface, et 1 run.

![DiagrammeDeClasseAdaptater](https://user-images.githubusercontent.com/50745455/58859948-42d07c80-86ab-11e9-8bad-072c0559162d.PNG)

### Etape 2

    Créer votre première classe, le chargeur, ainsi que notre interface.

    Classe Chargeur: Chargeur.java
```java
    public class Chargeur {
        // le portable branchÃ© sur le chargeur
        private InterfaceChargeable telephone;
        // le voltage en sortie du chargeur
        private final int VOLTAGE = 10;


        // branchement d'un portable pour le charger
        public void brancherPortable(InterfaceChargeable portable) {
            System.out.println("Branchement d'un portable :");
            System.out.println("---------------------------");
            this.telephone = portable;
            this.telephone.recharger(VOLTAGE);
        }   

    }
 ```

    Interface: InterfaceChargeable.java
 ```java
    public interface InterfaceChargeable {

	    public void recharger(int volts);
    }
 ```

### Etape 3

    Création des téléphones portables sur le marché:

    Classe du premier téléphone: PortableSamSaoule.java
```java
    public class PortableSamSaoule {

        //Portable se chargeant avec du 5Volts.
        public void chargerPortable(int volts) {
            System.out.println("Portable SamSaoul en charge");
            System.out.println("voltage : " + volts + "\n");
        }
    }
```

    Classe du deuxième téléphone: PortableSonneEricSonne.java
```java
    public class PortableSonneEricSonne {

        //Portable se chargeant avec du 10Volts.
        public void chargerBatteries(int volts) {
            System.out.println("Portable SonneEricSonne en charge");
            System.out.println("voltage : " + volts + "\n");
        }
    }
```

    Ok, donc maintenant, notre entreprise a créée son chargeur... Mais l'embout ne correspond à 
    aucun téléphone du marché ! 

### Etape 4

    Nous allons donc maintenant palier à  ce problème, et créer (vous l'avez deviné je suis sûr) un Adaptateur !
    Enfin... plusieurs en fait !

    Classe du premier adaptateur de téléphone: AdaptateurSamSaoule.java
```java
    public class AdaptateurSamSaoule implements InterfaceChargeable {

        //Référence du portable adapté
        private PortableSamSaoule telephone;
        
        public AdaptateurSamSaoule(PortableSamSaoule telephone) {
            super();
            this.telephone = telephone;
        }

        //Méthode de rechargement, mais ATTENTION, ne nécéssite que 5 volts !
        public void recharger(int volts) {
            int nouveauVoltage = volts > 5 ? 5 : volts;
            this.telephone.chargerPortable(nouveauVoltage);
        }
    }
```
    Classe du deuxième adaptateur de téléphone: AdaptateurSonneEricSonne.java
```java
    public class AdaptateurSonneEricSonne implements InterfaceChargeable {

        //Référence du portable adapté
        private PortableSonneEricSonne telephone;
            
        public AdaptateurSonneEricSonne(PortableSonneEricSonne telephone) {
            super();
            this.telephone = telephone;
        }

        public void recharger(int volts) {
            this.telephone.chargerBatteries(volts);
        }
    }
```
    Notons que nos adaptateurs doivent implémenter l'interface afin d'être en mesure de charger l'appareil.


### Etape 5 

    On crée le main: Main.java

```java
    public class Main {

        public static void main(String[] args) {
            //Déclaration du chargeur.
            Chargeur chargeur = new Chargeur();
            
            //************** Portable SonneEricSonne **************
            
            //Déclaration du portable et de son adaptaateur.
            PortableSonneEricSonne portableSonne = new PortableSonneEricSonne();
            AdaptateurSonneEricSonne adaptateurSonne = new AdaptateurSonneEricSonne(portableSonne);
            
            //Chargement du portable via son adaptateur.
            chargeur.brancherPortable(adaptateurSonne);

            //************** Portable SamSaoule **************
            
            //Déclaration du portable et de son adaptateur.
            PortableSamSaoule portableSam = new PortableSamSaoule();
            AdaptateurSamSaoule adaptateurSam = new AdaptateurSamSaoule(portableSam);
            
            //Chargement du portable via sn adaptateur.
            chargeur.brancherPortable(adaptateurSam);

        }

    }
```

### Etape 6

    Le résultat consolitique:

```java
    Branchement d'un portable :
    ---------------------------
    Portable SonneEricSonne en charge
    voltage : 10

    Branchement d'un portable :
    ---------------------------
    Portable SamSaoul en charge
    voltage : 5
```

### Etape 7 : Avez-vous remarqué ?

    Comment s'appelle la méthode permettant de charger un téléphone de la marque SonneEricSonne ?
    Et celle de la marque SamSaoul ? Qu'en est-il pour notre chargeur ?

### Etape 8

    Vous trouverez ici les liens m'ayant permis de travailler sur ce DesignPattern:

    https://badger.developpez.com/tutoriels/dotnet/patterns/adaptateur/
    https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
