import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Case extends JButton
{
	private int state = 0; //0 = rien; 1==enfonc�e; 2=drapeau; 3=?; 4=boum; 5=mine; 6=erreur de drapeau
	private boolean Mine = false;
	private boolean selection = false;
	private boolean bloque = false;
	private int num = 0;

	public Case(){
		new JButton("");

	}
}
