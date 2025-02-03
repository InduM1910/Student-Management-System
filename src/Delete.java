import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class Delete extends JFrame {

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
					Delete frame = new Delete();
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
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	ResultSet rs = null;
	int id;
	
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 663);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data Deletion");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(244, 20, 305, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(26, 105, 194, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Click Here to Delete :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(26, 187, 298, 41);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = null;
	             try {
	            	 Class.forName("com.mysql.cj.jdbc.Driver");
	            	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	            	 String sql1 = "select * from class1 where id=?";
	            	 String sql2 = "delete from class1 where id=?";
	            	 ps1 = con.prepareStatement(sql1);
	            	 ps2 = con.prepareStatement(sql2);
	            	 id = Integer.parseInt(textField_1.getText());
	            	 ps1.setInt(1, id);
	            	 ps2.setInt(1, id);
	            	 rs = ps1.executeQuery();
	            	 
	            	 if (rs.next()) {
	                     str = rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3);
	                     textField.setText(str); // Display student details
	                     
	                 } else {
	                     textField.setText("No records found for ID: " + id);
	                 }
	            	 int res = ps2.executeUpdate();
	            	 JOptionPane.showMessageDialog(null, res+" Rows Deleted");
	            	 //textField_1.setText(str);
	            	 con.close();
	     			ps1.close();
	     			ps2.close();
	     			rs.close();
	     			textField_1.setText("");
	             }
	             catch(Exception e1) {
	            	 JOptionPane.showMessageDialog(null, "Something Worng");
	            	 //e1.printStackTrace();
	             }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(323, 187, 194, 59);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Deleted Details :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(26, 306, 238, 54);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 30));
		textField.setBounds(255, 306, 462, 97);
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
		btnNewButton_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(270, 482, 208, 54);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setBounds(179, 99, 186, 47);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
