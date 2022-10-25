package gestionCompteBancaireFenetre;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

public class GestionComptableMenu extends JFrame {

	private JPanel topPanel;
	private JPanel centerPanel;
	private JLabel comptes;
	private JLabel numero;
	private ButtonGroup btnComptes;
	private static JRadioButton create;
	private static JRadioButton ajoutLigneComptable;
	private static JRadioButton consulter;
	protected static JFormattedTextField numeroCompte;
	private JButton choixMenu;
	static int numeroCompteInt;

	public void menu() {

		JFrame container = new JFrame("Gestion de Compte");

		container.setSize(950, 850);
		container.setDefaultCloseOperation(EXIT_ON_CLOSE);
		container.setVisible(true);

		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(450, 250));
		topPanel.setOpaque(true);
		topPanel.setBackground(Color.white);
		comptes = new JLabel("Comptes");
		topPanel.setBorder(BorderFactory.createTitledBorder("Comptes"));

		// creation des boutons radio
		btnComptes = new ButtonGroup();

		create = new JRadioButton("Creer");
		ajoutLigneComptable = new JRadioButton("Ajout d'une ligne comptable");
		consulter = new JRadioButton("Consulter");

		btnComptes.add(create);
		btnComptes.add(ajoutLigneComptable);
		btnComptes.add(consulter);

		topPanel.add(comptes);
		topPanel.add(create);
		topPanel.add(ajoutLigneComptable);
		topPanel.add(consulter);

		centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(450, 250));
		centerPanel.setOpaque(true);
		centerPanel.setBackground(Color.white);
		numero = new JLabel("Numero : ");
		centerPanel.setBorder(BorderFactory.createTitledBorder("Numero de compte"));

		MaskFormatter numeroCompteFormat;
		try {
			numeroCompteFormat = new MaskFormatter("########");
			numeroCompte = new JFormattedTextField(numeroCompteFormat);
			numeroCompte.setPreferredSize(new Dimension(150, 25));

			// numeroCompteInt = Integer.parseInt(numeroCompte.getText().toString());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		choixMenu = new JButton("OK");
		choixMenu.setPreferredSize(new Dimension(90, 20));
		choixMenu.addActionListener(new choixMenuListener());

		centerPanel.add(numeroCompte);
		centerPanel.add(choixMenu);

		// container.add(topPanel);

		container.getContentPane().add(topPanel, BorderLayout.NORTH);
		container.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	public static JRadioButton getConsulter() {
		return consulter;
	}

	public void setConsulter(JRadioButton consulter) {
		this.consulter = consulter;
	}

	public static JRadioButton getAjoutLigneComptable() {
		return ajoutLigneComptable;
	}

	public void setAjoutLigneComptable(JRadioButton ajoutLigneComptable) {
		this.ajoutLigneComptable = ajoutLigneComptable;
	}

	public static JRadioButton getCreate() {
		return create;
	}

	public void setCreate(JRadioButton create) {
		this.create = create;
	}

	public static int getNumeroCompteInt() {
		return numeroCompteInt;
	}

	public static void setNumeroCompteInt(int numeroCompteInt) {
		GestionComptableMenu.numeroCompteInt = numeroCompteInt;
	}

}

class choixMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (GestionComptableMenu.getCreate().isSelected() == true) {
			String numeroCompteStr = GestionComptableMenu.numeroCompte.getText();
			GestionComptableMenu.setNumeroCompteInt(Integer.parseInt(numeroCompteStr));
			System.out.println(GestionComptableMenu.numeroCompteInt);
			String query = "INSERT INTO compte(NumeroCompte, type, Solde) VALUES ("
					+ GestionComptableMenu.numeroCompteInt + " , null, null);";
			try {
				PreparedStatement prepare = test.conn.prepareStatement(query);
				prepare.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			creationCompte createAccount = new creationCompte();
			createAccount.create();

		} else if (GestionComptableMenu.getAjoutLigneComptable().isSelected() == true) {
			LigneComptable bilan = new LigneComptable();
			bilan.ligneComptable();

		} else {
			consultationCompte consultation = new consultationCompte();
			consultation.consultation();
		}

	}

}
