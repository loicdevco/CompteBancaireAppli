package GestionCompteBancaireMethode;

import java.util.ArrayList;

public class CompteMet {

	protected static String numeroCompte;
	protected static char typeCompte;
	protected String tableauOperation[];
	protected double solde;

	public static ArrayList<LigneComptableMet> listcomptable;

	public void CreerCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
		this.listcomptable = new ArrayList<LigneComptableMet>();
	}

	public static String GetLibelleType() {
		String LibelleType;
		if (CompteMet.typeCompte == 'C') {
			LibelleType = "courant";
		} else if (CompteMet.typeCompte == 'J') {
			LibelleType = "Joint";
		} else {
			LibelleType = "Epargne";
		}
		return LibelleType;

	}

	public void InfoCompte() {

	}

	public static ArrayList<LigneComptableMet> getListcomptable() {
		return listcomptable;
	}

	public static void setListcomptable(ArrayList<LigneComptableMet> listcomptable) {
		CompteMet.listcomptable = listcomptable;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double soldeUpdate) {
		this.solde = soldeUpdate;
	}

	public static String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public char getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(char typeCompte) {
		this.typeCompte = typeCompte;
	}

	public String[] getTableauOperation() {
		return tableauOperation;
	}

	public void setTableauOperation(String[] tableauOperation) {
		this.tableauOperation = tableauOperation;
	}
}
