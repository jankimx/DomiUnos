
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class drawing extends JPanel{
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 800;
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

    public void drawdot(Graphics g, ArrayList<Dominoes> domino, int p, int k) {
   int y = k;
   int x = p;
   //constants
   int conX = 0;
   int conY = 0;
   Graphics2D g2 = (Graphics2D) g;
   
   int j = 0;
   int count = 0;
   for (Dominoes current: domino) {
	   if(count%7 == 0 && count !=0)  j+=225;
	  drawDom(g, x, y+j);
	  
    switch(current.topside) {
    	case ZERO : { break;}
    	case ONE: {
    	g2.setColor(Color.BLACK);
    	g2.fillOval((x+40), (y+45), 18, 18);
    	break;
    	}
    	case TWO: {
    	g2.setColor(Color.BLACK);
    	  g2.fillOval((x+18), (y+72), 18, 18);
        g2.setColor(Color.BLACK);
    	g2.fillOval((x+65), (y+17), 18, 18);
    	break;
    	}
    	case THREE: {
			g2.setColor(Color.BLACK);
	    	g2.fillOval((x+40), (y+45), 18, 18);	
	    	g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+72), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+17), 18, 18);
	    	break;
		    	}
    	case FOUR: {
			g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+72), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+18), 18, 18);
	    	g2.setColor(Color.BLACK);
	        g2.fillOval((x+18), (y+18), 18, 18);
	        g2.setColor(Color.BLACK);
	    	g2.fillOval((x+65), (y+72), 18, 18);
	    	break;
		}
    	case FIVE: {
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
	    	break;
		}
    	case SIX: {
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
	    	break;
		}
    }
    conY+= 100;
    switch (current.botside) {
    	case ZERO : {break;}
    	case ONE: {
        	g2.setColor(Color.BLACK);
        	g2.fillOval((x+40+conX), (y+45+conY), 18, 18);
        	break;
        	}
        	case TWO: {
        	g2.setColor(Color.BLACK);
        	  g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
            g2.setColor(Color.BLACK);
        	g2.fillOval((x+65+conX), (y+17+conY), 18, 18);
        	break;
        	}
        	case THREE: {
    			g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+40+conX), (y+45+conY), 18, 18);	
    	    	g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65+conX), (y+17+conY), 18, 18);
    	    	break;
    		    	}
        	case FOUR: {
    			g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65+conX), (y+18+conY), 18, 18);
    	    	g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18+conX), (y+18+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65+conX), (y+72+conY), 18, 18);
    	    	break;
    		}
        	case FIVE: {
    			g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+42), (y+45+conY), 18, 18);
    			g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18), (y+72+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65), (y+18+conY), 18, 18);
    	    	g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18), (y+18+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65), (y+72+conY), 18, 18);
    	    	break;
    		}
        	case SIX: {
    			g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18+conX), (y+45+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65+conX), (y+45+conY), 18, 18);
    			g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65+conX), (y+18+conY), 18, 18);
    	    	g2.setColor(Color.BLACK);
    	        g2.fillOval((x+18+conX), (y+18+conY), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65+conX), (y+72+conY), 18, 18);
    	    	break;
    		}
        }
    x+= 140;
    conY-=100;
    count++;
   }
   System.out.println(count);
 }

    
    public void drawtable(Graphics g, Dominoes [] domino, int p, int k) {
    	   int y = k;
    	   int x = p;
    	   //constants
    	   int conX = 0;
    	   int conY = 0;
    	   Graphics2D g2 = (Graphics2D) g;
    	   
    	   int j = 0;
    	   int count = 0;
    	   for (Dominoes current: domino) {
    		   if(count%7 == 0 && count !=0)  j+=225;
    		  drawDom(g, x, y+j);
    		  
    	    switch(current.topside) {
    	    	case ZERO : { break;}
    	    	case ONE: {
    	    	g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+40), (y+45), 18, 18);
    	    	break;
    	    	}
    	    	case TWO: {
    	    	g2.setColor(Color.BLACK);
    	    	  g2.fillOval((x+18), (y+72), 18, 18);
    	        g2.setColor(Color.BLACK);
    	    	g2.fillOval((x+65), (y+17), 18, 18);
    	    	break;
    	    	}
    	    	case THREE: {
    				g2.setColor(Color.BLACK);
    		    	g2.fillOval((x+40), (y+45), 18, 18);	
    		    	g2.setColor(Color.BLACK);
    		        g2.fillOval((x+18), (y+72), 18, 18);
    		        g2.setColor(Color.BLACK);
    		    	g2.fillOval((x+65), (y+17), 18, 18);
    		    	break;
    			    	}
    	    	case FOUR: {
    				g2.setColor(Color.BLACK);
    		        g2.fillOval((x+18), (y+72), 18, 18);
    		        g2.setColor(Color.BLACK);
    		    	g2.fillOval((x+65), (y+18), 18, 18);
    		    	g2.setColor(Color.BLACK);
    		        g2.fillOval((x+18), (y+18), 18, 18);
    		        g2.setColor(Color.BLACK);
    		    	g2.fillOval((x+65), (y+72), 18, 18);
    		    	break;
    			}
    	    	case FIVE: {
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
    		    	break;
    			}
    	    	case SIX: {
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
    		    	break;
    			}
    	    }
    	    conY+= 100;
    	    switch (current.botside) {
    	    	case ZERO : {break;}
    	    	case ONE: {
    	        	g2.setColor(Color.BLACK);
    	        	g2.fillOval((x+40+conX), (y+45+conY), 18, 18);
    	        	break;
    	        	}
    	        	case TWO: {
    	        	g2.setColor(Color.BLACK);
    	        	  g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
    	            g2.setColor(Color.BLACK);
    	        	g2.fillOval((x+65+conX), (y+17+conY), 18, 18);
    	        	break;
    	        	}
    	        	case THREE: {
    	    			g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+40+conX), (y+45+conY), 18, 18);	
    	    	    	g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65+conX), (y+17+conY), 18, 18);
    	    	    	break;
    	    		    	}
    	        	case FOUR: {
    	    			g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65+conX), (y+18+conY), 18, 18);
    	    	    	g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18+conX), (y+18+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65+conX), (y+72+conY), 18, 18);
    	    	    	break;
    	    		}
    	        	case FIVE: {
    	    			g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+42), (y+45+conY), 18, 18);
    	    			g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18), (y+72+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65), (y+18+conY), 18, 18);
    	    	    	g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18), (y+18+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65), (y+72+conY), 18, 18);
    	    	    	break;
    	    		}
    	        	case SIX: {
    	    			g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18+conX), (y+45+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65+conX), (y+45+conY), 18, 18);
    	    			g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18+conX), (y+72+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65+conX), (y+18+conY), 18, 18);
    	    	    	g2.setColor(Color.BLACK);
    	    	        g2.fillOval((x+18+conX), (y+18+conY), 18, 18);
    	    	        g2.setColor(Color.BLACK);
    	    	    	g2.fillOval((x+65+conX), (y+72+conY), 18, 18);
    	    	    	break;
    	    		}
    	        }
    	    x+= 140;
    	    conY-=100;
    	    count++;
    	   }
    	   System.out.println(count);
    	 }
    
  public void paintComponent(Graphics g) {
   
       super.paintComponent(g);
       Game game = new Game ();
       Game.runGame();
       
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, WIDTH, HEIGHT); 

      drawdot(g, game.getUserTile().dominoes, 30, 50);
      drawtable(g, game.getTableTile(),500, 500);
    }


  public void run () {
	  JFrame frame = new JFrame("Dominunos");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new drawing());

      frame.pack();
      frame.setVisible(true); 
  }
}
