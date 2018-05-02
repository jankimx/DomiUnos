import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class congrats {
 
    private JFrame frame;
 
    /**
     * Launch the application.
     */
    public static void run() {
        EventQueue.invokeLater(new Runnable() {
		public void run() {
		    try {
			congrats window = new congrats();
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
    public congrats() {
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
        JButton btnCongrats = new JButton("It's a Draw.");
	if (Window.points1 >= 100) {
	    btnCongrats = new JButton("Congratulations! Player 2 won!");
	}
	else if (Window.points2 >= 100) {
	    btnCongrats = new JButton("Congratulations! Player 1 won!");
	}
	btnCongrats.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    System.exit(0);
		}
	    });
        btnCongrats.setBounds(70, 106, 300, 29);
        frame.getContentPane().add(btnCongrats);
    }
}