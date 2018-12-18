package ikea.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Main.UI;


public class Excel {
	static String excelFileName2="";
public static void main(String[] args) throws IOException {
	data.datas.add(new data("ok","pp"));
	
}
	public static void toexcel(ArrayList<data> val,boolean iscurrent) throws IOException {
	val.sort((o1, o2) -> Integer.compare(o1.key, o2.key));
	val.sort((o1, o2) -> o1.cat.compareTo(o2.cat));
	HashSet<String>hash=new HashSet<>();
	for(int i=0;i<val.size();i++)hash.add(val.get(i).cat);
	ArrayList<String>sheetnames=new ArrayList<>(hash);
	String path = System.getProperty("user.dir");
	System.out.println("saving");
		DateFormat dateFormat = new SimpleDateFormat("dd-MMMMM-yyyy(hh-mm-ss a)");
		String date = dateFormat.format(new Date()).toString();String excelFileName="";
		  excelFileName2="";
		  excelFileName = path+"\\"+"IKEA";File ff=new File(excelFileName);ff.mkdirs();
		  excelFileName2 = path+"\\"+"IKEA\\combined";File ff2=new File(excelFileName2);ff2.mkdirs();
		  excelFileName2 +="\\"+date+"IKcombined.xlsx";
		  if(!iscurrent)	  
		excelFileName+="\\"+date+".xlsx";//name of excel file
		 else excelFileName+="\\current_"+date+"_IK.xlsx";
		XSSFWorkbook wb = new XSSFWorkbook();
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					{XSSFWorkbook wb2 = new XSSFWorkbook();
					ArrayList<data>y=new ArrayList<>(val);
makesheet(wb2,"combined",y,false);
 FileOutputStream fileOut2 = new FileOutputStream(excelFileName2);
					wb2.write(fileOut2);
					fileOut2.flush();
					fileOut2.close();
}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});t.start();
		for(String cat:sheetnames)
		{ArrayList<data>y=new ArrayList<>(val);
		
		try {if(!cat.isEmpty()&&!cat.equals("-"))
			{if(cat.length()>=30)cat.substring(0, 30);
			try {cat=cat.replaceAll("/","").replaceAll("\\","");} catch (Exception e) {}
			makesheet(wb,cat.replaceAll("[:?*;]", ""),y,true);
			}
		} catch (Exception e) {
			cat=cat.replaceAll("[^\\w\\s]","");
			if(cat.isEmpty())cat="category";
			makesheet(wb,cat,y,true);
			e.printStackTrace();
		}
		}
	    FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	private static void makesheet(XSSFWorkbook wb,String cat,ArrayList<data>val,boolean filter) {
		if (filter) {
			val.removeIf(s -> !s.cat.equals(cat));
		}
String sheetName = cat;//name of sheet
		
		XSSFSheet sheet = wb.createSheet(sheetName) ;
		CellStyle style = wb.createCellStyle();
		 style.setAlignment(HorizontalAlignment.CENTER);
			System.out.println("5");
		       style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	       style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	  
	    
		      Font font = wb.createFont();
	        font.setFontHeightInPoints((short)11);
	         font.setBold(true);
	           style.setFont(font);


	           CellStyle style2 = wb.createCellStyle();
			      Font font2 = wb.createFont();
			      font2.setBold(true);
			      style2.setAlignment(HorizontalAlignment.CENTER);
		            style2.setFont(font2);
		//iterating r number of rows
		XSSFRow row = sheet.createRow(0);XSSFCell cell;
		{ 
		  cell = row.createCell(0);cell.setCellStyle(style);
		cell.setCellValue("Type");
		
		  cell = row.createCell(1);cell.setCellStyle(style);
		cell.setCellValue("Collection");
		  cell = row.createCell(2);cell.setCellStyle(style);
		cell.setCellValue("Tag");
		  cell = row.createCell(3);cell.setCellStyle(style);
		cell.setCellValue("Item Number");
		  cell = row.createCell(4);cell.setCellStyle(style);
		cell.setCellValue("Brand");
		  cell = row.createCell(5);cell.setCellStyle(style);
		cell.setCellValue("Product Title");
		cell = row.createCell(6);cell.setCellStyle(style);
		cell.setCellValue("Price");
		cell = row.createCell(7);cell.setCellStyle(style);
		cell.setCellValue("Per unit");
		
		cell = row.createCell(8);cell.setCellStyle(style);
		cell.setCellValue("Variant");
		
		cell = row.createCell(9);cell.setCellStyle(style);
		cell.setCellValue("Description");
		cell = row.createCell(10);cell.setCellStyle(style);
		cell.setCellValue("Product Information");
		cell = row.createCell(11);cell.setCellStyle(style);
		cell.setCellValue("Material Information");
		cell = row.createCell(12);cell.setCellStyle(style);
		cell.setCellValue("Dimension");
		cell = row.createCell(13);cell.setCellStyle(style);
		cell.setCellValue("Stock Dubai");
		cell = row.createCell(14);cell.setCellStyle(style);
		cell.setCellValue("Abu Dhabi");

		
		cell = row.createCell(15);cell.setCellStyle(style);
		cell.setCellValue("Note");
		cell = row.createCell(16);cell.setCellStyle(style);
		cell.setCellValue("Img Urls");
		cell = row.createCell(17);cell.setCellStyle(style);
		cell.setCellValue("Product url");
		cell = row.createCell(18);cell.setCellStyle(style);
		cell.setCellValue("sku wihtout 'IK'");
		 
		
		}
		for (int r=0;r < val.size(); r++ )
			if(!val.get(r).cat .isEmpty()&&!val.get(r).cat .equals("-"))
		{
			  row = sheet.createRow(r+1);

			//iterating c number of columns
		//	for (int c=0;c < 7; c++ )
			  
			{
				 cell = row.createCell(0);
					cell.setCellValue(val.get(r).cat ); 


		 cell = row.createCell(1);
					cell.setCellValue(val.get(r) .subcat); 


		 cell = row.createCell(2);
					cell.setCellValue(val.get(r) .subsubcat); 


		 cell = row.createCell(3);
					cell.setCellValue(val.get(r) .itemNumber); 


		 cell = row.createCell(4);
					cell.setCellValue(val.get(r).productName ); 


		 cell = row.createCell(5);
					cell.setCellValue(val.get(r) .productType); 


		 cell = row.createCell(6);
					cell.setCellValue(val.get(r).price ); 


		 cell = row.createCell(7);
					cell.setCellValue(val.get(r).per ); 


					 cell = row.createCell(8);
						cell.setCellValue(val.get(r).variant_type); 			
					
					
		 cell = row.createCell(9);
					cell.setCellValue(val.get(r).description); 


		 cell = row.createCell(10);
					cell.setCellValue(val.get(r).productinformation ); 


		 cell = row.createCell(11);
					cell.setCellValue(val.get(r) .materialinformation); 


		 cell = row.createCell(12);
					cell.setCellValue(val.get(r) .dimensions); 


		 cell = row.createCell(13);
		 try {
				cell.setCellValue(Integer.parseInt(val.get(r) .stockd));
			} catch (Exception e) {
				cell.setCellValue(val.get(r) .stockd); 
			} 



		 cell = row.createCell(14);
					try {
						cell.setCellValue(Integer.parseInt(val.get(r) .stockad));
					} catch (Exception e) {
						cell.setCellValue(val.get(r) .stockad); 
					} 


		 cell = row.createCell(15);
					cell.setCellValue(val.get(r) .note); 


		 cell = row.createCell(16);
					cell.setCellValue(val.get(r) .imgurls); 


		 cell = row.createCell(17);
					cell.setCellValue(val.get(r) .vurl); 


		 cell = row.createCell(18);
					cell.setCellValue(val.get(r).itemNumber.replaceAll("IK","") ); 



				  
				
			}
		}
		Double vv = (41 / 1500.0);
		
		sheet.setColumnWidth(0, (int) (140 / vv));


		sheet.setColumnWidth(1, (int) (180 / vv));


		sheet.setColumnWidth(2, (int) (200 / vv));


		sheet.setColumnWidth(3, (int) (90 / vv));


		sheet.setColumnWidth(4, (int) (110 / vv));


		sheet.setColumnWidth(5, (int) (300 / vv));


		sheet.setColumnWidth(6, (int) (65 / vv));


		sheet.setColumnWidth(7, (int) (80 / vv));


		sheet.setColumnWidth(8, (int) (250 / vv));


		sheet.setColumnWidth(9, (int) (250 / vv));


		sheet.setColumnWidth(10, (int) (150 / vv));


		sheet.setColumnWidth(11, (int) (350 / vv));


		sheet.setColumnWidth(12, (int) (100 / vv));


		sheet.setColumnWidth(13, (int) (100 / vv));


		sheet.setColumnWidth(14, (int) (240 / vv));


		sheet.setColumnWidth(15, (int) (100 / vv));


		sheet.setColumnWidth(16, (int) (100 / vv));


		sheet.setColumnWidth(17, (int) (100 / vv));

		sheet.setColumnWidth(18, (int) (100 / vv));

		 
	}
}
