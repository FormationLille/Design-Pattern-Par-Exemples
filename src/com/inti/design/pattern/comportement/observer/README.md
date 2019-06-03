#### Building for source
# Mon tutoriel de Design Pattern - Observer
Chadia EL AMRANI

###  Description du design pattern

Le design pattern Observer est utilisé pour envoyer un signal à des modules qui jouent le rôle d'observateurs.
En cas de notification, les observateurs effectuent alors l'action adéquate en fonction des informations qui parviennent depuis les modules qu'ils observent (les observables ou les sujets).

Le design pattern observer définit une dépendance un à plusieurs (One-to-Many) entre les objets de sorte que lorsqu'un objet change d'état, tous ses dépendants sont notifiés et mis à jour automatiquement.
L'objet surveillé s'appelle le sujet ou l’observable.
Les objets qui observent les changements d'état sont appelés observateurs (observers en anglais).

#####    Ses avantages:
-   On peut créer une multitude d'observateurs différents. Ils n'auront aucun lien entre eux et pourront avoir des tâches complètements différentes. 
-   Il permet aussi une gestion simplifiée d'observateurs multiples sur un même objet observable. 
-   Optimisation du code


### Implementation

##### Description du contexte de l'exemple

Nous pouvons prendre l’exemple d'une station météorologique. m l’affichage de la température actuelle et celle ressentie en fonction de la température mesurée.
Nous pouvons avoir une partie A dans notre application qui affiche sur un écran la température actuelle.
Et une partie B qui affiche la température ressentie.
Pour réagir aux changements de température, les parties A et B s’enregistreront donc , en tant qu’observateur.
Si la température est modifiée, un événement est déclenché.
Cet évènement est envoyé à tous les observateurs. 
Ces derniers reçoivent donc, les données modifiées et peuvent ajuster leurs affichages en fonction de ces données.

Remarque : Les observateurs peuvent récupérer le ou les états de l'observable via des fonctions, accesseurs de celui-ci .
cette solution est nommée « TIRER ». Les observateurs vont donc, tirer les informations de l'observable.
 Mais une seconde variante existe, celle-ci est nommée « POUSSER ».
  À l'inverse de la première, c'est l'observable qui va fournir les informations aux observateurs lors de la modification de l'état.
   Nous allons maintenant voir la mise en place de ce Design Pattern avec ses deux variantes.

#### Observer : version « Tirer »

Dans cette version, ce sont les observateurs qui récupèrent le ou les état(s) de l'observable. 

##### Création des interfaces

On commence par créer l'interface de l'observable ou du sujet:

l’interface observable contient généralement 3 méthodes :
    • add () : pour enregistrer ou inscrire l’observateur dans l’observable (afin qu’il puisse lui envoyer des notifications)
    • remove() : Pour désinscrire l’observateur
    • notify() : Pour envoyer des notifications à l’observateur.

On peut donc ajouter/retirer un observateur à tout moment sans bien sûr affecter le code des classes existantes.


    package com.inti.design.pattern.comportement.observer;

    public interface IObservable {

    	public void addObserver(IObserver o);

	    public void removeObserver(IObserver o);

    	public void notifyObservers();

    }



L’interface observateur contient une seule méthode qui lui permet d’actualiser ses données : 
    • La méthode update() 

    package com.inti.design.pattern.comportement.observer;
    public interface IObserver {
    	public void update(IObservable o);
    }

##### Implémentation des interfaces

  Nous allons maintenant implémenter ces deux interfaces.
Pour cela, créer une classe ObservableConcret pour implémenter l’interface observable, et une autre classe ObservateurConcretImpl1 afin d’implémenter l’interface observateur.

##### La classe ObservableConcret:
 Comme dit plus haut, nous avons une relation entre l’observable et l’observateur de type One-to-Many (Pour un observable, nous pouvons avoir plusieurs observateurs). Par conséquent, dans la classe ObservableConcret nous allons créer une collection d’observateurs.
L’attribut etat est accessible via un accesseur en lecture.
La méthode notifierObservateurs () déclenche l’appel de actualise(observable) pour chaque observateur abonné.

    package com.inti.design.pattern.comportement.observer;

    import java.util.ArrayList;
    import java.util.List;

    public class ObservableConcret implements IObservable {

    	private List<IObserver> observers = new ArrayList<>();
    	private int temperature;

	@Override
	public void addObserver(IObserver o) {
		observers.add(o);
	    }

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {

		for (IObserver o : observers) {
			o.update(this);
		}
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyObservers();
	}
    }


