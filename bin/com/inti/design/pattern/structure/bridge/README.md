# Mon tutoriel de Design Pattern - BRIDGE

Par Antoine C.

Sources : 

[Design Patterns - Bridge Pattern](https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm)

[Cours design pattern m youssfi partie 7 facade bridge flyweight](https://fr.slideshare.net/mohamedyoussfi9/cours-design-pattern-m-youssfi-partie-7-facade-bridge-flyweight)

[Le Bridge Design Pattern, un patron de conception essentiel (Lea Fayolle)](https://medium.com/@fayolle.lea/le-bridge-design-pattern-un-patron-de-conception-essentiel-5a2e11dca972)
	
Face à l’évolution rapide des applications et des besoins des clients, un Design Pattern comme le **BRIDGE** permet de faciliter les ajouts de fonctionnalités et de rendre certains composants réutilisables.
	
Bridge est un design pattern de **Structure**.
	
Comme les Patterns *Facade* et *FlyWeight*, on l’utilise lorsqu'un système est complexe.
	
3 Objectifs avec Bridge :
	
- Détacher l'abstraction de son implémentation. Les 2 doivent pouvoir varier indépendamment.
- Ajouter progressivement des fonctionnalités tout en séparant les grandes déviations à l’aide de classes abstraites.
- Optimiser le système

# Implémentation

**Contexte fonctionnel :** Un magasin de musique a besoin d’une application qui permette d'associer ses instruments a une catégorie de prix (petit prix, prix moyen, prix élevé).

Objectif : Concevoir des instruments et leur attribuer un ordre de prix.
 
Si nous abordons le problème sans utiliser le BRIDGE.
Nous obtenons un diagramme de classe de ce type :  

<img src="Diagramme SANS Bridge.png" />

L’implémentation est directement déclarée dans la classe abstraite. Le problème survient dans 2 cas : 

- Si le commerçant, satisfait de cette application qui lui permet d’avoir une vision ordonnée de son stock, souhaite étendre l’application au reste du magasin (Livre, Accessoire et Disque). 
	
	-> Car nous serions obligé de refaire la même implémentation dans les 3 nouvelles classes abstraites.
- Si le commerçant nous demande de modifier cette application.
	
	-> Car nous serions obligé de modifier la classe abstraite existante en redéfinissant la méthode, ce qui n’est pas une bonne pratique, ça pourrait faire planter une application qui jusque là était efficace.
 
 Le **design pattern Bridge** permet d'obtenir un résultat facilement modifiable et réutilisable:

<img src="Diagramme AVEC Bridge.png" />

Le Design Pattern Bridge va nous permettre de créer des implémentations de manière efficace, méthodique et indépendante. Chaque implémenteur (PetitPrix.java, PrixMoyen.java et PrixEleve.java) héritera de l’interface et viendra redéfinir la méthode `assigner()` afin qu’elle corresponde aux attentes. 

### Etape 1

Créez un nouveau projet : com.inti.design.pattern.structure.bridge

Dans un premier package, `com.inti.design.pattern.structure.bridge.implementation`, créez l’interface et les classes qui implémentent cette interface :

    package com.inti.design.pattern.structure.bridge.implementation;

	public interface OrdrePrix { // implémenteur du Bridge

	public void assigner(); // -> méthode pour assigner un ordre de prix

	}
-------------------
    package com.inti.design.pattern.structure.bridge.implementation;

	public class PetitPrix implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" petit prix ");

	}

	}
-------------------
	package com.inti.design.pattern.structure.bridge.implementation;

	public class PrixMoyen implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" prix moyen ");

	}
	}
-------------------
	package com.inti.design.pattern.structure.bridge.implementation;

	public class PrixEleve implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" prix elevé ");

	}

	}

### Etape 2

Dans un autre package, `com.inti.design.pattern.structure.bridge.abstraction` (qui nous permet de souligner l’indépendance de l’abstraction vis-à-vis de son implémentation), rapportez la classe **abstraite** Instrument et les classes qui l'étendent :

	package com.inti.design.pattern.structure.bridge.abstraction;

	import com.inti.design.pattern.structure.bridge.implementation.OrdrePrix;

	public abstract class Instrument {

	protected OrdrePrix ordrePrix;

	public Instrument(OrdrePrix ordrePrix) {
		super();
		this.ordrePrix = ordrePrix;
	}

	public abstract void assigner();

	}
