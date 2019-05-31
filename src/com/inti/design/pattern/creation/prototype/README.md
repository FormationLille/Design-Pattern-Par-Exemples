# Tutoriel de Design Pattern - Prototype

    Auteur : Romain Parisot
    
    Le but du design pattern Prototype est de pouvoir facilement copier un objet d�j� instanci�. Plut�t que de cr�er un nouvel objet et de l'instancier avec les m�mes param�tres que l'objet � copier, on clone directement l'objet, � la mani�re de la mitose des cellules.
    Cel� permet une �conomie de ressources car on �vite la cr�ation classique d'objets pour une m�thode plus optimis�e. C'est une meilleure m�thode pour cr�er des objets, notamment lorsque la cr�ation de ceux-ci fait intervenir des m�thodes co�teuses comme par exemple l'acc�s � une base de donn�es.

# Implementation

Nous sommes dans une soci�t� de burgers. Le but est de pouvoir �tre le plus productif en fabriquant des burgers rapidement.
Le soucis est qu'un burger necessite plusieurs ingr�dients, mis dans un ordre pr�cis.

## Etape 1 : Les burgers classiques
La technique classique pour cr�er un burger est la suivante :
- on commmence par donner un nom au burger
- on ajoute ensuite le premier ingr�dient (typiquement le pain)
- puis on ajoute le second
- puis le troisi�me
- jusqu'� arriver au dernier ingr�dient (le pain du dessus)

```java
Burger vegi = new Burger("Vegi Burger");
		vegi.addIngredient("Bun");
		vegi.addIngredient("Steak de soja");
		vegi.addIngredient("Salade");
		vegi.addIngredient("Radis");
		vegi.addIngredient("Concombre");
		vegi.addIngredient("Guacamole");
		vegi.addIngredient("Bun");
```

Ceci doit �tre r�p�t� pour chaque client et est tr�s fastidieux.

## Etape 2 : La r�volution des burgers clonables
Heuresement, notre ing�nieur a mis au point un nouveau type de Burger ! Les burgers clonables !
```java
public class Burger implements Cloneable
```

Gr�ce a ses Burgers et � leur m�thode clone(), tout va devenir plus simple !
```java
// M�thode de clonage du burger
	@Override
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return object;
	}
```

## Etape 3 : Le clonage de masse
En effet, cette methode permet � un burger de cr�er une copie de lui-m�me. Ceci permet un gain de temps consid�rable, car il nous suffit d�sormais de cr�er un seul burger et on se contentera de le cloner pour chaque client.
```java
for(client : clients){
  Burger monBurger = burgerType.clone();
}
```

# Conclusion
Le design pattern Prototype permet de cloner un objet afin d'�viter de recr�er l'objet de z�ro. il permet une optimisation des performances du programme.
Pour impl�menter ce designe pattern en Java, in suffit de d�clarer la classe que l'on souhaite cloner comme clonnable et de lui donner la m�thode appropri�e :
```java
public class Burger implements Cloneable {
  // M�thode de clonage du burger
	@Override
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return object;
	}
}
```

Attention : il faut bien penser � cr�er la m�thode clone() car elle n'est pas utilisable directement. Le mod�le ci-dessus est la version g�n�rique de la m�thode.
tous les objets ne peuvent pas non plus �tre clonnable, il faut donc �tre prudent et v�rifier ce que l'on fait. Dans le cas o� votre classe poss�de un attribut non immuable et non clonable,vous pouvez vous retrouver dans le cas o� vos deux objet (original et clone) poss�de le m�me attribut (m�me instance).