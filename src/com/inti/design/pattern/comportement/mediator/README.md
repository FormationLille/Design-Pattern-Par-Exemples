# Mon tutoriel de Design Pattern - Mediator

Le design pattern Médiateur (Mediator) est un design pattern de type comportement.
Les objectifs sont : 
- gérer la transmission d'informations entre des objets interagissant entre eux,
- avoir un couplage faible entre les objets puisqu'ils n'ont pas de lien direct entre eux,
- pouvoir varier leur interaction indépendamment.
L'objectif final est donc que le médiateur isole la communication des objets.
Les raisons d'utilisation sont :
- les différents objets peuvent avoir des interactions. Les actions d'un objet peuvent avoir des conséquences sur un autre objet.
- besoin de centraliser le contrôle et les communications complexe entre les objets apparentés
- construire un objet dont la vocation est la gestion et le contrôle des interactions complexes entre un ensemble d'objets sans que les éléments doivent se connaitre mutuellement.

Ainsi, un objet définit comment plusieurs objets communiquent entre eux en évitant à chacun de faire référence à ses interlocuteurs. 
Le médiateur (mediator) sert d'intermédiaire pour assurer les communications entre les objets.

Pour mieux comprendre concretement, on peut regarder l'exemple du contrôle du trafic aérien. Pour éviter une collision entre les différents avions survolants dans le ciel et gérer les atterrissages et les décollages, un intermédiaire est nécessaire. 
Il s'agit de la tour de contrôle. Elle s'occupe des communications avec chaque avion pour gérer l'ensemble du trafic aérien (décollage, atterrissage).

# Implementation

Le mediator va gérer les messages entre collègues.

![DiagrammeMediator](https://user-images.githubusercontent.com/49645567/58785010-fa4e8b80-85e4-11e9-8439-b3eefc83774c.PNG)



### Etape 1 : Créer les classes principales
	1) Créer la classe Message
``` java
    package adaming.com;

    public class Message {
    //Création des attributs de la classe Message
	private String message;
	private String expediteur;
	private String destinataire;
	
	//Création du constructeur
	public Message() {
	}
	
	public Message(String message, String expediteur, String destinataire) {
		this.message = message;
		this.destinataire = destinataire;
	}
	
	//Création de la méthode surchargée
	@Override
	public String toString() {
		return "Message [message=" + message + ", expediteur=" + expediteur + ", destinataire=" + destinataire + "]";
	}
    //Création des getters et des setters
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

2) Créer la classe abstracte Mediateur
```java
package adaming.com;

    import java.util.HashMap;
    import java.util.Map;

    public abstract class Mediateur {
    //Création d'une collection : map des collegues
	protected Map<String, Collegue> collegues=new HashMap<String, Collegue>();
	
	//Création de la méthode abstract transmettre des messages "transmettreMessage"
    public abstract void transmettreMessage(Message m);

    //Création de la méthode abstract ajouter un collegue "addCollegue"
    public void addCollegue(String ref, Collegue a) {
	collegues.put(ref, a);
}
}
```

3) Créer la classe abstracte Collegue
```java
package adaming.com;

    public abstract class Collegue {
    //Création des attributs
	protected String name;
	protected Mediateur mediateur;
	
	//Création du constructeur
    public Collegue(String name, Mediateur mediateur) {
	this.name=name;
	this.mediateur=mediateur;
	mediateur.addCollegue(name, this);
}

    //Création de la méthode abstracte envoyer des messages "envoyerMessage"
    public abstract void envoyerMessage(Message m);

    //Création de la méthode abstracte recevoir des messages "recevoirMessage"
    public abstract void recevoirMessage(Message m);
}
```

4) créer la classe MediateurImpl
``` java
    package adaming.com;

    import java.util.ArrayList;
    import java.util.List;

    public class MediateurImpl extends Mediateur{
    //La classe MediateurImpl herite de la classe Mediateur
	
	//Création de la liste des messages : une ArrayList
    private List<Message> conversations=new ArrayList<Message>();
	
	@Override
	//Création d'une méthode surchargée transmettre un message "transmettreMessage"
	public void transmettreMessage(Message m) {
		System.out.println("-------- Début Médiateur -------");
		//Affichage de l'enregistrement du message
		System.out.println("Enregistrement du message");
		//Ajouter le message dans les conversations
		conversations.add(m);
		//Affichage de la transmission du message
		System.out.println("Transmission du message");
		//Affichage de l'expédieur
		System.out.println("From :"+m.getExpediteur());
		//Affichage du destinataire
		System.out.println("To :"+m.getDestinataire());
		Collegue destinataire=collegues.get(m.getDestinataire());
		//Recevoir le message pour le destinataire
		destinataire.recevoirMessage(m);
		System.out.println("-------- Fin Médiateur -------");
	}

    //Création de la méthode analyser la conversation "analyserConversation"
	public void analyserConversation() {
	//Utilisation d'une boucle for : parcourir la liste des messages pour voir la conversation
		for(Message m:conversations) 
			System.out.println(m.toString());
	}
	}
```

### Etape 2 : Créer les classes filles CollegueA et CollegueB

 5) Créer la classe CollegueA
    
``` java
    package adaming.com;

    public class CollegueA extends Collegue {
    //Création d'une première classe fille qui hérite de la classe mère collegue

    //Création du constructeur
    public CollegueA(String name, Mediateur mediateur) {
	super(name, mediateur); 
    }

    //Création de la méthode surchargée envoyer un message "envoyerMessage"
    @Override
    public void envoyerMessage(Message m) {
	System.out.println("----------------------");
	//Affichage du nom du collègue expéditeur et l'envoi du message
	System.out.println("Collègue nom="+name+", "Envoi de message");
	//Obtenir le nom de l'expéditeur du message
	m.setExpediteur(this.name);
	//Appel de la méthode transmettre un message de la classe mediateur
	mediateur.transmettreMessage(m);
	System.out.println("----------------------");
    }

    //Création de la méthode surchargée recevoir un message "recevoirMessage"
    @Override
    public void recevoirMessage(Message m) {
	System.out.println("----------------------");
	//Affichage du nom du collègue expéditeur et la reception du message
	System.out.println("Collègue nom="+name+", Réception du message");
	//Affichage du nom du collègue expéditeur
	System.out.println("From :"+m.getExpediteur());
	//Affichage du message
	System.out.println("Contenu:"+m.getMessage());
	//Affichage du traitement du message par l'expéditeur
	System.out.println("Traitement du message par ....."+this.name);
	System.out.println("----------------------");
    }
    }
```
6) Créer la classe CollegueB
``` java
    package adaming.com;

    public class CollegueB extends Collegue {

    public CollegueB(String name, Mediateur mediateur) {
	super(name, mediateur); 
    }

    @Override
    public void envoyerMessage(Message m) {
	System.out.println("----------------------");
	System.out.println("Collègue nom="+name+", Envoi de message");
	m.setExpediteur(this.name);
	mediateur.transmettreMessage(m);
	System.out.println("----------------------");
    }

    @Override
    public void recevoirMessage(Message m) {
	System.out.println("----------------------");
	System.out.println("Collègue nom="+name+", Réception du message");
	System.out.println("From :"+m.getExpediteur());
	System.out.println("Contenu:"+m.getMessage());
	System.out.println("Traitement du message par ....."+this.name);
	System.out.println("----------------------");
    }
    }
    ```

### Etape finale : Créer la classe Application
``` java
    package adaming.com;

    public class Application {
    //Création de la classe main

    //Création de la méthode static main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Création d'un médiateur
		MediateurImpl mediateur=new MediateurImpl();
		//Création de 3 collègues avec leurs attributs (nom et le mediateur de référence)
		Collegue a1=new CollegueA("C1", mediateur);
		Collegue a2=new CollegueA("C2", mediateur);
		Collegue b1=new CollegueA("C3", mediateur);
		//Création du message
		a1.envoyerMessage(new Message("je suis à 20 m", "C2"));
		
	}

    }
```
    Résultat

    Collègue nom=C1, Envoi de message
-------- Début Médiateur -------
Enregistrement du message
Transmission du message
From :C1
To :C2
----------------------
Collègue nom=C2, Réception du message
From :C1
Contenu:je suis à 20 m
Traitement du message par .....C2
----------------------
-------- Fin Médiateur -------
----------------------


Lien pour avoir tous les trucs de mise en page qu'il faut : https://guides.github.com/features/mastering-markdown/
