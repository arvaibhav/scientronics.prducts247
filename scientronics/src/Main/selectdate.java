package Main;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class selectdate {
	static DefaultTableModel  model;
	  JDialog frame;
	private JTable table;


	public selectdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setUndecorated(true);
		frame.setOpacity(0.98f);
		frame.setResizable(false);
		frame.setBounds(100, 100, 250, 379);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectDate = new JLabel("SELECT DATE");
		lblSelectDate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSelectDate.setBounds(60, 0, 126, 29);
		frame.getContentPane().add(lblSelectDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 230, 301);
		frame.getContentPane().add(scrollPane);
		    model=new DefaultTableModel(new Object[] {"Date"}, 0){
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			} ;
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow()>=0)
			{dashboadpanel.model.setRowCount(0);
				dashboadpanel.datas.clear();
			String name=model.getValueAt(table.getSelectedRow(),0).toString();
			dashboadpanel.sldate.setText(name.replaceAll("-", "/"));
			try {
				dashboadpanel.datas=Csvfunction.readcsv(name);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
//			System.out.println(dashboadpanel.datas.get(0).title+"  --->>"+dashboadpanel.datas.get(0).handel);
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
			}
			frame.setVisible(false);}
		});
		btnSelect.setBounds(76, 350, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JLabel lblNewLabel = new JLabel(" X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
			}
		});
		lblNewLabel.setBounds(229, 0, 21, 23);
		frame.getContentPane().add(lblNewLabel);
		 
	}

}
