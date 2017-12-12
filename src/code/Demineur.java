import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Demineur extends JFrame{
	Button [] boutons; 
	
	public Demineur(int l, int c){
		setTitle("Démineur");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(l*20,c*36);
		setResizable(false);
		FlowLayout layout = new FlowLayout();
 		setLayout(layout);
 		boutons = new Button[l*c];
 		for(int i=0; i<l*c; i++ ){
 			boutons[i] = new Button(" ");
 			add(boutons[i]);
 		}
 		setVisible(true);
	}
}