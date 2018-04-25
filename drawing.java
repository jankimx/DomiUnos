import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.Font;
 
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
 
public class drawing extends JPanel implements ActionListener{
    public static final int WIDTH = 1440;
    public static final int HEIGHT = 900;
    int numofDom = 0;
    String last = "lol";
    Color gold = new Color(218,165,32);
    Game game = new Game ();
    Image img = Toolkit.getDefaultToolkit().createImage("background.jpg");
    private JFrame frame;
 
    public drawing(){
 
        //setLayout(null);
         
        JButton button1 = new JButton("remove1");
        button1.addActionListener(this); 
        button1.setBounds(100, 11, 200, 60);
        add(button1);
         
        JButton button2 = new JButton("remove2");
        button2.addActionListener(this); 
        button2.setBounds(267, 11, 200, 60);
        add(button2);
         
        JButton button3 = new JButton("remove3");
        button3.addActionListener(this); 
        button3.setBounds(432, 11, 200, 60);
        add(button3);
         
        JButton button4 = new JButton("remove4");
        button4.addActionListener(this);
        button4.setBounds(609, 11, 200, 60);
        add(button4);
         
        JButton button5 = new JButton("remove5");
        button5.addActionListener(this);
        button5.setBounds(779, 11, 200, 60);
        add(button5);
         
        JButton button6 = new JButton("remove6");
        button6.addActionListener(this);
        button6.setBounds(953, 11, 200, 60);
        add(button6);
        
        JButton button7 = new JButton("remove7");
        button7.addActionListener(this);
        button7.setBounds(1127, 11, 200, 60);
        add(button7);
         
    }           
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("remove1")) {
        	last = game.table.addOnTable(game.point.getDomino(0));
            if (last != "nothing") {
                game.point.remove(0);
            }
        }
        else if(actionCommand.equals("remove2")) {
        	last = game.table.addOnTable(game.point.getDomino(1));
            if (last != "nothing") {
                game.point.remove(1);
            }
        }
        else if(actionCommand.equals("remove3")) {
        	last = game.table.addOnTable(game.point.getDomino(2));
            if (last != "nothing") {
                game.point.remove(2);
            }
        }
        else if(actionCommand.equals("remove4")) {
        	last = game.table.addOnTable(game.point.getDomino(3));
            if (last != "nothing") {
                game.point.remove(3);
            }
        }
        else if(actionCommand.equals("remove5")) {
        	last = game.table.addOnTable(game.point.getDomino(4));
        	if (last != "nothing") {
                game.point.remove(4);
        	}
        }
        else if(actionCommand.equals("remove6")) {
        	last = game.table.addOnTable(game.point.getDomino(5));
            if (last != "nothing") {
                game.point.remove(5);
            }
        }
        else if(actionCommand.equals("remove7")) {
        	last = game.table.addOnTable(game.point.getDomino(6));
            if (last != "nothing") {
                game.point.remove(6);
            }
        }
         
        repaint();  
    }
    public void drawDom (Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        //DRAWING WHITE TAB
        g2.setPaint(Color.WHITE);
        g2.setStroke(new BasicStroke(3.0f));
        g2.fillRoundRect(x, y, 46, WIDTH/15 - 2, 10, 10);
        
        int tabx = x;
        int taby = y;
        int tabWidth = 46;
        //g2.fillRoundRect(x, y, 100, 200, 20, 20);
        //DRAWING BLACK STRIP
        //IF ITS PLAYER 1 DECK
        g.setColor(Color.BLACK);
        g.fillRect(tabx, taby + 48, tabWidth, 2);

        //SMALL GOLD DOT
        g.setColor(gold);
        g.fillOval(tabx + 21, taby + 46, 5, 5);

    }
    public void drawDomHorizon (Graphics g, int x, int y) {
 
    	 Graphics2D g2 = (Graphics2D) g;
    	// g2.rotate(Math.toRadians(90));
         //DRAWING WHITE TAB
         g2.setPaint(Color.WHITE);
         g2.setStroke(new BasicStroke(3.0f));
         int rightX = 0;
         int rightY = 0;
         int leftX = 0;
         int leftY = 0;
      //   if (last == "righttopside" || last == "rightbotside") {
        	 g2.fillRoundRect(x, y, WIDTH/15 - 2, 46, 10, 10);
             
             //DRAWING BLACK STRIP
             //IF ITS PLAYER 1 DECK
             g.setColor(Color.BLACK);
             g.fillRect(x + (WIDTH/15 - 2)/2 - 1, y, 2, 46);
             //SMALL GOLD DOT
             g.setColor(gold);
             g.fillOval(x + (WIDTH/15 - 2)/2 - 3, y + 23, 5, 5);
       /*  }
         else {
        	 g2.fillRoundRect(x, y, WIDTH/15 - 2, 46, 10, 10);
             
             //DRAWING BLACK STRIP
             //IF ITS PLAYER 1 DECK
             g.setColor(Color.BLACK);
             g.fillRect(x + (WIDTH/15 - 2)/2 - 1, y, 2, 46);
             //SMALL GOLD DOT
             g.setColor(gold);
             g.fillOval(x + (WIDTH/15 - 2)/2 - 3, y + 23, 5, 5);
         }
        */
    }
     
    //DRAWING VERTICAL DOMINO