Remarque: La méthode update () doit être appelée lorsque l'état change.


 ##### Les classes observateurs:

    package com.inti.design.pattern.comportement.observer;
    
    public class ObserverConcretImpl1 implements IObserver {
    
	@Override
	public void update(IObservable o) {
		int etat = ((ObservableConcret) o).getTemperature();
		System.out.println("Temp�rature actuelle: " + etat + "�C");
	}
    }

Nous pouvons ajouter un autre observateur en créant la classe ObservateurConcretImpl2

    package com.inti.design.pattern.comportement.observer;

    public class ObserverConcretImpl2 implements IObserver {

	@Override
	public void update(IObservable o) {
		int etat = ((ObservableConcret) o).getTemperature();
		System.out.println("  Température ressentie " + (etat - 2));
	}
    }


##### Lancement de l'application

Nous allons maintenant créer la classe Application pour tester notre code.
Nous commençons par instancier les classes ObservableConcret, ObserverConcretimpl1 et ObserverConcretImpl2, pour créer un observable et des observateurs.

Supposons que l'observateur change d'état, que va-t-il se passer ?

    import com.inti.design.pattern.comportement.observer.ObserverConcretImpl1;

    public class Application {

	public static void main(String[] args) {

		ObservableConcret lobservable = new ObservableConcret();
		ObserverConcretImpl1 obs1 = new ObserverConcretImpl1();
		ObserverConcretImpl2 obs2 = new ObserverConcretImpl2();

		lobservable.setTemperature(10);
	}
    }

Nous remarquons que rien ne s’affiche, ce qui est normal. Les observateurs sont crées mais pas encore inscrits dans l’observable.

    import com.inti.design.pattern.comportement.observer.ObserverConcretImpl1;
    public class Application {

	public static void main(String[] args) {

		ObservableConcret lobservable = new ObservableConcret();
		ObserverConcretimpl1 obs1 = new ObserverConcretimpl1();
		ObserverConcretImpl2 obs2 = new ObserverConcretImpl2();

		lobservable.addObserver(obs1);
		lobservable.addObserver(obs2);

		lobservable.setTemperature(1);
		lobservable.setTemperature(5);
	}

A chaque changement d’état, les deux observateurs sont informés.

Nous pouvons désinscrire un des deux observateurs grâce à la méthode remove(), dans ce cas-là il ne sera pas notifé, et nous n'aurons pas la température ressentie.

    package com.inti.design.pattern.comportement.observer;

    import com.inti.design.pattern.comportement.observer.ObservableConcret;
    import com.inti.design.pattern.comportement.observer.ObserverConcretImpl2;
    import com.inti.design.pattern.comportement.observer.ObserverConcretImpl1;

    public class Application {

	public static void main(String[] args) {

		ObservableConcret lobservable = new ObservableConcret();
		ObserverConcretImpl1 obs1 = new ObserverConcretImpl1();
		ObserverConcretImpl2 obs2 = new ObserverConcretImpl2();

		// lobservable.setEtat(10);

		lobservable.addObserver(obs1);
		lobservable.addObserver(obs2);

		lobservable.setEtat(1);
		lobservable.setEtat(5);
		lobservable.removeObserver(obs2);
		lobservable.setEtat(10);
	}
    }


#### Observer : version « Pousser »


Dans cette version, c'est l'observable qui met à disposition son/ses état(s) aux observateurs. Dans ce paragraphe, nous n'allons pas revoir l'ensemble du code des classes, mais uniquement les parties qui varient par rapport à la version « Tirer ».

Modification de la signature de la fonction actualiser, afin de transmettre la valeur de l'etat acrtuel (=temperature).

    package com.inti.design.pattern.comportement.observerV2;

    public interface IObserver {
	public void update(int etat);
    }

Nous devons modifier la méthode notifyObservers() également, pour faire appel à la nouvelle méthode update.

	@Override
	public void notifyObservers() {

		for (IObserver o : observers) {
			o.update(temperature);
		}
	}


Grâce à cette méthode, nous n'avons plus besoin d'aller chercher la valeur de l'etat d'où la suppression de la ligne d'avant:

    @Override
	public void update(int etat) {
		System.out.println("Température actuelle: " + etat + "°C");
	}

   En exécutant l'application, nous remarquons que le résultat reste le même qu'avec la méthode "tirer".

### Conclusion:
   
  Ce design pattern nous facilite certaines tâches de développement.
Il nous épargne les difficultés de coder par nous-même les notifications entre objets.
Le desig pattern Observer évite le recours à des mécanismes d'interrogation coûteux, dans la mesure où l'observateur demande en permanence (et inutilement) des mises à jour.