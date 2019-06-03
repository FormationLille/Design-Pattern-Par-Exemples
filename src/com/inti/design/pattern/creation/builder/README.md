## **Qu�est-ce qu�un Design Pattern :**

Un **Design Pattern** est la r�ponse � des probl�mes r�currents rencontr�s en informatique et surtout lors de la construction d�objets complexes.

Ces **Design Pattern** sont r�pertori�s en 3 types (cr�ation, structure et comportement).

Ils sont l� pour r�pondre � des probl�mes li�s � la cr�ation d'objets complexes par exemple, utilisable dans des cas pr�cis et r�utilisable � l�infini.

Les Design Pattern ont �taient invent�s par le GOF (Gang of Four), 4 architectes qui ont regroup�s tous les **design Pattern** dans un diagramme dit de GOF.

## **Le Design Pattern Builder :**

Ce Design Pattern permet de cr�er un objet complexe � l'aide d'objets simples et d'une approche �tape par �tape.

C'est un pattern de cr�ation qui propose la meilleure pour cr�er des objets complexes.

C�est la classe Builder qui permet de cr�er l�objet en question. Il faut savoir que cette classe est compl�tement ind�pendante des autres.

## **Exemple de cas de restauration rapide**

Nous avons envisag� un cas de restauration rapide :

Un repas typique se compose d�un burger et d�une boisson fra�che. Le Burger peut �tre un Burger V�g�tarien ou un Burger no v�g�tarien et disposera d'un emballage papier dit Wrapper. Une boisson fra�che accompagnera le reste du menu (Pepsi ou Coca) qui sera �galement emball� dans un gobelet.

Nous allons cr�er une interface Item repr�sentant des produits alimentaires, tels que les Burgers et les boissons fra�ches, ainsi que des classes concr�tes impl�mentant l�interface Item car le Burger serait emball� dans un "Wrapper" et la boisson fra�che serait emball� dans une "Bottle".

Nous cr�ons ensuite une classe Meal ayant une ArrayList d�Items et un MealBuilder pour construire diff�rents types d�objets Meal en combinant Item. BuilderPatternDemo, notre classe Main de d�monstration utilisera MealBuilder pour cr�er un repas.

Impl�mentation :

Pr�sentation du diagramme de classes de notre exemple :

![enter image description here](https://www.tutorialspoint.com/design_pattern/images/builder_pattern_uml_diagram.jpg)

## **�tape n�1 :**

Cr�er une interface Article repr�sentant un aliment.

public interface Item {

public String name();

public Packing packing();

public float price();

}

Cr�er une interface Emballage repr�sentant un emballage.

public interface Packing {

public String pack();

}

## **�tape n�2 :**

Cr�ez des classes concr�tes impl�mentant l'interface Packing.

Cr�ez une classe Wrapper (l'emballage des burgers)

public class Wrapper implements Packing {

@Override

public String pack() {

return "Wrapper";

}

}

Cr�ez une classe Bottle (l'emballage des boissons fra�ches)

public class Bottle implements Packing {

@Override

public String pack() {

return "Bottle";

}

}

## **�tape n�3 :**

Cr�ez des classes abstraites impl�mentant l'interface d'�l�ment fournissant les fonctionnalit�s par d�faut.

public abstract class Burger implements Item {

@Override

public Packing packing() {

return new Wrapper();

}

@Override

public abstract float price();

}

ColdDrink.java

public abstract class ColdDrink implements Item {

@Override

public Packing packing() {

return new Bottle();

}

@Override

public abstract float price();

}

## **�tape n�4 :**

Cr�ez des classes h�ritant des classes ColdDrink (qui contient Pepsi et Coke) et Burger qui contient (VegBurger et ChickenBurger).

Appelez les m�thodes abstraites des classes pr�c�demment cr�ent puis les compl�ter dans les 4 classes ci-dessous en y ajoutant le nom du produit � retourner ainsi que son prix unitaire pour calculer le prix total du menu.

public class VegBurger extends Burger {

@Override

public float price() {

return 25.0f;

}

@Override

public String name() {

return "Veg Burger";

}

}

public class ChickenBurger extends Burger {

@Override

public float price() {

return 50.5f;

}

@Override

public String name() {

return "Chicken Burger";

}

}

public class Coke extends ColdDrink {

@Override

public float price() {

return 30.0f;

}

@Override

public String name() {

return "Coke";

}

}

public class Pepsi extends ColdDrink {

@Override

public float price() {

return 35.0f;

}

@Override

public String name() {

return "Pepsi";

}

}

## **�tape n�5 :**

Cr�ez une classe de repas "meal"  ayant les objets d�Item d�finis ci-dessus.

Cr�ez une ArrayList ou tous nos Items se trouveront dans cette collection.

Ajout de 3 m�thodes :

- addItem pour ajouter tous e que l'on veut dans notre menu (pepsi, ChickenBurger,...).

- getCost pour calculer le prix total du menu en parcourant

tous les items ajout�s et d�terminer le prix � payer par le client.

- Affichage des �l�ments de la commande (l'item, le packaging, le prix de chaque article)

import java.util.ArrayList;

import java.util.List;

public class Meal {

private List<Item> items = new ArrayList<Item>();

public void addItem(Item item){

items.add(item);

}

public float getCost(){

float cost = 0.0f;

for (Item item : items) {

cost += item.price();

}

return cost;

}

public void showItems(){

for (Item item : items) {

System.out.print("Item : " + item.name());

System.out.print(", Packing : " + item.packing().pack());

System.out.println(", Price : " + item.price());

}

}

}

## **�tape n�6 :**

Cr�ez une classe MealBuilder, la classe de g�n�rateur charg�e de cr�er les objets Meal.

La classe qui va nous permettre de cr�er des repas comme on le souhaite et ou on peut y ajouter ce que l'on veut.

public class MealBuilder {

public Meal prepareVegMeal (){

Meal meal = new Meal();

meal.addItem(new VegBurger());

meal.addItem(new Coke());

return meal;

}

public Meal prepareNonVegMeal (){

Meal meal = new Meal();

meal.addItem(new ChickenBurger());

meal.addItem(new Pepsi());

return meal;

} }

## **�tape n�7 :**

Cr�ation de la classe Main afin de tester le Design Pattern Builder et d�terminer si cela fonctionne.

On lui demande d'afficher tous les items compris dans le repas V�g�tarien cr�aient dans la classe MealBuilder.

Mais aussi d'afficher le cout total de ce repas.

La m�me chose est demand�e pour le repas non V�g�tarien

public class BuilderPatternDemo {

public static void main(String[] args) {

MealBuilder mealBuilder = new MealBuilder();

Meal vegMeal = mealBuilder.prepareVegMeal();

System.out.println("Veg Meal");

vegMeal.showItems();

System.out.println("Total Cost: " + vegMeal.getCost());

Meal nonVegMeal = mealBuilder.prepareNonVegMeal();

System.out.println("\n\nNon-Veg Meal");

nonVegMeal.showItems();

System.out.println("Total Cost: " + nonVegMeal.getCost());

}

}

## **�tape n�8 :**

Si tout fonctionne comme pr�vu vous devriez trouver les r�sultats suivants qui s'afficheront dans votre console. Sinon reprenez l'�tape n�4 et/ou n�5.

Veg Meal

Item : Veg Burger, Packing : Wrapper, Price : 25.0

Item : Coke, Packing : Bottle, Price : 30.0

Total Cost: 55.0

Non-Veg Meal

Item : Chicken Burger, Packing : Wrapper, Price : 50.5

Item : Pepsi, Packing : Bottle, Price : 35.0

Total Cost: 85.5