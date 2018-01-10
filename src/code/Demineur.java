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
	Casem[][] test;

	public Demineur(int hauteur, int largeur)
	{
		HAUTEUR = hauteur;
		LARGEUR = largeur;
		cases_libres=HAUTEUR * LARGEUR;
		test = new Casem[HAUTEUR][LARGEUR];

		for (int i = 0; i < HAUTEUR; i++)
		{
			for (int j = 0; j < LARGEUR; j++)
			{
				test[i][j] = new Casem();
			}
		}
   
	}
}