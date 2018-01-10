import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;

public class Demineur extends JFrame implements ActionListener 
{
	private int LARGEUR;
	private int HAUTEUR;
	private int cases_libres;
	private int nbMines;
	private int DIFF;
	private Segment affichageMines = new Segment();
	private Segment affichageTemps = new Segment();
	private Temps temps = new Temps(affichageTemps);
	private JButton btNouveau = new JButton(new ImageIcon("../images/good.png"));
	private Icon good, loose, search, win;
	private JButton[][] choix = new JButton[HAUTEUR][LARGEUR];


	public Demineur(int hauteur, int largeur, int nbMines, int difficulte)
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

		btNouveau.setActionCommand("nouveau");
		btNouveau.addActionListener(this);

		affichageMines.setMaximumSize(new Dimension(49, 27));
		affichageMines.setValeur(nbMines);
		affichageTemps.setMaximumSize(new Dimension(49, 27));
		btNouveau.setMaximumSize(new Dimension(25, 25));
		btNouveau.setMinimumSize(new Dimension(25, 25));
		btNouveau.setPreferredSize(new Dimension(25,25));

		JPanel barreHaut = new JPanel();
		barreHaut.setLayout(new BoxLayout(barreHaut, BoxLayout.LINE_AXIS));
		barreHaut.add(affichageMines, null);
		barreHaut.add(btNouveau);
		barreHaut.add(affichageTemps, null);

		HAUTEUR = hauteur;
		LARGEUR = largeur;
		DIFF = difficulte;
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

	    
	    for (int i=1; i<HAUTEUR; i++)
	    {
	    	for (int j=1; j<LARGEUR; j++)
	    	{
	    		String text = String.format("Button [%d, %d]", i, j);
            	choix[i][j] = new JButton(text);
	    		choix[i][j].setActionCommand("choix[i][j]");
	    		choix[i][j].addActionListener(this);
	    	}
	    }

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
			new Demineur(8, 8, 10, 1);
		}

		if (evenement.getActionCommand().equals("partie_inter"))
		{
			this.dispose();
			new Demineur(16, 16, 40, 2);
		}

		if (evenement.getActionCommand().equals("partie_expert"))
		{
			this.dispose();
			new Demineur(16, 30, 99, 3);
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

		if (evenement.getActionCommand().equals("nouveau"))
		{
			if(DIFF==1)
			{
				this.dispose();
				new Demineur(8, 8, 10, 1);
			}
			else if(DIFF==2)
			{
				this.dispose();
				new Demineur(16, 16, 40, 2);
			}
			else if(DIFF==3)
			{
				this.dispose();
				new Demineur(16, 30, 99, 3);
			}
		}

		if (evenement.getActionCommand().equals("choix[0][0]"))
		{
			System.exit(0);
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
