package Main;

import java.awt.Color;

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

import Tool.comparetool1;
import ikea.com.data;
import ikea.com.getAllProducts;
import ikea.com.Csv;
import ikea.com.chkdata;
import ikea.com.Excel;
import ikea.com.chkdata;
import ikea.com.getCategoryandsubcategory;
import ikea.com.makeThreads;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class site2panel {
	static JLabel txtstatus;
	JPanel panel = new JPanel();
	public static JTable table;

	public static DefaultTableModel model;
	JLabel lbldate;
	public static boolean headless = true;
	public static JButton btnStart;
	public static JProgressBar pbar1;
	public static JProgressBar pbar2;
	public static JProgressBar pbar3;
	public static JLabel lblstatus;

	/**
	 * Create the panel.
	 */
	public static void complete() {
		btnStart.setEnabled(true);
		txtstatus.setText("Saving to Excel");
		boolean don = false;
		for (int i = 0; i < 4; i++)
			try {
				ArrayList<data> val = data.datas;
				Excel.toexcel(val, false);
				don = true;
				break;
			} catch (Exception e) {
				e.printStackTrace();
				txtstatus.setText("retry");
			}
		if (don)
			txtstatus.setText("done");
		else
			txtstatus.setText("done! press save");
		pbar3.setValue(pbar3.getMaximum());
		try {
			comparetool1.make();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public site2panel() {

		panel.setToolTipText("");
		panel.setBackground(Color.LIGHT_GRAY);

		panel.setSize(1065, 720);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("         IKEA");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(430, 7, 228, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel);
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 38, 988, 12);
		panel.add(separator);

		JLabel lblStage = new JLabel("Stage 1:(Collecting category url)");
		lblStage.setToolTipText("");
		lblStage.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage.setBounds(28, 48, 287, 20);
		panel.add(lblStage);

		pbar1 = new JProgressBar();
		pbar1.setStringPainted(true);
		pbar1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pbar1.setForeground(new Color(0, 100, 0));
		pbar1.setBounds(28, 79, 988, 20);
		panel.add(pbar1);

		JLabel lblStage_1 = new JLabel("Stage 2:(Collecting products url from cat. url)");
		lblStage_1.setToolTipText("");
		lblStage_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage_1.setBounds(28, 111, 326, 20);
		panel.add(lblStage_1);
		pbar2 = new JProgressBar();
		pbar2.setStringPainted(true);
		pbar2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pbar2.setForeground(new Color(34, 139, 34));
		pbar2.setBounds(28, 142, 988, 20);
		panel.add(pbar2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 169, 988, 2);
		panel.add(separator_1);

		JLabel lblStage_2 = new JLabel("    Stage 3: Collecting product information");
		lblStage_2.setToolTipText("");
		lblStage_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStage_2.setBounds(399, 180, 259, 20);
		panel.add(lblStage_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 1045, 448);
		panel.add(scrollPane);
		// Title URL Collection Model/EAN/SKU Type Category Sub Category (if Any) Price
		// Color Size StyleDescriptions Img1 Img2 Img3 Img4

		model = new DefaultTableModel(new Object[] { "Sno.", "Product Name", "Product Type", "Price", "ItemNumber",
				"Variant_type", "Category", "Sub Category", "Sub-Sub Category", "productinformation",
				"materialinformation", "imgurls",
				// stockd,stockad,per,dimensions,note,description,vurl
				"stockd", "stockad", "per", "dimensions", "note", "description", "vurl" }, 0) {
			/*
			 * productName, productType,price ,itemNumber , variant_type,cat,subcat
			 * ,productinformation ,materialinformation , imgurls,vurl , , String ="";
			 * String ; String =""; String =""; String =""; String =""; String ; String
			 * vurl; String ; String ; (non-Javadoc)
			 * 
			 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
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

		JButton btnNewButton = new JButton("Generate current Excel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Thread w = new Thread(new Runnable() {

					@Override
					public void run() {
						btnNewButton.setEnabled(false);
						comparetool1.make();
						btnNewButton.setEnabled(true);
					}
				});
				w.start();
			}
		});
		btnNewButton.setBounds(188, 685, 219, 30);
		panel.add(btnNewButton);

		lblstatus = new JLabel("");
		lblstatus.setForeground(Color.BLUE);
		lblstatus.setBounds(417, 693, 190, 14);
		panel.add(lblstatus);

		txtstatus = new JLabel("");
		txtstatus.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		txtstatus.setForeground(new Color(0, 128, 0));
		txtstatus.setBounds(744, 685, 212, 30);
		panel.add(txtstatus);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(site2panel.class.getResource("/img/yellow-wallpapers-25359-2633633.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1065, 720);
		panel.add(lblNewLabel_1);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread w = new Thread() {

					public void run() {
						btnStart.setEnabled(false);
						data.datas.clear();
						getAllProducts.allproducts.clear();
						getCategoryandsubcategory.cats.clear();
						chkdata.datas.clear();
						model.setRowCount(0);
						txtstatus.setText("");
						while (true)
							try {
								getCategoryandsubcategory.get(true);
								break;
							} catch (Exception e) {
							} // wrong way
						pbar1.setValue(pbar1.getMaximum());
						pbar2.setMaximum(getCategoryandsubcategory.cats.size());
						makeThreads.start(16, getCategoryandsubcategory.cats.size());

					}
				};
				w.start();
			}
		});
	}
}
