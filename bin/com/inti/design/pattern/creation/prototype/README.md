# Tutoriel de Design Pattern - Prototype

Auteur : Romain Parisot
    
Le but du design pattern Prototype est de pouvoir facilement copier un objet déjà instancié. Plutôt que de créer un nouvel objet et de l'instancier avec les mêmes paramètres que l'objet à copier, on clone directement l'objet, à la manière de la mitose des cellules.
Cela permet une économie de ressources car on évite la création classique d'objets pour une méthode plus optimisée. C'est une meilleure méthode pour créer des objets, notamment lorsque la création de ceux-ci fait intervenir des méthodes coûteuses comme par exemple l'accès à une base de données.

# Implementation

Nous sommes dans une société de burgers. Le but est de pouvoir être le plus productif en fabriquant des burgers rapidement.
Le soucis est qu'un burger necessite plusieurs ingrédients, mis dans un ordre précis.

## Etape 1 : Les burgers classiques
La technique classique pour créer un burger est la suivante :
- on commmence par donner un nom au burger
- on ajoute ensuite le premier ingrédient (typiquement le pain)
- puis on ajoute le second
- puis le troisième
- jusqu'à arriver au dernier ingrédient (le pain du dessus)

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

Ceci doit être répété pour chaque client et est très fastidieux.

## Etape 2 : La révolution des burgers clonables
Heuresement, notre ingénieur a mis au point un nouveau type de Burger ! Les burgers clonables !
```java
public class Burger implements Cloneable
```

Grâce à ses Burgers et à leur méthode ```clone()```, tout va devenir plus simple !
```java
// Méthode de clonage du burger
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
En effet, cette methode permet à un burger de créer une copie de lui-même. Ceci permet un gain de temps considérable, car il nous suffit désormais de créer un seul burger type et on se contentera de le cloner pour chaque client.
```java
for(Client monClient : clients){
    Burger monBurger = burgerType.clone();
}
```

# Conclusion
Le design pattern Prototype permet de cloner un objet afin d'éviter de recréer l'objet de zéro. il permet une optimisation des performances du programme.
Pour implémenter ce design pattern en Java, il suffit de déclarer la classe que l'on souhaite cloner comme ```cloneable``` et de lui donner la méthode appropriée :
```java
public class Burger implements Cloneable {

    // Méthode de clonage du burger
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

Attention : il faut bien penser à créer la méthode ```clone()``` car elle n'est pas utilisable directement. Le modèle ci-dessus est la version générique de la méthode.
Tous les objets ne peuvent pas non plus être clonnable, il faut donc être prudent et vérifier ce que l'on fait. Dans le cas où votre classe possède un attribut non immuable et non clonable,vous pouvez vous retrouver dans le cas où vos deux objet (original et clone) possèdent le même attribut (même instance).

# Sites utiles :
- https://gameprogrammingpatterns.com/prototype.html
- https://ydisanto.developpez.com/tutoriels/java/cloneable/
