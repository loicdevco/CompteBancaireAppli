package gestionCompteBancaireFenetre;

import java.sql.Connection;
import java.sql.DriverManager;

public class test {

	// public static ArrayList<CompteMet> list = new ArrayList<CompteMet>();
	protected static Connection conn;

	public static void main(String[] args) {

		// Votre fonction Run
		// Vos information de connexion à une base de données
		String BDD = "comptebancaire";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		// L'essaie de connexion à votre base de donées
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, "root");
			System.out.println("Connecter");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}

		GestionComptableMenu fenetre = new GestionComptableMenu();
		fenetre.menu();

	}

}
