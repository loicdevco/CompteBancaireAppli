package GestionCompteBancaireMethode;

import gestionCompteBancaireFenetre.test;

public class Epargne extends CompteMet {

	private double tauxPlacement = 1.94;

	public double Epargne(int index) {
		double interetAnnuel = test.list.get(index).getSolde()
				+ (tauxPlacement * test.list.get(index).getSolde()) / 100;
		return interetAnnuel;
	}

}
