import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FenetreGraphique extends JFrame implements ActionListener
{
	public FenetreGraphique(String nom)
	{
		setTitle(nom);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Partie");
		menuBar.add(menu);

		JMenuItem item1 = new JMenuItem("Nouveau");
		menu.add(item1);
		menu.add(new JSeparator());
		JMenuItem item2 = new JMenuItem("Debutant");
		menu.add(item2);
		JMenuItem item3 = new JMenuItem("Intermediaire");
		menu.add(item3);
		JMenuItem item4 = new JMenuItem("Expert");
		menu.add(item4);
		JMenuItem item5 = new JMenuItem("Personnalisee");
		menu.add(item5);
		menu.add(new JSeparator());
		JMenuItem item8 = new JMenuItem("Quitter");
		menu.add(item8);


		JMenu menu2 = new JMenu("A propos");
		menuBar.add(menu2);

		JMenuItem item6 = new JMenuItem("Regles");
		menu2.add(item6);
		menu2.add(new JSeparator());
		JMenuItem item7 = new JMenuItem("Createurs");
		menu2.add(item7);

		item8.setActionCommand("menu_quitter");
		item8.addActionListener(this);

		JTextPane textPane = new JTextPane();
		getContentPane().add(textPane);

	}

	public void actionPerformed(ActionEvent evenement)
 	{
		if(evenement.getActionCommand().equals("menu_quitter"))
		{
			if (JOptionPane.showConfirmDialog(this, "Voulez vous quitter ?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}

		if (evenement.getActionCommand().equals("menu_charger"))
		{
			JFileChooser selecteur = new JFileChooser();
			selecteur.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
			selecteur.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "gif"));
			int resultat = selecteur.showOpenDialog(this);
			if(resultat == JFileChooser.APPROVE_OPTION)
			{
 				System.out.println("Fichier choisi: " +	selecteur.getSelectedFile().getAbsolutePath());
			}
		}
	}
}
