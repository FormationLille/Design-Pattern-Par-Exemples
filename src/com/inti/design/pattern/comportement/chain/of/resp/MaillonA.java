package com.inti.design.pattern.comportement.chain.of.resp;

public class MaillonA extends Maillon {

	/**
	 * M�thode affichant un message si le nombre pass� en param�tre est pair
	 * 
	 * @return true, si la maillon a g�r� l'op�ration
	 */
	public boolean operationSpec(int pNombre) {
		if (pNombre % 2 == 0) {
			System.out.println("MaillonA : " + pNombre + " : pair");
			return true;
		}
		return false;
	}
}
