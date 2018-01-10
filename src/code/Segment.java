package demin;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;


//Afficheur 3 chiffres à 7 segments chacun;
//utilisé pour le temps et les mines
public class Segment extends JPanel {
  /*NUMEROS DES SEGMENTS
   2___
  1|   |3
   7---
  4|___|6
     5
  */
  private boolean[][] chiffres = {
    //TABLE DE VERITE DES SEGMENTS POUR CHAQUE CHIFFRE
    {true, true, true, true, true, true, false},//0
    {false, false, true, false, false, true, false},//1
    {false, true, true, true, true, false, true},//2
    {false, true, true, false, true, true, true},//3
    {true, false, true, false, false, true, true},//4
    {true, true, false, false, true, true, true},//5
    {true, true, false, true, true, true, true},//6
    {false, true, true, false, false, true, false},//7
    {true, true, true, true, true, true, true},//8
    {true, true, true, false, true, true, true}//9
  };
  private int valeur;
  final private Color AFFICHE = new Color(255,0,0);//couleur d'un segment allumé
  final private Color CACHE = new Color(80,0,0);//couleur d'un segment éteint
  private Border border1;

  public Segment() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,Color.darkGray,Color.gray);
    this.setBackground(Color.black);
    this.setBorder(border1);
    this.setPreferredSize(new Dimension(49,27));
  }
  public int getValeur() {
    return valeur;
  }
  public void setValeur(int valeur) {
    if (valeur>=0) {
      if (valeur<=999) this.valeur = valeur;
      else {this.valeur = 999;}
      repaint();
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setStroke(new BasicStroke(1.6f));
    int[] segments=new int[3];//le chiffre affiché par chaque afficheur
    segments[0]=valeur/100; segments[1]=(valeur/10)%10; segments[2]=valeur%10;
    for (int i=0; i<3; i++) {//pour chaque segment
      int n=segments[i];
      if (chiffres[n][0]==true) g2d.setColor(AFFICHE);//segment 1
      else g2d.setColor(CACHE);
      g2d.drawLine(3+i*15,3,3+i*15,12);
      g2d.drawLine(4+i*15,4,4+i*15,11);
      g2d.drawLine(5+i*15,5,5+i*15,10);

      if (chiffres[n][1]==true) g2d.setColor(AFFICHE);//segment 2
      else g2d.setColor(CACHE);
      g2d.drawLine(4+i*15,2,13+i*15,2);
      g2d.drawLine(5+i*15,3,12+i*15,3);
      g2d.drawLine(6+i*15,4,11+i*15,4);

      if (chiffres[n][2]==true) g2d.setColor(AFFICHE);//segment 3
      else g2d.setColor(CACHE);
      g2d.drawLine(12+i*15,5,12+i*15,10);
      g2d.drawLine(13+i*15,4,13+i*15,11);
      g2d.drawLine(14+i*15,3,14+i*15,12);

      if (chiffres[n][3]==true) g2d.setColor(AFFICHE);//segment 4
      else g2d.setColor(CACHE);
      g2d.drawLine(3+i*15,14,3+i*15,22);
      g2d.drawLine(4+i*15,15,4+i*15,21);
      g2d.drawLine(5+i*15,16,5+i*15,20);

      if (chiffres[n][4]==true) g2d.setColor(AFFICHE);//segment 5
      else g2d.setColor(CACHE);
      g2d.drawLine(6+i*15,21,11+i*15,21);
      g2d.drawLine(5+i*15,22,12+i*15,22);
      g2d.drawLine(4+i*15,23,13+i*15,23);

      if (chiffres[n][5]==true) g2d.setColor(AFFICHE);//segment 6
      else g2d.setColor(CACHE);
      g2d.drawLine(12+i*15,16,12+i*15,20);
      g2d.drawLine(13+i*15,15,13+i*15,21);
      g2d.drawLine(14+i*15,14,14+i*15,22);

      if (chiffres[n][6]==true) g2d.setColor(AFFICHE);//segment 7
      else g2d.setColor(CACHE);
      g2d.drawLine(5+i*15,12,12+i*15,12);
      g2d.drawLine(4+i*15,13,13+i*15,13);
      g2d.drawLine(5+i*15,14,12+i*15,14);
    }
  }
}
