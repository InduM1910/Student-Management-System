import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data Updation");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(284, 22, 326, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_1.setBounds(55, 118, 230, 53);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Name");
		chckbxNewCheckBox_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		chckbxNewCheckBox_1.setBounds(72, 218, 134, 33);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Marks");
		chckbxNewCheckBox_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		chckbxNewCheckBox_2.setBounds(572, 218, 123, 33);
		contentPane.add(chckbxNewCheckBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Click Here to Update : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(60, 308, 303, 33);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
	            	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	            	   int studentID = Integer.parseInt(textField_1.getText()); // ID to update
	                   String newName = textField_2.getText(); // New Name
	                   String newMarks = textField_3.getText(); // New Marks

	                   // Step 3: Check which checkboxes are selected
	                   boolean isNameChecked = chckbxNewCheckBox_1.isSelected();
	                   boolean isMarksChecked = chckbxNewCheckBox_2.isSelected();

	                   // Step 4: Build the dynamic update query
	                   StringBuilder queryBuilder = new StringBuilder("UPDATE class1 SET ");
	                   boolean isFirstField = true; // To manage commas between fields

	                   if (isNameChecked) {
	                       queryBuilder.append("name = ?");
	                       isFirstField = false;
	                   }

	                   if (isMarksChecked) {
	                       if (!isFirstField) queryBuilder.append(", ");
	                       queryBuilder.append("marks = ?");
	                   }

	                   queryBuilder.append(" WHERE id = ?");

	                   // Step 5: Prepare and execute the query
	                   PreparedStatement ps = con.prepareStatement(queryBuilder.toString());
	                   int parameterIndex = 1;

	                   if (isNameChecked) {
	                       ps.setString(parameterIndex++, newName);
	                   }
	                   if (isMarksChecked) {
	                       ps.setInt(parameterIndex++, Integer.parseInt(newMarks));
	                   }
	                   ps.setInt(parameterIndex, studentID);

	                   int rowsUpdated = ps.executeUpdate();

	                   // Step 6: Retrieve and display updated details
	                   if (rowsUpdated > 0) {
	                       String fetchQuery = "SELECT * FROM class1 WHERE id = ?";
	                       ps = con.prepareStatement(fetchQuery);
	                       ps.setInt(1, studentID);

	                       ResultSet rs = ps.executeQuery();
	                       if (rs.next()) {
	                           String updatedDetails = "ID: " + rs.getInt("id") +
	                                                   ", Name: " + rs.getString("name") +
	                                                   ", Marks: " + rs.getInt("marks");
	                           textField.setText(updatedDetails);
	                       } else {
	                           textField.setText("No record found with ID: " + studentID);
	                       }
	                   } else {
	                       textField.setText("No rows updated. Please check the ID and try again.");
	                   }

	                   // Step 7: Close connections
	                   con.close();
	               } catch (Exception ex) {
	                   textField.setText("Error: " + ex.getMessage());
	                   ex.printStackTrace();
	               }
			}
		});
		btnNewButton.setForeground(new Color(153, 51, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(403, 301, 230, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Updated Details :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(61, 404, 285, 41);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 30));
		textField.setBounds(303, 383, 478, 84);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(153, 0, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(325, 531, 177, 53);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setBounds(228, 118, 210, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setBounds(228, 218, 291, 46);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(721, 218, 114, 33);
		contentPane.add(textField_3);
	}

}
