# Mon tutoriel de Design Pattern - Chain Of Responsibility
# Yann


- Categorie : Comportement
- Defintion : Evitez de coupler l'expiditeur � son destinataire en donnant a plus d'un objet une chance de gerer la demande
- Objectif : Le pattern "Chain of responsibility" repose sur la transformation de comportements particuliers en objets autonomes 
appeles "gestionnaires (Handler)"
- Resultat : Le design pattern permet a plusieurs objets de gerer la demande sans coupler la classe emettrice aux classes concretes. 
La chaine peut etre composee dynamiquement au moment de l�execution avec tout gestionnaire qui suit une interface de gestionnaire 
standard. 

# Exemple : Nombre

L'objectif ici est de renvoyer un message selon la demande du client. Le client va formuler une requete (ici un nombre)
 qui va faire appelle a la methode operation() du premier maillon de la chaine. pour cela on va definir une classe abstraite (maillon), 
 ainsi que 3 classes maillons (maillonA, maillonB, maillonC) qui sont des sous classes concretes qui definissent un maillon de la chaine. Chaque maillon a la responsabilite d'une partie d'un traitement.


   
### Etape 1

- Classe maillon


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
     * si le maillon courant n'a pas g�r� l'op�ration.
     * @param pNombre
     * @return Si l'op�ration a �t� g�r�e.
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
    

        
### Etape 2

- Creation de la classe maillonA


    public class MaillonA extends Maillon {

    /**
     * M�thode affichant un message 
     * si le nombre pass� en param�tre est pair
     * @return true, si la maillon a g�r� l'op�ration
     */
    public boolean operationSpec(int pNombre) {
        if(pNombre % 2 == 0) {
            System.out.println("MaillonA : " + pNombre + " : pair");
            return true;
        }
        return false;
    }
}

- creation de la classe maillonB


    public class MaillonB extends Maillon {

    /**
     * M�thode affichant un message 
     * si le nombre pass� en param�tre est inf�rieur � 2
     * @return true, si la maillon a g�r� l'op�ration
     */
    public boolean operationSpec(int pNombre) {
        if(pNombre < 2) {
            System.out.println("MaillonB : " + pNombre + " : < 2");
            return true;
        }
        return false;
    }
    }

- creation de la classe maillonC


    public class MaillonC extends Maillon {

    /**
     * M�thode affichant un message 
     * si le nombre pass� en param�tre est sup�rieur � 2
     * @return true, si la maillon a g�r� l'op�ration
     */
    public boolean operationSpec(int pNombre) {
        if(pNombre > 2) {
            System.out.println("MaillonC : " + pNombre + " : > 2");
            return true;
        }
        return false;
    }
    }

### Etape finale

- Creation de la classe main


    public class ChainOfResponsibilityPatternMain {

    public static void main(String[] args) {
        // Cr�ation des maillons
        Maillon lMaillonA = new MaillonA();
        Maillon lMaillonB = new MaillonB();
        Maillon lMaillonC = new MaillonC();
        
        // D�finition de l'enchainement des maillons
        lMaillonA.setSuivant(lMaillonB);
        lMaillonB.setSuivant(lMaillonC);
        
        // Appel de la m�thode du premier maillon
        // avec des valeurs diff�rentes
        System.out.println("--> Appel de la m�thode avec param�tre '1' : ");
        lMaillonA.operation(1);
        System.out.println("--> Appel de la m�thode avec param�tre '2' : ");
        lMaillonA.operation(2);
        System.out.println("--> Appel de la m�thode avec param�tre '3' : ");
        lMaillonA.operation(3);
        System.out.println("--> Appel de la m�thode avec param�tre '4' : ");
        lMaillonA.operation(4);
    }
    }
    
### Resultat

        Affichage : 
        Appel de la m�thode avec param�tre '1' : 
        MaillonB : 1 : < 2
        Appel de la m�thode avec param�tre '2' : 
        MaillonA : 2 : pair
        Appel de la m�thode avec param�tre '3' : 
        MaillonC : 3 : > 2
        Appel de la m�thode avec param�tre '4' : 
        MaillonA : 4 : pair
