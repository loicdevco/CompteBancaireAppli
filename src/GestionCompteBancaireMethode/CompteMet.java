package GestionCompteBancaireMethode;

import java.util.ArrayList;

public class CompteMet {

	protected int numeroCompteInt;
	protected static char typeCompte;
	protected String tableauOperation[];
	protected double solde;

	public static ArrayList<LigneComptableMet> listcomptable;

	public void CreerCompte(int numeroCompteInt) {
		this.numeroCompteInt = numeroCompteInt;
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

	public int getNumeroCompteInt() {
		return numeroCompteInt;
	}

	public void setNumeroCompteInt(int numeroCompteInt) {
		this.numeroCompteInt = numeroCompteInt;
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
