# Mon tutoriel de Design Pattern - Memento 
R�alis� par Pierre Laurend dans le cadre de la formation Adaming Mars - Juin 2019
 Bas� sur un exemple de tutoriel sur memento de (tutorialpoint.com)
  
### *Description du design pattern*
    
Le design pattern Memento est utilis� pour restaurer l'�tat d'un objet � un �tat ant�rieur. 
M�mento est class� dans la cat�gorie de mod�le de comportement. (Au m�me titre que "Chain", "Iterator", "Mediator", "Observer" et "State")


### *Memento is Rollback ?*

- Le design pattern Memento utilise trois classes d'acteurs. Memento contient l'�tat d'un objet � restaurer. Originator cr�e et stocke les �tats dans les objets Memento, tandis que l�objet Gardien est charg� de restaurer l��tat de l�objet � partir de Memento. Nous avons cr�� les classes Memento , Originator et CareTaker .

- MementoPatternDemo , notre classe de d�monstration, utilisera les objets CareTaker et Originator pour montrer la restauration des �tats d'objet.

    
    
    



### Etape 1

##### Cr�er une classe de m�mento.


**Memento.java**

```java
public class Memento {
	private String nomDeQuelqunDeLaFormation;

	public Memento(String nomDeQuelqunDeLaFormation) {
		this.nomDeQuelqunDeLaFormation = nomDeQuelqunDeLaFormation;
	}

	public String getNomDeQuelqunDeLaFormation() {
		return nomDeQuelqunDeLaFormation;
	}
}

```

### �tape 2
##### Cr�er une classe d'origine

**Originator.java**
```java
public class Originator {
	private String nomDeQuelqunDeLaFormation;

	public void setNomDeQuelqunDeLaFormation(String nomDeQuelqunDeLaFormation) {
		this.nomDeQuelqunDeLaFormation = nomDeQuelqunDeLaFormation;
	}

	public String getNomDeQuelqunDeLaFormation() {
		return nomDeQuelqunDeLaFormation;
	}

	public Memento saveNomDeQuelqunDeLaFormationToMemento() {
		return new Memento(nomDeQuelqunDeLaFormation);
	}

	public void getNomDeQuelqunDeLaFormationFromMemento(Memento memento) {
		nomDeQuelqunDeLaFormation = memento.getNomDeQuelqunDeLaFormation();
	}
}

```
### �tape 3
##### Cr�er une classe ListeDeNosObjetsSauvegard�s

**ListeDeNosObjetsSauvegardes.java**
```java
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ListeDeNosObjetsSauvegardes {
	private List<Memento> mementoList = new ArrayList<Memento>();
	public void add(Memento nomDeQuelqunDeLaFormation) {
		mementoList.add(nomDeQuelqunDeLaFormation);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}
```
### �tape 4
##### Utilisez les objets CareTaker et Originator .

**MementoPatternDemo.java**
```java
public class MementoPatternDemo {
	public static void main(String[] args) {
		Originator originator = new Originator();
		ListeDeNosObjetsSauvegardes ListeDesNoms = new ListeDeNosObjetsSauvegardes();
		originator.setNomDeQuelqunDeLaFormation("Yann Marson");
		originator.setNomDeQuelqunDeLaFormation("Antoine Storme");
		ListeDesNoms.add(originator.saveNomDeQuelqunDeLaFormationToMemento());
		originator.setNomDeQuelqunDeLaFormation("No�mie Eliazord");
		ListeDesNoms.add(originator.saveNomDeQuelqunDeLaFormationToMemento());
		originator.setNomDeQuelqunDeLaFormation("Florian Ledunkerquois");
		System.out.println("Nom ajout� en dernier :  " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(0));
		System.out.println("Premier nom sauvegard� : " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(1));
		System.out.println("Deuxi�me nom sauvegard� : " + originator.getNomDeQuelqunDeLaFormation());
	}
}
```
### �tape 5
##### V�rifiez la sortie.

```java

Nom ajout� en dernier :  Florian Ledunkerquois
Premier nom sauvegard� : Antoine Storme
Deuxi�me nom sauvegard� : No�mie Eliazord
```

**F�licitations, vous �tes devenus des experts du design pattern Memento !** 
Satisfaits par ce tutoriel ? N'hesitez pas � soutenir son cr�ateur en donnant un peu d'argent. (En pi�ce jointe sur GitHub, le diagramme de classe sous forme de sch�ma et mon RIB)

 