-------------------
	package com.inti.design.pattern.structure.bridge.abstraction;

	import com.inti.design.pattern.structure.bridge.implementation.OrdrePrix;

	public class InstruCordes extends Instrument {

	public String nom;

	public InstruCordes(OrdrePrix ordrePrix, String nom) {
		super(ordrePrix);
		this.nom = nom;
	}

	@Override
	public void assigner() {
		System.out.println(nom + ", ordre de prix :");
		ordrePrix.assigner();

	}

	}
-------------------
	package com.inti.design.pattern.structure.bridge.abstraction;

	import com.inti.design.pattern.structure.bridge.implementation.OrdrePrix;

	public class InstruPercu extends Instrument {

	public String nom;

	public InstruPercu(OrdrePrix ordrePrix, String nom) {
		super(ordrePrix);
		this.nom = nom;
	}

	@Override
	public void assigner() {
		System.out.println(nom + ", ordre de prix : ");
		ordrePrix.assigner();

	}

	}
-------------------
	package com.inti.design.pattern.structure.bridge.abstraction;

	import com.inti.design.pattern.structure.bridge.implementation.OrdrePrix;

	public class InstruVent extends Instrument {

	public String nom;

	public InstruVent(OrdrePrix ordrePrix, String nom) {
		super(ordrePrix);
		this.nom = nom;
	}

	@Override
	public void assigner() {
		System.out.println(nom + ", ordre de prix :");
		ordrePrix.assigner();

	}
	}

### Etape 3

Testez votre programme dans le package `com.inti.design.pattern.structure.bridge`

	package com.inti.design.pattern.structure.bridge;

	import com.inti.design.pattern.structure.bridge.abstraction.*;
	import com.inti.design.pattern.structure.bridge.implementation.*;

	public class Application {

	/*
	 * on utilise l'interface OrdrePrix pour assigner un ordre de prix à chaque
	 * instrument.
	 */

	public static void main(String[] args) {
		Instrument instr1 = new InstruVent(new PetitPrix(), "flûte à bec");
		instr1.assigner();

		Instrument instr2 = new InstruCordes(new PrixMoyen(), "guitar Fender");
		instr2.assigner();

		Instrument instr3 = new InstruPercu(new PrixEleve(), "Batterie Pearl");
		instr3.assigner();

	}

	}

### Résultat

On rappelle les 3 objectifs de départ du BRIDGE :

1. **Détacher l'abstraction de son implémentation. Les 2 doivent pouvoir varier indépendamment.**

-> Nous avons bien détaché la classe abstraite `Instrument` de la méthode `assigner()`.

2. **Ajouter progressivement des fonctionnalités tout en séparant les grandes déviations à l’aide de classes abstraites.**

-> Il sera maintenant facile et sûr d’ajouter et de modifier des fonctionnalités en utilisant l'Interface `OrdrePrix`.

-> Il sera également facile de multiplier les produits à traiter. Tout comme la classe abstraite `Instrument`, les classes  `Livre`, `Disque` et `Accessoire` vont avoir l’instance `protected OrdrePrix ordrePrix` qui permettra d’attribuer un ordre de prix à chaque article. 

3. **Optimiser le système**

-> Dans cet exemple notre design pattern nous évitera de faire des redéfinitions de méthode, et des doublons pour faire évoluer l'application.

### Résumé

> Nous avons séparé les différents composants de cette application, cela nous permet d'obtenir une solution facilement réutilisable. 

> *"L’héritage associe étroitement une abstraction à une implémentation au moment de la compilation. Le *Bridge Design Pattern* est très utile pour éviter ce lien fort. Il permet de sélectionner l’implémentation au moment de l’exécution."* [Lea Fayolle](https://medium.com/@fayolle.lea/le-bridge-design-pattern-un-patron-de-conception-essentiel-5a2e11dca972)
	
