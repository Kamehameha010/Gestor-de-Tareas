package com.cr.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.cr.Services.security.AuthServiceMysql;
import com.cr.Services.security.IAuthService;
import com.cr.model.viewmodel.UserViewModel;
import com.cr.view.FieldValidation.InputText;

public class LoginView extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPasword;
	private IAuthService auth;
	private InputText isTextValidity;

	private UserView signUp = null;

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
		txtUser.setText("jlop02");
		txtUser.setInputVerifier(isTextValidity);
		panel.add(txtUser);

		txtPasword = new JPasswordField();
		txtPasword.setBounds(85, 143, 243, 30);
		txtPasword.setText("1234");
		txtPasword.setInputVerifier(isTextValidity);
		panel.add(txtPasword);

		JButton btnSignIn = new JButton("sign in");
		btnSignIn.setForeground(new Color(51, 51, 51));
		btnSignIn.setBackground(new Color(51, 153, 255));
		btnSignIn.setBounds(164, 207, 89, 23);
		btnSignIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				var user = new UserViewModel(txtUser.getText().trim(), new String(txtPasword.getPassword()).trim());

				auth = new AuthServiceMysql();

				var result = auth.isUserValid(user);

				if (result != null) {

					MainView mainWindow = new MainView(result);
					mainWindow.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Verify User or password", "Sign In",
							JOptionPane.ERROR_MESSAGE);
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

					var prop = new Properties();
					prop.setProperty("key", "value");
					try {
						prop.store(new FileWriter("file.propieties"), "Propiedades");
					} catch (IOException e) {
						e.printStackTrace();
					}
					signUp = new UserView();
					signUp.setVisible(true);
					dispose();
				}
			}
		});
		panel.add(btnSignUp);
	}

}
