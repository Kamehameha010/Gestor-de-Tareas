package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import model.User;
import view.FieldValidation.InputText;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private InputText isTextValidity;
	private UserController controller;

	/**
	 * Create the frame.
	 */

	public UserView() {
		isTextValidity = new InputText();
		try {
			controller = new UserController();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initComponents();
	}

	public void initComponents() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 371);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				LoginView sign = new LoginView(null);
				sign.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 26, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastname.setBounds(50, 92, 229, 14);
		contentPane.add(lblLastname);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(50, 154, 152, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(50, 220, 178, 14);
		contentPane.add(lblPassword);

		txtName = new JTextField();
		txtName.setBounds(50, 51, 229, 30);
		txtName.setColumns(10);
		txtName.setInputVerifier(isTextValidity);
		contentPane.add(txtName);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(50, 117, 229, 30);
		txtLastName.setInputVerifier(isTextValidity);
		contentPane.add(txtLastName);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(50, 179, 229, 30);
		txtUsername.setInputVerifier(isTextValidity);
		contentPane.add(txtUsername);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(50, 234, 229, 30);
		txtPassword.setInputVerifier(isTextValidity);
		contentPane.add(txtPassword);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(251, 298, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setName(txtName.getText().trim());
				user.setLastName(txtLastName.getText().trim());
				user.setUsername(txtUsername.getText().trim());
				user.setPassword(new String(txtPassword.getPassword()).trim());
				try {
					controller.create(user);
					cleanInput(txtName, txtLastName, txtUsername, txtPassword);
					JOptionPane.showMessageDialog(null, "The user was registered ", "Save",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {

					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocurred an error", "Save", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnSubmit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(350, 298, 89, 23);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView sign = new LoginView(null);
				sign.setVisible(true);
				dispose();
			}

		});
		contentPane.add(btnCancel);

	}

	private void cleanInput(JTextField... fields) {

		for (var field : fields) {
			field.setText(null);
		}
	}
}
