import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class rules {
 
    private JFrame frame;
 
    /**
     * Launch the application.
     */
    public static void run() {
        EventQueue.invokeLater(new Runnable() {
		public void run() {
		    try {
			rules window = new rules();
			window.frame.setVisible(true);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    });
    }
 
    /**
     * Create the application.
     */
    public rules() {
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1084, 560);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
         
        JTextPane txtpnAsdfasf = new JTextPane();
        txtpnAsdfasf.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtpnAsdfasf.setBackground(Color.ORANGE);
        txtpnAsdfasf.setText("# DomiUnos\r\n\r\nRules:\r\n1. 2 players (alternating turns)\r\n2. To start, each player is given 7 dominos\r\n3. Yellow dominos mean skip and green dominos indicate draw another tile\r\n4. If Player 1 sets down a yellow domino (if it fits), then Player 2's turn is skipped (and vice versa)\r\n5. If Player 1 sets down a green domino (if it fits), then Player 2 must draw another tile from the shuffled pile (and vice versa) \r\n6. Each turn a player lays the dominoes end to end (the touching ends must match: i.e., one\u2019s touch one\u2019s, two\u2019s touch two\u2019s, etc.)\r\n7. The player is to click the desired domino and drag to the area he or she wants to place the domino (must be within the middle area) \r\n8. If a player cannot make another move with their tile, they must draw a domino until they can place one unless there are no more tiles to draw from. If the latter is true, then the other player places their tile.\r\n9. The round ends when either no more moves are left to make (or all tiles used) or one of the players does not have any tiles left in his/her pile \r\n10. Game ends when one player gets 100 points with as many rounds as needed. Points are accumulated by the values on the leftover dominos in one's hand \r\n11. Whoever gets 100 points first loses");
        txtpnAsdfasf.setBounds(0, 0, 1084, 560);
        frame.getContentPane().add(txtpnAsdfasf);
    }
}