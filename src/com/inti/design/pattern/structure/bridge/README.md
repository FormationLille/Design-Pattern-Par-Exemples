# Mon tutoriel de Design Pattern - BRIDGE

Par Antoine C.
Sources : 
[Design Patterns - Bridge Pattern](https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm)
[Cours design pattern m youssfi partie 7 facade bridge flyweight](https://fr.slideshare.net/mohamedyoussfi9/cours-design-pattern-m-youssfi-partie-7-facade-bridge-flyweight)
[Le Bridge Design Pattern, un patron de conception essentiel (Lea Fayolle)](https://medium.com/@fayolle.lea/le-bridge-design-pattern-un-patron-de-conception-essentiel-5a2e11dca972)
	
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

![Gestion Magasin SANS Bridge](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Diagramme%20sans%20nom.drawio#R7VrvT%2BIwGP5rltx9wOwHA%2FwIQ89LNEfEcJ%2FrVkZj15KuCPjX31vWsXUDBYVTkyUE12dvW9rneZ92q5YXJKtfAs1ndzzC1HLtaGV5Q8t1XUt97GidFVtu50JDsSBRBjoFMCYvWIO2RhckwqkRKDmnksxNMOSM4VAaGBKCL82wKadmr3MU4xowDhGto39JJGcZ2nO7BX6DSTzLe3Y6l9mdBOXBeiTpDEV8WYK8K8sLBOcyu0pWAaZq7vJ5yepd77m7%2FWECM3lIBbpqT27Y9Po2eJwsHloPcSvotHQrz4gu9ID7j6kUCGbStQOK0hT%2B%2FmYALRLVTzYSuc6nJ12ShCIGpcGUMznWdxwoI0piBtch1MMCgGcsJIGZ7esbks8BDWeERrdozRdqFKlE4VNeGsy4IC%2FQLKK6TbgtpBaJ2zEixqomwDagAqcQM8qnxqlAd2hlBN6iVGog5JSieUoet8NIkIgJG3ApeaKD9JzBcPBqLxnOlmJIDcwTLMUaQvIKuSp0YrR1cVlozOlobFbWl6dBpHUdb5ve9nYPeYBYDCM4qrvuju5gjo3eEAUqGZJ4wBcsSst6g4vSQAtoo8IjFOnWFGm5MOM2F5HAI0FWcG15ffgeS0FYXJMkkCI3UhH8CQecctDekPFMo4TSCpTLlOKp3CvSdI5C6Ot2EzNsF8i9nisFcag7pZsUn5EowkwJjEskUaYmJZ05J0xuJtMfwAemPLAvfMuHHx5A2SnK8FHhQgZcpR8iG2FhkOoSK7kepsL9SV%2BX5trk%2FC0pVrVRVqIhimMV4O1QQIVjSjbcZRznvuy8i%2BAEqKK4YPRBET5sOTXWvTrr3g6GKXrEdMRTIglX7YsstsL8Z5Hru4eR2zsTt%2B092V0sMT%2F%2B5In%2B01IS85zMckuXTcKfVBOdA9ee7itLz4dEcVkThbnzCMD7cdrsPU609%2FCMrYDrdev0%2Bzu3HucyfKe%2BC20c%2F%2FDsvjx6Od9Fr98%2BF7v7dnTl5DZcv%2FH3kyqgt8PfdyrgbPldX%2FVNg580j5ans3fXN5%2F1voLB%2B43Bf2T71v7iDt951eEn1V194%2B%2BnFcDnG3z3DYMfYREuGoc%2F2ctD33D4tt37dIfvNQ7%2FkQTvfnGHrz%2BiK4cPXKtfzvDG5c8ogk93%2BfwM4bUcxyzqq1M3Zd1qBSCh8lmZ5B6cVcBR7dDtTe8rDXvnqDUmMEWSPJvNv3JYMlLMl6zVrm6eKy%2B9Ur4QIda13NJpW7Whyi7c6VUagsUoxrLW0MmOUQ54p%2FLdyfJORVb1kem%2Fk3XAkcd3J8utkNW230uWfS6yoFgcx2fhxf80eFf%2FAA%3D%3D)
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
	