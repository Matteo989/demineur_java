import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Demineur extends JFrame 
{
	private int LARGEUR;
	private int HAUTEUR;
	private int cases_libres;

	public Demineur(int hauteur, int largeur)
	{
		HAUTEUR = hauteur;
		LARGEUR = largeur;
		cases_libres = LARGEUR*HAUTEUR;
		setSize(HAUTEUR*18, LARGEUR*16);
		setResizable(false);
		setBorder(new )
		GridLayout gl = new GridLayout();
	    gl.setColumns(LARGEUR);
	    gl.setRows(HAUTEUR);
	    this.setLayout(gl);

	    for (int i=0; i < cases_libres; i++)
	    {   
	        getContentPane().add(new JButton(""));
	    }

	    this.setVisible(true);
	  	
   
	}
}