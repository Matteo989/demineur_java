import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Test extends JFrame
{
	public Test(String nom)
	{
		setTitle(nom);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setVisible(true);


		JPanel p = new JPanel();
		JLabel l1 = new JLabel("<html><br /><p>Le démineur est un jeu qui se joue à un seul joueur.<br />	Des bombes sont disséminées sur une grille rectangulaire et le but du jeu est de trouver leurs positions.<br />	Au début du jeu toutes les cases sont cachées, puis on les découvre petit à petit en cliquant sur celles-ci. <br />	Lorsque l'on clique sur une case avec le bouton gauche de la souris il y a deux possibilités :<ul><li>Soit cette case contient une mine, dans ce cas la partie est perdue,</li>	<li>Sinon, on affiche dans la case le nombre de bombes adjacentes à cette case (les 8 cases alentours).</li><li>Si ce nombre est 0, alors on découvre aussi les cases voisines.</li></ul>Si le clic a été effectué à l'aide du bouton droit, alors on marque une mine à la position donnée.<br />Si toutes les mines ont été marquées alors la partie est gagnée.<br />Attention, si une case sans mine a été marquée alors la partie n'est pas gagnée.</p></html>");
        p.add(l1);
        getContentPane().add(p);
	}
}