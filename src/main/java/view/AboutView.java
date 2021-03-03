package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AboutView extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutView() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(180, 125, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Label About");
		lblNewLabel.setBounds(102, 21, 213, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Label About");
		lblNewLabel_1.setBounds(102, 46, 213, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Label About");
		lblNewLabel_2.setBounds(102, 71, 213, 14);
		add(lblNewLabel_2);
	}

}
