package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controller.TaskController;
import model.Actions;
import model.Task;
import model.TaskStatus;
import view.fieldValidation.InputText;

public class TaskView extends JInternalFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final int INSERT = 0;
	private static final int EDIT = 1;

	private JTextField txtName;
	private JTextField txtDescription;
	private JDateChooser dfCalendar;
	private InputText isTextValidity;
	private TaskController controller;
	private int m_idUser;
	private Actions m_action;

	public TaskView(int idUser, Actions action) {
		m_idUser = idUser;
		m_action = action;
		isTextValidity = new InputText();
		controller = new TaskController();
		initComponents();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setBounds(100, 100, 510, 420);
		getContentPane().setLayout(null);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(31, 88, 179, 23);
		txtName.setInputVerifier(isTextValidity);
		getContentPane().add(txtName);

		JLabel lblNewLabel = new JLabel("Task name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 61, 89, 29);
		getContentPane().add(lblNewLabel);

		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(31, 155, 179, 23);
		txtDescription.setInputVerifier(isTextValidity);
		getContentPane().add(txtDescription);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setBounds(31, 129, 89, 29);
		getContentPane().add(lblDescription);

		dfCalendar = new JDateChooser();
		dfCalendar.setBounds(31, 215, 179, 23);
		getContentPane().add(dfCalendar);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(31, 189, 89, 29);
		getContentPane().add(lblDate);

		JLabel lblIsCompleted = new JLabel("Status:");
		lblIsCompleted.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsCompleted.setBounds(31, 249, 92, 29);
		getContentPane().add(lblIsCompleted);

		JComboBox<TaskStatus> cbStatus = new JComboBox<>();
		cbStatus.setModel(new DefaultComboBoxModel(TaskStatus.values()));
		cbStatus.setBounds(31, 278, 179, 23);
		getContentPane().add(cbStatus);

		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(51, 153, 255));
		btnSave.setBounds(31, 334, 75, 23);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				var task = new Task(m_idUser, txtName.getText(), txtDescription.getText(), getTime(dfCalendar),
						getStatus(cbStatus));

				try {
					if(m_action == Actions.INSERT) controller.create(task);
					if(m_action == Actions.EDIT) controller.edit(task);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});
		getContentPane().add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c
			}
		});
		btnCancel.setBounds(135, 334, 75, 23);
		getContentPane().add(btnCancel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(278, 89, 167, 212);
		getContentPane().add(panel);

	}

	private long getTime(JDateChooser comp) {
		return comp != null ? comp.getDate().getTime() : null;
	}

	private TaskStatus getStatus(JComboBox comp) {
		return TaskStatus.valueOf(comp.getSelectedIndex());
	}
}
