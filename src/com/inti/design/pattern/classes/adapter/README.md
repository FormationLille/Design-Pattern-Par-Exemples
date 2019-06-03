# Mon tutoriel de Design Pattern - Adapter

***
* Auteur : Antoine Storme
* Date de derni�re maj : 03/06/2019
***


    Adapter permet � plusieurs entit�s incompatibles de s'utiliser ensemble, en cr�ant un pont, 
    une relation artificielle entre  ces entit�s.

# Implementation

    Voici quelques exemples de la vie courante repr�sentant l'usage d'un adaptateur:
    - Vous voyagez au Royaume-Uni et voulez brancher votre t�l�phone. La prise murale est diff�rente de
    votre prise "fran�aise" --> vous achetez un adaptateur.
    - Vous souhaitez transferer des photos de votre carte m�moire microSD vers votre ordinateur --> Vous
    ins�rez la carte dans un support adapt�, permettant la lecture de la carte par l'ordinateur.
    - Vous souhaitez savoir comment se d�place un chien, un oiseau et un humain. L'un court, l'autre conduis
    alors que le dernier vole... Mais vous ne vous souvenez plus de qui fait quoi ! Un adaptateur avec un
    nom de m�thode "d�placement", qui vous renvois le moyen de d�placement, peu importe le nom sp�cifique
    des m�thodes.


    Mettre le diagramme de classes


### Etape 1

    Dans l'exemple ci-dessous, nous allons �tudier l'exemple d'une entreprise voulant cr�er un chargeur
    universel pour t�l�phone. Notons cependant que tous les t�l�phones n'ont pas forc�ment les m�mes besoins...
    Je vous laisse trouver la subtilit� dans l'exemple ;).
    Nous allons avoir 5 classes, 1 interface, et 1 run.
    Mettre le code des classes principales

### Etape 2

    Cr�er votre premi�re classe, le chargeur, ainsi que notre interface.

    Classe Chargeur: Chargeur.java
    ```java
    public class Chargeur {
        // le portable branch� sur le chargeur
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

    Cr�ation des t�l�phones portables sur le march�:

    Classe du premier t�l�phone: PortableSamSaoule.java
    ```java
    public class PortableSamSaoule {

        //Portable se chargeant avec du 5Volts.
        public void chargerPortable(int volts) {
            System.out.println("Portable SamSaoul en charge");
            System.out.println("voltage : " + volts + "\n");
        }
    }
    ```

    Classe du deuxi�me t�l�phone: PortableSonneEricSonne.java
    ```java
    public class PortableSonneEricSonne {

        //Portable se chargeant avec du 10Volts.
        public void chargerBatteries(int volts) {
            System.out.println("Portable SonneEricSonne en charge");
            System.out.println("voltage : " + volts + "\n");
        }
    }
    ```

    Ok, donc maintenant, notre entreprise a cr��e son chargeur... Mais l'embout ne correspond �
    aucun t�l�phone du march� ! 

### Etape 4

    Nous allons donc maintenant palier � ce probl�me, et cr�er (vous l'avez devin� je suis s�r) un Adaptateur !
    Enfin... plusieurs en fait !

    Classe du premier adaptateur de t�l�phone: AdaptateurSamSaoule.java
    ```java
    public class AdaptateurSamSaoule implements InterfaceChargeable {

        //R�f�rence du portable adapt�
        private PortableSamSaoule telephone;
        
        public AdaptateurSamSaoule(PortableSamSaoule telephone) {
            super();
            this.telephone = telephone;
        }

        //M�thode de rechargement, mais ATTENTION, ne n�c�ssite que 5 volts !
        public void recharger(int volts) {
            int nouveauVoltage = volts > 5 ? 5 : volts;
            this.telephone.chargerPortable(nouveauVoltage);
        }
    }
    ```
    Classe du deuxi�me adaptateur de t�l�phone: AdaptateurSonneEricSonne.java
    ```java
    public class AdaptateurSonneEricSonne implements InterfaceChargeable {

        //R�f�rence du portable adapt�
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
    Notons que nos adaptateurs doivent impl�menter l'interface afin d'�tre en mesure de charger l'appareil.


### Etape 5 

    On cr�e le main: Main.java

    ```java
    public class Main {

        public static void main(String[] args) {
            //D�claration du chargeur.
            Chargeur chargeur = new Chargeur();
            
            //************** Portable SonneEricSonne **************
            
            //D�claration du portable et de son adaptaateur.
            PortableSonneEricSonne portableSonne = new PortableSonneEricSonne();
            AdaptateurSonneEricSonne adaptateurSonne = new AdaptateurSonneEricSonne(portableSonne);
            
            //Chargement du portable via son adaptateur.
            chargeur.brancherPortable(adaptateurSonne);

            //************** Portable SamSaoule **************
            
            //D�claration du portable et de son adaptateur.
            PortableSamSaoule portableSam = new PortableSamSaoule();
            AdaptateurSamSaoule adaptateurSam = new AdaptateurSamSaoule(portableSam);
            
            //Chargement du portable via sn adaptateur.
            chargeur.brancherPortable(adaptateurSam);

        }

    }
    ```

### Etape 6

    Le r�sultat consolitique:

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

### Etape 7 : Avez-vous remarqu� ?

    Comment s'appelle la m�thode permettant de charger un t�l�phone de la marque SonneEricSonne ?
    Et celle de la marque SamSaoul ? Qu'en est-il pour notre chargeur ?

### Etape 8

    Vous trouverez ici les liens m'ayant permis de travailler sur ce DesignPattern:

    https://badger.developpez.com/tutoriels/dotnet/patterns/adaptateur/
    https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm