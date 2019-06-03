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
```
	package adaming.com;

    public class Message {
	private String message;
	private String expediteur;
	private String destinataire;
	
	public Message() {
	}
	
	public Message(String message, String expediteur, String destinataire) {
		this.message = message;
		this.destinataire = destinataire;
	}
	
	@Override
	public String toString() {
		return "Message [message=" + message + ", expediteur=" + expediteur + ", destinataire=" + destinataire + "]";
	}

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

2) Créer la classe Mediateur
```
package adaming.com;

import java.util.HashMap;
import java.util.Map;

public abstract class Mediateur {
	protected Map<String, Collegue> collegues=new HashMap<String, Collegue>();
	
public abstract void transmettreMessage(Message m);

public void addCollegue(String ref, Collegue a) {
	collegues.put(ref, a);
}
}
```

3) Créer la classe Collegue
```
package adaming.com;

    public abstract class Collegue {
	protected String name;
	protected Mediateur mediateur;
	
    public Collegue(String name, Mediateur mediateur) {
	this.name=name;
	this.mediateur=mediateur;
	mediateur.addCollegue(name, this);
}

    public abstract void envoyerMessage(Message m);

    public abstract void recevoirMessage(Message m);
}
```

4) créer la classe MediateurImpl
```
    package adaming.com;

    import java.util.ArrayList;
    import java.util.List;

    public class MediateurImpl extends Mediateur{
	
    private List<Message> conversations=new ArrayList<Message>();
		
	@Override
	public void transmettreMessage(Message m) {
		System.out.println("-------- Début Médiateur -------");
		System.out.println("Enregistrement du message");
		conversations.add(m);
		System.out.println("Transmission du message");
		System.out.println("From :"+m.getExpediteur());
		System.out.println("To :"+m.getDestinataire());
		Collegue destinataire=collegues.get(m.getDestinataire());
		destinataire.recevoirMessage(m);
		System.out.println("-------- Fin Médiateur -------");
	}

	public void analyserConversation() {
		for(Message m:conversations) 
			System.out.println(m.toString());
	}
	}
```

### Etape 2 : Créer les classes CollegueA et CollegueB

 5) Créer la classe CollegueA
 ```
    package adaming.com;

    public class CollegueA extends Collegue {

    public CollegueA(String name, Mediateur mediateur) {
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
6) Créer la classe CollegueB
```
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
```
    package adaming.com;

    public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MediateurImpl mediateur=new MediateurImpl();
		Collegue a1=new CollegueA("C1", mediateur);
		Collegue a2=new CollegueA("C2", mediateur);
		Collegue b1=new CollegueA("C3", mediateur);
		a1.envoyerMessage(new Message("je suis à 20 m", "C2"));
		
	}

    }
```
Lien pour avoir tous les trucs de mise en page qu'il faut : https://guides.github.com/features/mastering-markdown/
