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
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;

import Tool.ExcelReader;
import Tool.comparetool1;
import aceuae.Info;
import aceuae.Main2;
import aceuae.More;
import aceuae.datastorage;
import aceuae.makeThreads4;
import aceuae.makeThreads6;
import aceuae.productsurls;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
public class site3panel   {
	JPanel panel=new JPanel();
	 public static JTable table;
	public static  DefaultTableModel  model;
	    JLabel lbldate;
	    public static JCheckBox chk1;
	    public static int count=1;
		public static JCheckBox chk2,chk3;
	    public static boolean headless=true;
	   public static JButton btnStart;
	public   static JProgressBar pbar1;
	public	   static JProgressBar pbar2;
	public   static JProgressBar pbar3;
	public static JLabel status;
	/**
	 * Create the panel.
	 */
	public site3panel() {
		
		panel.setToolTipText("");
		panel.setBackground(new Color(255, 102, 102));

		panel.setSize(1065, 720);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("ACEUAE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(450, 9, 228, 29);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblNewLabel);
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 38, 988, 12);
		panel.add(separator);
		
		JLabel lblStage = new JLabel("Stage 1(Remap categories,sub,tags):");
		lblStage.setForeground(Color.WHITE);
		lblStage.setToolTipText("");
		lblStage.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage.setBounds(28, 45, 332, 20);
		panel.add(lblStage);
		
		  chk1 = new JCheckBox("Use Previous");
		  chk1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		  chk1.setForeground(Color.WHITE);
		chk1.setOpaque(false);
		chk1.setSelected(true);
		chk1.setBounds(366, 45, 128, 23);
		panel.add(chk1);
		
		pbar1 = new JProgressBar();
		pbar1.setStringPainted(true);
		pbar1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pbar1.setForeground(new Color(0, 100, 0));
		pbar1.setBounds(28, 79, 988, 20);
		panel.add(pbar1);
		
		JLabel lblStage_1 = new JLabel("Stage 2:(Get products url and generate compare sheet)");
		lblStage_1.setForeground(Color.WHITE);
		lblStage_1.setToolTipText("");
		lblStage_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage_1.setBounds(28, 108, 332, 20);
		panel.add(lblStage_1);
		
		  chk2 = new JCheckBox("Use Previous");
		  chk2.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		  chk2.setForeground(Color.WHITE);
		chk2.setBounds(366, 108, 128, 23);
		panel.add(chk2);
		chk2.setOpaque(false);
		pbar2 = new JProgressBar();
		pbar2.setStringPainted(true);
		pbar2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pbar2.setForeground(new Color(34, 139, 34));
		pbar2.setBounds(28, 142, 988, 20);
		panel.add(pbar2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 169, 988, 2);
		panel.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 1045, 448);
		panel.add(scrollPane);
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
		    		"	Description (TEXT)	".trim()	 

		    		
		    }, 0){
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
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(10, 685, 51, 24);
		panel.add(lblDate);
		
		  lbldate = new JLabel("");
		  lbldate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbldate.setForeground(Color.WHITE);
		lbldate.setBounds(40, 685, 128, 24);
		panel.add(lbldate);
		  
		  JLabel lblStagegetProduct = new JLabel("Stage 3:(get product information)");
		  lblStagegetProduct.setForeground(Color.WHITE);
		  lblStagegetProduct.setToolTipText("");
		  lblStagegetProduct.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  lblStagegetProduct.setBounds(28, 180, 332, 20);
		  panel.add(lblStagegetProduct);
		  
		    status = new JLabel("");
		    status.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		    status.setForeground(Color.WHITE);
		    status.setBounds(462, 692, 486, 20);
		    panel.add(status);
		  
		    chk3 = new JCheckBox("Required");
		  chk3.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		  chk3.setForeground(Color.WHITE);
		  chk3.setOpaque(false);
		  chk3.setBounds(366, 180, 128, 23);
		  panel.add(chk3);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Thread w = new Thread() {
					 	
					public void run() {
						chk1.setEnabled(false);
						chk2.setEnabled(false);
						chk3.setEnabled(false);
						datastorage.fpurl.clear();
						datastorage.fpurl2.clear();
						datastorage.purls.clear();
						datastorage.purls2.clear();
						datastorage.datas.clear();
						count=1;
						pbar1.setValue(0);pbar2.setValue(0);pbar3.setValue(0);
						model.setRowCount(0);
						btnStart.setEnabled(false);
						urldata.urldatas.clear();urldata.urldatas2.clear();
					 
//-------------------------------------------------------------------------------------------------------------------------
						
						
						if(!chk1.isSelected())
						{
						status.setText("Getting categories urls");;	
						Main2.Start();
						}
						else
						{		String path = System.getProperty("user.dir");
						String excelFileName = "";

						excelFileName = path + "\\data\\" + "aceuae";
						File ff = new File(excelFileName);
						ff.mkdirs();

						excelFileName += "\\category_MAP_ACE.xlsx";
						File c=new File(excelFileName);
						if(!c.exists())
						{status .setText("FILE NA!! remapping");
							status.setText("Getting categories urls");;	
							Main2.Start();
							chk1.setSelected(false);
						}
						
						try {
							ArrayList<String[]> read=ExcelReader.read(excelFileName);
							for(int i=0;i<read.size();i++)
							{
								String cat =read.get(i)[0],subcat=read.get(i)[1],  
										subsubcat=read.get(i)[2],
										producturl=read.get(i)[5];
								
								int key=i;
								String tag1=read.get(i)[3],tag2=read.get(i)[4];
							datastorage.fpurl.add(new More(cat, subcat, subsubcat, tag1, tag2, producturl));
							;
							} 
							st2();
							pbar1.setValue(pbar1.getMaximum());
						} catch (IOException e) {
							status.setText("error in reading");
						}
						 }
//-------------------------------------------------------------------------------------------------------------------------
						
					}
				};
				w.start();
			}
		});
	}
	public static void st2()
	{
		if(!chk2.isSelected())
		{
			makeThreads4.start();
		}else
			
		{
			//read
			String path = System.getProperty("user.dir");
			
		String	excelFileName = path + "\\data\\" + "aceuae";
		excelFileName += "\\productsurl_MAP_ACE.xlsx";
		File ff = new File(excelFileName);
		if(ff.exists())
		{//read
			if(datastorage.purls.size()==0)
			try {
				ArrayList<String[]>arr=	ExcelReader.read(excelFileName);
				
				for(int i=0;i<arr.size();i++)
				{	 
					String[]arrs=arr.get(i);
					String 	 cat    	=	arrs[	0	];
					String 	 scat    	=	arrs[	1	];
					String 	 sscat    	=	arrs[	2	];
					String 	 tag1    	=	arrs[	3	];
					String 	 tag2    	=	arrs[	4	];
					String 	 brandname    	=	arrs[	5	];
					String 	 productname    	=	arrs[	6	];
					String 	 price    	=	arrs[	7	];
					String 	 orginalprice    	=	arrs[	8	];
					String 	 sku     	=	arrs[	9	];
					boolean	 stock   	=	Boolean.parseBoolean(arrs[	10	]);
					System.out.println(stock);
					String 	 des    	=	arrs[	11	];
					String 	 keypos    	=	arrs[	12	];
					String 	 specs    	=	arrs[	13	];
					String 	 weight    	=	arrs[	14	];
					String 	 imageurl    	=	arrs[	15	];
					String 	 url    	=	arrs[	16	];
					String 	 deswithtags    	=	arrs[	17	];
					int	 key   	=	i;


			 
				datastorage.purls.add(new productsurls(cat, scat, sscat, tag1, tag2, url, 0, key, brandname, productname, price, stock, sku, orginalprice));
				}
				pbar2.setValue(pbar2.getMaximum());
				st3();
			} catch (IOException e) {
				status.setText("File Error !! remapping products");
				makeThreads4.start();
			}else {
				pbar2.setValue(pbar2.getMaximum());
				st3();
			}
		}else {
			status.setText("File NA !! remapping products");
			makeThreads4.start();
		}
			}
	}
	
	public static void st3()
	{status.setText("");
	
		if(chk3.isSelected())
		{status.setText("Getting info");
			makeThreads6.start();
		}
		else {
			pbar3.setValue(pbar3.getMaximum());
			complete();
		}
	}
	public static void complete()
	{btnStart.setEnabled(true);
		pbar1.setValue(pbar1.getMaximum());pbar2.setValue(pbar2.getMaximum());
	pbar3.setValue(pbar3.getMaximum());
	chk1.setEnabled(true);chk2.setEnabled(true);chk3.setEnabled(true);
		status.setText("completed !!");
	}
}
