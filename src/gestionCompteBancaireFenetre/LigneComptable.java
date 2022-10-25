package gestionCompteBancaireFenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionCompteBancaireMethode.LigneComptableMet;

public class LigneComptable extends JFrame {

	private JPanel topPanelLigneComptable;
	private JLabel compteLigneComptable;
	private String type;
	private static JTextField valeur;
	private JLabel valeurLabel;
	private JLabel deviseLabel;
	private JComboBox motifList;

	private JComboBox transactionList;

	private JButton btnDebit;
	private JButton btnCredit;
	private JButton btnExit;
	public static double valeurInt;
	public static String motif;
	public static String transaction;

	protected static int index;
	protected static double soldeOp;

	public void ligneComptable() {
		JFrame container = new JFrame("Operation du compte");

		container.setSize(950, 850);
		container.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		container.setVisible(true);

		topPanelLigneComptable = new JPanel();
		topPanelLigneComptable.setPreferredSize(new Dimension(450, 250));
		topPanelLigneComptable.setOpaque(true);
		topPanelLigneComptable.setBackground(Color.white);
		compteLigneComptable = new JLabel("Ajout d'une ligne comptable");

		for (int i = 0; i < test.list.size(); i++) {
			if (test.list.get(i).getNumeroCompteInt() == GestionComptableMenu.getNumeroCompteInt()) {
				topPanelLigneComptable.setBorder(BorderFactory.createTitledBorder(
						"Compte " + test.list.get(i).GetLibelleType() + " N°: " + test.list.get(i).getNumeroCompteInt()
								+ " : " + test.list.get(i).getSolde() + " Euros "));
				soldeOp = test.list.get(i).getSolde();
				index = i;

			}
		}

		valeur = new JTextField();
		valeur.setPreferredSize(new Dimension(90, 25));
		valeurLabel = new JLabel("Valeur : ");
		deviseLabel = new JLabel(" Euros ");
		valeur.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
					e.consume(); // ignorer l'événement
				}
			}
		});

		String[] motifs = { "Salaire", "Loyer", "Alimentation", "Energie", "Taxes", "Divers" };
		motifList = new JComboBox(motifs);

		String[] transactions = { "Carte Bancaire", "Cheque", "Espece", "Virement" };
		transactionList = new JComboBox(transactions);

		btnDebit = new JButton("DEBIT");
		btnDebit.setPreferredSize(new Dimension(90, 25));
		// btnDebit.addActionListener(new debit());

		btnDebit.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				valeurInt = Double.parseDouble(valeur.getText());
				double resultat = test.list.get(consultationCompte.index).getSolde() - valeurInt;
				test.list.get(consultationCompte.index).setSolde(resultat);
				LigneComptableMet ligneComptable = new LigneComptableMet();
				motif = motifList.getSelectedItem().toString();
				transaction = transactionList.getSelectedItem().toString();

				ligneComptable.CreerLigneComptable(LigneComptable.motif, LigneComptable.transaction,
						LigneComptable.valeurInt);
				test.list.get(consultationCompte.index).getListcomptable().add(ligneComptable);

				System.out.println(valeurInt);
				System.out.println(test.list.get(consultationCompte.index).getListcomptable());

			}

		});

		btnCredit = new JButton("CREDIT");
		btnCredit.setPreferredSize(new Dimension(90, 25));

		btnCredit.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				valeurInt = Double.parseDouble(valeur.getText());
				double resultat = test.list.get(consultationCompte.index).getSolde() + valeurInt;
				test.list.get(consultationCompte.index).setSolde(resultat);
				LigneComptableMet ligneComptable = new LigneComptableMet();
				motif = motifList.getSelectedItem().toString();
				transaction = transactionList.getSelectedItem().toString();

				ligneComptable.CreerLigneComptable(LigneComptable.motif, LigneComptable.transaction,
						LigneComptable.valeurInt);
				test.list.get(consultationCompte.index).getListcomptable().add(ligneComptable);

				System.out.println(valeurInt);
				System.out.println(test.list.get(consultationCompte.index).getListcomptable());

			}

		});

		btnExit = new JButton("EXIT");
		btnExit.setPreferredSize(new Dimension(90, 25));
		btnExit.setBackground(Color.RED);
		btnExit.setForeground(Color.WHITE);

		btnExit.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				container.dispose();
			}

		});

		topPanelLigneComptable.add(valeurLabel);
		topPanelLigneComptable.add(valeur);
		topPanelLigneComptable.add(deviseLabel);

		topPanelLigneComptable.add(btnDebit);
		topPanelLigneComptable.add(btnCredit);

		topPanelLigneComptable.add(motifList);
		topPanelLigneComptable.add(transactionList);

		topPanelLigneComptable.add(btnDebit);
		topPanelLigneComptable.add(btnCredit);
		topPanelLigneComptable.add(btnExit);

		container.add(topPanelLigneComptable);
	}

}
