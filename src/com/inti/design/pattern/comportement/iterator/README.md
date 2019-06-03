# Tutoriel de Design Pattern - Iterator

Auteur : Florian Libre

Le but est ici de parcourir et accéder aux différents éléments d’un conteneur (hashmap, list, etc.) sans connaitre sa structure interne qui peut se révéler complexe. 

# Implementation

L’idée générale est donc ici de pouvoir parcourir la collection sans se soucier de sa nature

On peut faire le rapprochement avec le pointeur avec ses 3 propriétés :
-	L’accès à l’élément
-	Le déplacement entre les éléments 
-	L’épuisement du conteneur (la collection) 

On utilise pour cela l’interface Iterator qui contient plusieurs méthodes :
-	public boolean hasNext() : Retourne true s’il y a encore des objets dans la collectiotn
-	public Object next() : retourne le prochain objet de la collection (sous réserve que la méthode hasNext() retourne true).
-	public void remove() : supprime l’objet actuel

### Diagramme de classes :

![iterator_pattern_uml_diagram](https://user-images.githubusercontent.com/49645577/58784889-b3609600-85e4-11e9-878f-39dd31c0dd6f.png)

### Etape 1

Création de l'interface Container.

```java
	package com.inti.design.pattern.comportement.iterator;

	import java.util.Iterator;

	public interface Container {
	   public Iterator getIterator();
	}
```	
	
### Etape 2

Création de la classe Repository NameRepository implémentant l'interface Container. Cette classe possède une classe interne NameIterator implémentant l'interface Iterator.

```java
	package com.inti.design.pattern.comportement.iterator;

	import java.util.Iterator;

	public class NameRepository implements Container {
	   public String noms[] = {"Yann" , "Florian" ,"Antoine" , "Taoufik"};

	   @Override
	   public Iterator getIterator() {
	      return new NameIterator();
	   }

	   private class NameIterator implements Iterator {

	      int index;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < noms.length){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	            return noms[index++];
	         }
	         return null;
	      }		
	   }
	}
```

### Etape 3

Création de la classe main.

```java
	package com.inti.design.pattern.comportement.iterator;

	import java.util.Iterator;

	public class IteratorPattern {
	
	   public static void main(String[] args) {
	      NameRepository namesRepository = new NameRepository();

	      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
	         String nom = (String)iter.next();
	         System.out.println("Nom : " + nom);
	      } 	
	   }
	}
```

### Etape finale

Lors de l'execution, vous devez obtenir ceci :

```java
	Nom : Yann
	Nom : Florian
	Nom : Antoine
	Nom : Taoufik
```