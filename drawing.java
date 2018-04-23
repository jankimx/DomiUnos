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
            if (game.table.addOnTable(game.point.getDomino(0)) == true) {
                game.point.remove(0);
            }
        }
        else if(actionCommand.equals("remove2")) {
            if (game.table.addOnTable(game.point.getDomino(1)) == true) {
                game.point.remove(1);
            }
        }
        else if(actionCommand.equals("remove3")) {
            if (game.table.addOnTable(game.point.getDomino(2)) == true) {
                game.point.remove(2);
            }
        }
        else if(actionCommand.equals("remove4")) {
            if (game.table.addOnTable(game.point.getDomino(3)) == true) {
                game.point.remove(3);
            }
        }
        else if(actionCommand.equals("remove5")) {
        	if (game.table.addOnTable(game.point.getDomino(4)) == true) {
                game.point.remove(4);
        	}
        }
        else if(actionCommand.equals("remove6")) {
            if (game.table.addOnTable(game.point.getDomino(5)) == true) {
                game.point.remove(5);
            }
        }
        else if(actionCommand.equals("remove7")) {
            if (game.table.addOnTable(game.point.getDomino(6)) == true) {
                game.point.remove(6);
            }
        }
         
        repaint();  
    }
    public void drawDom (Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
 
        g2.setPaint(Color.WHITE);
        g2.setStroke(new BasicStroke(3.0f));
        g2.fillRoundRect(x, y, 100, 200, 20, 20);
        if(y < 400) {
        g.setColor(Color.BLACK);
        g.fillRect(x+8, y+y+y, 84, 5);
        
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(x+8, y+100, 84, 5);
        }
        g.setColor(gold);
        g.fillOval(x+44, y+97, 10, 10);

    }
    public void drawDomHorizon (Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
 
        g2.setPaint(Color.WHITE);
        g2.setStroke(new BasicStroke(3.0f));
 
        g2.fillRoundRect(x, y, 200, 100, 20, 20);
         
        g.setColor(Color.BLACK);
        g.fillRect(x+100, y+10, 5, 84);
         
        g.setColor(gold);
        g.fillOval(x+97, y+48, 10, 10);
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
 }
 
     
    public void drawtable(Graphics g, Dominoes [] domino, int p, int k) {
         int y = k;
           int x = p;
 
           //constants
           int conX = 0;
           int conY = 0;
           Graphics2D g2 = (Graphics2D) g;
            
           int save = 0;
           int save2 = 0;
           int count = 0;
           int next = 0;
           int savex = 750;
           int save2x = savex + 106;
           int savey = 450;
           for (Dominoes current: domino) {
               if(current == null) continue;
                   if (count == 0) {
                       ArrayList<Dominoes> dominoto = new ArrayList<Dominoes>();
                       dominoto.add(current);
                       drawdot(g, dominoto, x+600, y);
                       save = x + 600;
                       save2 = y;
                       count ++;
 
                   }
                   else {
                    drawDomHorizon(g, save + 102 + next, save2 + 50);
                     
                    
            switch(current.topside) {
                case ZERO : { break;}
                case ONE: {
                g2.setColor(Color.BLACK);
                g2.fillOval((savex+40), (savey+45), 18, 18);
                break;
                }
                case TWO: {
                g2.setColor(Color.BLACK);
                  g2.fillOval((savex+18), (savey+72), 18, 18);
                g2.setColor(Color.BLACK);
                g2.fillOval((savex+65), (savey+17), 18, 18);
                break;
                }
                case THREE: {
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+40), (savey+45), 18, 18);    
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+72), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+17), 18, 18);
                    break;
                        }
                case FOUR: {
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+72), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+18), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+18), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+72), 18, 18);
                    break;
                }
                case FIVE: {
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+42), (savey+45), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+72), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+18), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+18), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+72), 18, 18);
                    break;
                }
                case SIX: {
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+45), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+45), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+72), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+18), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+18), (savey+18), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((savex+65), (savey+72), 18, 18);
                    break;
                }
            }
            //conY+= 100;
            switch (current.botside) {
                case ZERO : {break;}
                case ONE: {
                    g2.setColor(Color.BLACK);
                    g2.fillOval((save2x+40+conX), (savey+45+conY), 18, 18);
                    break;
                    }
                    case TWO: {
                    g2.setColor(Color.BLACK);
                      g2.fillOval((save2x+18+conX), (savey+72+conY), 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.fillOval((save2x+65+conX), (savey+17+conY), 18, 18);
                    break;
                    }
                    case THREE: {
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+40+conX), (savey+45+conY), 18, 18); 
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18+conX), (savey+72+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65+conX), (savey+17+conY), 18, 18);
                        break;
                            }
                    case FOUR: {
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18+conX), (savey+72+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65+conX), (savey+18+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18+conX), (savey+18+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65+conX), (savey+72+conY), 18, 18);
                        break;
                    }
                    case FIVE: {
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+42), (savey+45+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18), (savey+72+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65), (savey+18+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18), (savey+18+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65), (savey+72+conY), 18, 18);
                        break;
                    }
                    case SIX: {
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18+conX), (savey+45+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65+conX), (savey+45+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18+conX), (savey+72+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65+conX), (savey+18+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+18+conX), (savey+18+conY), 18, 18);
                        g2.setColor(Color.BLACK);
                        g2.fillOval((save2x+65+conX), (savey+72+conY), 18, 18);
                        break;
                    }
                }
            next = next + 202;
            savex = savex + save + 102 + next;
            x+= 140;
            //conY-=100;
            count++;
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
