# Mon tutoriel de Design Pattern - Flyweight

 Auteur : Clement Renault


Le design pattern **Flyweight** est un design pattern de structure.
Il est utilise pour diminuer l'utilisation de la mémoire et augmenter la performance. 
Cela est permit grace a une diminution du nombre d'objets crees. 
Ce design pattern essaye de reutiliser des types d'objets similaires déjà existants et les stocks. 
Il en cree de nouveaux quand aucun objets ne corresponds. 

# Implementation

Cette description est difficilement comprehensible a brut pour point. 
C'est pourquoi, voici un exemple !

Dans cette exemple nous allons creer : 

Quoi? | Nom | Pourquoi?
------------ | ------------- | -------------
une interface | _Shape_ |
une classe | _Circle_ | Implemente l'interface _Shape_ 
une classe | _ShapeFactory_ | Permet de cree des objets _Circle_
une classe de main | _Application_ | Run l'application 


NB : Application est appelee FlyweightPatternDemo dans le diagramme de classe ci-dessous.

![Diagramme de classe de l'exemple pour le design pattern FlyWeight](https://www.tutorialspoint.com/design_pattern/images/flyweight_pattern_uml_diagram.jpg)

_ShapeFactory_ a une Hashmap de _Circle_ ayant pour clef la couleur des objets _Circle_. 
De cette façon, a chaque fois qu'une requete demande de cree un cercle d'une certaine couleur, 
_ShapeFactory_  recherche dans la Hashmap, si un objet similaire est trouve, 
il le renvoie au client sinon il en cree un nouveau, le stock dans la Hashmap et l'envoie au client.
_Application_ va utiliser _ShapeFactory_ pour obtenir un objet _Shape_, il donnera les 
caracteristiques a _ShapeFactory_ pour obtenir le cercle de la couleur demandee.


### Etape 1

Creez une interface _Shape_ :

```java
    public interface Shape {
    	void draw();
    }
```

### Etape 2

Creez une classe _Circle_ implmentant l'interface :

```java
    package com.inti.design.pattern.structure.flyweight;

    public class Circle implements Shape {
       private String color;
       private int x;
       private int y;
       private int radius;

       public Circle(String color){
          this.color = color;               
       }

       public void setX(int x) {
          this.x = x;
       }

       public void setY(int y) {
          this.y = y;
       }

       public void setRadius(int radius) {
          this.radius = radius;
       }

       @Override
       public void draw() {
          System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
       }
    }
```

### Etape 3

Creez une usine _ShapeFactory_ qui genere des objets de la classe precedente en utilisant des informations donnees :

```java
    package com.inti.design.pattern.structure.flyweight;
    
    import java.util.HashMap;

    public class ShapeFactory {

       // Uncomment the compiler directive line and
       // javac *.java will compile properly.
       // @SuppressWarnings("unchecked")
       private static final HashMap circleMap = new HashMap();

       public static Shape getCircle(String color) {
          Circle circle = (Circle)circleMap.get(color);

          if(circle == null) {
             circle = new Circle(color);
             circleMap.put(color, circle);
             System.out.println("Creating circle of color : " + color);
          }
          return circle;
       }
    }
```

### Etape 4

Utilisez l'usine pour obtenir des objets en donnant des informations tel que la couleur :

```java
    package com.inti.design.pattern.structure.flyweight;
    
    public class Application {
       private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
       public static void main(String[] args) {

          for(int i=0; i < 20; ++i) {
             Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
             circle.setX(getRandomX());
             circle.setY(getRandomY());
             circle.setRadius(100);
             circle.draw();
          }
       }
       private static String getRandomColor() {
          return colors[(int)(Math.random()*colors.length)];
       }
       private static int getRandomX() {
          return (int)(Math.random()*100 );
       }
       private static int getRandomY() {
          return (int)(Math.random()*100);
       }
    }
```

### Etape 5

Le resultat attendu est :

    Creating circle of color : Black
    Circle: Draw() [Color : Black, x : 36, y :71, radius :100
    Creating circle of color : Green
    Circle: Draw() [Color : Green, x : 27, y :27, radius :100
    Creating circle of color : White
    Circle: Draw() [Color : White, x : 64, y :10, radius :100
    Creating circle of color : Red
    Circle: Draw() [Color : Red, x : 15, y :44, radius :100
    Circle: Draw() [Color : Green, x : 19, y :10, radius :100
    Circle: Draw() [Color : Green, x : 94, y :32, radius :100
    Circle: Draw() [Color : White, x : 69, y :98, radius :100
    Creating circle of color : Blue
    Circle: Draw() [Color : Blue, x : 13, y :4, radius :100
    Circle: Draw() [Color : Green, x : 21, y :21, radius :100
    Circle: Draw() [Color : Blue, x : 55, y :86, radius :100
    Circle: Draw() [Color : White, x : 90, y :70, radius :100
    Circle: Draw() [Color : Green, x : 78, y :3, radius :100
    Circle: Draw() [Color : Green, x : 64, y :89, radius :100
    Circle: Draw() [Color : Blue, x : 3, y :91, radius :100
    Circle: Draw() [Color : Blue, x : 62, y :82, radius :100
    Circle: Draw() [Color : Green, x : 97, y :61, radius :100
    Circle: Draw() [Color : Green, x : 86, y :12, radius :100
    Circle: Draw() [Color : Green, x : 38, y :93, radius :100
    Circle: Draw() [Color : Red, x : 76, y :82, radius :100
    Circle: Draw() [Color : Blue, x : 95, y :82, radius :100


### Source :

[https://www.tutorialspoint.com/design_pattern/flyweight_pattern.html](https://www.tutorialspoint.com/design_pattern/flyweight_pattern.html).
