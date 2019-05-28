# Mon tutoriel de Design Pattern - BRIDGE

    Par Antoine C.
	Sources : 
	- [Design Patterns - Bridge Pattern](https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm)
	- [Cours design pattern m youssfi partie 7 facade bridge flyweight](https://fr.slideshare.net/mohamedyoussfi9/cours-design-pattern-m-youssfi-partie-7-facade-bridge-flyweight)
	- [Le Bridge Design Pattern, un patron de conception essentiel (Lea Fayolle)](https://medium.com/@fayolle.lea/le-bridge-design-pattern-un-patron-de-conception-essentiel-5a2e11dca972)
	
	Face à l’évolution rapide des applications et des besoins des clients, un Design Pattern comme le **BRIDGE** permet de faciliter les ajouts de fonctionnalités et de rendre certains composants réutilisables.
	
	Bridge est un design pattern de **Structure**.
	
	Comme les Patterns *Facade* et *FlyWeight*, on l’utilise lorsqu’un système est complexe. Cette complexité apparaît quand un sous-système fait appel à plusieurs interfaces.
	
	2 Objectifs avec Bridge :
	
- Détacher l'abstraction de son implémentation. Ainsi les 2 peuvent varier indépendamment.
- Ajouter progressivement des fonctionnalités tout en séparant les grandes déviations à l’aide de classes abstraites.

# Implementation

**Contexte fonctionnel :** Un magasin de musique a besoin d’une application qui permette d'associer ses instruments a une catégorie de prix (petit prix, prix moyen, prix élevé).

Objectif : Concevoir des instruments et leur attribuer un ordre de prix.
 
Si nous abordons le problème sans utiliser le BRIDGE.
Nous obtenons un diagramme de classe de ce type :  

![Gestion Magasin SANS Bridge](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Diagramme%20sans%20nom%20(3).drawio#R7VrbbuIwFPyaSLsPXeVCgD5Celup1aJSdZ%2FdxASrjo0cU6Bfv8fEaeIk0LSFbStFQiWe%2BILPzBk7cS0vSNaXAi3mNzzC1HLtaG15Z5brOrZjw5dCNhnie14GxIJEulIBTMkzzltqdEkinBoVJedUkoUJhpwxHEoDQ0LwlVltxqk56gLFuAZMQ0Tr6F8SyXmGDt1BgV9hEs%2FzkZ3%2BaXYnQXllPZN0jiK%2BKkHeueUFgnOZXSXrAFMVvDwuWbuLHXdffpjATLZpQNe9%2Bys2u7gOHu6Xdyd38UnQP9G9PCG61BMePaRSIIikawcUpSl8%2F2YALRM1TjYTucnDk65IQhGD0njGmZzqOw6UESUxg%2BsQ2mEBwBMWkkBkR%2FqG5AtAwzmh0TXa8KWaRSpR%2BJiXxnMuyDN0i6juE24LqUXi9o0aU9USYBtQgVOoM8lD41SgG7Q2Kl6jVGog5JSiRUoeXqaRIBETNuZS8kRXqkc%2BDyPMEK9LkGbiEvMES7GBKvndXBU6LXq6uCo05vQ1Ni%2Fry9Mg0rqOX7p%2BGe0W8gCxGGbwpuEGDcNBjI3REAUqGZJ4zJcsSst6g4vSRAtoq8I3KNKtKdJyIeI2F5HAE0HWcG15I%2Fg7lYKwuCZJYEBupSL4Iw445aC9M8YzjRJKK1AuU4pncqdI0wUKYazrbZ2zXoHc6lgpiEPbGd2m%2BJxEEWZKYFwiiTI1KeksOGFyG0x%2FDB8IeWD%2F8i0ffngAZacow0dVFzLgKv0Q2WoNg1RXWMm1QYV7M%2Fx1aW5Mzl%2BTYlUbZSUaonirArwGBVQ4pmTLXcZx7svOuwhOgCqKC0bvFOFnJ06Nda%2FOutfAMEUPmE54SiThqn%2BR1a0w%2F1nk%2Bm47codH4ra3I7uLJebHnzzRf1pKYp6TWW7pskv4g2qi33LtGexZej4kitOaKMydRwDej9Nu73GgvYdnbAVcb1Cn32%2FcehzL8J36LrRz%2FFdy5UPLeRO9fu9Y7O7a0ZWT23D9zt8PqoBhg783KuBo%2BV1f9U2Dv%2B8eLQ9n765vPut9BYP3O4NvvX3rtSb8yzh8f6%2FD31d39Z2%2FH1YAn2%2Fwg1cMfoJFuOwc%2FmAvD33D4Xv28NMdftg5fOsEH7Qm%2FMs4fP0RXTl84FqjcoZ3Ln9EEXy6y%2BdnCPtyHLNopE7dlHWrFYCEymdlknvwTvfDkXEOV49CadqNs9aYwBRJ8mSe3u05LJko5kvWalc3z5WXXilfihDrVm7ptK3aUWUX7gwrHcFiFGNZ6%2Bhgxygt3ql8d7K8Q5FVfWT672S1OPL47mS5FbJ69nvJso9FFhSL4%2FisevFPDd75Pw%3D%3D)
 
 L’implémentation est directement déclarée dans la classe abstraite. Le problème survient dans 2 cas : 
 
- Si le commerçant, satisfait de cette application qui lui permet d’avoir une vision ordonnée de son stock, souhaite étendre l’application au reste du magasin (Livre, Accessoires et Disques). 
	-> Car nous serions obligé de refaire la même implémentation dans 3 les nouvelles classes abstraites.
- Si le commerçant souhaite modifier son actuel méthode `instrument(OrdrePrix)`
	-> Car nous serions obligé de modifier la classe abstraite existante en redéfinissant la méthode, ce qui n’est pas une bonne pratique, ça pourrait avoir faire planter une application qui jusque là était efficace.
 
 Le **design pattern Bridge** permet d'obtenir un résultat facilement modifiable et réutilisable.

![Gestion Magasin AVEC Bridge](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Diagramme%20sans%20nom2#R7V1dc9o4FP01zKQPZfwNfgwk%2FZhpZ7NNp7v7KLAATQ2itkigv34lWwJLssEQC2c3zmQIvpYF1j1X9%2BhYUnrueLn9mID14iuOYNxzrGjbc%2B96jjP0HPrKDLvc4HlebpgnKMpN9sHwiH5DbrS4dYMimEoFCcYxQWvZOMWrFZwSyQaSBD%2FLxWY4lj91DeZQMzxOQaxb%2F0IRWfDbcgYH%2ByeI5gvxyXYQ5meWQBTmd5IuQISfCyb3vueOE4xJ%2Fm65HcOYtZ1ol%2Fy6DxVn918sgStS54LdJvy1%2FvP203rwcWg%2F%2FhrfTT%2Ft3vNankC84Td8O0lJAmhLOtY4BmlK%2F35eUdNmyT4nvxOyE82TPqNlDFb0aDTDK%2FLIz9j0GMRovqLvp%2FQ6mFDDE0wIoi17y08QvKbW6QLF0Rewwxt2FykB05%2FiaLTACfpNqwUxr5OeTggHiRNIJR7ZldRsUWsCU1rmQTSNrZi%2Bgq1U8AtICTdMcRyDdYom%2B9tYgmSOViNMCF7yQrzN6O3AbaUz7L2LaWhAvIQk2dEi4gJxCQ8Lnx8%2BHzBmBxw4Cwlf3Ag4ruf7qg%2Bup2%2B4989AgqMhoee4OIkS%2BJCgLT3Tc2%2Fp6x8HiwIF2hgkc1GCf8IxjjH1%2Bd0K59hAcayYBDxiOCOV4EjXYIpW8y9ZmTvvYPnGm4SZML12FmehtUBRBFfMsZgAAnIvMpetMVqRrMn8Ef2ljTi2%2Bn7Pp198TI%2FtwzH9ZcUTMsYM9gBlDoUUIs%2BQwaSe96uDTYcEhwDFcy0IiHKNI8AtQYDi4xhlvst9LPpD%2ByIHL6mrYnjw6Hfm8Lv3tuZ1V%2Fe6W%2BLhGExg%2FIBTRBBm9Sd5WcXzbTnXd%2Bo5d2jIt16Jb0dS136zj%2Bx3PQYx1867ulH2dVLqNJjcvNv3A0%2BYfl6xXNcbNAoYAY5TgPFN5QNbpwafWSKfgSk8mgc6SnAZJfBVSlATAeYogd1xgpq9AAO6uBfaRB%2Byn5f1Dq%2BcLNgdWzDo3rbpgl3FFzomcH0wtE8F%2FNOxDlfRLZNbWHZnsgGaslRMliJNV%2FWQtGWS3d8slq2%2BRRMOt%2FzD%2FNN3rKEw3In8nB%2FtikcPMEH0ThmjyI1bRFiVNq3R5cdShfT4UB872BUO1NryW4WRphMpiZ02B94kU3ikIXmzUcYyh0cB4ZQDooAA%2FwgAEhgDgp7k71uGCv4JDywICtrE0JKIyFDBVX6b%2FKKi4KTU43jH68mbQasng%2Bj%2Bpl%2BA2qAEtUEs0nWmGQo8Br82OI9h18p%2BiqZgzv5a%2FT69xBZV0K%2BU15Kfrer1ChGQEcvKrof1LmBDcJozWfvMnpDnQ%2B%2BlXOQ4RfVCR6aoodYzeWUkxFjHNNBcLGuWY0pWYdoNUSwdFxznzaiZcqA7VvtDl2EFgZkhyJ4AMOJCdmv4ZtmKgRHL4JWPWMJuxGLOvW2PWESOUQJ%2B7PRupVzQyZzXHtwcx03rgxtH1zk1Lyd4s4pgxJv1eYEIfFyDjOo%2FJ2Bdb6TzkjzLG8sd6g0TOKYaRidXWsMURn0c4RFIF1lL2ee0yunRVVuDoSCUuY0dXjgasu0TFRkeDjlljOjNuVP1gvdf9WYNMtN5s6431SBX6zHsTLeMu7w5ZzbW07btzTJCcbnuJK6dCMPo2%2Be7j%2FcFHWqiFn2T2pTWI%2FN8VwBv6XDTFK90HQ0Gsjb1AJPpRvNNJ00Zlaa89p%2Bqu2VPTjtpyqQ0lcfi65Wm3LLHrZ001ZB725am3LLHp5I0laWCTpm6sjJ1AjatK1Ou%2FgBTZhA%2Fuhn55glEKPEH1xn0%2FZoMwjKWLsqUuY5BGGUQQTMMwpRY69ZQ9zoGcal7PX0seV0GUab2SQziRzeDvwUCcRw1fs1OwRiB8HRdURAIhpKveEfbtuMPZvlD4MoKhOsEtRmEMQ3CK9MoOwZhkkF4VjlMXosGIRZqdwzChHvb1iC8KtFxnwhuOtJwFdJwAiitqw6erkXuSQMkiHRr%2FlogDdnE85YpQ7mK2VEGg5TBe%2BWUoWyFRUcZGnJv65ShXGXMRId9JuhYw5VYw3GstM8adP2xKDXcx%2FBJzwwdazDLGry6XYhB1lCuXHaswSBrGL5u1uDrqmTHGhpzb9uswa9SFvdpoKMMV6IMx4HSOmXwdUnqfkvgKtLX6xYmP09izDL1iJp4KreD%2FPADYp%2Bftf85%2Bw5YfS8IeoVtB%2By%2BNdjvQ3DhtgNW0DtsO8B2NgjFPgSt7Dsg5sKe3HiggmWWYeSlU%2FcHnsRV9vN1z95lQEgjYt5v4MsVVUz3poACu0IxHrPVXzgM5C%2FseEoI5DU2Opfc10WXa8aIAHRP2kPDPw7lQ2ANPCWufO%2BSuGowEMSk7EsDgWOB3pofyrBzj3SnLw0VmdX7g0vXLA1OVNRQpKj7fniDQXWkHK4W1ePZLIVGVmb4NfSqkjCSFtrIQVSIMOe8mMq2u%2FGlwLKHgzaThBD%2BT%2B9Oc3qZUFPQ9ywZSnYY9pXuvS76%2FeBkVQ3hP1Aykpj1ZTZTnLda1zi29xst5di2rPMJUCGTuEEopZKW04iYPnE6VK5HqDwlTbiqplM7UAYnKmooTHxlmymXDwjMhsl5q6CNhonVu4xWOZ6v8Cq79YCoO8C4ZkCoE6%2BCSwMiPFFRUwGhZCiPB4jZgChbenT5alUoRif1VqKaHdgH9lAJFP%2BigX3dQDkyXggsMZQT9MPgeGHgKB3rpRv4OQplCty%2BMkpvasjgqLngCPSvOmQoe35xSXgUUC%2BMEzD9Oc%2B2lnnPK2HCZzKf3DgMLEw1pK%2FK%2B3d6zKHlOoZsC%2FfaYfe%2FXADu%2B4oQFOohJijHC1eA08PD%2F23JoXb45zfu%2Fb8%3D)

Le Design Pattern Bridge va nous permettre de créer des implémentations de manière efficace, méthodique et indépendante. Chaque implémenteur (PetitPrix.java, PrixMoyen.java et PrixEleve.java) héritera de l’interface et viendra redéfinir la méthode `assigner()` afin qu’elle corresponde aux attentes. 

### Etape 1

Créez un nouveau projet : GestionMagasinAVECBridge.

Dans un premier package, `tuto.bridge.implémentation`, créez l’interface et les classes qui implémentent cette interface :

    package tuto.bridge.implementation;

	public interface OrdrePrix { // implémenteur du Bridge

	public void assigner(); // -> méthode pour assigner un ordre de prix

	}
-------------------
    package tuto.bridge.implementation;

	public class PetitPrix implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" petit prix ");

	}

	}
-------------------
	package tuto.bridge.implementation;

	public class PrixMoyen implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" prix moyen ");

	}
	}
