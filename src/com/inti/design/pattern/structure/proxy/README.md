# Mon tutoriel de Design Pattern - Proxy

Ce tutoriel a �t� cr�� par Camille.

Proxy est un design pattern de structure qui fournit un interm�diaire entre le client et un objet afin de contr�ler l'acc�s � celui-ci.
Il permet d'isoler le comportement lors de l'acc�s � un objet gr�ce � une interface. Le proxy ne charge l'objet qu'en cas de r�el besoin, ou n'autorise l'acc�s que si les conditions sont satisfaites.

Sources :
- https://fr.slideshare.net/mohamedyoussfi9/cours-design-pattern-m-youssfi-partie-6-proxy
- https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm

# Implementation

Dans notre exemple, on cherche � acc�der � une image. Nous allons donc cr�er une interface "Image" ainsi qu'une classe RealImage l'impl�mentant.

ProxyImage est une classe proxy permettant de r�duire l'encombrement m�moire du chargement de l'objet RealImage.

ProxyPatternDemo est notre classe client. Elle utilisera ProxyImage pour charger et afficher un objet Image selon ses besoins.

![Image du diagramme de classe](https://www.tutorialspoint.com/design_pattern/images/proxy_pattern_uml_diagram.jpg)

### Etape 1

Nous allons tout d'abord cr�er l'interface Image.
###### Image.java
> public interface Image {
    void display();
}

### Etape 2

Cr�ons � pr�sent une classe concr�te RealImage ainsi que le ProxyImage, qui impl�mentent l'interface.

###### RealImage.java
> public class RealImage implements Image {
    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    
>   @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

>   private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

###### ProxyImage.java
> public class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

>   public ProxyImage(String fileName){
        this.fileName = fileName;
    }

>  @Override
   public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

### Etape 3

On cr�e la classe client qui permettra d'afficher ou non l'image.

###### ProxyPatternDemo.java

> public class ProxyPatternDemo {
    public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

>   // L'image sera charg�e
        image.display(); 
        System.out.println("");
	      
>   // L'image ne sera pas charg�e
        image.display(); 	
	}
}

### Etape finale

Enfin, on v�rifie la sortie sur la commande.
> Loading test_10mb.jpg
Displaying test_10mb.jpg
Displaying test_10mb.jpg