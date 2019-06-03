# Mon tutoriel de Design Pattern - Design pattern State by Noemie

    Catégorie : Comportement 
    Objectif: changer le comportement d'un objet selon son état
    Résultat: ce Design Pattern permet d'isoler les algorithmes propres à chaque état d'un objet
	
<<<<<<< HEAD
![image1](https://user-images.githubusercontent.com/49645543/58787341-eeb19380-85e9-11e9-9cad-5c00e3c5bd24.png)
=======
	![image1](https://user-images.githubusercontent.com/49645543/58786026-04718980-85e7-11e9-9a42-6cb6963dc8a6.png)
>>>>>>> bb0f9aadf9c036e955b6818e833ac7a13d38c311


# Implementation

Description du contexte de l'exemple: 
On souhaite illustrer le comportement d'un avion selon qu'il soit au garage, en piste ou en l'air. 

    Diagramme de classe: 

![image2](https://user-images.githubusercontent.com/49645543/58786172-47cbf800-85e7-11e9-9e80-609fe41097ac.png)



### Etape 1 : Création d'un interface 

 
On  définit une interface EtatAvion dans laquelle on définit les transitions d'états qui vont piloter le passage d'un état à l'autre (entrer, sortir, décoller, atterrir).
On implémente également une méthode doAction qui permet d'exécuter un traitement qui dépend de l'état de l'avion (si il est dans le garage il réagit différement de si il est hors du garage).

![image3](https://user-images.githubusercontent.com/49645543/58786496-ff610a00-85e7-11e9-82ac-689e6556c802.png)

On déclare un objet de type EtatAvion auquel on va déléguer les méthodes (Source, gerenerate delegate method). 
Par exemple, quand on appelle la méthode entrerAuGarage de l'objet, cette action va être déléguée à l'objet EtatAvion. 
(clic droit, Source, gerenerate delegate method)

![image4](https://user-images.githubusercontent.com/49645543/58786591-3800e380-85e8-11e9-8270-a9a0def217b1.png)


### Etape 2 :  Création des classes implémentant l'interface


   ![image5](https://user-images.githubusercontent.com/49645543/58786699-71d1ea00-85e8-11e9-9b27-bc1012f2c455.png)
   
   ![image6](https://user-images.githubusercontent.com/49645543/58786764-975ef380-85e8-11e9-94e8-cb8c560f51c5.png)
   
   ![image7](https://user-images.githubusercontent.com/49645543/58786821-b3fb2b80-85e8-11e9-9f87-b94a79af041a.png)

### Etape 3 : Spécification de l'Etat initial dans le constructeur

Dans le constructeur de la classe avion, on définit l'état initial de l'avion comme étant AuGarage. 

### Etape 4 : démonstration

   ![image8](https://user-images.githubusercontent.com/49645543/58786938-fcb2e480-85e8-11e9-9d4c-870388ae311e.png)
   
### Etape 4: Vérification

![image9](https://user-images.githubusercontent.com/49645543/58787060-44397080-85e9-11e9-85ad-0d31d44254c1.png)

Remarque: dans ce tutoriel, on utilise la composition (tout est dans la même classe).  