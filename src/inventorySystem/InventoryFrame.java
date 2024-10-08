package inventorySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToolBar;
import javax.swing.JMenu;

public class InventoryFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable inventoryTable;
	public JTextField linkTextField;
	public JTextPane descriptionText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryFrame frame = new InventoryFrame();
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
	public InventoryFrame() {
		setTitle("Inventory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 578);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		mnNewMenu.add(menuItemSave);
		menuItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIManager.t.unloadFromTable();
			}
		});
		
		JMenuItem menuItemSaveAndExit = new JMenuItem("Save and exit");
		mnNewMenu.add(menuItemSaveAndExit);
		
		JMenuItem menuItemBackToMain = new JMenuItem("Back to Main Menu");
		mnNewMenu.add(menuItemBackToMain);
		menuItemBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIManager.t.goToMainMenu();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JLabel inventoryTitleText = new JLabel("Inventory");
		inventoryTitleText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inventoryTitleText.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(inventoryTitleText);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.65);
		splitPane_1.setOneTouchExpandable(true);
	
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		
		inventoryTable = new JTable();
		inventoryTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Name", "Part Number", "Quantity", "KeyWord"
			}
		));
		scrollPane.setViewportView(inventoryTable);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		
		descriptionText = new JTextPane();
		descriptionText.setEditable(false);
		descriptionText.setText("Insert description here");
		
		JLabel descLabel = new JLabel("Description");
		descLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel linkLabel = new JLabel("Link");
		linkLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		linkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		linkTextField = new JTextField();
		linkTextField.setEditable(false);
		linkTextField.setText("Insert link here");
		linkTextField.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(descriptionText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
						.addComponent(descLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
						.addComponent(linkLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
						.addComponent(linkTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(descLabel)
					.addGap(10)
					.addComponent(descriptionText, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(linkLabel)
					.addGap(10)
					.addComponent(linkTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(177))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(1)
					.addComponent(splitPane_1))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(1)
					.addComponent(splitPane_1))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
