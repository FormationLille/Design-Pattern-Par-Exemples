# Mon tutoriel de Design Pattern - Mediator

Le design pattern M�diateur (Mediator) est un design pattern de type comportement.
Les objectifs sont : 
- g�rer la transmission d'informations entre des objets interagissant entre eux,
- avoir un couplage faible entre les objets puisqu'ils n'ont pas de lien direct entre eux,
- pouvoir varier leur interaction ind�pendamment.
L'objectif final est donc que le m�diateur isole la communication des objets.
Les raisons d'utilisation sont :
- les diff�rents objets peuvent avoir des interactions. Les actions d'un objet peuvent avoir des cons�quences sur un autre objet.
- besoin de centraliser le contr�le et les communications complexe entre les objets apparent�s
- construire un objet dont la vocation est la gestion et le contr�le des interactions complexes entre un ensemble d'objets sans que les �l�ments doivent se connaitre mutuellement.

Ainsi, un objet d�finit comment plusieurs objets communiquent entre eux en �vitant � chacun de faire r�f�rence � ses interlocuteurs. 
Le m�diateur (mediator) sert d'interm�diaire pour assurer les communications entre les objets.

Pour mieux comprendre concretement, on peut regarder l'exemple du contr�le du trafic a�rien. Pour �viter une collision entre les diff�rents avions survolants dans le ciel et g�rer les atterrissages et les d�collages, un interm�diaire est n�cessaire. 
Il s'agit de la tour de contr�le. Elle s'occupe des communications avec chaque avion pour g�rer l'ensemble du trafic a�rien (d�collage, atterrissage).

# Implementation

Le mediator va g�rer les messages entre coll�gues.

![DiagrammeMediator](https://user-images.githubusercontent.com/49645567/58785010-fa4e8b80-85e4-11e9-8439-b3eefc83774c.PNG)



### Etape 1 : Cr�er les classes principales
	1) Cr�er la classe Message
``` java
    package adaming.com;

    public class Message {
    //Cr�ation des attributs de la classe Message
	private String message;
	private String expediteur;
	private String destinataire;
	
	//Cr�ation du constructeur
	public Message() {
	}
	
	public Message(String message, String expediteur, String destinataire) {
		this.message = message;
		this.destinataire = destinataire;
	}
	
	//Cr�ation de la m�thode surcharg�e
	@Override
	public String toString() {
		return "Message [message=" + message + ", expediteur=" + expediteur + ", destinataire=" + destinataire + "]";
	}
    //Cr�ation des getters et des setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	} 
}
```

2) Cr�er la classe abstracte Mediateur
```java
package adaming.com;

    import java.util.HashMap;
    import java.util.Map;

    public abstract class Mediateur {
    //Cr�ation d'une collection : map des collegues
	protected Map<String, Collegue> collegues=new HashMap<String, Collegue>();
	
	//Cr�ation de la m�thode abstract transmettre des messages "transmettreMessage"
    public abstract void transmettreMessage(Message m);

    //Cr�ation de la m�thode abstract ajouter un collegue "addCollegue"
    public void addCollegue(String ref, Collegue a) {
	collegues.put(ref, a);
}
}
```

3) Cr�er la classe abstracte Collegue
```java
package adaming.com;

    public abstract class Collegue {
    //Cr�ation des attributs
	protected String name;
	protected Mediateur mediateur;
	
	//Cr�ation du constructeur
    public Collegue(String name, Mediateur mediateur) {
	this.name=name;
	this.mediateur=mediateur;
	mediateur.addCollegue(name, this);
}

    //Cr�ation de la m�thode abstracte envoyer des messages "envoyerMessage"
    public abstract void envoyerMessage(Message m);

    //Cr�ation de la m�thode abstracte recevoir des messages "recevoirMessage"
    public abstract void recevoirMessage(Message m);
}
```

