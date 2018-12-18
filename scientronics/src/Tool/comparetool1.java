package Tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.jsoup.nodes.Element;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import Main.settingsdata;
import Main.setttingpanell;
import aceuae.datastorage;
import aceuae.productsurls;
import ikea.com.data;

public class comparetool1 {
	String ean0;// 0
	String sku1;// 1

	String c4 = "SCIENTRONICS";// 4

	String active6;// 6
	String price7;// 7
	String stock8;// 8

	String c10 = "c";// 10

	String[] row;

	public comparetool1(String[] row) {
		super();
		this.ean0 = row[0];
		this.sku1 = row[1];

		this.active6 = row[6];
		this.price7 = row[7];
		this.stock8 = row[8];

		this.row = row;

	}

	public static void make2() {
		ArrayList<comparetool1> old = new ArrayList<>();
		try {
			ArrayList<String[]> ss = ExcelReader.read(readSouqaceuae());
			for (String[] s : ss)
				old.add(new comparetool1(s));
		} catch (IOException e1) {
			// TODO Auto-generated catch block

		}
		ArrayList<comparetool1> filter = new ArrayList<>();

		for (int i = 0; i < old.size(); i++) {
			String sku1 = old.get(i).sku1.trim();// 1
			String active6 = old.get(i).active6;// 6
			String price7 = old.get(i).price7.replaceAll("[^0-9.]", "").trim();
			;// 7
			String stock8 = old.get(i).stock8;// 8
			ArrayList<productsurls> currents = datastorage.purls;
			for (int f = 0; f < currents.size(); f++) {
				if (sku1.trim().equals(currents.get(f).sku.trim())) {
					String[] row = old.get(i).row;
					int newstock = 0;

					boolean tem = currents.get(f).stock;
					if (tem)
						newstock = 9;

					price7 = currents.get(f).price;
					int oldstock = Integer.parseInt(stock8);
					if (active6.toUpperCase().equals("YES")) {
						if (oldstock == 0)
							if (newstock == 9) {
								active6 = "NO";
							}
					} else
						active6 = "YES";
					if (newstock == 0)
						price7 = "sold_out";
					row[6] = active6;
					if(!price7.equals("sold_out"))
					try {
						double prc=Double.parseDouble(price7);
						ArrayList<settingsdata>arr=setttingpanell.rules;
						for(int z=0;z<arr.size();z++)
						{double from=arr.get(z).from;
						double to=arr.get(z).to;
						double factor=arr.get(z).factor;
						if(prc<=to&&prc>=from)
						{prc*=factor;
						System.out.println("rule :"+price7+"  *"+factor+"  "+prc  );
							break;
						}
						}
						price7=Double.toString(prc);
					}catch (Exception e) {
						// TODO: handle exception
					}
					row[7] = price7;
					row[8] = Integer.toString(newstock);
					filter.add(new comparetool1(row));
					break;
				}
			}

		}
		try {
			System.out.println(old.size() + "  " + filter.size());
			save(filter, "MAAC");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//

	static void save(ArrayList<comparetool1> list, String name) throws IOException {
		System.out.println("saving");

		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		String date = dateFormat.format(new Date()).toString();
		String g;
		if(name.contains("IK"))
		g = System.getProperty("user.dir") + "\\Compare_output\\IKEA";
		else g = System.getProperty("user.dir") + "\\Compare_output\\ACEUAE";
		File fd = new File(g);// Compare_output
		fd.mkdirs();
		fd.mkdir();
		String excelFileName = g + "\\" + date + name+".xlsx";
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFWorkbook wb2 = new XSSFWorkbook();
		makesheet(wb,list);makesheet(wb2,list);
				FileOutputStream fileOut = new FileOutputStream(excelFileName);

		// write this workbook to an Outputstream. sheet.autoSizeColumn(1);
//			  for(int i=0;i<datas.size();i++)  sheet.autoSizeColumn(i);
				while(true)try {
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();//
			break;} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
		   
//		Files.copy(,);
//	//	copyf(new File(excelFileName), new File(setttingpanell.base) );
//		 Path path=FileSystems.getDefault().getPath(excelFileName);
//		System.out.println("EFILE"+excelFileName);
//		System.out.println("BASE"+setttingpanell.base);
		while(true) 
		try {
			 FileOutputStream fileOut2 = new FileOutputStream(setttingpanell.base+"\\"+date+name+".xlsx");
			 wb2.write(fileOut2);
				fileOut2.flush();
				fileOut2.close();

		break;} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	private static void makesheet(XSSFWorkbook wb, ArrayList<comparetool1> list) {
		String sheetName = "Output";
		XSSFSheet sheet = wb.createSheet(sheetName);
		CellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);

		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setBold(true);
		style.setFont(font);

		// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = null;

		{
			cell = row.createCell(0);
			cell.setCellStyle(style);
			cell.setCellValue("EAN #1");

			cell = row.createCell(1);
			cell.setCellStyle(style);
			cell.setCellValue("SKU");

			cell = row.createCell(2);
			cell.setCellStyle(style);
			cell.setCellValue("Supplier Sku");

			cell = row.createCell(3);
			cell.setCellStyle(style);
			cell.setCellValue("Item Title");

			cell = row.createCell(4);
			cell.setCellStyle(style);
			cell.setCellValue("Seller Username");

			cell = row.createCell(5);
			cell.setCellStyle(style);
			cell.setCellValue("Offer Condition");

			cell = row.createCell(6);
			cell.setCellStyle(style);
			cell.setCellValue("Active");

			cell = row.createCell(7);
			cell.setCellStyle(style);
			cell.setCellValue("Listing Price");

			cell = row.createCell(8);
			cell.setCellStyle(style);
			cell.setCellValue("Stock Quantity");

			cell = row.createCell(9);
			cell.setCellStyle(style);
			cell.setCellValue("Offer Note");

			cell = row.createCell(10);
			cell.setCellStyle(style);
			cell.setCellValue("Handling Time");

			cell = row.createCell(11);
			cell.setCellStyle(style);
			cell.setCellValue("Free Shipping By Seller");

			cell = row.createCell(12);
			cell.setCellStyle(style);
			cell.setCellValue("Is Drop Off");

			cell = row.createCell(13);
			cell.setCellStyle(style);
			cell.setCellValue("Pricing Status");

			cell = row.createCell(14);
			cell.setCellStyle(style);
			cell.setCellValue("Date Inserted");

			cell = row.createCell(15);
			cell.setCellStyle(style);
			cell.setCellValue("Max Quantity");

			cell = row.createCell(16);
			cell.setCellStyle(style);
			cell.setCellValue("Is FBS");

			cell = row.createCell(17);
			cell.setCellStyle(style);
			cell.setCellValue("Date Received");

			cell = row.createCell(18);
			cell.setCellStyle(style);
			cell.setCellValue("Is SWS");

			cell = row.createCell(19);
			cell.setCellStyle(style);
			cell.setCellValue("App	ear on Kuwait (yes/no)");

			cell = row.createCell(20);
			cell.setCellStyle(style);
			cell.setCellValue("id_offer");

		} // name

		for (int r = 0; r < list.size(); r++) {
			row = sheet.createRow(r + 1);

			// iterating c number of columns
			String ean = list.get(r).ean0; // 0
			String sku = list.get(r).sku1; // 1
			String supsku = list.get(r).row[2]; // 2
			String itemt = list.get(r).row[3]; // 3
			String selusername = list.get(r).c4; // 4
			String offercon = list.get(r).row[5]; // 5
			String active = list.get(r).active6; // 6
			String listprice = list.get(r).price7; // 7
			String stockq = list.get(r).stock8; // 8
			String offern = list.get(r).row[9]; // 9
			String handtime = list.get(r).c10; // 10
			String free = list.get(r).row[11]; // 11
			String isdrop = list.get(r).row[12]; // 12
			String price = list.get(r).row[13]; // 13
			String datein = list.get(r).row[14]; // 14
			String maxq = list.get(r).row[15]; // 15
			String isf = list.get(r).row[16]; // 16
			String dater = list.get(r).row[17]; // 17
			String iss = list.get(r).row[18]; // 18
			String apon = list.get(r).row[19]; // 19
			String idof = list.get(r).row[20]; // 20

			cell = row.createCell(0);
			cell.setCellValue(ean);

			cell = row.createCell(1);
			cell.setCellValue(sku);

			cell = row.createCell(2);
			cell.setCellValue(supsku);

			cell = row.createCell(3);
			cell.setCellValue(itemt);

			cell = row.createCell(4);
			cell.setCellValue(selusername);

			cell = row.createCell(5);
			cell.setCellValue(offercon);

			cell = row.createCell(6);
			cell.setCellValue(active);

			cell = row.createCell(7);
			cell.setCellValue(listprice);

			cell = row.createCell(8);
			cell.setCellValue(stockq);

			cell = row.createCell(9);
			cell.setCellValue(offern);

			cell = row.createCell(10);
			cell.setCellValue(handtime);

			cell = row.createCell(11);
			cell.setCellValue(free);

			cell = row.createCell(12);
			cell.setCellValue(isdrop);

			cell = row.createCell(13);
			cell.setCellValue(price);

			cell = row.createCell(14);
			cell.setCellValue(datein);

			cell = row.createCell(15);
			cell.setCellValue(maxq);

			cell = row.createCell(16);
			cell.setCellValue(isf);

			cell = row.createCell(17);
			cell.setCellValue(dater);

			cell = row.createCell(18);
			cell.setCellValue(iss);

			cell = row.createCell(19);
			cell.setCellValue(apon);

			cell = row.createCell(20);
			cell.setCellValue(idof);

		}
 

		
	}

	public static void make() {
		ArrayList<comparetool1> old = new ArrayList<>();
		try {
			ArrayList<String[]> ss = ExcelReader.read(readSouqIkea());
			for (String[] s : ss)
				old.add(new comparetool1(s));
		} catch (IOException e1) {
			// TODO Auto-generated catch block

		}
		ArrayList<comparetool1> filter = new ArrayList<>();

		for (int i = 0; i < old.size(); i++) {
			String sku1 = old.get(i).sku1.trim();// 1
			String active6 = old.get(i).active6;// 6
			String price7 = old.get(i).price7.replaceAll("[^0-9.]", "").trim();
			;// 7
			String stock8 = old.get(i).stock8;// 8
			ArrayList<data> currents = data.datas;
//			System.out.println("OKKOO+"+stock8);
			for (int f = 0; f < currents.size(); f++) {
				price7 = currents.get(f).price;
				if (sku1.replaceAll("IK", "").equals(currents.get(f).itemNumber.trim().replaceAll("IK", ""))) {
					String[] row = old.get(i).row;
					int newstock = Integer.parseInt(currents.get(f).stockd) + Integer.parseInt(currents.get(f).stockad);
					if (newstock >= 10)
						newstock = 9;
					else
						newstock = 0;
					int oldstock = Integer.parseInt(stock8);
					if (active6.toUpperCase().equals("YES")) {
						if (oldstock == 0)
							if (newstock == 9) {
								active6 = "NO";
							}
					} else
						active6 = "YES";
					if (newstock == 0)
						price7 = "sold_out";
					row[6] = active6;
					try {
						double prc=Double.parseDouble(price7);
						ArrayList<settingsdata>arr=setttingpanell.rules;
						for(int z=0;z<arr.size();z++)
						{double from=arr.get(z).from;
						double to=arr.get(z).to;
						double factor=arr.get(z).factor;
						if(prc<=to&&prc>=from)
						{prc*=factor;
						System.out.println(prc+"factor"+factor);
							break;
						}
						}
						price7=Double.toString(prc);
					} catch (Exception e) {
						// TODO: handle exception
					}
					row[7] = price7;
					row[8] = Integer.toString(newstock);
					filter.add(new comparetool1(row));
					break;
				}
			}

		}
		try {
			System.out.println(old.size() + "  " + filter.size());
			save(filter, "MAIK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String readSouqaceuae() {

		File f = new File(System.getProperty("user.dir") + "\\Souq_list\\Aceuae");
		f.mkdirs();

		File[] fs = f.listFiles((new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".xlsx");
			}
		}));
		String toread = "";
		for (int i = 0; i < fs.length; i++) {
			String temp = (fs[i].getAbsolutePath());
			toread = (temp);
		}
		return toread;

	}

	public static String readSouqIkea() {

		File f = new File(System.getProperty("user.dir") + "\\Souq_list\\Ikea");
		f.mkdirs();

		File[] fs = f.listFiles((new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".xlsx");
			}
		}));
		String toread = "";
		for (int i = 0; i < fs.length; i++) {
			String temp = (fs[i].getAbsolutePath());
			toread = (temp);
		}
		return toread;

	}
	 

}
