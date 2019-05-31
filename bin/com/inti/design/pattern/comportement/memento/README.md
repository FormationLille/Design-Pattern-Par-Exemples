# Mon tutoriel de Design Pattern - Memento (tutorialpoint.com)
Réalisé par Pierre Laurend dans le cadre de la formation Adaming Mars - Juin 2019
   
### *Description du design pattern*
    
Le design pattern Memento est utilisé pour restaurer l'état d'un objet à un état antérieur. 
Mémento est classé dans la catégorie de modèle de comportement. (Au même titre que "Chain", "Iterator", "Mediator", "Observer" et "State")


### *Memento is Rollback ?*

- Le design pattern Memento utilise trois classes d'acteurs. Memento contient l'état d'un objet à restaurer. Originator crée et stocke les états dans les objets Memento, tandis que l’objet Gardien est chargé de restaurer l’état de l’objet à partir de Memento. Nous avons créé les classes Memento , Originator et CareTaker .

- MementoPatternDemo , notre classe de démonstration, utilisera les objets CareTaker et Originator pour montrer la restauration des états d'objet.

    


    Mettre le diagramme de classes (Regarder si quelqu'un a reussi à importer une image sur Markdown)
![Alt text](\E:\Soft\TutoGit\TutorielMemento\Design-Pattern-Par-Exemples\bin\com\inti\design\pattern\comportement\memento/DiagrammeClasseMemento.png?raw=true "diagramme de classes") 



### Etape 1

##### Créer une classe de mémento.


**Memento.java**

 public class Memento {
 private String state;
   public Memento(String state){
      this.state = state;
   }
   public String getState(){
      return state;
   }	
}

### Étape 2
##### Créer une classe d'origine

**Originator.java**

public class Originator {
   private String state;
   public void setState(String state){
      this.state = state;
   }
   public String getState(){
      return state;
   }
   public Memento saveStateToMemento(){
      return new Memento(state);
   }
   public void getStateFromMemento(Memento memento){
      state = memento.getState();
   }
}

### Étape 3
##### Créer une classe CareTaker

**CareTaker.java**

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
   private List<Memento> mementoList = new ArrayList<Memento>();
   public void add(Memento state){
      mementoList.add(state);
   }
   public Memento get(int index){
      return mementoList.get(index);
   }
}

### Étape 4
##### Utilisez les objets CareTaker et Originator .

**MementoPatternDemo.java**

public class MementoPatternDemo {
   public static void main(String[] args) {
      Originator originator = new Originator();
      CareTaker careTaker = new CareTaker();
      originator.setState("State #1");
      originator.setState("State #2");
      careTaker.add(originator.saveStateToMemento());
      originator.setState("State #3");
      careTaker.add(originator.saveStateToMemento());
      originator.setState("State #4");
      System.out.println("Current State: " + originator.getState());		
      originator.getStateFromMemento(careTaker.get(0));
      System.out.println("First saved State: " + originator.getState());
      originator.getStateFromMemento(careTaker.get(1));
      System.out.println("Second saved State: " + originator.getState());
   }
}

### Étape 5
##### Vérifiez la sortie.

Current State: State #4
First saved State: State #2
Second saved State: State #3
  



    Lien pour avoir tous les trucs de mise en page qu'il faut : https://guides.github.com/features/mastering-markdown/
    (Markdown online)