package aceuae;

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
//	data.datas.add(new data("ok","pp"));
	
}
	public static void toexcel(ArrayList<Info> val,boolean iscurrent) throws IOException {
	val.sort((o1, o2) -> Integer.compare(o1.key, o2.key));
	val.sort((o1, o2) -> o1.cat.compareTo(o2.cat));
	HashSet<String>hash=new HashSet<>();
	for(int i=0;i<val.size();i++)hash.add(val.get(i).cat);
	ArrayList<String>sheetnames=new ArrayList<>(hash);
	String path = System.getProperty("user.dir");
//	System.out.println("saving");
		DateFormat dateFormat = new SimpleDateFormat("dd-MMMMM-yyyy(hh-mm-ss a)");
		String date = dateFormat.format(new Date()).toString();String excelFileName="";
		  excelFileName2="";
		  excelFileName = path+"\\"+"ACEUAE";File ff=new File(excelFileName);ff.mkdirs();
		  excelFileName2 = path+"\\"+"ACEUAE\\combined";File ff2=new File(excelFileName2);ff2.mkdirs();
		  excelFileName2 +="\\"+date+"ACEcombined.xlsx";
		  if(!iscurrent)	  
		excelFileName+="\\"+date+"_ACE.xlsx";//name of excel file
		 else excelFileName+="\\current_"+date+"_IK.xlsx";
		XSSFWorkbook wb = new XSSFWorkbook();
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					{XSSFWorkbook wb2 = new XSSFWorkbook();
					ArrayList<Info>y=new ArrayList<>(val);
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
		{ArrayList<Info>y=new ArrayList<>(val);
		
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
	private static void makesheet(XSSFWorkbook wb,String catz,ArrayList<Info>val,boolean filter) {
		if (filter) {
			val.removeIf(s -> !s.cat.equals(catz));
		}
String sheetName = catz;//name of sheet
		
		XSSFSheet sheet = wb.createSheet(sheetName) ;
//		XSSFSheet sheet = wb.createSheet(sheetName);
		CellStyle style = wb.createCellStyle();
		CellStyle style3 = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style3.setAlignment(HorizontalAlignment.CENTER);

		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style3.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
		Font font = wb.createFont();               Font font3 = wb.createFont();
		font.setFontHeightInPoints((short) 11);    font3.setFontHeightInPoints((short) 11);
		font.setBold(true);							font3.setBold(true);
		style.setFont(font);						style3.setFont(font3);

	           CellStyle style2 = wb.createCellStyle();
			      Font font2 = wb.createFont();
			      font2.setBold(true);
			      style2.setAlignment(HorizontalAlignment.CENTER);
		            style2.setFont(font2);
		
		//iterating r number of rows
		XSSFRow row = sheet.createRow(0);XSSFCell cell;
		{ 
			cell = row.createCell(0);
			cell.setCellStyle(style);
			cell.setCellValue("	Category	 	".trim());

			cell = row.createCell(1);
			cell.setCellStyle(style);
			cell.setCellValue("	Sub-category	 	".trim());

			cell = row.createCell(2);
			cell.setCellStyle(style);
			cell.setCellValue("	Sub-sub-category	 	".trim());

			cell = row.createCell(3);
			cell.setCellStyle(style);
			cell.setCellValue("	tag1	 	".trim());

			cell = row.createCell(4);
			cell.setCellStyle(style);
			cell.setCellValue("	tag2	 	".trim());

			cell = row.createCell(5);
			cell.setCellStyle(style);
			cell.setCellValue("	Brand name	 	".trim());

			cell = row.createCell(6);
			cell.setCellStyle(style);
			cell.setCellValue("	Product name	 	".trim());

			cell = row.createCell(7);
			cell.setCellStyle(style);
			cell.setCellValue("	Price	 	".trim());

			cell = row.createCell(8);
			cell.setCellStyle(style);
			cell.setCellValue("	Old price	 	".trim());

			cell = row.createCell(9);
			cell.setCellStyle(style);
			cell.setCellValue("	SKU	 	".trim());

			cell = row.createCell(10);
			cell.setCellStyle(style);
			cell.setCellValue("	stock	 	".trim());

			cell = row.createCell(11);
			cell.setCellStyle(style);
			cell.setCellValue("	Description	 	".trim());

			cell = row.createCell(12);
			cell.setCellStyle(style);
			cell.setCellValue("	Keypoints	 	".trim());

			cell = row.createCell(13);
			cell.setCellStyle(style);
			cell.setCellValue("	Specification	 	".trim());

			cell = row.createCell(14);
			cell.setCellStyle(style);
			cell.setCellValue("	Weight	 	".trim());

			cell = row.createCell(15);
			cell.setCellStyle(style);
			cell.setCellValue("	imageurl	 	".trim());

			cell = row.createCell(16);
			cell.setCellStyle(style);
			cell.setCellValue("	URL	 	".trim());

			cell = row.createCell(17);
			cell.setCellStyle(style);
			cell.setCellValue("	Description (Tag)	 	".trim());

		
		}
		for (int r=0;r < val.size(); r++ )
			if(!val.get(r).cat .isEmpty()&&!val.get(r).cat .equals("-"))
		{
			  row = sheet.createRow(r+1);

			//iterating c number of columns
		//	for (int c=0;c < 7; c++ )
			  
			{
				String 		cat	 =val.get(r).	cat	;
				String		scat	 =val.get(r).	scat	;
				String		sscat	 =val.get(r).	sscat	;
				String		tag1	 =val.get(r).	tag1	;
				String		tag2	 =val.get(r).	tag2	;
				String		brandname	 =val.get(r).	brandname	;
				String		productname	 =val.get(r).	productname	;
				String		price	 =val.get(r).	price	;
				String		orginalprice	 =val.get(r).	orginalprice	;
				String		sku	 =val.get(r).	sku	;
				boolean		stock	 =val.get(r).	stock	;
				 
				String		url 	 =val.get(r).	url 	;
			 

	   
				cell = row.createCell(	0	);	cell.setCellValue(	cat	 );           cell.setCellStyle(style3);
				cell = row.createCell(	1	);	cell.setCellValue(	scat	 );           cell.setCellStyle(style3);
				cell = row.createCell(	2	);	cell.setCellValue(	sscat	 );           cell.setCellStyle(style3);
				cell = row.createCell(	3	);	cell.setCellValue(	tag1	 );           cell.setCellStyle(style3);
				cell = row.createCell(	4	);	cell.setCellValue(	tag2	 );           cell.setCellStyle(style3);
				cell = row.createCell(	5	);	cell.setCellValue(	brandname	 );         
				cell = row.createCell(	6	);	cell.setCellValue(	productname	 );        
				cell = row.createCell(	7	);	cell.setCellValue(	price	 );           
				cell = row.createCell(	8	);	cell.setCellValue(	orginalprice	 );      
				cell = row.createCell(	9	);	cell.setCellValue(	sku	 );            
				cell = row.createCell(	10	);	cell.setCellValue(	stock	 );            
				cell = row.createCell(	11	);	cell.setCellValue(	val.get(r).des	 );           cell.setCellStyle(style3);
				cell = row.createCell(	12	);	cell.setCellValue(	val.get(r).keypoints	 );           cell.setCellStyle(style3);
				cell = row.createCell(	13	);	cell.setCellValue(	val.get(r).specs	 );           cell.setCellStyle(style3);
				cell = row.createCell(	14	);	cell.setCellValue(val.get(r).	weight	 );           cell.setCellStyle(style3);
				cell = row.createCell(	15	);	cell.setCellValue(	val.get(r).imageurl	 );           cell.setCellStyle(style3);
				cell = row.createCell(	16	);	cell.setCellValue(	url 	 );           cell.setCellStyle(style3);
				cell = row.createCell(	17	);	cell.setCellValue(	val.get(r).deswithtags 	 );           cell.setCellStyle(style3);

				
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
