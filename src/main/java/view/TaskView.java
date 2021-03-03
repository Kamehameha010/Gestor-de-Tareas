package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.TaskStatus;

public class TaskView extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Create the frame.
	 */
	public TaskView() {
		setBounds(100, 100, 510, 420);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(51, 153, 255));
		btnNewButton.setBounds(31, 334, 75, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(31, 88, 179, 23);
		getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("Task name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 61, 89, 29);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(31, 155, 179, 23);
		getContentPane().add(textField_1);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setBounds(31, 129, 89, 29);
		getContentPane().add(lblDescription);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(31, 215, 179, 23);
		getContentPane().add(textField_2);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(31, 189, 89, 29);
		getContentPane().add(lblDate);
		
		JLabel lblIsCompleted = new JLabel("Status:");
		lblIsCompleted.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsCompleted.setBounds(31, 249, 92, 29);
		getContentPane().add(lblIsCompleted);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TaskStatus.values()));
		comboBox.setBounds(31, 278, 179, 23);
		getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(135, 334, 75, 23);
		getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(278, 89, 167, 212);
		getContentPane().add(panel);

	}
}
