package gestionCompteBancaireFenetre;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import GestionCompteBancaireMethode.CompteMet;

public class creationCompte extends JFrame {

	private JPanel topPanelCreate;
	private JLabel compteCreate;
	private ButtonGroup btnChoixCompte;
	static JRadioButton C;
	static JRadioButton J;
	static JRadioButton E;
	private static JTextField solde;
	private JButton btnRegister;
	private static JLabel soldeLabel;
	private static JRadioButton tab_type[] = { C, J, E };
	private static double soldeInt;

	public void create() {
		JFrame container = new JFrame("Creation de Compte");

		container.setSize(950, 850);
		container.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		container.setVisible(true);

		topPanelCreate = new JPanel();
		topPanelCreate.setPreferredSize(new Dimension(450, 250));
		topPanelCreate.setOpaque(true);
		topPanelCreate.setBackground(Color.white);
		compteCreate = new JLabel("Comptes");
		topPanelCreate
				.setBorder(BorderFactory.createTitledBorder("Compte N°: " + GestionComptableMenu.getNumeroCompteInt()));

		// creation des boutons radio
		btnChoixCompte = new ButtonGroup();

		C = new JRadioButton("Compte Courant");
		C.setSelected(true);
		J = new JRadioButton("Compte Joint");
		E = new JRadioButton("Compte Epargne");

		btnChoixCompte.add(C);
		btnChoixCompte.add(J);
		btnChoixCompte.add(E);

		topPanelCreate.add(C);
		topPanelCreate.add(J);
		topPanelCreate.add(E);

		solde = new JTextField();
		soldeLabel = new JLabel("Solde : ");
		solde.setPreferredSize(new Dimension(90, 20));

		btnRegister = new JButton("OK");
		btnRegister.setPreferredSize(new Dimension(90, 20));

		btnRegister.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (creationCompte.getSolde().getText() != null) {
					CompteMet compte = new CompteMet();
					compte.CreerCompte(GestionComptableMenu.getNumeroCompteInt());
					if (creationCompte.C.isSelected() == true) {
						compte.setTypeCompte('C');
					} else if (creationCompte.J.isSelected() == true) {
						compte.setTypeCompte('J');
					} else {
						compte.setTypeCompte('E');
					}
					compte.setSolde(creationCompte.getSoldeInt());
					String query1 = "UPDATE compte SET Type='" + compte.getTypeCompte() + "' , Solde="
							+ compte.getSolde() + "WHERE NumeroCompte =" + compte.getNumeroCompteInt() + ";";

					try {
						PreparedStatement prepare = test.conn.prepareStatement(query1);
						prepare.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					String query2 = "INSERT INTO listecomptable(ID_listeComptable, listingtransaction, motif, NumeroCompte, valeur) VALUES (0,'Depot','Ouverture de compte',(SELECT NumeroCompte FROM compte WHERE NumeroCompte ="
							+ compte.getNumeroCompteInt() + ") , " + compte.getSolde() + ");";
					try {
						PreparedStatement prepare2 = test.conn.prepareStatement(query2);
						prepare2.execute();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

//					LigneComptableMet ouvertureComptable = new LigneComptableMet();
//					ouvertureComptable.CreerLigneComptable("Ouverture de compte", "Depot",
//							creationCompte.getSoldeInt());
//					test.list.get(consultationCompte.index).getListcomptable().add(ouvertureComptable);
//
//					consultationCompte consultation = new consultationCompte();
//					consultation.consultation();
//
//					container.dispose();
				}
			}
		});

		topPanelCreate.add(soldeLabel);
		topPanelCreate.add(solde);
		topPanelCreate.add(btnRegister);
		container.add(topPanelCreate);
	}

	public static JRadioButton[] getTab_type() {
		return tab_type;
	}

	public void setTab_type(JRadioButton[] tab_type) {
		this.tab_type = tab_type;
	}

	public static JTextField getSolde() {

		solde.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});

		return solde;
	}

	public static void setSolde(JTextField solde) {
		creationCompte.solde = solde;
	}

	public static double getSoldeInt() {
		String soldeStr = solde.getText();
		try {
			soldeInt = Double.parseDouble(soldeStr);
		} catch (NumberFormatException e) {
			// n'est pas un nombre, gérer ce cas
		}
		return soldeInt;
	}

	public static void setSoldeInt(int soldeInt) {
		creationCompte.soldeInt = soldeInt;
	}

}
