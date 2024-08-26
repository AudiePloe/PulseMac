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
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

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
		splitPane_1.setResizeWeight(0.1);
		
		JLabel projectDateLabel = new JLabel("Date:");
		splitPane_1.setLeftComponent(projectDateLabel);
		
		JLabel projectDateField = new JLabel("00/00/0000");
		projectDateField.setHorizontalAlignment(SwingConstants.LEFT);
		splitPane_1.setRightComponent(projectDateField);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel descPanel = new JPanel();
		descPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(splitPane_2, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(projectNameLabel, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(descPanel, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
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
					.addComponent(descPanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(splitPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47))
		);
		
		JLabel projectDescriptionLabel = new JLabel("Description");
		projectDescriptionLabel.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_descPanel = new GroupLayout(descPanel);
		gl_descPanel.setHorizontalGroup(
			gl_descPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_descPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(projectDescriptionLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_descPanel.setVerticalGroup(
			gl_descPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_descPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(projectDescriptionLabel, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
					.addContainerGap())
		);
		descPanel.setLayout(gl_descPanel);
		
		JButton projectEditButton = new JButton("Edit Project");
		splitPane_2.setLeftComponent(projectEditButton);
		
		JButton projectBuildButton = new JButton("Build Project");
		splitPane_2.setRightComponent(projectBuildButton);
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
					node_1 = new DefaultMutableTreeNode("Flozone");
						node_1.add(new DefaultMutableTreeNode("Standard"));
						node_1.add(new DefaultMutableTreeNode("3rd Party"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("L&S Proline");
						node_1.add(new DefaultMutableTreeNode("4 Battery UPS"));
						node_1.add(new DefaultMutableTreeNode("6 Battery UPS"));
						node_1.add(new DefaultMutableTreeNode("RTU"));
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
