import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.Font;
 
 
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.JScrollBar;
 
public class drawing extends JPanel implements ActionListener{
    public static final int WIDTH = 1440;
    public static final int HEIGHT = 900;
    public static final int FPS = 60;
    int numofDom = 0;
    boolean toHide = false;
    String last = "lol";
    Color gold = new Color(218,165,32);
    Color yellow = new Color(255,255,0);
    Color green = new Color(0,255,0);
    int toRemove=0;
    static Game game = new Game ();
    int x = 0;
    private JFrame frame;
    Image background = Toolkit.getDefaultToolkit().createImage("C:\\Users\\kosta\\Dropbox (Amherst College)\\2nd Semester Amherst\\CS112\\FINAL PROJECT\\background1.jpg");
    Image waiting = Toolkit.getDefaultToolkit().createImage("C:\\Users\\kosta\\Dropbox (Amherst College)\\2nd Semester Amherst\\CS112\\FINAL PROJECT\\Newest\\Patch 2\\dominoesfall.gif");
//-----------------------------------------------------------------KEY BINDINGS----------------------------------------------------------------    
    public class InputMouseEvents extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
             
            System.out.println("X:" + x + " " + "Y:" + y);
            if(x>100 && x<146 && y>46 && y<146)  toRemove = 0;
            else if (x>239 && x<285 && y>46 && y<146) toRemove = 1; 
            else if (x>378 && x<426 && y>46 && y<146) toRemove = 2;
            else if (x>519 && x<565 && y>46 && y<146) toRemove = 3;
            else if (x>658 && x<707 && y>46 && y<146) toRemove = 4;
            else if (x>798 && x<846 && y>46 && y<146) toRemove = 5;
            else if (x>938 && x<986 && y>46 && y<146) toRemove = 6;
            else if (x>1079 && x<1126 && y>46 && y<146) toRemove = 7;
            else if (x>1216 && x<1267 && y>46 && y<146) toRemove = 8;
            else if (x>1357 && x<1407 && y>46 && y<146) toRemove = 9;   
        }
        public void mouseReleased(MouseEvent e) {
              int x = e.getX();
              int y = e.getY();
        //First player round      
      if(!toHide) {
 
              if(x<WIDTH/2) {
                  game.table.addOnTable(game.userOneHand.remove(toRemove), 0);
              }
              else {
                  game.table.addOnTable(game.userOneHand.remove(toRemove), 1);
              }  
              toHide=true;
        }
      else {
          if(x<WIDTH/2) {
              game.table.addOnTable(game.userTwoHand.remove(toRemove), 0);
          }
          else {
              game.table.addOnTable(game.userTwoHand.remove(toRemove), 1);
          }  
          toHide = false;
     }
   }
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            System.out.println(x + " " + y);
            game.userOneHand.dominoes.get(toRemove).x = game.userOneHand.dominoes.get(toRemove).x + x;
            game.userOneHand.dominoes.get(toRemove).y = game.userOneHand.dominoes.get(toRemove).y + y;
            repaint();
           
        }
          public void updateLocation(MouseEvent e, ArrayList<Dominoes> domino) {
              int x = e.getX();
              int y = e.getY();
              domino.get(toRemove).x = domino.get(toRemove).x + x;
              domino.get(toRemove).y = domino.get(toRemove).y + y;
 
              repaint();
          }
    }
    public class InputKeyEvents extends KeyAdapter{
 
        public void keyPressed(KeyEvent e) {
            int c=e.getKeyCode();
    System.out.println(c);
            //First player move -- Drawing domino from deck, if not then they play on table
    if(c==37) {
        x +=50;
        repaint();
    }
    else if (c==39) {
        x -=50;
        repaint();
    }
    else if (!toHide && c == 32) {
        game.userOneHand.dominoes.add(game.GamePile.remove(0));
    }
    else if (toHide && c == 32) game.userTwoHand.dominoes.add(game.GamePile.remove(0));
    }
        
   }
