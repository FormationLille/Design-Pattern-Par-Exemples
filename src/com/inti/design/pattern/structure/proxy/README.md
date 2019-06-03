# Mon tutoriel de Design Pattern - Proxy

Auteur : Camille

Proxy est un design pattern de structure qui fournit un intermédiaire entre le client et un objet afin de contrôler l'accès à celui-ci.
Il permet d'isoler le comportement lors de l'accès à un objet grâce à une interface. Le proxy ne charge l'objet qu'en cas de réel besoin, ou n'autorise l'accès que si les conditions sont satisfaites.

Sources :
- https://fr.slideshare.net/mohamedyoussfi9/cours-design-pattern-m-youssfi-partie-6-proxy
- https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm

# Implementation

Dans notre exemple, on cherche à accéder à une image. Nous allons donc créer une interface "Image" ainsi qu'une classe RealImage l'implémentant.

ProxyImage est une classe proxy permettant de réduire l'encombrement mémoire du chargement de l'objet RealImage.

ProxyPatternDemo est notre classe client. Elle utilisera ProxyImage pour charger et afficher un objet Image selon ses besoins.

![Image du diagramme de classe](https://www.tutorialspoint.com/design_pattern/images/proxy_pattern_uml_diagram.jpg)

### Etape 1

Nous allons tout d'abord créer l'interface Image.

###### Image.java

```java
public interface Image {
    void display();
}
```

### Etape 2

Créons à présent une classe concrète RealImage ainsi que le ProxyImage, qui implémentent l'interface.

###### RealImage.java

```java
public class RealImage implements Image {
    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
```

###### ProxyImage.java

```java
public class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```

### Etape 3

On crée la classe client qui permettra d'afficher ou non l'image.

###### ProxyPatternDemo.java

```java
public class ProxyPatternDemo {
    public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

    // L'image sera chargée
        image.display(); 
        System.out.println("");
	      
    // L'image ne sera pas chargée
        image.display(); 	
	}
}
```

### Etape finale

Enfin, on vérifie la sortie sur la commande.

```java
Loading test_10mb.jpg
Displaying test_10mb.jpg
Displaying test_10mb.jpg
```
