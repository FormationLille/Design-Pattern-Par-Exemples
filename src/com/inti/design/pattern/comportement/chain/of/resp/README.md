# Mon tutoriel de Design Pattern - Chain Of Responsibility
# Yann


- Categorie : Comportement
- Defintion : Evitez de coupler l'expéditeur à son destinataire en donnant a plus d'un objet une chance de gerer la demande
- Objectif : Le pattern "Chain of responsibility" repose sur la transformation de comportements particuliers en objets autonomes appeles "gestionnaires (Handler)"
- Resultat : Le design pattern permet a plusieurs objets de gerer la demande sans coupler la classe emettrice aux classes concretes. La chaine peut etre composee dynamiquement au moment de l’execution avec tout gestionnaire qui suit une interface de gestionnaire standard. 

# Exemple 

L'objectif ici est de renvoyer un message selon la demande du client. Le client va formuler une requete qui va faire appelle a la methode operation() du premier maillon de la chaine. pour cela on va definir une classe abstraite (maillon), ainsi que 3 classes maillons (maillonA, maillonB, maillonC) qui sont des sous classes concretes qui definissent un maillon de la chaine. Chaque maillon a la responsabilite d'une partie d'un traitement.

![Diagramme_de_Classe](https://user-images.githubusercontent.com/49645529/58784968-d9863600-85e4-11e9-9f25-7942e19f3ff4.PNG)

   
### Etape 1


- Classe maillon


```java 
    public abstract class Maillon {

    private Maillon suivant;
    /**
     * Fixe le maillon suivant dans la chaine
     * @param pSuivant
     */
    public void setSuivant(Maillon pSuivant) {
        suivant = pSuivant;
    }
    /**
     * Appelle le traitement sur le maillon courant
     * Puis demande au maillon suivant d'en faire autant,
     * si le maillon courant n'a pas géré l'opération.
     * @param pNombre
     * @return Si l'opération a été gérée.
     */
    public boolean operation(int pNombre) {
        if(operationSpec(pNombre)) {
        	return true;
        };
        
        if(suivant != null) {
            return suivant.operation(pNombre);
        }
        return false;
    }

    public abstract boolean operationSpec(int pNombre);
    }
  ```
    

        
### Etape 2

- Creation de la classe maillonA


```java
    public class MaillonA extends Maillon {

    /**
     * Méthode affichant un message 
     * si le nombre passé en paramètre est pair
     * @return true, si la maillon a géré l'opération
     */
    public boolean operationSpec(int pNombre) {
        if(pNombre % 2 == 0) {
            System.out.println("MaillonA : " + pNombre + " : pair");
            return true;
        }
        return false;
    }
    }
```

- creation de la classe maillonB

```java
    public class MaillonB extends Maillon {

    /**
     * Méthode affichant un message 
     * si le nombre passé en paramètre est inférieur à 2
     * @return true, si la maillon a géré l'opération
     */
    public boolean operationSpec(int pNombre) {
        if(pNombre < 2) {
            System.out.println("MaillonB : " + pNombre + " : < 2");
            return true;
        }
        return false;
    }
    }
```

- creation de la classe maillonC

```java
    public class MaillonC extends Maillon {

    /**
     * Méthode affichant un message 
     * si le nombre passé en paramètre est supérieur à 2
     * @return true, si la maillon a géré l'opération
     */
    public boolean operationSpec(int pNombre) {
        if(pNombre > 2) {
            System.out.println("MaillonC : " + pNombre + " : > 2");
            return true;
        }
        return false;
    }
    }
```

### Etape finale

- Creation de la classe main

```java
    public class ChainOfResponsibilityPatternMain {

    public static void main(String[] args) {
        // Création des maillons
        Maillon lMaillonA = new MaillonA();
        Maillon lMaillonB = new MaillonB();
        Maillon lMaillonC = new MaillonC();
        
        // Définition de l'enchainement des maillons
        lMaillonA.setSuivant(lMaillonB);
        lMaillonB.setSuivant(lMaillonC);
        
        // Appel de la méthode du premier maillon
        // avec des valeurs différentes
        System.out.println("--> Appel de la méthode avec paramètre '1' : ");
        lMaillonA.operation(1);
        System.out.println("--> Appel de la méthode avec paramètre '2' : ");
        lMaillonA.operation(2);
        System.out.println("--> Appel de la méthode avec paramètre '3' : ");
        lMaillonA.operation(3);
        System.out.println("--> Appel de la méthode avec paramètre '4' : ");
        lMaillonA.operation(4);
    }
    }
```

### Resultat

        Affichage : 
        Appel de la méthode avec paramètre '1' : 
        MaillonB : 1 : < 2
        Appel de la méthode avec paramètre '2' : 
        MaillonA : 2 : pair
        Appel de la méthode avec paramètre '3' : 
        MaillonC : 3 : > 2
        Appel de la méthode avec paramètre '4' : 
        MaillonA : 4 : pair