4) cr�er la classe MediateurImpl
``` java
    package adaming.com;

    import java.util.ArrayList;
    import java.util.List;

    public class MediateurImpl extends Mediateur{
    //La classe MediateurImpl herite de la classe Mediateur
	
	//Cr�ation de la liste des messages : une ArrayList
    private List<Message> conversations=new ArrayList<Message>();
	
	@Override
	//Cr�ation d'une m�thode surcharg�e transmettre un message "transmettreMessage"
	public void transmettreMessage(Message m) {
		System.out.println("-------- D�but M�diateur -------");
		//Affichage de l'enregistrement du message
		System.out.println("Enregistrement du message");
		//Ajouter le message dans les conversations
		conversations.add(m);
		//Affichage de la transmission du message
		System.out.println("Transmission du message");
		//Affichage de l'exp�dieur
		System.out.println("From :"+m.getExpediteur());
		//Affichage du destinataire
		System.out.println("To :"+m.getDestinataire());
		Collegue destinataire=collegues.get(m.getDestinataire());
		//Recevoir le message pour le destinataire
		destinataire.recevoirMessage(m);
		System.out.println("-------- Fin M�diateur -------");
	}

    //Cr�ation de la m�thode analyser la conversation "analyserConversation"
	public void analyserConversation() {
	//Utilisation d'une boucle for : parcourir la liste des messages pour voir la conversation
		for(Message m:conversations) 
			System.out.println(m.toString());
	}
	}
```

### Etape 2 : Cr�er les classes filles CollegueA et CollegueB

 5) Cr�er la classe CollegueA
    
``` java
    package adaming.com;

    public class CollegueA extends Collegue {
    //Cr�ation d'une premi�re classe fille qui h�rite de la classe m�re collegue

    //Cr�ation du constructeur
    public CollegueA(String name, Mediateur mediateur) {
	super(name, mediateur); 
    }

    //Cr�ation de la m�thode surcharg�e envoyer un message "envoyerMessage"
    @Override
    public void envoyerMessage(Message m) {
	System.out.println("----------------------");
	//Affichage du nom du coll�gue exp�diteur et l'envoi du message
	System.out.println("Coll�gue nom="+name+", "Envoi de message");
	//Obtenir le nom de l'exp�diteur du message
	m.setExpediteur(this.name);
	//Appel de la m�thode transmettre un message de la classe mediateur
	mediateur.transmettreMessage(m);
	System.out.println("----------------------");
    }

    //Cr�ation de la m�thode surcharg�e recevoir un message "recevoirMessage"
    @Override
    public void recevoirMessage(Message m) {
	System.out.println("----------------------");
	//Affichage du nom du coll�gue exp�diteur et la reception du message
	System.out.println("Coll�gue nom="+name+", R�ception du message");
	//Affichage du nom du coll�gue exp�diteur
	System.out.println("From :"+m.getExpediteur());
	//Affichage du message
	System.out.println("Contenu:"+m.getMessage());
	//Affichage du traitement du message par l'exp�diteur
	System.out.println("Traitement du message par ....."+this.name);
	System.out.println("----------------------");
    }
    }
```
6) Cr�er la classe CollegueB
``` java
    package adaming.com;

    public class CollegueB extends Collegue {

    public CollegueB(String name, Mediateur mediateur) {
	super(name, mediateur); 
    }

    @Override
    public void envoyerMessage(Message m) {
	System.out.println("----------------------");
	System.out.println("Coll�gue nom="+name+", Envoi de message");
	m.setExpediteur(this.name);
	mediateur.transmettreMessage(m);
	System.out.println("----------------------");
    }

    @Override
    public void recevoirMessage(Message m) {
	System.out.println("----------------------");
	System.out.println("Coll�gue nom="+name+", R�ception du message");
	System.out.println("From :"+m.getExpediteur());
	System.out.println("Contenu:"+m.getMessage());
	System.out.println("Traitement du message par ....."+this.name);
	System.out.println("----------------------");
    }
    }
    ```

### Etape finale : Cr�er la classe Application
``` java
    package adaming.com;

    public class Application {
    //Cr�ation de la classe main

    //Cr�ation de la m�thode static main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Cr�ation d'un m�diateur
		MediateurImpl mediateur=new MediateurImpl();
		//Cr�ation de 3 coll�gues avec leurs attributs (nom et le mediateur de r�f�rence)
		Collegue a1=new CollegueA("C1", mediateur);
		Collegue a2=new CollegueA("C2", mediateur);
		Collegue b1=new CollegueA("C3", mediateur);
		//Cr�ation du message
		a1.envoyerMessage(new Message("je suis � 20 m", "C2"));
		
	}

    }
```
    R�sultat

    Coll�gue nom=C1, Envoi de message
-------- D�but M�diateur -------
Enregistrement du message
Transmission du message
From :C1
To :C2
----------------------
Coll�gue nom=C2, R�ception du message
From :C1
Contenu:je suis � 20 m
Traitement du message par .....C2
----------------------
-------- Fin M�diateur -------
----------------------


Lien pour avoir tous les trucs de mise en page qu'il faut : https://guides.github.com/features/mastering-markdown/
