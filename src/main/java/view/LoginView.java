package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;
import model.viewmodel.UserViewModel;
import services.security.AuthService;
import view.FieldValidation.InputText;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPasword;
	private AuthService auth;
	private InputText isTextValidity;

	private UserView signUp;

	/**
	 * Create the frame.
	 */

	public LoginView() {
		isTextValidity = new InputText();
		initComponents();
	}

	public LoginView(UserView viewRef) {
		signUp = viewRef;
		isTextValidity = new InputText();
		initComponents();
	}

	public void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(85, 79, 243, 30);
		txtUser.setInputVerifier(isTextValidity);
		panel.add(txtUser);

		txtPasword = new JPasswordField();
		txtPasword.setBounds(85, 143, 243, 30);
		txtPasword.setInputVerifier(isTextValidity);
		panel.add(txtPasword);

		JButton btnSignIn = new JButton("sign in");
		btnSignIn.setForeground(new Color(51, 51, 51));
		btnSignIn.setBackground(new Color(51, 153, 255));
		btnSignIn.setBounds(164, 207, 89, 23);
		btnSignIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				var user = new UserViewModel(txtUser.getText().trim(), new String(txtPasword.getPassword()).trim());
				
				auth = new AuthService();
				try {
					var result = auth.isUserValid(user);
					
					if (result != null) {
						MainView mainWindow = new MainView(result);
						mainWindow.setVisible(true);
						dispose();
					}
				} catch (Exception e) {

					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Verify User or password", "Sign In", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnSignIn);

		JButton btnSignUp = new JButton("sign up");
		btnSignUp.setForeground(new Color(255, 51, 51));
		btnSignUp.setBackground(new Color(255, 153, 255));
		btnSignUp.setBounds(164, 237, 89, 23);

		btnSignUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				if (signUp == null) {
					signUp = new UserView();
					signUp.setVisible(true);
					dispose();

				}
			}
		});
		panel.add(btnSignUp);
	}

}
