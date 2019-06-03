package com.inti.design.pattern.classes.adapter;

public class AdaptateurSamSaoule implements InterfaceChargeable{

	//R�f�rence du portable adapt�
	private PortableSamSaoule telephone;
	
	public AdaptateurSamSaoule(PortableSamSaoule telephone) {
		super();
		this.telephone = telephone;
	}

	//M�thode de rechargement, mais ATTENTION, ne n�c�ssite que 5 volts !
	public void recharger(int volts) {
		int nouveauVoltage = volts > 5 ? 5 : volts;
		this.telephone.chargerPortable(nouveauVoltage);
	}
}
