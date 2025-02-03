import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 45));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 617);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(178, 21, 588, 60);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Display Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display d = new Display();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(71, 168, 300, 60);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customaised Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customised_display cd = new Customised_display();
				cd.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(524, 168, 328, 60);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Record");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete d = new Delete();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.MAGENTA);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_2.setBounds(71, 323, 300, 60);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Insert Record");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert i = new Insert();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_3.setForeground(Color.MAGENTA);
		btnNewButton_3.setBounds(524, 323, 328, 60);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update Record");
		btnNewButton_4.setForeground(Color.MAGENTA);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update u = new Update();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(295, 447, 317, 67);
		getContentPane().add(btnNewButton_4);
	}
}
