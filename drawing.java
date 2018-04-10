
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.geom.RoundRectangle2D;

public class drawing extends JPanel{
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    int numofDom = 0;
    Color gold = new Color(218,165,32);
    public drawing(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    public void drawDom (Graphics g, int x, int y) {
    	Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.WHITE);
        g2.setStroke(new BasicStroke(3.0f));

        g2.fillRoundRect(x, y, 100, 200, 20, 20);
        
        g.setColor(Color.BLACK);
        g.fillRect(x+8, 3*y, 84, 5);
        
        g.setColor(gold);
        g.fillOval(x+44, y+97, 10, 10);
 
    }
  /*  public void drawDominoe(Graphics g2, Tile topSide, Tile botSide) {
    	g2.setColor(Color.WHITE);
        g2.fillRect(x, y, 100, 200);
        
    	switch(topSide){
		case ZERO: break;
		case ONE: drawdot(g2, 1, x, y); break;
		/*case TWO: drawdot(g, 2, x, y); break;
		case THREE: drawdot(g, 3, x, y); break;
		case FOUR: drawdot(g, 4, x, y); break;
		case FIVE: drawdot(g, 5, x, y); break;
		case SIX: drawdot(g, 6, x, y); break; 
		}

    	numofDom ++;
    } */
    public void drawdot(Graphics g2, int numDots, int x, int y) {
    	if (numDots==1) {
    	g2.setColor(Color.BLACK);
    	g2.fillOval((x+40), (y+45), 18, 18);
    	}
    	else if(numDots == 2) {
    	g2.setColor(Color.BLACK);
    	  g2.fillOval((x+18), (y+72), 18, 18);
        g2.setColor(Color.BLACK);
    	g2.fillOval((x+65), (y+17), 18, 18);
    	}
		else if(numDots == 3) {
			g2.setColor(Color.BLACK);
	    	g2.fillOval((x+40), (y+45), 18, 18);	
	    	g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+72), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+17), 18, 18);
		    	}
		else if(numDots == 4) {
			g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+72), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+18), 18, 18);
	    	g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+18), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+72), 18, 18);
		}
		else if(numDots == 5) {
			g2.setColor(Color.BLACK);
	    	g2.fillOval((x+42), (y+45), 18, 18);
			g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+72), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+18), 18, 18);
	    	g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+18), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+72), 18, 18);
		}
		else if(numDots == 6) {
			g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+45), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+45), 18, 18);
			g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+72), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+18), 18, 18);
	    	g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+18), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+72), 18, 18);
		}
    }
   
    
  public void paintComponent(Graphics g) {
	  
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT); 
        int k = 70;
        for (int i = 0; i < 7; i++) {
        drawDom(g, k, 50);
        drawdot(g, 6, k, 50);
        k+=130;
        }
       // paint(g);
       // drawDominoe(g, Game.GamePile.dominoes.get(0).topside, Game.GamePile.dominoes.get(0).botside);
  
    }
    
    public static void main(String args[]){
    	Game.runGame();
        JFrame frame = new JFrame("Dominunos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new drawing());
        frame.pack();
        frame.setVisible(true);
    }
}