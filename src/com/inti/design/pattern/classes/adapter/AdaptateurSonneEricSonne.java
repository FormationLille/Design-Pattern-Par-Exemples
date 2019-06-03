package com.inti.design.pattern.classes.adapter;

public class AdaptateurSonneEricSonne implements InterfaceChargeable{

	//R�f�rence du portable adapt�
	private PortableSonneEricSonne telephone;
		
	public AdaptateurSonneEricSonne(PortableSonneEricSonne telephone) {
		super();
		this.telephone = telephone;
	}

	public void recharger(int volts) {
		this.telephone.chargerBatteries(volts);
	}
}
