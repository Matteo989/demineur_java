import java.awt.Graphics;

abstract class Case {
	public final static int tailleCase = 15;
	public final static int MARQUEE = 2, DECOUVERTE = 1;
	
	public static double ratio = 2.0/15.0;
	static int largeur = 0;
    static int hauteur = 0;

    static Case tableau[][] = null;

    int stat;
    int Cord_x, Cord_y;

    Case(int xx,int yy) {
		Cord_x = xx;
		Cord_y = yy;
    }

    public static  void initJeu(int l,int h) {
		largeur = l+2;
		hauteur = h+2;
		tableau = new Case[largeur][hauteur];
    }

    boolean estDecouverte() {
		return (stat == DECOUVERTE);
    }

    boolean estMarquee() {
		return (stat == MARQUEE);
    }

    boolean marqueCase() { 
		return false;
    }

    public static void paintAll(Graphics g) {
	if (tableau != null) {
	    for (int i = 0 ; i < largeur; i++)
		for(int j = 0 ; j < hauteur; j++)
		    tableau[i][j].paint(g);
	}
    }

    public void paint(Graphics g) {	
	g.drawString(""+this,tailleCase*Cord_x+tailleCase/3,tailleCase*Cord_y+tailleCase*2/3);
    }

    public String toString() {
	return "@";
    }


    abstract boolean existeBombe();
   

    abstract boolean decouvreCase();
}