//-----------------------------------------------------------------RUNNABLE DRAG/DROP-----------------------------------------------------------------     
    class Runner implements Runnable{
        public void run()
        {
            while(true){
            updateDom(1.0 / (double)FPS);
            repaint();
            try{
                Thread.sleep(1000/FPS);
            }
            catch(InterruptedException e){}
            }
 
        }
         
        }
    public void updateDom (double time) {
        if(!toHide) {
            update(game.userOneHand.dominoes, time);
        }
        else {
            update(game.userTwoHand.dominoes, time);
        }
    }
     
    public void update (ArrayList<Dominoes> domino, double time) {
        domino.get(toRemove).x= domino.get(toRemove).x * time;
        domino.get(toRemove).y = domino.get(toRemove).y * time;
    }
//-----------------------------------------------------------------CONSTRUCTOR-----------------------------------------------------------------     
    public drawing() {
        addKeyListener(new InputKeyEvents());
        addMouseListener(new InputMouseEvents());
        addMouseMotionListener(new InputMouseEvents());
        setFocusable(true);
        setLayout(null);
         
         
    }
//--------------------------------------------------------------DRAWING OF DOMINOES------------------------------------------------------------ 
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
    public void drawSpecialSkipDom (Graphics g, double x, double y) {
        Graphics2D g2 = (Graphics2D) g;
        //DRAWING WHITE TAB
        g2.setPaint(Color.RED);
         
        g2.setStroke(new BasicStroke(3.0f));
        g2.fillRoundRect((int)x, (int)y, 46, WIDTH/15 - 2, 10, 10);
         
        double tabx = x;
        double taby = y;
        double tabWidth = 46;
        //g2.fillRoundRect(x, y, 100, 200, 20, 20);
        //DRAWING BLACK STRIP
        //IF ITS PLAYER 1 DECK
        g.setColor(Color.BLACK);
        g.fillRect((int)tabx,(int) taby + 48, (int)tabWidth, 2);
 
        //SMALL GOLD DOT
        g.setColor(Color.GREEN);
        g.fillOval((int)tabx + 21,(int) taby + 46, 5, 5);
         
    }
    public void drawSpecialDrawDom (Graphics g, double x, double y) {
        Graphics2D g2 = (Graphics2D) g;
        //DRAWING WHITE TAB
        g2.setPaint(Color.BLUE);
         
        g2.setStroke(new BasicStroke(3.0f));
        g2.fillRoundRect((int)x, (int)y, 46, WIDTH/15 - 2, 10, 10);
         
        double tabx = x;
        double taby = y;
        double tabWidth = 46;
        //g2.fillRoundRect(x, y, 100, 200, 20, 20);
        //DRAWING BLACK STRIP
        //IF ITS PLAYER 1 DECK
        g.setColor(Color.BLACK);
        g.fillRect((int)tabx,(int) taby + 48, (int)tabWidth, 2);
 
        //SMALL GOLD DOT
        g.setColor(Color.GREEN);
        g.fillOval((int)tabx + 21,(int) taby + 46, 5, 5);
         
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
public void drawdot(Graphics g, Dominoes domino, double k, double p) {
   //constants for moving onto the next domino
    int x = (int)k;
    int y = (int)p;
   int count = 0;
   int conY = 48;
   int dominoWidth = 46;
   int dominoHeight = WIDTH/15 - 2;
   Graphics2D g2 = (Graphics2D) g;
     
 
      if(domino.isSpecialSkip()) {drawSpecialSkipDom(g, x, y);}
      else if(domino.isSpecialDraw()) {drawSpecialDrawDom(g, x, y);}
      else {  drawDom(g, x, y);}
        
     for(int i = 0; i < 2; i++) { 
       
   if(count == 0) {
        if(domino.topside.name().equals("ZERO"))  {}
        else if(domino.topside.name().equals("ONE")) {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+18), (y+20), 10, 10);
       
        }
        else  if(domino.topside.name().equals("TWO")) {
        g2.setColor(Color.BLACK);
          g2.fillOval((x+5), (y+5), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34), 10, 10);
        
        }
        else  if(domino.topside.name().equals("THREE")) {
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+5), 10, 10);    
            g2.setColor(Color.BLACK);
            g2.fillOval((x+18), (y+20), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+34), 10, 10);
          
                }
        else   if(domino.topside.name().equals("FOUR")) {
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+5), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+5), (y+34), 10, 10);
            g2.setColor(Color.BLACK);
            g2.fillOval((x+31), (y+34), 10, 10);
 
        }
        else if(domino.topside.name().equals("FIVE")) {
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
          
        }
        else  if(domino.topside.name().equals("SIX")) {
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
             
        }
        count++;
    }
   else {
       if(domino.botside.name().equals("ZERO")) {}
       else if(domino.botside.name().equals("ONE")) {
    g2.setColor(Color.BLACK);
    g2.fillOval((x+18), (y+20 + conY), 10, 10);
     
    }
       else  if(domino.botside.name().equals("TWO")) {
    g2.setColor(Color.BLACK);
      g2.fillOval((x+5), (y+5 + conY), 10, 10);
    g2.setColor(Color.BLACK);
    g2.fillOval((x+31), (y+34 + conY), 10, 10);
     
    }
       else if(domino.botside.name().equals("THREE")) {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+5 + conY), 10, 10);    
        g2.setColor(Color.BLACK);
        g2.fillOval((x+18), (y+20 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34 + conY), 10, 10);
       
            }
       else  if(domino.botside.name().equals("FOUR")) {
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+5 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+5), (y+34 + conY), 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval((x+31), (y+34 + conY), 10, 10);
         
    }
       else   if(domino.botside.name().equals("FIVE")) {
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
         
    }
       else if(domino.botside.name().equals("SIX")) {
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
         
    }
         
   }
  }
}
  
