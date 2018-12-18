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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//import org.apache.commons.io.IOUtils;

import javafx.scene.control.ProgressBar;
import marksandspencer.com.Stage3;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class UI { 
	 
	 
	public static FirefoxOptions op=new FirefoxOptions();
	public static ArrayList<String>csvfiles=new ArrayList<>(2000);
	  public static FirefoxDriver driver1;
	  public static FirefoxDriver driver2;
	public static String tdydate;
	int draggedAtX; int draggedAtY;
	 JFrame frame;
	 static ArrayList<String> data;
	 dashboadpanel dashbp=new dashboadpanel();
	 
	 site1panel site1p=new site1panel();
	 site2panel site2p=new site2panel();
	 site3panel site3p=new site3panel();
	setttingpanell sp=new setttingpanell();
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
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
	public UI() {
		initialize();
		 
		Thread w = new Thread() {

			public void run() {csvfiles=Csvfunction.Listdates();
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\data\\geckodriver.exe");
				 op.addPreference("permissions.default.image", 2);
				 op.addPreference("browser.cache.disk.enable", false);
				 op.addPreference("browser.cache.memory.enable", false);
				 op.addPreference("browser.cache.offline.enable", false);
				 op.addPreference("network.http.use-cache", false);
			 
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int months = localDate.getMonthValue();
				  
				int dates=localDate.getDayOfMonth();
			 
				int year =localDate.getYear();
tdydate=dates+"-"+months+"-"+year;
if(Integer.toString(dates).length()==1)
tdydate="0"+dates+"-"+months+"-"+year;

if(Integer.toString(months).length()==1)
tdydate=dates+"-"+"0"+months+"-"+year;
site1p.lbldate.setText(tdydate); 
site2p.lbldate.setText(tdydate); 
			}
		};
		w.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UI.class.getResource("/img/Webp.net-resizeimage.jpg")));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1200, 720);
		frame.getContentPane().setLayout(null);
		
		JPanel P2 = new JPanel();
		P2.setBounds(0, 0, 135, 720);
		frame.getContentPane().add(P2);
		P2.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(0, 0, 0)));
		P2.setLayout(null); 	
		
		
		P2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				draggedAtX = e.getX();
               draggedAtY = e.getY();
			}
		});
		
		
	 
		P2.addMouseMotionListener(new MouseMotionAdapter() {
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
				  try {
			        	 Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe") ;
			        	Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe") ;
			        } catch (Exception e) {
			            e.printStackTrace();  
			        }
						System.exit(0);

					 
			 
			}
		});
		closelbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
		closelbl.setBounds(0, 0, 37, 36);
		P2.add(closelbl);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 153));
		panel.setBounds(10, 119, 115, 102);
		P2.add(panel);
		panel.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDashboard.setBounds(10, 33, 95, 31);
		panel.add(lblDashboard);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 275, 115, 2);
		P2.add(separator);
		
		JLabel lblScraper = new JLabel("Scraper");
		lblScraper.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblScraper.setForeground(Color.BLACK);
		lblScraper.setBounds(34, 250, 80, 27);
		P2.add(lblScraper);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(10, 288, 115, 102);
		P2.add(panel1);
		
		JLabel lblSite = new JLabel("site1");
		lblSite.setIcon(new ImageIcon(UI.class.getResource("/img/Webp.net-resizeimage.jpg")));
		lblSite.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSite.setBounds(0, 0, 115, 102);
		panel1.add(lblSite);
		
		JPanel panel2 = new JPanel();
		panel2.setForeground(Color.BLUE);
		panel2.setLayout(null);
		panel2.setBackground(Color.YELLOW);
		panel2.setBounds(10, 410, 115, 102);
		P2.add(panel2);
		
		JLabel lblIkea = new JLabel("  IKEA");
		 
		lblIkea.setForeground(Color.BLUE);
		lblIkea.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		lblIkea.setBounds(0, 0, 115, 102);
		panel2.add(lblIkea);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setForeground(Color.BLUE);
		panel3.setBackground(Color.RED);
		panel3.setBounds(10, 534, 115, 102);
		P2.add(panel3);
		
		JLabel lblAce = new JLabel("  ACE");
		lblAce.setForeground(Color.WHITE);
		lblAce.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 31));
		lblAce.setBounds(0, 0, 115, 102);
		panel3.add(lblAce);
		
		JPanel panels = new JPanel();
		panels.setLayout(null);
		panels.setBackground(Color.GRAY);
		panels.setBounds(10, 64, 115, 44);
		P2.add(panels);
		
		JLabel lblSetting = new JLabel("Setting");
		lblSetting.setForeground(Color.WHITE);
		lblSetting.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSetting.setBounds(24, 11, 81, 31);
		panels.add(lblSetting);
		JPanel choice = new JPanel();
		choice.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		choice.setBackground(new Color(189, 183, 107));
		choice.setBounds(135, 0, 1065, 720);
		frame.getContentPane().add(choice);
		choice.setLayout(null);
		choice.add(site1p.panel);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setBackground(new Color(51, 51, 153));
				panel1.setBackground(new Color(102, 102, 153));
				 
			 //remove 
				choice.removeAll();
				choice.repaint();
				choice.revalidate();
			//
				//add
				
				choice.add(dashbp.panel);
				choice.repaint();
				choice.revalidate();
				//
				
			}
		});	panel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel1.setBackground(new Color(51, 51, 153));
				panel.setBackground(new Color(102, 102, 153));
				 panel2.setBackground(new Color(218, 165, 32));
				 //remove 
				choice.removeAll();
				choice.repaint();
				choice.revalidate();
			//
				//add
				choice.add(site1p.panel);
				choice.repaint();
				choice.revalidate();
				//
			}
		});
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel1.setBackground(new Color(51, 51, 153));
				panel.setBackground(new Color(102, 102, 153));
				panel2.setBackground(Color.YELLOW); 
				 //remove 
				choice.removeAll();
				choice.repaint();
				choice.revalidate();
			//
				//add
				choice.add(site2p.panel);
				choice.repaint();
				choice.revalidate();
				//
			}
		});
		 
		
		panel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel1.setBackground(new Color(51, 51, 153));
				panel.setBackground(new Color(102, 102, 153));
				panel2.setBackground(Color.YELLOW); 
				 //remove 
				choice.removeAll();
				choice.repaint();
				choice.revalidate();
			//
				//add
				choice.add(site3p.panel);
				choice.repaint();
				choice.revalidate();
				//
			}
		});
		
		panels.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel1.setBackground(new Color(51, 51, 153));
				panel.setBackground(new Color(102, 102, 153));
				panel2.setBackground(Color.YELLOW); 
				 //remove 
				choice.removeAll();
				choice.repaint();
				choice.revalidate();
			//
				//add
				choice.add(sp.panel);
				choice.repaint();
				choice.revalidate();
				//
			}
		});
	}
}
