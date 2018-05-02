import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class scoreboard {
 
    public JFrame frame;
 
    /**
     * Launch the application.
     */
    public static void run (){
        EventQueue.invokeLater(new Runnable() {
		public void run() {
		    try {
			scoreboard window = new scoreboard();
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
    public scoreboard() {
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(0, 0, 262, 483);
        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
         
        JLabel lblScoreboard = new JLabel("Scoreboard");
        lblScoreboard.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblScoreboard.setBounds(33, 27, 171, 29);
        frame.getContentPane().add(lblScoreboard);
        JLabel lblPlayer = new JLabel("Player 1: " + Window.points1);
        lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblPlayer.setBounds(61, 76, 143, 29);
        frame.getContentPane().add(lblPlayer);
         
        JLabel lblPlayer2 = new JLabel("Player 2: " + Window.points2);
        lblPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblPlayer2.setBounds(61, 146, 143, 44);
        frame.getContentPane().add(lblPlayer2);
         
        JButton btnDominurules = new JButton("DomiUno Rules");
        
        btnDominurules.setBounds(61, 330, 141, 29);
        btnDominurules.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    rules rules = new rules();
		    rules.run();
		}
	    });
        frame.getContentPane().add(btnDominurules);
    }
}