public void drawdotTable(Graphics g, ArrayList<Dominoes> domino, int x, int y) {
       //constants for moving onto the next domino
       int conY = 48;
       int dominoWidth = 46;
       int dominoHeight = WIDTH/15 - 2;
       Graphics2D g2 = (Graphics2D) g;
         
       for (Dominoes current: domino) {
          if(current.isSpecialSkip()) {drawSpecialSkipDom(g, x, y);}
          else if(current.isSpecialDraw()) {drawSpecialDrawDom(g, x, y);}
          else {  drawDom(g, x, y);}
            
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
                       drawdotTable(g, dominoto, x+600, y);
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
    public void drawDotshorizon (Graphics g, Dominoes [] domino, int p, int k) {
         
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
//----------------------------------------------------------PAINT METHOD AND BACKGROUND IMAGES-------------------------------------------------- 
    public void paint(Graphics g) {
 
        int q = 0; int p = 0;
      g.drawImage(background, 0, 0, null);
       
      for(Dominoes current : game.userOneHand.dominoes) {
            current.x = (double)100+q;
            current.y = (double)50;
      drawdot(g, current, current.x, current.y);
      q+=140;
      }
      for(Dominoes current : game.userTwoHand.dominoes) {
          current.x = (double)100+p;
          current.y = (double)50;
      drawdot(g, current, 100+p, 650);
      p+=140;
      }
 
     drawtable(g, game.table.dominoes, 50+x, 400);
      
      if(toHide) {
          g.drawImage(waiting, 0, 0, null);
          g.drawImage(waiting, 500, 0, null);
          g.drawImage(waiting, 950, 0, null);
      }else {
          g.drawImage(waiting, 0, 600, null);
          g.drawImage(waiting, 500, 600, null);
          g.drawImage(waiting, 950, 600, null);
      }
    
      repaint();
     
       
    }
 
 
  public void run() {
      Game.runGame();
      JFrame frame = new JFrame();
      drawing instance = new drawing();
     // JScrollPane scroll = new JScrollPane(instance, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //  frame.add(scroll);
      frame.getContentPane().add(instance);
      frame.setBounds(250, 100, WIDTH, HEIGHT);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
  }
   
public void actionPerformed(ActionEvent e) {
    // update screen
/// repaint();
    }
}
