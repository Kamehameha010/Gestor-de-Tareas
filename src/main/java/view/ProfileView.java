package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;

public class ProfileView extends JInternalFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private User _user;


	public ProfileView(User user){
		_user = user;
		initComponents();
	}
	/**
	 * Create the frame.
	 */
	public void initComponents() {
		
		setBounds(100, 100, 472, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(24, 36, 229, 30);
		txtName.setText(_user.getName());
		contentPane.add(txtName);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastname.setBounds(24, 77, 229, 14);
		contentPane.add(lblLastname);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(24, 102, 229, 30);
		txtLastName.setText(_user.getLastName());
		contentPane.add(txtLastName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(24, 139, 152, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(24, 164, 229, 30);
		txtUsername.setText(_user.getUsername());
		contentPane.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(24, 205, 178, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(24, 219, 229, 30);
		contentPane.add(txtPassword);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(225, 283, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(324, 283, 89, 23);
		contentPane.add(btnCancel);
	}

}
