package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

public class MainView extends JFrame {

	private JPanel contentPane;
	private User _user;

	/**
	 * Create the frame.
	 */

	public MainView() {

	}

	public MainView(User user) {
		_user = user;
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 435);

		

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
		mnNewMenu_2.add(menuItemTask);

		JMenuItem menuItemProfile = new JMenuItem("Perfil");
		
		mnNewMenu_2.add(menuItemProfile);

		JMenu mnNewMenu_3 = new JMenu("Help");
		menuBar.add(mnNewMenu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.YELLOW);
		desktopPane.setBounds(0, 0, 667, 374);
		contentPane.add(desktopPane);

		menuItemProfile.addActionListener(new ActionListener(){
			//pending
			@Override
			public void actionPerformed(ActionEvent e) {
				var winProfile = new LoginView();
				winProfile.setVisible(true);
				/* desktopPane.add(winProfile); */
			}
			
		} );
	}
}
