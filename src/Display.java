import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Display extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
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
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int id;
	
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 642);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setForeground(new Color(0, 51, 204));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(302, 23, 497, 70);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 50));
		textField.setBounds(222, 312, 665, 122);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID :");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(171, 122, 275, 52);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textField_1.setBackground(new Color(250, 235, 215));
		textField_1.setForeground(new Color(128, 128, 128));
		textField_1.setBounds(433, 129, 261, 52);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = null;
             try {
            	 Class.forName("com.mysql.cj.jdbc.Driver");
            	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            	 String sql = "select * from class1 where id=?";
            	 ps = con.prepareStatement(sql);
            	 id = Integer.parseInt(textField_1.getText());
            	 ps.setInt(1, id);
            	 rs = ps.executeQuery();
            	 if (rs.next()) {
                     str = rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3);
                     textField.setText(str); // Display student details
                 } else {
                     textField.setText("No records found for ID: " + id);
                 }
            	 //textField_1.setText(str);
            	 con.close();
     			ps.close();
     			rs.close();
     			textField_1.setText("");
             }
             catch(Exception e1) {
            	 JOptionPane.showMessageDialog(null, "Something Worng");
            	 //e1.printStackTrace();
             }
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(433, 207, 365, 62);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Click Here to Display :");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(116, 213, 318, 51);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Details :");
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(91, 340, 121, 52);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(361, 498, 169, 52);
		contentPane.add(btnNewButton_1);
	}
}
