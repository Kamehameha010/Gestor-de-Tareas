package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Actions;
import model.User;

public class MainView extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	
	private JPanel contentPane;
	private User _user;

	/**
	 * Create the frame.
	 */

	public MainView() {
		initComponents();
	}

	public MainView(User user) {

		_user = user;;
		initComponents();
	}

	public void initComponents() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				LoginView sign = new LoginView(null);
				sign.setVisible(true);
			}
		});

		setBounds(100, 100, 783, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.YELLOW);
		desktopPane.setBounds(0, 0, 783, 600);
		contentPane.add(desktopPane);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Export");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CSV");
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("PDF");
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu menuItemExit = new JMenu("Exit");

		mnNewMenu.add(menuItemExit);

		JMenu mnNewMenu_2 = new JMenu("Module");
		menuBar.add(mnNewMenu_2);

		JMenuItem menuItemTask = new JMenuItem("Task");
		menuItemTask.addActionListener(new ActionListener() {
			// pending
			@Override
			public void actionPerformed(ActionEvent e) {
				var task = new TaskView(_user.getId(), Actions.INSERT);
				desktopPane.add(task);
				task.show();
			}
		});
		mnNewMenu_2.add(menuItemTask);

		JMenuItem menuItemProfile = new JMenuItem("Profile");
		menuItemProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				var profile = new ProfileView(_user);
				desktopPane.add(profile);
				profile.show();
				profile.setIconifiable(true);
			}

		});

		mnNewMenu_2.add(menuItemProfile);

		JMenu mnNewMenu_3 = new JMenu("Help");
		menuBar.add(mnNewMenu_3);

	}
}
