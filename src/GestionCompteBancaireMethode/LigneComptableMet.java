package GestionCompteBancaireMethode;

public class LigneComptableMet {

	private int numeroCompteInt;
	private String transaction;
	private String Motif;
	private double valeur;

	public static void LireLigneComptable() {
	}

	public void CreerLigneComptable(String motif, String transaction, double valeur) {
		this.Motif = motif;
		this.transaction = transaction;
		this.valeur = valeur;

	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getMotif() {
		return Motif;
	}

	public void setMotif(String motif) {
		Motif = motif;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

}
