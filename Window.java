import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
  
public class Window {
  
    static int points1 = 0;
    static int points2 = 0;
    static scoreboard scorepointer;
    private JFrame frmDominunos;
    static drawing pointer;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
		public void run() {
		    try {
			Window window = new Window();
			window.frmDominunos.setVisible(true);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    });
    }
  
    /**
     * Create the application.
     */
    public Window() {
        initialize();
    }
  
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmDominunos = new JFrame();
        frmDominunos.setFont(new Font("Dialog", Font.PLAIN, 11));
        frmDominunos.setTitle("Dominunos\r\n");
        frmDominunos.setForeground(Color.WHITE);
        frmDominunos.getContentPane().setBackground(Color.WHITE);
        frmDominunos.setBounds(100, 100, 1127, 491);
        frmDominunos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frmDominunos.getContentPane().setLayout(null);
          
        JButton btnPlay = new JButton("");
        btnPlay.setIcon(new ImageIcon("C:\\Users\\juper\\Desktop\\background\\playbutton.jpg"));
        btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnPlay.setBackground(new Color(204, 204, 204));
        btnPlay.setForeground(Color.DARK_GRAY);
        
        btnPlay.setBounds(395, 11, 311, 108);
        btnPlay.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    drawing play = new drawing();
		    pointer = play;
		    play.run();
                  
		    scoreboard score = new scoreboard();
		    scorepointer = score;
		    scorepointer.run();

		}
	    });
        frmDominunos.getContentPane().add(btnPlay);
          
        JLabel label = new JLabel("");
        label.setBackground(new Color(0, 102, 51));
        label.setIcon(new ImageIcon("C:\\Users\\juper\\Desktop\\background\\3D-Dominunos.jpg"));
        label.setBounds(-136, 0, 1265, 716);
        frmDominunos.getContentPane().add(label);
          
          
          
    }
}