public void drawdot(Graphics g, ArrayList<Dominoes> domino, int x, int y) {
   //constants for moving onto the next domino
   int conY = 48;
   int dominoWidth = 46;
   int dominoHeight = WIDTH/15 - 2;
   Graphics2D g2 = (Graphics2D) g;
    
   for (Dominoes current: domino) {
      drawDom(g, x, y);
       
    switch(current.topside) {
        case ZERO : { break;}
        case ONE: {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+18), (y+20), 10, 10);
        break;
        }
        case TWO: {
        g2.setColor(Color.BLACK);
          g2.fillOval((x+5), (y+5), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34), 10, 10);
        break;
        }
        case THREE: {
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+5), 10, 10);    
            g2.setColor(Color.BLACK);
            g2.fillOval((x+18), (y+20), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+34), 10, 10);
            break;
                }
        case FOUR: {
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+34), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+34), 10, 10);
            break;
        }
        case FIVE: {
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+34), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+34), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+18), (y+20), 10, 10);
            break;
        }
        case SIX: {
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+20), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+34), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+20), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+34), 10, 10);
            break;
        }
    }
    switch (current.botside) {
    case ZERO : { break;}
    case ONE: {
    g2.setColor(Color.BLACK);
    g2.fillOval((x+18), (y+20 + conY), 10, 10);
    break;
    }
    case TWO: {
    g2.setColor(Color.BLACK);
      g2.fillOval((x+5), (y+5 + conY), 10, 10);
    g2.setColor(Color.BLACK);
    g2.fillOval((x+31), (y+34 + conY), 10, 10);
    break;
    }
    case THREE: {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+5 + conY), 10, 10);    
        g2.setColor(Color.BLACK);
        g2.fillOval((x+18), (y+20 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34 + conY), 10, 10);
        break;
            }
    case FOUR: {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+34 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34 + conY), 10, 10);
        break;
    }
    case FIVE: {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+34 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+18), (y+20 + conY), 10, 10);
        break;
    }
    case SIX: {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+20 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+20 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+34 + conY), 10, 10);
        break;
    }
        }
    x+= 140;
   }
 }
 
     
    public void drawtable(Graphics g, Dominoes [] domino, int x, int y) {

// 
//           //constants
//           int conX = 0;
           int botShift = 48;
           Graphics2D g2 = (Graphics2D) g;
//            
//           int save = 0;
//           int save2 = 0;
           int count = 0;
           int nextDomXR = 0;
           int nextDomYR = 0;
           
           int nextDomXL = 0;
           int nextDomYL = 0;
//           int next = 0;
//           int savex = 750;
//           int save2x = savex + 106;
//           int savey = 450;
           for (Dominoes current: domino) {
        	   //IF FIRST DOMINO PLACED ON TABLE
               if(current == null) continue;
                   if (count == 0) {
                       ArrayList<Dominoes> dominoto = new ArrayList<Dominoes>();
                       dominoto.add(current);
                       drawdot(g, dominoto, x+600, y);
                       nextDomXR = x + 648;
                       nextDomYR = y + 23;
                       
                       nextDomXL = x + 600 - 96;
                       nextDomYL = nextDomYR;

                       count++;
                   }
                   else {
                	   //IF DOMINO IS TO THE RIGHT
                	   if (current.last == "righttopside" || current.last == "rightbotside") {
                           drawDomHorizon(g, nextDomXR, nextDomYR);
                           //IF TOPSIDE IS JUTTING OUT TO THE RIGHT
                           if (current.last == "righttopside") {
                        	   switch(current.botside) {
                               case ZERO : { break;}
                               case ONE: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20), (nextDomYR + 18), 10, 10);
                               break;
                               }
                               case TWO: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5), (nextDomYR + 31), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 34), (nextDomYR + 5), 10, 10);
                               break;
                               }
                               case THREE: {
                            	   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 18), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 34), (nextDomYR + 5), 10, 10);
                                   break;
                                       }
                               case FOUR: {
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 34), 10, 10);
                                   break;
                               }
                               case FIVE: {
                            	   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 18), 10, 10);
                                   break;
                               }
                               case SIX: {
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 34), 10, 10);
                               }
                           }
                           switch (current.topside) {
                           case ZERO : { break;}
                           case ONE: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 18), 10, 10);
                           break;
                           }
                           case TWO: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 31), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXR + 34 + botShift), (nextDomYR + 5), 10, 10);
                           break;
                           }
                           case THREE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 18), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 34 + botShift), (nextDomYR + 5), 10, 10);
                               break;
                                   }
                           case FOUR: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 34), 10, 10);
                               break;
                           }
                           case FIVE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 18), 10, 10);
                               break;
                           }
                           case SIX: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 34), 10, 10);
                           }
                               }
                           count++;
                           nextDomXR = nextDomXR + 96;
                           }
                           else {
                        	   //IF BOTSIDE IS JUTTING OUT TO THE RIGHT
                               switch(current.topside) {
                               case ZERO : { break;}
                               case ONE: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20), (nextDomYR + 18), 10, 10);
                               break;
                               }
                               case TWO: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5), (nextDomYR + 31), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 34), (nextDomYR + 5), 10, 10);
                               break;
                               }
                               case THREE: {
                            	   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 18), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 34), (nextDomYR + 5), 10, 10);
                                   break;
                                       }
                               case FOUR: {
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 34), 10, 10);
                                   break;
                               }
                               case FIVE: {
                            	   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 18), 10, 10);
                                   break;
                               }
                               case SIX: {
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 5), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 31), (nextDomYR + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXR + 20), (nextDomYR + 34), 10, 10);
                               }
                           }
                           switch (current.botside) {
                           case ZERO : { break;}
                           case ONE: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 18), 10, 10);
                           break;
                           }
                           case TWO: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 31), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXR + 34 + botShift), (nextDomYR + 5), 10, 10);
                           break;
                           }
                           case THREE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 18), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 34 + botShift), (nextDomYR + 5), 10, 10);
                               break;
                                   }
                           case FOUR: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 34), 10, 10);
                               break;
                           }
                           case FIVE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 18), 10, 10);
                               break;
                           }
                           case SIX: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 5 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 31 + botShift), (nextDomYR + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXR + 20 + botShift), (nextDomYR + 34), 10, 10);
                           }
                               }
                           count++;
                           nextDomXR = nextDomXR + 96;
                           }
                	   }
                	   else {
                		   //DOMINO IS PLACED ON THE LEFTSIDE
                		   drawDomHorizon(g, nextDomXL, nextDomYL);
                		 //IF TOPSIDE IS JUTTING OUT TO THE LEFT
                		   if (current.last == "lefttopside") {
                           switch(current.topside) {
                           case ZERO : { break;}
                           case ONE: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 20), (nextDomYL + 18), 10, 10);
                           break;
                           }
                           case TWO: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5), (nextDomYL + 31), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 34), (nextDomYL + 5), 10, 10);
                           break;
                           }
                           case THREE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20), (nextDomYL + 18), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 34), (nextDomYL + 5), 10, 10);
                               break;
                                   }
                           case FOUR: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31), (nextDomYL + 34), 10, 10);
                               break;
                           }
                           case FIVE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20), (nextDomYL + 18), 10, 10);
                               break;
                           }
                           case SIX: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20), (nextDomYL + 34), 10, 10);
                           }
                       }
                       switch (current.botside) {
                       case ZERO : { break;}
                       case ONE: {
                       g2.setColor(Color.BLACK);
                       g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 18), 10, 10);
                       break;
                       }
                       case TWO: {
                       g2.setColor(Color.BLACK);
                       g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 31), 10, 10);
                       g2.setColor(Color.BLACK);
                       g2.fillOval((nextDomXL + 34 + botShift), (nextDomYL + 5), 10, 10);
                       break;
                       }
                       case THREE: {
                    	   g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 18), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 34 + botShift), (nextDomYL + 5), 10, 10);
                           break;
                               }
                       case FOUR: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 5), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 5), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 34), 10, 10);
                           break;
                       }
                       case FIVE: {
                    	   g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 5), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 5), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 34), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 18), 10, 10);
                           break;
                       }
                       case SIX: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 5), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 5), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 34), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 5), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 34), 10, 10);
                       }
                           }
                       count++;
                       nextDomXL = nextDomXL - 96;
                		   }
                           else {
                        	   //IF BOTSIDE IS JUTTING OUT TO THE LEFT
                        	   switch(current.botside) {
                               case ZERO : { break;}
                               case ONE: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20), (nextDomYL + 18), 10, 10);
                               break;
                               }
                               case TWO: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5), (nextDomYL + 31), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 34), (nextDomYL + 5), 10, 10);
                               break;
                               }
                               case THREE: {
                            	   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 20), (nextDomYL + 18), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 34), (nextDomYL + 5), 10, 10);
                                   break;
                                       }
                               case FOUR: {
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 5), (nextDomYL + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 31), (nextDomYL + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 31), (nextDomYL + 34), 10, 10);
                                   break;
                               }
                               case FIVE: {
                            	   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 5), (nextDomYL + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 31), (nextDomYL + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 31), (nextDomYL + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 20), (nextDomYL + 18), 10, 10);
                                   break;
                               }
                               case SIX: {
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 5), (nextDomYL + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 5), (nextDomYL + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 31), (nextDomYL + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 31), (nextDomYL + 34), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 20), (nextDomYL + 5), 10, 10);
                                   g2.setColor(Color.BLACK);
                                   g2.fillOval((nextDomXL + 20), (nextDomYL + 34), 10, 10);
                               }
                           }
                           switch (current.topside) {
                           case ZERO : { break;}
                           case ONE: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 18), 10, 10);
                           break;
                           }
                           case TWO: {
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 31), 10, 10);
                           g2.setColor(Color.BLACK);
                           g2.fillOval((nextDomXL + 34 + botShift), (nextDomYL + 5), 10, 10);
                           break;
                           }
                           case THREE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 18), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 34 + botShift), (nextDomYL + 5), 10, 10);
                               break;
                                   }
                           case FOUR: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 34), 10, 10);
                               break;
                           }
                           case FIVE: {
                        	   g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 18), 10, 10);
                               break;
                           }
                           case SIX: {
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 5 + botShift), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 31 + botShift), (nextDomYL + 34), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 5), 10, 10);
                               g2.setColor(Color.BLACK);
                               g2.fillOval((nextDomXL + 20 + botShift), (nextDomYL + 34), 10, 10);
                           }
                               }
                           count++;
                           nextDomXL = nextDomXL - 96;
                           }
                	   }
                   }
           }
           }
         
 /*   public void drawDotshorizon (Graphics g, Dominoes [] domino, int p, int k) {
         
         int y = k;
           int x = p;
           //constants
           int conX = k;
           int conY = p;
           Graphics2D g2 = (Graphics2D) g;
            
           int j = 0;
           int count = 0;
        
        for(Dominoes current : domino) {
            if(count%7 == 0 && count !=0)  j+=225;
            if(current == null) continue;
            //if(count == 0) { drawtable(g, domino, p, k); count ++; continue;}
              //drawDomHorizon(g, k, p+j);
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
    }
   */
    public void paint(Graphics g) {
 
    g.setColor(Color.RED);
      g.fillRect(0, 0, WIDTH, HEIGHT); 
       
      drawdot(g, game.point.dominoes, 300, 50);
      drawtable(g, game.table.dominoes, 50, 400);
    }
public void background () {
    JLabel label = new JLabel("");
    label.setBackground(new Color(0, 102, 51));
    label.setIcon(new ImageIcon("C:\\Users\\kosta\\Dropbox (Amherst College)\\2nd Semester Amherst\\CS112\\FINAL PROJECT\\background.jpg"));
    label.setBounds(-10, -124, 977, 692);
    frame.getContentPane().add(label);
 
}
 
  public void run() {
      Game.runGame();
      JFrame frame = new JFrame();
      frame.getContentPane().add(new drawing());
      frame.setBounds(250, 100, WIDTH, HEIGHT);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      repaint();
  }
}
