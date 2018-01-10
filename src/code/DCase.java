import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DCase extends JPanel implements MouseListener {
  private int state = 0; //0 = rien; 1==enfonc�e; 2=drapeau; 3=?; 4=boum; 5=mine; 6=erreur de drapeau
  private boolean Mine = false;
  private boolean selection = false;
  private boolean bloque = false;
  private int num = 0;

  public DCase() {

  }


}
