import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class reset {
 
    JFrame frame;
 
    /**
     * Launch the application.
     */
    public static void run() {
        EventQueue.invokeLater(new Runnable() {
		public void run() {
		    try {
			reset window = new reset();
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
    public reset() {
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
         
        JButton btnReplay = new JButton("Begin next round?");
        
        btnReplay.setBounds(125, 106, 170, 29);
        btnReplay.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    frame.dispose();
		    drawing replay = new drawing();
		    replay.run();
                
		    scoreboard score = new scoreboard();
		    score.run();
		}
	    });
        frame.getContentPane().add(btnReplay);
        
    }
}