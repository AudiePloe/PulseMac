package inventorySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;

public class projectInventoryFrame extends JFrame {

	private JPanel contentPane;
	private JTable inventoryTable;
	private JTextField txtInsertLinkHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projectInventoryFrame frame = new projectInventoryFrame();
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
	public projectInventoryFrame() {
		setTitle("Project name here");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 489);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		mnNewMenu.add(menuItemSave);
		
		JMenuItem mennuItemSaveAndExit = new JMenuItem("Save and Exit");
		mnNewMenu.add(mennuItemSaveAndExit);
		
		JMenuItem menuItemBackToMain = new JMenuItem("Back to Main Menu");
		mnNewMenu.add(menuItemBackToMain);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOneTouchExpandable(true);
		splitPane_1.setResizeWeight(0.5);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		
		JLabel descLabel = new JLabel("Description");
		descLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextPane txtpnInsertDescriptionHere = new JTextPane();
		txtpnInsertDescriptionHere.setText("Insert description here");
		txtpnInsertDescriptionHere.setToolTipText("");
		
		JLabel linkLabel = new JLabel("Link");
		linkLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		linkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtInsertLinkHere = new JTextField();
		txtInsertLinkHere.setText("Insert link here");
		txtInsertLinkHere.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(linkLabel, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addComponent(txtpnInsertDescriptionHere, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addComponent(descLabel, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
						.addComponent(txtInsertLinkHere, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(descLabel)
					.addGap(18)
					.addComponent(txtpnInsertDescriptionHere, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(linkLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtInsertLinkHere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		
		inventoryTable = new JTable();
		inventoryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Part Number", "Quantity"
			}
		));
		scrollPane.setViewportView(inventoryTable);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(splitPane_1, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(splitPane_1, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel projectTitleText = new JLabel("Project List");
		projectTitleText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		projectTitleText.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(projectTitleText);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(splitPane))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(splitPane)
					.addGap(10))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