-------------------
	package tuto.bridge.implementation;

	public class PrixEleve implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" prix elevé ");

	}

	}

### Etape 2

Dans un autre package, `tuto.bridge.abstraction` (qui nous permet de souligner l’indépendance de l’abstraction vis-à-vis de son implémentation), rapporter les classes suivantes :

	package tuto.bridge.abstraction;

	import tuto.bridge.implementation.OrdrePrix;

	public abstract class Instrument {

	protected OrdrePrix ordrePrix; // on utilise l'interface OrdrePrix

	public Instrument(OrdrePrix ordrePrix) {
		super();
		this.ordrePrix = ordrePrix;
	}

	public abstract void assigner();

	}
-------------------
	package tuto.bridge.abstraction;

	import tuto.bridge.implementation.OrdrePrix;

	public class InstruCordes extends Instrument {

	private String nom;

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
	package tuto.bridge.abstraction;

	import tuto.bridge.implementation.OrdrePrix;

	public class InstruPercu extends Instrument {

	private String nom;

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
	package tuto.bridge.abstraction;

	import tuto.bridge.implementation.OrdrePrix;

	public class InstruVent extends Instrument {

	private String nom;

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

	Testez votre programme dans le package `tuto.bridge`

	package tuto.bridge;

	import tuto.bridge.abstraction.InstruCordes;
	import tuto.bridge.abstraction.InstruPercu;
	import tuto.bridge.abstraction.InstruVent;
	import tuto.bridge.abstraction.Instrument;
	import tuto.bridge.implementation.PetitPrix;
	import tuto.bridge.implementation.PrixEleve;
	import tuto.bridge.implementation.PrixMoyen;

	public class Application {

	// on utilise les classes Instrument et l'interface OrdrePrix
	// pour assigner un ordre de prix à chaque instrument.

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

La Classe `Application` nous  permet d'associer les instruments aux différentes catégories. Il sera maintenant facile et sûr d’ajouter et de modifier des fonctionnalités en utilisant l'Interface `OrdrePrix`.

Il sera également facile de multiplier les produits à traiter: tout comme la classe abstraite `instrument`, les classes  `Livre`, `Disque` et `accessoire` vont avoir l’instance `protected OrdrePrix ordrePrix` qui permettra d’attribuer un niveau de prix à chaque article. 

**Dans cet exemple notre design pattern nous évite de faire des redéfinitions de méthode, et des doublons.**

### Résumé

> Nous avons séparé les différents composants de cette application, cela nous permet d'obtenir une solution facilement réutilisable. 

> *"L’héritage associe étroitement une abstraction à une implémentation au moment de la compilation. Le *Bridge Design Pattern* est très utile pour éviter ce lien fort. Il permet de sélectionner l’implémentation au moment de l’exécution."* [Lea Fayolle](https://medium.com/@fayolle.lea/le-bridge-design-pattern-un-patron-de-conception-essentiel-5a2e11dca972)
	