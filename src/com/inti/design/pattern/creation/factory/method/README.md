# Mon tutoriel de Design Pattern - Factory Method par Antonin Guibourg

Il faut savoir que le Design Pattern "Factory Method" est un des plus utilis�s en Java. 
Ce Design Pattern est associ� � un mod�le de cr�ation,
car il constitue l�un des meilleurs moyens de cr�er un objet.

Dans le Design Pattern Factory Method, 
nous cr�ons un objet sans toucher � la logique de cr�ation du client,
et faisons r�f�rence au nouvel objet cr�� � l'aide d'une interface commune.


# Implementation

Nous allons cr�er une interface Shape et des classes concr�tes impl�mentant l' interface Shape.

Notre classe de d�monstration "FactoryPatternDemo" utilisera ShapeFactory pour obtenir un objet Shape.
Il transmettra les informations ( CIRCLE / RECTANGLE / SQUARE ) � ShapeFactory pour obtenir le type d'objet dont il a besoin.

### Etape 1

Cr�ez une interface.

Shape.java

public interface Shape {
   void draw();
}

### Etape 2

Cr�ez des classes concr�tes impl�mentant la m�me interface.

Rectangle.java

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}

Square.java

public class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}

Circle.java

public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}

### Etape 3

Cr�ez une classe pour g�n�rer un objet de classe concr�te en fonction d'informations donn�es.

ShapeFactory.java

public class ShapeFactory {
        
   //use getShape method to get object of type shape 
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }         
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
         
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
         
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      
      return null;
   }
}

### Etape 4

Utilisez Factory pour obtenir un objet de classe concr�te en transmettant une information telle que le type.

FactoryPatternDemo.java

public class FactoryPatternDemo {

   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //get an object of Circle and call its draw method.
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //call draw method of Circle
      shape1.draw();

      //get an object of Rectangle and call its draw method.
      Shape shape2 = shapeFactory.getShape("RECTANGLE");

      //call draw method of Rectangle
      shape2.draw();

      //get an object of Square and call its draw method.
      Shape shape3 = shapeFactory.getShape("SQUARE");

      //call draw method of square
      shape3.draw();
   }
}


### Etape finale

    faites les tests.

Inside Circle::draw() method.
Inside Rectangle::draw() method.
Inside Square::draw() method.