#  Tutoriel Design Pattern (Rémy) - Pattern Composite

Composite est un Design Pattern de structure qui permet d'organiser des objets similaires
(ou avec des fonctions similaires) en structure arborescente hiérarchisée.

L'idée est de manipuler un groupe d'objets de la même façon que s'il s'agissait d'un objet unique.
Cela permet de simplifier le code et de manipuler directement les éléments qui composent un objet sans
avoir à modifier le code de leurs classes.

En régle générale on retrouve différents éléments: 

![DPComposite2](https://user-images.githubusercontent.com/49645454/58750191-79ca4680-848f-11e9-84cc-6c2510ae1e38.png)

- Objet : l'interface pour la composition des objets, donne le comportement par défaut.
- ObjetSimple : implémente l'interface commune Objet et représente l'objet manipulé.
- ObjetComposite : permet de stocker et de gérer nos composants, et de leur définir un comportement.
 
# Exemple : Cave à vins.

Si on prend comme exemple la gestion du nombre de bouteille que contient une cave, on admet qu'on puisse y trouver
un nombre de bouteilles de vin _nombreV_, et/ou un nombre de bouteilles de biére _nombreB_.
Ces 2 nombres sont nos objets à manipuler et leur somme donne le nombre total de bouteilles de notre cave.
Dans notre classe Composite (notre Cave) dans laquelle on définit une collection contenant ces 2 nombres on pourra
manipuler notre nombre de bouteilles total directement.

![DPComposite 13215](https://user-images.githubusercontent.com/49645454/58750187-6dde8480-848f-11e9-9998-8b9ebe593866.png)

### Création des Classes

On commence par la création de notre interface et de nos classes :

	- une interface _Bouteilles_ simple dans laquelle on définit un nombre de bouteilles;
	
	- une classe _BouteilleBiere_ et une classe _BouteilleVin_ qui implémentent cette interface et qui permettent la création 
	de nos objets, respectivement nombreB et nombreV;

	- une classe composite _Cave_ qui implémente également l'interface _Bouteilles_ et dans laquelle on définit une
	collection pour stocker et manipuler nos objets nombreB et nombreV.

 _Création de l'interface **Bouteilles** :_   	

```javascript
    public interface Bouteilles {
		public int NbrBouteilles();
		}
```

 _Création de la classe **BouteilleBiere** :_

```javascript
    public class BouteilleBiere implements Bouteilles{
		private int nombreB;

		public BouteilleBiere(int nbre) {
			this.nombreB = nbre;
		}
		@Override
		public int NbrBouteilles() {
			return this.nombreB;
		}
    }
```

_Création de la classe **BouteilleVin** :_

```javascript
	public class BouteilleVin implements Bouteilles {
		private int nombreV;
	
		public BouteilleVin(int nbre) {
			this.nombreV = nbre;
			}
		@Override
		public int NbrBouteilles() {
			return this.nombreV;
		}
	}
```

_Création de la classe Composite **Cave** :_

```javascript
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Iterator;

	public class Cave implements Bouteilles{
		private Collection elements;

		public Cave() {
			elements = new ArrayList();
		}

		public void remove(Bouteilles bouteille) {
			elements.remove(bouteille);
		}

		public void add(Bouteilles bouteille) {
			elements.add(bouteille);
		}

		public Iterator getElements() {
			return elements.iterator();
		}
		@Override
		public int NbrBouteilles() {
			int result = 0;
			for (Iterator i = elements.iterator(); i.hasNext(); ) {
				Object objet = i.next();
				Bouteilles bouteille = (Bouteilles)objet;
				result += bouteille.NbrBouteilles();
			}
			return result;
		}
	}
```

### Création d'un main et lancement de l'application

Tout est dit dans le titre, il ne nous reste plus ici qu'à donner une valeur à nos objets _nombreB_ et _nombreV_, 
à les stocker dans notre cave et à vérifier que tout s'est bien déroulé.

_Création de la classe **Test** :_

```javascript
	public class Test {

	public static void main(String[] args) {
		
		System.out.println("Nombre de bouteilles : ");
		System.out.println("");

		BouteilleBiere maBiere = new BouteilleBiere(10);
		System.out.println("-Bière : "+maBiere.NbrBouteilles()+" bouteilles");
		System.out.println("");

		BouteilleVin monVin = new BouteilleVin(20);
		System.out.println("-Vin : "+monVin.NbrBouteilles()+" bouteilles");

		System.out.println("");

		Cave maCave = new Cave();
		maCave.add(monVin);
		maCave.add(maBiere);
		System.out.println("-Total : "+maCave.NbrBouteilles()+" bouteilles");

	 }
	}
```
	
### Résultat

Une fois le test lancé on devrait retrouver le résultat suivant sur la console

![DBComposite2](https://user-images.githubusercontent.com/49645454/58750178-48517b00-848f-11e9-8d72-665334c8be20.png)

Notre cave contient bien 30 bouteilles au total et est donc bien composée

- d'un nombreV de bouteilles de vin = 10 
- d'un nombreB de bouteilles de bière = 20
	
Note : Dans cet exemple on a utilisé uniquement l'opération add() pour ajouter les bouteilles à notre cave, 
mais on peut aussi utilisé l'opération remove() définie ou toute autre opération JavaScript qui permettrait 
de manipuler une collection.
