import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Case extends JButton
{

	private int etat = 0; //0 = rien; 1==enfoncée; 2=drapeau; 3=?; 4=boum; 5=mine; 6=erreur de drapeau
	private boolean mine = false; //Si il y a une mine
	private boolean selected = false; //case enfoncée
	private boolean blocked = false; //bloquée
	private int chiffre = 0; //chiffre affiché s'il doit être affiché
	
	

	public Case(){
		new JButton("");

	}
}