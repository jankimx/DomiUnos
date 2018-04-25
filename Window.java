import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Window {

	private JFrame frmDominunos;

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
		frmDominunos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDominunos.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon("C:\\Users\\kosta\\Dropbox (Amherst College)\\2nd Semester Amherst\\CS112\\FINAL PROJECT\\playbutton.jpg"));
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setBackground(new Color(204, 204, 204));
		btnPlay.setForeground(Color.DARK_GRAY);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing play = new drawing();
				play.run();
			}
		});
		btnPlay.setBounds(395, 11, 311, 108);
		frmDominunos.getContentPane().add(btnPlay);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(0, 102, 51));
		label.setIcon(new ImageIcon("C:\\Users\\kosta\\Dropbox (Amherst College)\\2nd Semester Amherst\\CS112\\FINAL PROJECT\\3D-Dominunos.jpg"));
		label.setBounds(-136, 0, 1265, 716);
		frmDominunos.getContentPane().add(label);
		
		
		
	}
}
