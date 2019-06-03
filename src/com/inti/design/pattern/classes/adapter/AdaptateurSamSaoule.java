package com.inti.design.pattern.classes.adapter;

public class AdaptateurSamSaoule implements InterfaceChargeable{

	//Référence du portable adapté
	private PortableSamSaoule telephone;
	
	public AdaptateurSamSaoule(PortableSamSaoule telephone) {
		super();
		this.telephone = telephone;
	}

	//Méthode de rechargement, mais ATTENTION, ne nécéssite que 5 volts !
	public void recharger(int volts) {
		int nouveauVoltage = volts > 5 ? 5 : volts;
		this.telephone.chargerPortable(nouveauVoltage);
	}
}
