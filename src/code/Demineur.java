import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BoxLayout;

public class Demineur extends JFrame implements ActionListener 
{
	private int LARGEUR;
	private int HAUTEUR;
	private int cases_libres;
	private int nbMines;
	private Segment affMines = new Segment();
	private Segment affTemps = new Segment();
	private Temps temps = new Temps(affTemps);
	private JButton nouveau = new JButton(new ImageIcon("../images/good.png"));
	private Icon good, loose, search, win;

	public Demineur(int hauteur, int largeur, int nbMines)
	{

		setTitle("Demineur");
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(true);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Partie");
		menuBar.add(menu);

		
		JMenuItem item1 = new JMenuItem("Debutant");
		menu.add(item1);
		JMenuItem item2 = new JMenuItem("Intermediaire");
		menu.add(item2);
		JMenuItem item3 = new JMenuItem("Expert");
		menu.add(item3);
		JMenuItem item4 = new JMenuItem("Personnalisee");
		menu.add(item4);
		menu.add(new JSeparator());
		JMenuItem item5 = new JMenuItem("Quitter");
		menu.add(item5);


		JMenu menu2 = new JMenu("A propos");
		menuBar.add(menu2);

		JMenuItem item6 = new JMenuItem("Regles");
		menu2.add(item6);
		menu2.add(new JSeparator());
		JMenuItem item7 = new JMenuItem("Createurs");
		menu2.add(item7);

		item1.setActionCommand("partie_debutant");
		item1.addActionListener(this);

		item2.setActionCommand("partie_inter");
		item2.addActionListener(this);

		item3.setActionCommand("partie_expert");
		item3.addActionListener(this);

		item4.setActionCommand("partie_perso");
		item4.addActionListener(this);

		item5.setActionCommand("partie_quitter");
		item5.addActionListener(this);

		item6.setActionCommand("apropos_regles");
		item6.addActionListener(this);

		item7.setActionCommand("apropos_createurs");
		item7.addActionListener(this);

		affMines.setMaximumSize(new Dimension(49, 27));
		affMines.setValeur(nbMines);
		affTemps.setMaximumSize(new Dimension(49, 27));
		nouveau.setMaximumSize(new Dimension(25, 25));
		nouveau.setMinimumSize(new Dimension(25, 25));
		nouveau.setPreferredSize(new Dimension(25,25));

		JPanel barreHaut = new JPanel();
		barreHaut.setLayout(new BoxLayout(barreHaut, BoxLayout.LINE_AXIS));
		barreHaut.add(affMines, null);
		barreHaut.add(nouveau);
		barreHaut.add(affTemps, null);

		HAUTEUR = hauteur;
		LARGEUR = largeur;
		cases_libres = LARGEUR*HAUTEUR;
		setSize(LARGEUR*25, HAUTEUR*30);

	    GridLayout gl = new GridLayout();
	    gl.setColumns(LARGEUR);
	    gl.setRows(HAUTEUR);

		JPanel jeu = new JPanel();
		jeu.setLayout(gl);

	    for (int i=0; i < cases_libres; i++)
	    {   
	        jeu.add(new Case());
	    }

	    JPanel fenetre = new JPanel();
	    fenetre.setLayout(new BoxLayout(fenetre, BoxLayout.PAGE_AXIS));
	    fenetre.add(barreHaut);
	    fenetre.add(jeu);
			
	    this.getContentPane().add(fenetre);
	    this.setVisible(true);

	}

	public void actionPerformed(ActionEvent evenement)
 	{
		if(evenement.getActionCommand().equals("partie_quitter"))
		{
			if (JOptionPane.showConfirmDialog(this, "Voulez vous quitter ?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}

		if (evenement.getActionCommand().equals("partie_debutant"))
		{
			this.dispose();
			new Demineur(8, 8, 10);
		}

		if (evenement.getActionCommand().equals("partie_inter"))
		{
			this.dispose();
			new Demineur(16, 16, 40);
		}

		if (evenement.getActionCommand().equals("partie_expert"))
		{
			this.dispose();
			new Demineur(16, 30, 99);
		}

		if (evenement.getActionCommand().equals("partie_perso"))
		{
			setSize(1000,1000);
		}

		if (evenement.getActionCommand().equals("apropos_regles"))
		{
			Regles regles = new Regles();
		}

		if (evenement.getActionCommand().equals("apropos_createurs"))
		{
			Createurs createurs = new Createurs();
		}
	}

	class GestionnaireFenetre extends WindowAdapter
	{
	    public void windowClosing(WindowEvent e) 
	    {
			System.exit(0);
	    }
	}
}
