package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import controller.TaskController;
import model.Actions;
import model.Task;
import view.customer.TaskTable;

public class TaskListView extends JInternalFrame {
	private JTable table;
	private TaskTable taskTableModel;
	private TaskController controller;
	private int m_idUser;

	public TaskListView(int idUser) {
		m_idUser = idUser;
		controller = new TaskController();
		initComponents();
		setTableModel();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {

		setBounds(100, 100, 537, 357);
		getContentPane().setLayout(null);

		JButton btnNewTask = new JButton("New Task");
		btnNewTask.setBounds(20, 34, 95, 23);

		btnNewTask.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				var form = new TaskView(m_idUser, Actions.INSERT);
				form.toFront();
				form.setVisible(true);
				;
			}

		});
		getContentPane().add(btnNewTask);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(232, 34, 129, 20);
		getContentPane().add(textPane);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(371, 34, 89, 23);
		getContentPane().add(btnSearch);

		table = new JTable();
		table.setBounds(38, 109, 422, 182);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null } },
				new String[] { "Id", "Name", "Description", "Date", "Completed" }));

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int pos = table.getSelectedRow();
				Task task;
				try {
					task = taskTableModel.getRowTask(pos);
					var form = new TaskView(task, Actions.EDIT);
					form.toFront();
					form.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Datos erroneos");
				}
			}
		});

		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(table);
		scrollPanel.setBounds(38, 109, 422, 182);
		getContentPane().add(scrollPanel);

	}

	public void setTableModel() {
		try {
			taskTableModel = new TaskTable(controller.GetAll(m_idUser));
			table.setModel(taskTableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void loadTable() {
		table.setModel(taskTableModel);
	}
}
