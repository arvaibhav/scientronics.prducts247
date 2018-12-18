package Main;

import java.awt.Color;
import marksandspencer.com.*;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
public class site1panel   {
	JPanel panel=new JPanel();
	 public static JTable table;
	public static  DefaultTableModel  model;
	    JLabel lbldate;
	    public static JCheckBox chkstage1;
		public static JCheckBox chkstage2;
	    public static boolean headless=true;
	   public static JButton btnStart;
	public   static JProgressBar pbar1;
	public	   static JProgressBar pbar2;
	public   static JProgressBar pbar3;
	public static JLabel lblstatus;
	public static JCheckBox chkHeadless;
	/**
	 * Create the panel.
	 */
	public site1panel() {
		
		panel.setToolTipText("");
		panel.setBackground(Color.LIGHT_GRAY);

		panel.setSize(1065, 720);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("marksandspencer");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(430, 7, 228, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel);
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 38, 988, 12);
		panel.add(separator);
		
		JLabel lblStage = new JLabel("Stage 1:");
		lblStage.setToolTipText("");
		lblStage.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage.setBounds(28, 48, 59, 20);
		panel.add(lblStage);
		
		  chkstage1 = new JCheckBox("Use Previous");
		chkstage1.setOpaque(false);
		chkstage1.setSelected(true);
		chkstage1.setBounds(91, 48, 128, 23);
		panel.add(chkstage1);
		
		pbar1 = new JProgressBar();
		pbar1.setStringPainted(true);
		pbar1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pbar1.setForeground(new Color(0, 100, 0));
		pbar1.setBounds(28, 79, 988, 20);
		panel.add(pbar1);
		
		JLabel lblStage_1 = new JLabel("Stage 2:");
		lblStage_1.setToolTipText("");
		lblStage_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage_1.setBounds(28, 111, 59, 20);
		panel.add(lblStage_1);
		
		  chkstage2 = new JCheckBox("Use Previous");
		chkstage2.setSelected(true);
		chkstage2.setBounds(91, 111, 128, 23);
		panel.add(chkstage2);
		chkstage2.setOpaque(false);
		pbar2 = new JProgressBar();
		pbar2.setStringPainted(true);
		pbar2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pbar2.setForeground(new Color(34, 139, 34));
		pbar2.setBounds(28, 142, 988, 20);
		panel.add(pbar2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 169, 988, 2);
		panel.add(separator_1);
		
		JLabel lblStage_2 = new JLabel("Stage 3:");
		lblStage_2.setToolTipText("");
		lblStage_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage_2.setBounds(502, 180, 59, 20);
		panel.add(lblStage_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 1045, 448);
		panel.add(scrollPane);
		//Title	URL	Collection	Model/EAN/SKU	Type	Category	Sub Category (if Any)	Price	Color	Size	StyleDescriptions	Img1	Img2	Img3	Img4

		    model=new DefaultTableModel(new Object[] {"Sno.","Title","URL","Collection","Model/EAN/SKU","Type","Category","Sub Category","Price","Color","Size","StyleDescriptions","Img1","Img2","Img3","Img4"}, 0){
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			} ;
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		table.getColumnModel().getColumn(10).setPreferredWidth(90);
		table.getColumnModel().getColumn(11).setPreferredWidth(90);
		DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
	    rendar1.setForeground(Color.blue);
	    table.getColumnModel().getColumn(6).setCellRenderer(rendar1);
		
		  btnStart = new JButton("Start");
		
		btnStart.setBounds(966, 685, 89, 30);
		panel.add(btnStart);
		
		pbar3 = new JProgressBar();
		pbar3.setStringPainted(true);
		pbar3.setForeground(new Color(154, 205, 50));
		pbar3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pbar3.setBounds(10, 662, 1045, 20);
		panel.add(pbar3);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 685, 51, 24);
		panel.add(lblDate);
		
		  lbldate = new JLabel("");
		lbldate.setForeground(new Color(255, 0, 0));
		lbldate.setBounds(40, 685, 128, 24);
		panel.add(lbldate);
		
		  chkHeadless = new JCheckBox("Headless");
		chkHeadless.setSelected(true);
		chkHeadless.setBounds(809, 689, 148, 23);
		panel.add(chkHeadless);
		
		JButton btnNewButton = new JButton("Generate current CSV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Thread w=new Thread(new Runnable() {
					
					@Override
					public void run() {
						ArrayList<data> tempd=data.datas;
						lblstatus.setText("saving");
						tempd.sort((o1, o2) -> Integer.compare(o1.key, o2.key));
						try {
							Stage3.createCSV(UI.tdydate+"_current", tempd);
							lblstatus.setText("saved in current");
						} catch (IOException e) {
							
							lblstatus.setText("try again");
						}
					}
				});w.start();
			}
		});
		btnNewButton.setBounds(188, 685, 219, 30);
		panel.add(btnNewButton);
		
		  lblstatus = new JLabel("");
		lblstatus.setForeground(Color.BLUE);
		lblstatus.setBounds(417, 693, 190, 14);
		panel.add(lblstatus);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(site1panel.class.getResource("/img/Hd7S83Q.png")));
		lblNewLabel_1.setBounds(0, 0, 1065, 720);
		panel.add(lblNewLabel_1);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Thread w = new Thread() {
					 	
					public void run() {
					
						pbar1.setValue(0);pbar2.setValue(0);pbar3.setValue(0);
						model.setRowCount(0);
						btnStart.setEnabled(false);
						urldata.urldatas.clear();urldata.urldatas2.clear();
						data.datas.clear();
						if(chkHeadless.isSelected())headless=true;else headless=false;
							if(chkstage1.isSelected())
							caturl.chkstage1();
							else caturl.pass();
							
							if(chkstage2.isSelected())
							caturl.chkstage2();
							else caturl.pass_stage2();
							site1panel.chkstage1.setEnabled(false);site1panel.chkHeadless.setEnabled(false);
							site1panel.chkstage2.setEnabled(false);

					}
				};
				w.start();
			}
		});
		chkHeadless.setOpaque(false);
	}
}
