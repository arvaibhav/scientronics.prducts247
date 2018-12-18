package Main;

 

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

 
import javafx.scene.control.ProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Editpanel {
	int draggedAtX; int draggedAtY;
	 JFrame frame;
public	 static JLabel sno;
	 static ArrayList<String> data;
	 static   JTextField txttitle;
	 static  JTextField txtcollection;
	 static   JTextField txtmodel;
	 static  JTextField txttype;
	 static JTextField txtcat;
	 static JTextField txtsubcat;
	 static JTextField txtprice;
	 static JTextField lblcolor;
	 static  JTextField txtsize;
	 static  JTextArea txtstyle;
	 static JTextField txturl;
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editpanel window = new Editpanel();
					window.frame.setLocation(5, 5);
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
	public Editpanel() {
		initialize();
		 
	 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1009, 573);
		frame.getContentPane().setLayout(null);
		  
	        //frame.setSize(1080, 720);
		
		JPanel movepanel = new JPanel();
		movepanel.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		movepanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				draggedAtX = e.getX();
                draggedAtY = e.getY();
			}
		});
		 
		movepanel.setBounds(0, 0, 1009, 40);
		frame.getContentPane().add(movepanel);
		movepanel.setLayout(null);
	 
		movepanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			 
				frame. setLocation(e.getX() - draggedAtX + frame.getLocation().x,
	                        e.getY() - draggedAtY + frame.getLocation().y);
				 			}
		});
		JLabel closelbl = new JLabel("  X");
		closelbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		closelbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
		closelbl.setBounds(1037, 0, 43, 40);
		movepanel.add(closelbl);
		
		JLabel lblSno = new JLabel("SNO:");
		lblSno.setBounds(10, 0, 32, 40);
		movepanel.add(lblSno);
		
		  sno = new JLabel("");
		sno.setBounds(45, 0, 77, 40);
		movepanel.add(sno);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {frame.setVisible(false);
			}
		});
		lblX.setBounds(977, 0, 32, 40);
		movepanel.add(lblX);
		
		txturl = new JTextField();
		txturl.setColumns(10);
		txturl.setBounds(142, 9, 693, 20);
		movepanel.add(txturl);
		
		JButton btnNewButton = new JButton("Copy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringSelection stringSelection = new StringSelection (txturl.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
		});
		btnNewButton.setBounds(861, 9, 89, 20);
		movepanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(22, 59, 97, 31);
		frame.getContentPane().add(lblNewLabel);
		
		txttitle = new JTextField();
		txttitle.setBounds(140, 60, 812, 31);
		frame.getContentPane().add(txttitle);
		txttitle.setColumns(10);
		
		JLabel lblCollection = new JLabel("Collection");
		lblCollection.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCollection.setBounds(22, 114, 97, 31);
		frame.getContentPane().add(lblCollection);
		
		txtcollection = new JTextField();
		txtcollection.setColumns(10);
		txtcollection.setBounds(140, 115, 812, 31);
		frame.getContentPane().add(txtcollection);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblModel.setBounds(22, 169, 97, 31);
		frame.getContentPane().add(lblModel);
		
		txtmodel = new JTextField();
		txtmodel.setColumns(10);
		txtmodel.setBounds(140, 170, 812, 31);
		frame.getContentPane().add(txtmodel);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblType.setBounds(22, 224, 97, 31);
		frame.getContentPane().add(lblType);
		
		txttype = new JTextField();
		txttype.setColumns(10);
		txttype.setBounds(140, 225, 812, 31);
		frame.getContentPane().add(txttype);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCategory.setBounds(22, 282, 97, 31);
		frame.getContentPane().add(lblCategory);
		
		txtcat = new JTextField();
		txtcat.setColumns(10);
		txtcat.setBounds(140, 283, 812, 31);
		frame.getContentPane().add(txtcat);
		
		JLabel lblSubcat = new JLabel("Sub-cat.");
		lblSubcat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSubcat.setBounds(22, 337, 97, 31);
		frame.getContentPane().add(lblSubcat);
		
		txtsubcat = new JTextField();
		txtsubcat.setColumns(10);
		txtsubcat.setBounds(140, 338, 812, 31);
		frame.getContentPane().add(txtsubcat);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPrice.setBounds(22, 393, 97, 31);
		frame.getContentPane().add(lblPrice);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(140, 394, 147, 31);
		frame.getContentPane().add(txtprice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 447, 636, 101);
		frame.getContentPane().add(scrollPane);
		
		txtstyle = new JTextArea();
		scrollPane.setViewportView(txtstyle);
		
		JLabel lblStyle = new JLabel("Style");
		lblStyle.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblStyle.setBounds(22, 452, 97, 31);
		frame.getContentPane().add(lblStyle);
		
		JButton btnSave = new JButton("Save");
	
		btnSave.setBounds(816, 452, 111, 40);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnCancel.setBounds(816, 503, 111, 40);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblColor.setBounds(339, 392, 97, 31);
		frame.getContentPane().add(lblColor);
		
		lblcolor = new JTextField();
		lblcolor.setColumns(10);
		lblcolor.setBounds(457, 393, 147, 31);
		frame.getContentPane().add(lblcolor);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSize.setBounds(662, 392, 97, 31);
		frame.getContentPane().add(lblSize);
		
		txtsize = new JTextField();
		txtsize.setColumns(10);
		txtsize.setBounds(780, 393, 147, 31);
		frame.getContentPane().add(txtsize);
		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=Integer.parseInt(sno.getText())-1;
				dashboadpanel.datas.get(index).title=txttype.getText();
				dashboadpanel.datas.get(index).collection=txtcollection.getText();	
				dashboadpanel.datas.get(index).model=txtmodel.getText();
				dashboadpanel.datas.get(index).type=txttype.getText();
				dashboadpanel.datas.get(index).category=txtcat.getText();
				dashboadpanel.datas.get(index).subcategory=txtsubcat.getText();
				dashboadpanel.datas.get(index).price=txtprice.getText();
				dashboadpanel.datas.get(index).color=lblcolor.getText();
				dashboadpanel.datas.get(index).size=txtsize.getText();
				dashboadpanel.datas.get(index).stypedecription=txtstyle.getText();
				dashboadpanel.model.setRowCount(0);
				for(int i=0;i<dashboadpanel.datas.size();i++)
					 
					dashboadpanel.model.addRow(new Object[] {
							(i+1),
							dashboadpanel.datas.get(i).title,
							dashboadpanel.datas.get(i).producturl,
							dashboadpanel.datas.get(i).collection,
							dashboadpanel.datas.get(i).model,
							dashboadpanel.datas.get(i).type,
							dashboadpanel.datas.get(i).category,
							dashboadpanel.datas.get(i).subcategory,
							dashboadpanel.datas.get(i).price,
							dashboadpanel.datas.get(i).color,
							dashboadpanel.datas.get(i).size,
							dashboadpanel.datas.get(i).stypedecription,
							dashboadpanel.datas.get(i).img1,
							dashboadpanel.datas.get(i).img2,
							dashboadpanel.datas.get(i).img3,
							dashboadpanel.datas.get(i).img4});
				frame.setVisible(false);
			}
			
				
			 
		}); 
		
	}
}
