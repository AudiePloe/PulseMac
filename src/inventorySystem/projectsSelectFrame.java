package inventorySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class projectsSelectFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projectsSelectFrame frame = new projectsSelectFrame();
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
	public projectsSelectFrame() {
		setTitle("Project Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(1.0);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JLabel projectNameLabel = new JLabel("Project Name");
		projectNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		projectNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		
		JSplitPane splitPane_1_1 = new JSplitPane();
		splitPane_1_1.setResizeWeight(0.5);
		
		JLabel projectPartsLabel = new JLabel("Parts");
		splitPane_1_1.setLeftComponent(projectPartsLabel);
		
		JLabel projectPartsField = new JLabel("123");
		splitPane_1_1.setRightComponent(projectPartsField);
		
		JLabel projectDateLabel = new JLabel("Date");
		splitPane_1.setLeftComponent(projectDateLabel);
		
		JLabel projectDateField = new JLabel("05/25/2000");
		splitPane_1.setRightComponent(projectDateField);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(projectNameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
						.addComponent(splitPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
						.addComponent(splitPane_1_1))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(projectNameLabel)
					.addGap(78)
					.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(splitPane_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(196))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Projects") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("PulseMac");
						node_1.add(new DefaultMutableTreeNode("Pond 2.0"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("L&S Proline");
						node_1.add(new DefaultMutableTreeNode("4B UPS"));
						node_1.add(new DefaultMutableTreeNode("6B UPS"));
						node_1.add(new DefaultMutableTreeNode("RTU"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("EOG");
						node_1.add(new DefaultMutableTreeNode("Rock"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Flozone");
						node_1.add(new DefaultMutableTreeNode("Standard"));
						node_1.add(new DefaultMutableTreeNode("3rd Party"));
					add(node_1);
				}
			}
		));
		scrollPane.setViewportView(tree);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
					.addGap(10))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
