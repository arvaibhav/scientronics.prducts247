package Main;

import java.awt.Color;
import java.awt.Font;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeArea;
 

import marksandspencer.com.data;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dashboadpanel   {
	static boolean iscurrent;
	public static ArrayList<data>datas=new ArrayList<>(80000);
	JPanel panel=new JPanel();
	selectdate sd=new selectdate();
	static  JLabel sldate;
	public static DefaultTableModel model;
	private JTable table;
	Editpanel ep=new Editpanel();
	/**
	 * Create the panel.
	 */
	public dashboadpanel() {
		panel.setBackground(new Color(106, 90, 205));
		model=new DefaultTableModel(new Object[] {"Sno.","Title","URL","Collection","Model/EAN/SKU","Type","Category","Sub Category","Price","Color","Size","StyleDescriptions","Img1","Img2","Img3","Img4"}, 0){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		} ;
		panel.setSize(1065, 720);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("DashBoard");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(475, 7, 147, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel);
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 38, 988, 12);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Date Range:");
		lblNewLabel_1.setBounds(23, 58, 94, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JPanel datepanel = new JPanel();
		datepanel.setBounds(127, 55, 324, 23);
		panel.add(datepanel);
		 datepanel.setBackground(new Color(51, 51, 153));
		 datepanel.setLayout(new BoxLayout(datepanel, BoxLayout.X_AXIS));
		 DatePicker datePicker1 = new DatePicker();
		 datepanel. add(datePicker1);
	        DatePicker datePicker12 = new DatePicker();
	        datepanel.    add(datePicker12);
	        
	        JButton btnSelect = new JButton("Select");
	       
	        btnSelect.setBounds(475, 55, 89, 23);
	        panel.add(btnSelect);
	        
	        JScrollPane scrollPane = new JScrollPane();
	     
	        scrollPane.setBounds(28, 99, 1009, 573);
	        panel.add(scrollPane);
	        
	        table = new JTable(model);
	        
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
	        
	        scrollPane.setViewportView(table);
	        
	        JButton btnSaveChanges = new JButton("Save Changes");
	        btnSaveChanges.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if(!sldate.getText().isEmpty())
						try {
							Csvfunction.writecsv(sldate.getText().replaceAll("/", "-"), datas);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        	}
	        });
	        btnSaveChanges.setBounds(917, 683, 120, 23);
	        panel.add(btnSaveChanges);
	        
	          sldate = new JLabel("");
	        sldate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        sldate.setForeground(new Color(255, 0, 0));
	        sldate.setBounds(936, 82, 101, 15);
	        panel.add(sldate);
	        DatePickerSettings dateSettings = new DatePickerSettings();
	        dateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);
	        TimePickerSettings timeSettings = new TimePickerSettings();
	        timeSettings.setColor(TimeArea.TimePickerTextValidTime, Color.blue);
	        timeSettings.initialTime = LocalTime.now();
	        System.out.println(datePicker1.getText());
	        btnSelect.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		
	        	if(!(datePicker1.getText().isEmpty()&&datePicker1.getText().isEmpty()))
	        	{ sd.model.setRowCount(0);
	        		LocalDate start = LocalDate.of( datePicker1.getDate().getYear() , datePicker1.getDate().getMonth() , datePicker1.getDate().getDayOfMonth() ) ;
	    		LocalDate stop = LocalDate.of( datePicker12.getDate().getYear() , datePicker12.getDate().getMonth() , datePicker12.getDate().getDayOfMonth() ) ;
	    		 
	        		for(int i=0;i<UI.csvfiles.size();i++)
	        		{  iscurrent=false;
	        		String datefromfile=UI.csvfiles.get(i);	
	        		if(datefromfile.contains("_current")) {iscurrent=true;
	        		datefromfile=datefromfile.substring(0,datefromfile.indexOf("_current"));
	        			}
	        			String []csvtemp=datefromfile.split("-");
	        			LocalDate today;
						try {
							today = LocalDate.of(Integer.parseInt(csvtemp[2]),Integer.parseInt(csvtemp[1]),Integer.parseInt(csvtemp[0]));
						} catch (Exception e) {continue;}
	        			Boolean containsToday = ( ! today.isBefore( start ) ) && ( today.isBefore( stop ) ) ;
	        			if( containsToday)
	        			{ 
	        			 	sd.model.addRow(new Object[] {UI.csvfiles.get(i)});
	        			}
	        		}
	        		sd.frame.setLocation(btnSelect.getLocationOnScreen().x+20, btnSelect.getLocationOnScreen().y+10);
	        		sd.frame.setVisible(true);
	        	}
	        	}
	        });
	        table.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyReleased(KeyEvent arg0) {
	        		System.out.println("s");
	        		int val=table.getSelectedRow();
	        		if(val>=0)
	        		{
	        			if(arg0.getKeyCode()==KeyEvent.VK_DELETE)
	        			{
	        	 datas.remove(val);model.removeRow(val);for(int i=1;i< datas.size();i++)model.setValueAt(i, (i-1), 0);
	        				
	        			}
	        		}
	        	}
	        });
	        table.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		int index=table.getSelectedRow();
	        		if(index>=0)
	        		{
	        			if(e.getClickCount()>=2)
	        			{		ep.sno.setText(Integer.toString((index+1)));
	        				ep.txturl.setText(dashboadpanel.datas.get(index).producturl);
	        				 ep.txttitle.setText(dashboadpanel.datas.get(index).title);
	        				 ep.txtcollection.setText(dashboadpanel.datas.get(index).collection);	
	        				 ep.txtmodel.setText(dashboadpanel.datas.get(index).model);
	        				 ep.txttype.setText(dashboadpanel.datas.get(index).type);
	        				 ep.txtcat.setText(dashboadpanel.datas.get(index).category);
	        				 ep.txtsubcat.setText(dashboadpanel.datas.get(index).subcategory);
	        				 ep.txtprice.setText(dashboadpanel.datas.get(index).price);
	        				 ep.lblcolor.setText(dashboadpanel.datas.get(index).color);
	        				 ep.txtsize.setText(dashboadpanel.datas.get(index).size);
	        				 ep.txtstyle.setText(dashboadpanel.datas.get(index).stypedecription);
	        				 ep.frame.setVisible(true);
	        				
	        			}
	        		}
	        	}
	        });
	}
}
