# Mon tutoriel de Design Pattern - Memento 
Réalisé par Pierre Laurend dans le cadre de la formation Adaming Mars - Juin 2019
 Basé sur un exemple de tutoriel sur memento de (tutorialpoint.com)
  
### *Description du design pattern*
    
Le design pattern Memento est utilisé pour restaurer l'état d'un objet à un état antérieur. 
Mémento est classé dans la catégorie de modèle de comportement. (Au même titre que "Chain", "Iterator", "Mediator", "Observer" et "State")


### *Memento is Rollback ?*

- Le design pattern Memento utilise trois classes d'acteurs. Memento contient l'état d'un objet à restaurer. Originator crée et stocke les états dans les objets Memento, tandis que l’objet Gardien est chargé de restaurer l’état de l’objet à partir de Memento. Nous avons créé les classes Memento , Originator et CareTaker .

- MementoPatternDemo , notre classe de démonstration, utilisera les objets CareTaker et Originator pour montrer la restauration des états d'objet.

    
    
    



### Etape 1

##### Créer une classe de mémento.


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

### Étape 2
##### Créer une classe d'origine

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
### Étape 3
##### Créer une classe ListeDeNosObjetsSauvegardés

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
### Étape 4
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
		originator.setNomDeQuelqunDeLaFormation("Noémie Eliazord");
		ListeDesNoms.add(originator.saveNomDeQuelqunDeLaFormationToMemento());
		originator.setNomDeQuelqunDeLaFormation("Florian Ledunkerquois");
		System.out.println("Nom ajouté en dernier :  " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(0));
		System.out.println("Premier nom sauvegardé : " + originator.getNomDeQuelqunDeLaFormation());
		originator.getNomDeQuelqunDeLaFormationFromMemento(ListeDesNoms.get(1));
		System.out.println("Deuxième nom sauvegardé : " + originator.getNomDeQuelqunDeLaFormation());
	}
}
```
### Étape 5
##### Vérifiez la sortie.

```java

Nom ajouté en dernier :  Florian Ledunkerquois
Premier nom sauvegardé : Antoine Storme
Deuxième nom sauvegardé : Noémie Eliazord
```

**Félicitations, vous êtes devenus des experts du design pattern Memento !** 
Satisfaits par ce tutoriel ? N'hesitez pas à soutenir son créateur en donnant un peu d'argent. (En pièce jointe sur GitHub, le diagramme de classe sous forme de schéma et mon RIB)

 