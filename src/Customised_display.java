import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Customised_display extends JFrame {

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
					Customised_display frame = new Customised_display();
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
	
	public Customised_display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Custome Student Details");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(147, 23, 495, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(144, 116, 150, 35);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBounds(302, 116, 300, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Details :");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(116, 175, 150, 53);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ID");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 30));
		chckbxNewCheckBox.setForeground(Color.BLUE);
		chckbxNewCheckBox.setBounds(272, 184, 160, 35);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Name");
		chckbxNewCheckBox_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		chckbxNewCheckBox_1.setForeground(Color.BLUE);
		chckbxNewCheckBox_1.setBounds(496, 182, 137, 38);
		contentPane.add(chckbxNewCheckBox_1);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
	            	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	            	   int studentID = Integer.parseInt(textField.getText());

	                   // Check which checkboxes are selected
	                   boolean isIDChecked = chckbxNewCheckBox.isSelected();
	                   boolean isNameChecked = chckbxNewCheckBox_1.isSelected();

	                   // Dynamically build the SQL query
	                   StringBuilder queryBuilder = new StringBuilder("SELECT ");
	                   if (isIDChecked) {
	                       queryBuilder.append("id");
	                   }
	                   if (isNameChecked) {
	                       if (isIDChecked) queryBuilder.append(", ");
	                       queryBuilder.append("name");
	                   }
	                   queryBuilder.append(" FROM class1 WHERE id = ?");

	                   // Prepare and execute the query
	                   ps = con.prepareStatement(queryBuilder.toString());
	                   ps.setInt(1, studentID);
	                   rs = ps.executeQuery();

	                   // Display the result in the textField_1
	                   if (rs.next()) {
	                       StringBuilder resultBuilder = new StringBuilder();
	                       if (isIDChecked) {
	                           resultBuilder.append("ID: ").append(rs.getInt("id")).append("  ");
	                       }
	                       if (isNameChecked) {
	                           resultBuilder.append("Name: ").append(rs.getString("name"));
	                       }
	                       textField_1.setText(resultBuilder.toString());
	                   } else {
	                       textField_1.setText("No records found for ID: " + studentID);
	                   }

	                   // Close connections
	                   con.close();
	                   ps.close();
	                   rs.close();
	                   textField.setText("");
	               } catch (Exception ex) {
	                   textField_1.setText("Error: " + ex.getMessage());
	               }
				 
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(448, 248, 154, 48);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		textField_1.setBounds(225, 336, 512, 99);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Click Here to Dsiaply :");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(90, 255, 325, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Details :");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_4.setBounds(103, 355, 129, 48);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(65, 105, 225));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(302, 476, 152, 53);
		contentPane.add(btnNewButton_1);
	}
}
