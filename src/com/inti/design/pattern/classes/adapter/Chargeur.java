package com.inti.design.pattern.classes.adapter;

public class Chargeur {
    // le portable branché sur le chargeur
    private InterfaceChargeable telephone;
    // le voltage en sortie du chargeur
    private final int VOLTAGE = 10;


    // branchement d'un portable pour le charger
    public void brancherPortable(InterfaceChargeable portable)
    {
    	System.out.println("Branchement d'un portable :");
    	System.out.println("---------------------------");
		this.telephone = portable;
        this.telephone.recharger(VOLTAGE);
    }   

}
