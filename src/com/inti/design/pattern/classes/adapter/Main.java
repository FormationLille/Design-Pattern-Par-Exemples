package com.inti.design.pattern.classes.adapter;

public class Main {

	public static void main(String[] args) {
		//D�claration du chargeur.
		Chargeur chargeur = new Chargeur();
		
		//************** Portable SonneEricSonne **************
		
		//D�claration du portable et de son adaptaateur.
		PortableSonneEricSonne portableSonne = new PortableSonneEricSonne();
		AdaptateurSonneEricSonne adaptateurSonne = new AdaptateurSonneEricSonne(portableSonne);
		
		//Chargement du portable via son adaptateur.
		chargeur.brancherPortable(adaptateurSonne);

		//************** Portable SamSaoule **************
		
		//D�claration du portable et de son adaptateur.
		PortableSamSaoule portableSam = new PortableSamSaoule();
		AdaptateurSamSaoule adaptateurSam = new AdaptateurSamSaoule(portableSam);
		
		//Chargement du portable via sn adaptateur.
		chargeur.brancherPortable(adaptateurSam);

	}

}
