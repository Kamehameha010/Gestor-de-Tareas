package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.TaskStatus;

public class TaskView extends JInternalFrame {
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
					TaskView frame = new TaskView();
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
	public TaskView() {
		setBounds(100, 100, 510, 420);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(82, 334, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(31, 88, 179, 23);
		getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("Task name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 62, 89, 29);
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
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(319, 334, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
}
