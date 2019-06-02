# Mon tutoriel de Design Pattern - Observer
Chadia EL AMRANI

    Description du design pattern

    Le design pattern Observer est utilis� pour envoyer un signal � des modules qui jouent le r�le d'observateurs.
En cas de notification, les observateurs effectuent alors l'action ad�quate en fonction des informations qui parviennent depuis les modules qu'ils observent (les observables ou les sujets).

Le design pattern observer d�finit une d�pendance un � plusieurs (One-to-Many) entre les objets de sorte que lorsqu'un objet change d'�tat, tous ses d�pendants sont notifi�s et mis � jour automatiquement.
L'objet surveill� s'appelle le sujet ou l�observable.
Les objets qui observent les changements d'�tat sont appel�s observateurs (observers en anglais).

Avanntages:

-On peut cr�er une multitude d'observateurs diff�rents. Ils n'auront aucun lien entre eux et pourront avoir des t�ches compl�tements diff�rentes. 
-Il permet aussi une gestion simplifi�e d'observateurs multiples sur un m�me objet observable. 
-Optimisation du code


# Implementation

Description du contexte de l'exemple

Nous pouvons prendre l�exemple d'une station m�t�orologique. m l�affichage de la temp�rature actuelle et celle ressentie en fonction de la temp�rature mesur�e.
Nous pouvons avoir une partie A dans notre application qui affiche sur un �cran la temp�rature actuelle.
Et une partie B qui affiche la temp�rature ressentie.
Pour r�agir aux changements de temp�rature, les parties A et B s�enregistreront donc�, en tant qu�observateur.
Si la temp�rature est modifi�e, un �v�nement est d�clench�.
Cet �v�nement est envoy� � tous les observateurs. 
Ces derniers re�oivent donc, les donn�es modifi�es et peuvent ajuster leurs affichages en fonction de ces donn�es.

Remarque�: Les observateurs peuvent r�cup�rer le ou les �tats de l'observable via des fonctions, accesseurs de celui-ci�; 
cette solution est nomm�e ��TIRER��. Les observateurs vont donc, tirer les informations de l'observable.
 Mais une seconde variante existe, celle-ci est nomm�e ��POUSSER��.
  � l'inverse de la premi�re, c'est l'observable qui va fournir les informations aux observateurs lors de la modification de l'�tat.
   Nous allons maintenant voir la mise en place de ce Design Pattern avec ses deux variantes.

####Observer�: version ��tirer��
Dans cette version, ce sont les observateurs qui r�cup�rent le ou les �tat(s) de l'observable. 
### Cr�ation des interfaces

On commence par cr�er l'interface de l'observable ou du sujet:

l�interface observable contient g�n�ralement 3 m�thodes�:
    � add�() : pour enregistrer ou inscrire l�observateur dans l�observable (afin qu�il puisse lui envoyer des notifications)
    � remove()�: Pour d�sinscrire l�observateur
    � notify()�: Pour envoyer des notifications � l�observateur.

On peut donc ajouter/retirer un observateur � tout moment sans bien s�r affecter le code des classes existantes.


    package com.inti.design.pattern.comportement.observer;

public interface IObservable {

	public void addObserver(IObserver o);

	public void removeObserver(IObserver o);

	public void notifyObservers();

}



L�interface observateur contient une seule m�thode qui lui permet d�actualiser ses donn�es�: 
    � La m�thode update()�


package com.inti.design.pattern.comportement.observer;

public interface IObserver {

	public void update(IObservable o);
}




### Impl�mentation des interfaces

    Nous allons maintenant impl�menter ces deux interfaces.
Pour cela, cr�er une classe ObservableConcret pour impl�menter l�interface observable, et une autre classe ObservateurConcretImpl1 afin d�impl�menter l�interface observateur.

    # La classe ObservableConcret:
    Comme dit plus haut, nous avons une relation entre l�observable et l�observateur de type One-to-Many (Pour un observable, nous pouvons avoir plusieurs observateurs). Par cons�quent, dans la classe ObservableConcret nous allons cr�er une collection d�observateurs.
L�attribut etat est accessible via un accesseur en lecture.
La m�thode notifierObservateurs () d�clenche l�appel de actualise(observable) pour chaque observateur abonn�.

package com.inti.design.pattern.comportement.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableConcret implements IObservable {

	private List<IObserver> observers = new ArrayList<>();

	private int etat;

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

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;

		notifyObservers();
	}

}


Remarque: La m�thode update () doit �tre appel�e lorsque l'�tat change.


    # Les classes observateurs:

    package com.inti.design.pattern.comportement.observer;

public class ObserverConcretImpl1 implements IObserver {

	@Override
	public void update(IObservable o) {

		int etat = ((ObservableConcret) o).getEtat();

		System.out.println("Temp�rature actuelle: " + etat + "�C");

	}

}



Nous pouvons ajouter un autre observateur en cr�ant la classe ObservateurConcretImpl2


package com.inti.design.pattern.comportement.observer;

public class ObserverConcretImpl2 implements IObserver {

	@Override
	public void update(IObservable o) {

		int etat = ((ObservableConcret) o).getEtat();

		System.out.println("  Temp�rature ressentie " + (etat - 2));
	}

}


### Lancement de l'application

Nous allons maintenant cr�er la classe Application pour tester notre code.
Nous commen�ons par instancier les classes ObservableConcret, ObserverConcretimpl1 et ObserverConcretImpl2, pour cr�er un observable et des observateurs.


Supposons que l'observateur change d'�tat, que va-t-il se passer ?

import com.inti.design.pattern.comportement.observer.ObserverConcretImpl1;

public class Application {

	public static void main(String[] args) {

		ObservableConcret lobservable = new ObservableConcret();
		ObserverConcretImpl1 obs1 = new ObserverConcretImpl1();
		ObserverConcretImpl2 obs2 = new ObserverConcretImpl2();

		lobservable.setEtat(10);

	}
}

Nous remarquons que rien ne s�affiche, ce qui est normal.
Les observateurs sont cr�es mais pas encore inscrits dans l�observable.

import com.inti.design.pattern.comportement.observer.ObserverConcretImpl1;
public class Application {

	public static void main(String[] args) {

		ObservableConcret lobservable = new ObservableConcret();
		ObserverConcretimpl1 obs1 = new ObserverConcretimpl1();
		ObserverConcretImpl2 obs2 = new ObserverConcretImpl2();

		lobservable.addObserver(obs1);
		lobservable.addObserver(obs2);

		lobservable.setEtat(1);
		lobservable.setEtat(5);

	}

nous remarquons qu�� chaque changement d��tat, les deux observateurs sont inform�s.

Nous pouvons d�sinscrire un des deux observateurs gr�ce � la m�thode remove(), dans ce cas-l� il ne sera pas notif�, et nous n'aurons pas la temp�rature ressentie.

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




####Observer�: version ��tirer��


ans cette version, c'est l'observable qui met � disposition son/ses �tat(s) aux observateurs.. Dans ce paragraphe, nous n'allons pas revoir l'ensemble du code des classes, mais uniquement les parties qui varient par rapport � la version ��POUSSER��.
Modification de la signature de la fonction actualiser.
   