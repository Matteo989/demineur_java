import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Demineur extends JFrame implements ActionListener
{
	private int LARGEUR;
	private int HAUTEUR;
	private int cases_libres;

	public Demineur(int hauteur, int largeur)
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

		HAUTEUR = hauteur;
		LARGEUR = largeur;
		cases_libres = LARGEUR*HAUTEUR;
		setSize(HAUTEUR*16, LARGEUR*16);

		//setBorder(new );
		GridLayout gl = new GridLayout();
	    gl.setColumns(LARGEUR);
	    gl.setRows(HAUTEUR);
	    this.setLayout(gl);

	    for (int i=0; i < cases_libres; i++)
	    {   
	        getContentPane().add(new JButton(""));
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
			setSize(300,300);
			new Demineur(8, 8);
		}

		if (evenement.getActionCommand().equals("partie_inter"))
		{
			this.dispose();
			setSize(400,600);
			new Demineur(16, 16);
		}

		if (evenement.getActionCommand().equals("partie_expert"))
		{
			this.dispose();
			setSize(800,600);
			new Demineur(16, 30);
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
