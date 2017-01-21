import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;
public class FeedDetails {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnAdd;
	private JTable table;
	String data;
	JPanel tablepan;
	ArrayList<String> list;
	String column[]={"id,name,Quantity"};
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedDetails window = new FeedDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FeedDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FeedDetails.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		frame.setTitle("ListProduct");
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		frame.setBounds(100, 100, 575, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Item NO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 56, 107, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Product Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(10, 87, 107, 20);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblName);
		
		JLabel lblClass = new JLabel("Quantity");
		lblClass.setForeground(Color.WHITE);
		lblClass.setBounds(10, 118, 86, 20);
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblClass);
		
		textField = new JTextField();
		textField.setBounds(136, 59, 86, 20);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setBackground(Color.white);
			}
		});
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 90, 86, 20);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setBackground(Color.white);
			}
		});
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(136, 121, 86, 20);
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setBackground(Color.white);
			}
		});
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ev) {
				if(ev.getKeyCode()==KeyEvent.VK_ENTER)
				{
					btnAdd.doClick();
				}
			}
		});
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		 btnAdd = new JButton("Add");
		 btnAdd.setBounds(10, 203, 107, 37);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
					System.out.println("check");
					String id=textField.getText();
					String name=textField_1.getText();
					String quantity=textField_2.getText();
					if(id.equals("")&&name.equals("")&&quantity.equals(""))
					{
						textField.setBackground(Color.RED);
						textField_1.setBackground(Color.RED);
						textField_2.setBackground(Color.RED);
					}
					else if(id.equals(""))
					{
						textField.setBackground(Color.RED);
					}
					else if(name.equals(""))
					{
						textField_1.setBackground(Color.RED);
					}
					else if(quantity.equals(""))
					{
						textField_2.setBackground(Color.RED);
					}
					else{
						list=new ArrayList<String>();
						list.add(id);
						list.add(name);
						list.add(quantity);
						Iterator<String> itr=list.iterator();
						while(itr.hasNext())
						{
							System.out.print("\t"+itr.next());
						}
							DefaultTableModel model=(DefaultTableModel) table.getModel();
							Object rowData[]=new Object[3];
						for(int i=0;i<list.size();i++)
						{
							rowData[0]=list.get(0);
							rowData[1]=list.get(1);
							rowData[2]=list.get(2);
						}	
							model.addRow(rowData);
							
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
					}	
			}
		});
		btnAdd.setIcon(new ImageIcon(FeedDetails.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		frame.getContentPane().add(btnAdd);
		
		JButton printbtn = new JButton("");
		printbtn.setBounds(126, 203, 96, 37);
		printbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MessageFormat header=new MessageFormat("Report");
				MessageFormat footer=new MessageFormat("page{0,number,integer}");
				try {
					
				table.print(JTable.PrintMode.NORMAL,header,footer);
					Graphics g=(Graphics)tablepan.getGraphics();
					tablepan.print(g);
//					PrintClass p=new PrintClass();
//					p.printWork();
//					
					
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		});
		printbtn.setIcon(new ImageIcon("C:\\Users\\sandeep\\Downloads\\print_button.gif"));
		frame.getContentPane().add(printbtn);
		
		tablepan = new JPanel();
		tablepan.setBounds(232, 31, 317, 261);
		frame.getContentPane().add(tablepan);
		tablepan.setLayout(null);
		
		JLabel lblSandeep = new JLabel("Sandeep Technology");
		lblSandeep.setBounds(10, 10, 187, 14);
		tablepan.add(lblSandeep);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
		scrollPane.setBounds(10, 35, 297, 226);
		tablepan.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int i=table.getSelectedRow();
				System.out.println("click : "+i);
				textField.setText(model.getValueAt(i,0).toString());
				textField_1.setText(model.getValueAt(i,1).toString());
				textField_2.setText(model.getValueAt(i, 2).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setForeground(new Color(0, 0, 255));
		table.setEnabled(false);
		table.setBackground(new Color(255, 250, 240));
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item No", "Product name", "Quantity"
			}
		));
		
				table.setColumnSelectionAllowed(false);
				table.setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
				
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 559, 21);
				frame.getContentPane().add(menuBar);
				
				JMenu mnFile = new JMenu("File");
				menuBar.add(mnFile);
				
				JMenuItem mntmPrint = new JMenuItem("Print");
				mntmPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						printbtn.doClick();
						
					}
				});
				mnFile.add(mntmPrint);
				
				JMenuItem mntmImportInExcle = new JMenuItem("import in excle");
				mntmImportInExcle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser jFileChooser=new JFileChooser();
						if(jFileChooser.showSaveDialog(frame)==JFileChooser.APPROVE_OPTION)
						{
							String withExtension=jFileChooser.getSelectedFile().getAbsolutePath() +".xls";
							File saveFile=new File(withExtension);
							try {
								ExcelExporter excelExporter=new ExcelExporter();
								excelExporter.exportTable(table,saveFile);						
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				mnFile.add(mntmImportInExcle);
				
				JMenu mnExit_1 = new JMenu("Exit");
				menuBar.add(mnExit_1);
				
				JMenuItem mntmExit = new JMenuItem("exit");
				mntmExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						frame.dispose();
					}
				});
				mnExit_1.add(mntmExit);
	}
}
