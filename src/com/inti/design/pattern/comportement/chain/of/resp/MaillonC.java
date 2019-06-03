package com.inti.design.pattern.comportement.chain.of.resp;

public class MaillonC extends Maillon {

	/**
	 * Méthode affichant un message si le nombre passé en paramètre est supérieur à
	 * 2
	 * 
	 * @return true, si la maillon a géré l'opération
	 */
	public boolean operationSpec(int pNombre) {
		if (pNombre > 2) {
			System.out.println("MaillonC : " + pNombre + " : > 2");
			return true;
		}
		return false;
	}
}