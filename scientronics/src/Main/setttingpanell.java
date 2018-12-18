package Main;

import java.awt.Color;
import marksandspencer.com.*;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;


import Tool.ExcelReader;
import Tool.comparetool1;
import aceuae.Main2;
import aceuae.More;
import aceuae.datastorage;
import aceuae.makeThreads4;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
public class setttingpanell   {
	JPanel panel=new JPanel();
	public static  DefaultTableModel  model;
	    public static boolean headless=true;
	   public static JButton btnSave;
	public static JLabel status;
	public static String base;	boolean once = true;
	private JTextField txtbase;
	private JTable table;
 

	
	
	
public static ArrayList<settingsdata>rules=new ArrayList<>(56);
private JTextField txtfrom;
private JTextField txtto;
private JTextField txtfactor;
	/**
	 * Create the panel.
	 */
	public static String readfile(String rootfolder, JTextField root) throws IOException {
		String current = System.getProperty("user.dir");
		current = current + "\\data\\folderdata.txt";
		File f = new File(current);
		if (!f.exists()) {
			writefile((System.getProperty("user.dir") + "\\Compare_output"), rootfolder, root);
		}

		ArrayList<String> da = (ArrayList<String>) IOUtils.readLines(new FileInputStream(current));

		rootfolder = da.get(0);
		f = new File(rootfolder);
		try {
			f.mkdir();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (!f.exists()) {
			writefile((System.getProperty("user.dir") + "\\Compare_output"), rootfolder, root);

			da = (ArrayList<String>) IOUtils.readLines(new FileInputStream(current));
		}
		System.out.println(da.get(0));
		root.setText(da.get(0));
		rootfolder = da.get(0);
		return da.get(0);

	}

	public static void writefile(String string, String rootfolder, JTextField root) {
		root.setText(string);
		rootfolder = string;
		File f = new File(System.getProperty("user.dir") + "\\data");
		f.mkdirs();
		try {
			FileUtils.writeStringToFile(new File(f.getAbsolutePath() + "\\folderdata.txt"), string, false);
		} catch (IOException e) {
e.printStackTrace();
			 
		}

	}
	public setttingpanell() {
		
		panel.setToolTipText("");
		panel.setBackground(Color.LIGHT_GRAY);

		panel.setSize(1065, 720);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("SETTINGS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(450, 9, 228, 29);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblNewLabel);
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 38, 988, 12);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 115, 988, 2);
		panel.add(separator_1);
		//Title	URL	Collection	Model/EAN/SKU	Type	Category	Sub Category (if Any)	Price	Color	Size	StyleDescriptions	Img1	Img2	Img3	Img4

		    model=new DefaultTableModel(new Object[] {
		    		"	S.no	".trim()	,
		    		"	Category	".trim()	,
		    		"	Sub-category	".trim()	,
		    		"	Sub-sub-category	".trim()	,
		    		"	tag1	".trim()	,
		    		"	tag2	".trim()	,
		    		"	Brand name	".trim()	,
		    		"	Product name	".trim()	,
		    		"	Price	".trim()	,
		    		"	Old price	".trim()	,
		    		"	SKU	".trim()	,
		    		"	stock	".trim()	,
		    		"	Description	".trim()	,
		    		"	Keypoints	".trim()	,
		    		"	Specification	".trim()	,
		    		"	Weight	".trim()	,
		    		"	imageurl	".trim()	,
		    		"	URL	".trim()	,
		    		"	Description (Tag)	".trim()	 

		    		
		    }, 0){
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			} ;
		DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
	    rendar1.setForeground(Color.blue);
		
		  btnSave = new JButton("Save");
		
		btnSave.setBounds(966, 685, 89, 30);
		panel.add(btnSave);
		  
		    status = new JLabel("");
		    status.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		    status.setForeground(Color.WHITE);
		    status.setBounds(462, 692, 486, 20);
		    panel.add(status);
		    
		    JButton btnbase = new JButton("Drive ");
		    btnbase.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {

					if (once) {
						System.out.println(base);
						Thread w = new Thread(new Runnable() {

							@Override
							public void run() {
								once = false;
								btnbase.setEnabled(false);
								JFileChooser fc = new JFileChooser();
								fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
								try {
									fc.setCurrentDirectory(new File(base.substring(0, base.lastIndexOf("\\")))); // start at
																													// application
																													// current
																													// directory
								} catch (Exception e) {
								}
								fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
								int returnVal = fc.showSaveDialog(fc);
								if (returnVal == JFileChooser.APPROVE_OPTION) {
									File yourFolder = fc.getSelectedFile();
									base = yourFolder.getAbsolutePath();
									setttingpanell.writefile(yourFolder.getAbsolutePath(), base, txtbase);
								} // TODO Auto-generated method stub
								btnbase.setEnabled(true);
								once = true;
							}
						});
						w.start();
					}
				
		    	}
		    });
		    btnbase.setFont(new Font("Times New Roman", Font.BOLD, 18));
		    btnbase.setBounds(23, 74, 122, 30);
		    panel.add(btnbase);
		    
		    txtbase = new JTextField();
		    txtbase.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		    txtbase.setBounds(158, 75, 858, 29);
		    panel.add(txtbase);
		    txtbase.setColumns(10);
		   
		    
		    JLabel lblNewLabel_1 = new JLabel("Change drive folder");
		    lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		    lblNewLabel_1.setForeground(Color.WHITE);
		    lblNewLabel_1.setBounds(28, 49, 291, 25);
		    panel.add(lblNewLabel_1);
		    
		    JScrollPane scrollPane = new JScrollPane();
		    scrollPane.setBounds(49, 186, 297, 180);
		    panel.add(scrollPane);
		      model=new DefaultTableModel(new Object[] {"S.no"," From "," To "," Factor "}, 0){
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			} ;
table = new JTable(model);
table.addKeyListener(new KeyAdapter() {
	@Override
	public void keyReleased(KeyEvent e) {
		if(table.getSelectedRow()>0)
		if(e.getKeyCode()==KeyEvent.VK_DELETE)
		{
		model.removeRow(table.getSelectedRow());
		rules.remove(table.getSelectedRow());
		for(int i=0;i<rules.size();i++)
		{
			model.setValueAt(i+1, i, 0);
			settingsdata.count-=1;
		}
		}
	
	}
});
 
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		 DefaultTableCellRenderer dsv = new DefaultTableCellRenderer();
	    dsv.setForeground(Color.blue);
	    table.getColumnModel().getColumn(3).setCellRenderer(dsv);
		    scrollPane.setViewportView(table);
		    
		    JButton btnNewButton = new JButton("Add");
		    btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		String from=txtfrom.getText().replaceAll("[^\\d.Ee]", "");
		    		String to=txtto.getText().replaceAll("[^\\d.Ee]", "");
		    		String factor=txtfactor.getText().replaceAll("[^\\d.Ee]", "");
		    		settingsdata.addrule(from, to, factor);
		    	}
		    });
		    btnNewButton.setBounds(23, 156, 66, 29);
		    panel.add(btnNewButton);
		    
		    JSeparator separator_2 = new JSeparator();
		    separator_2.setBounds(23, 377, 988, 2);
		    panel.add(separator_2);
		    
		    JLabel lblMultiplierRule = new JLabel("Multiplier rule");
		    lblMultiplierRule.setForeground(Color.WHITE);
		    lblMultiplierRule.setFont(new Font("Times New Roman", Font.BOLD, 18));
		    lblMultiplierRule.setBounds(28, 128, 291, 25);
		    panel.add(lblMultiplierRule);
		    
		    txtfrom = new JTextField();
		   
		    txtfrom.setBounds(96, 156, 74, 29);
		    panel.add(txtfrom);
		    txtfrom.setColumns(10);
		    
		    txtto = new JTextField();
		    txtto.setColumns(10);
		    txtto.setBounds(177, 156, 74, 29);
		    panel.add(txtto);
		    
		    txtfactor = new JTextField();
		    txtfactor.setColumns(10);
		    txtfactor.setBounds(260, 156, 74, 29);
		    panel.add(txtfactor);
		   
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Thread w = new Thread() {
					 	
					public void run() {
						btnSave.setEnabled(false);
					//-------------------------------------------------------------------------------------------------------------------------
					try {
						settingsdata.writerule(setttingpanell.rules);
					} catch (IOException e) { JOptionPane.showMessageDialog(null,e.getMessage());}
						
						btnSave.setEnabled(true);
					}
				};
				w.start();
			}
		});
Thread jj=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					base = readfile(base, txtbase);
				} catch (IOException e1) {
				}
				try {
					 settingsdata.readrule();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});jj.start();
	}
}
