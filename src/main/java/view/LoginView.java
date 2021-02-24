package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;

    public LoginView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        this.setBounds(100, 100, 465, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(109, 120, 244, 27);
        this.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(109, 169, 244, 27);
        this.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(109, 249, 89, 23);
        this.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(264, 249, 89, 23);
        this.getContentPane().add(btnNewButton_1);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(-59, 29, 32, 32);
        this.getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setBounds(50, 169, 46, 27);
        lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/resource/img/lock.png")));
        this.getContentPane().add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("New label");

        lblNewLabel_2.setBounds(165, 11, 89, 72);
        this.getContentPane().add(lblNewLabel_2);

        System.out.println(LoginView.class.getResource("/resource/img/lock.png"));
    }
}
