# Tutoriel Design Pattern (Rémy) - Pattern Composite

Composite est un Design Pattern de structure.
Il permet d'organiser les objets en structure arborescente hiérarchisée et d'isoler des objets appartenant à un aggrégat.
	= Il permet de gérer un ensemble d'objets en tant qu'un seul.

Il rend le code plus simple en permettant de manipuler les éléments qui composent un objet sans avoir à modifier celui de leurs classes.
La partie cliente peut ainsi manipuler un objet unique et un objet composé de la même manière.

# Exemple

Prenons comme modèle une cave à vin.
Dans celle-ci on peut trouver des bouteilles de vin ou de biére; on a donc un nombre de bouteilles de vin v et un nombre de bouteilles de biéres b,
leur somme représentée par un nombre de bouteilles total.

Note : dans cet exemple le nombre de bouteilles de vin (ou de biére) est considéré comme un objet FIXE, on ne peut pas modifier directement ce nombre.

![DPComposite](C:\Users\IN-LL-033\Pictures\DPComposite.png " Diagramme de classes Cave à Vin")


### Création de nos Classes

On commence par la création de nos différentes classes et interfaces.

* _Création de l'interface **Composant** : _   	

```javascript
    public interface Composant {
		public int NbrBouteilles();
		}
```

Elle sera implémentée par nos différents éléments

* _Création de la classe **BouteilleBiere** : _

```javascript
    public class BouteilleBiere implements Composant{
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


* _Création de la classe **BouteilleVin** : _

```javascript
	public class BouteilleVin implements Composant {
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

* _Création de la classe **Cave** : _

```javascript
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Iterator;

	public class Cave implements Composant{
		private Collection elements;

		public Cave() {
			elements = new ArrayList();
		}

		public void remove(Composant composant) {
			elements.remove(composant);
		}

		public void add(Composant composant) {
			elements.add(composant);
		}

		public Iterator getElements() {
			return elements.iterator();
		}
		@Override
		public int NbrBouteilles() {
			int result = 0;
			for (Iterator i = elements.iterator(); i.hasNext(); ) {
				Object objet = i.next();
				Composant composant = (Composant)objet;
				result += composant.NbrBouteilles();
			}
			return result;
		}
	}
```

* _Et enfin création de la classe **Test** : _

```javascript
	public class Test {

	public static void main(String[] args) {
		
		System.out.println("--  Inventaire  --");
		System.out.println("");
		
		BouteilleBiere maBiere = new BouteilleBiere(10);
		System.out.println("-Bières : "+maBiere.NbrBouteilles()+" bouteilles");
		System.out.println("");

		BouteilleVin monVin = new BouteilleVin(20);
		System.out.println("-Vin : "+monVin.NbrBouteilles()+" bouteilles");

		System.out.println("");
		
		Cave maCave = new Cave();
		maCave.add(monVin);
		maCave.add(maBiere);
		System.out.println("-Total : "+maCave.NbrBouteilles()+" bouteilles");
		System.out.println("     Je suis fin heureux :) ");
	 }
	}
```
	
### Résultat

Une fois le test lancé on devrait retrouver le résultat suivant sur la console

![RésultatTest] (C:\Users\IN-LL-033\Pictures\DBComposite2.png)

On retrouve bien le total de bouteilles pris en compte dans notre cave.

### Etape finale

    Faites un calin aux gens que vous aimez, c'est important.

    Lien pour avoir tous les trucs de mise en page qu'il faut : https://guides.github.com/features/mastering-markdown/
