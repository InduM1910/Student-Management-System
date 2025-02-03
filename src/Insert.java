import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Insert extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	PreparedStatement pst = null;
	int id;
	String name;
	int marks;
	public Insert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data Insertion");
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(281, 22, 334, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(96, 130, 142, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(96, 217, 196, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Marks :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(96, 312, 196, 36);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField.setBounds(281, 132, 191, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_1.setBounds(281, 217, 343, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_2.setBounds(302, 313, 170, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// loading driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// Establish connection
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root & password=root");
					String sql = "insert into class1 values(?,?,?)";
					
					//Creating preparedstatement medium
					pst = con.prepareStatement(sql);
					 id = Integer.parseInt(textField.getText());
					 name = textField_1.getText();
					 marks = Integer.parseInt(textField_2.getText());
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, marks);
					
					//query
					int res = pst.executeUpdate();
		JOptionPane.showMessageDialog(null, res+" Rows Inserted");
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Someting Wrong");
				}
				finally {
					try {
						// close resoures
						con.close();
						pst.close();
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(133, 421, 170, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(582, 421, 148, 57);
		contentPane.add(btnNewButton_1);
	}

}
