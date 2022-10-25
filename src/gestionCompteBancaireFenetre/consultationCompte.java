package gestionCompteBancaireFenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GestionCompteBancaireMethode.CompteMet;

public class consultationCompte extends JFrame {

	private static JPanel topPanelConsultation;
	private static JPanel bottomPanelConsultation;
	private JLabel compteConsultation;
	private static String typeCompte;
	private JTable tableauOperation;
	public static int index;
	protected static double soldeOp;

	public void consultation() {
		JFrame container = new JFrame("Consultation de Compte");

		container.setSize(950, 850);
		container.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		container.setVisible(true);

		topPanelConsultation = new JPanel();
		topPanelConsultation.setPreferredSize(new Dimension(450, 550));
		topPanelConsultation.setOpaque(true);
		topPanelConsultation.setBackground(Color.white);
		compteConsultation = new JLabel("Bilan Comptable");

		for (int i = 0; i < test.list.size(); i++) {
			if (test.list.get(i).getNumeroCompteInt() == GestionComptableMenu.numeroCompteInt) {
				topPanelConsultation.setBorder(BorderFactory.createTitledBorder(
						"Compte " + test.list.get(i).GetLibelleType() + " N°: " + test.list.get(i).getNumeroCompteInt()
								+ " : " + test.list.get(i).getSolde() + " Euros "));
				soldeOp = test.list.get(i).getSolde();
				index = i;

			}
		}

		bottomPanelConsultation = new JPanel();
		bottomPanelConsultation.setPreferredSize(new Dimension(450, 250));
		bottomPanelConsultation.setOpaque(true);
		bottomPanelConsultation.setBackground(Color.white);
		JButton Exit = new JButton("EXIT");
		Exit.setPreferredSize(new Dimension(90, 25));
		Exit.setBounds(40, 30, 200, 40);
		Exit.setBackground(Color.RED);
		Exit.setForeground(Color.white);

		Exit.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				container.dispose();
			}

		});

		print();

		bottomPanelConsultation.add(Exit);

		container.add(topPanelConsultation, BorderLayout.PAGE_START);
		container.add(bottomPanelConsultation, BorderLayout.AFTER_LAST_LINE);
	}

	public void print() {

		String[] title = { "Motif", "Mode de Paiement", "montant" };

		JTable tableauOperation = new JTable(getArray(), title);
		this.getContentPane().add(new JScrollPane(tableauOperation));

		JLabel bilan = new JLabel("Solde : " + test.list.get(index).getSolde());

		topPanelConsultation.setLayout(new BorderLayout());
		topPanelConsultation.add(tableauOperation.getTableHeader(), BorderLayout.PAGE_START);
		topPanelConsultation.add(tableauOperation, BorderLayout.CENTER);
		topPanelConsultation.add(bilan, BorderLayout.SOUTH);

	}

	public Object[][] getArray() {
		Object[][] data = new Object[CompteMet.listcomptable.size()][3];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = CompteMet.listcomptable.get(i).getMotif();
			data[i][1] = CompteMet.listcomptable.get(i).getTransaction();
			data[i][2] = Double.toString(CompteMet.listcomptable.get(i).getValeur());
		}

		return data;

	}

}
