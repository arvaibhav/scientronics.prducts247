package aceuae;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.io.File;
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
import Main.site3panel;

public class Csv {
static String[][]clr= {{"Outdoor & Garden","Garden_&_Outdoor"}, {"DIY & Tools","Hardware_&_Electrical"}, {"Car","Automotive"}, {"Electrical & Security","Hardware_&_Electrical"},  {"Kids","Kids_Zone"},{"Pets","PetWorld"}};	
    private static final String SAMPLE_CSV_FILE = "./sample.csv";
public static void main(String[] args) {
	   
	Main2.Start();
	 System.err.println(datastorage.cats.size());
//	 HashSet<String>hash=new HashSet<>();
//	 for(Subcat s:Subcat.sss)hash.add(s.subcaturls);
//	 System.out.println(hash.size());hash.clear();
// 
//	 ArrayList<Subcat>ss=new ArrayList<>();
//	 ss.add(datastorage.cats.get(0));
//datastorage.cats=ss;
 makeThreads2.start();
}
//    public static void save() throws IOException {
//    	
//    	datastorage.fpurl.sort( (p1, p2) -> p1.key - p2.key);
//    	HashSet<More>hh=new LinkedHashSet<>(2000);
//    	HashSet<String>z=new LinkedHashSet<>(2000);
//    	HashSet<String>sc=new LinkedHashSet<>(2000);
//    	HashSet<String>ssc=new LinkedHashSet<>(2000);
//    	HashSet<String>urlz=new LinkedHashSet<>(2000);
//    	for(int i=0;i<datastorage.fpurl.size();i++)
//    	{
//    		String cat =datastorage.fpurl.get(i).cat,subcat=datastorage.fpurl.get(i).subcat,  subsubcat=datastorage.fpurl.get(i).subsubcat,producturl=datastorage.fpurl.get(i).producturl;
//    		ArrayList<String>tags=datastorage.fpurl.get(i).tags;
//    		int Sc=z.size(),Ssc=sc.size(),Sssc=ssc.size(),Surl=urlz.size();
//    		z.add(cat);sc.add(subcat);ssc.add(subsubcat);urlz.add(producturl);
//    		if((Sc!=z.size())||(Ssc!=sc.size())||(Sc!=z.size())||(Sssc!=ssc.size())||(Surl!=urlz.size()))
//    		hh.add(new More(cat, subcat, subsubcat, tags, producturl));
//    	}
//    	datastorage.fpurl=new ArrayList<>(hh);
//       
//             for(int i=0;i<datastorage.fpurl.size();i++)
//             {
//            		String cat =datastorage.fpurl.get(i).cat,subcat=datastorage.fpurl.get(i).subcat,  subsubcat=datastorage.fpurl.get(i).subsubcat,producturl=datastorage.fpurl.get(i).producturl;
//            		ArrayList<String>tags=datastorage.fpurl.get(i).tags;
//            	    String tag1="-",tag2="-";
//            	    int c=tags.size();
//            	    if(c==1)tag1=tags.get(0).replaceAll(" ","_");
//            	    else if(c==2) {tag1=tags.get(0).replaceAll(" ","_").toUpperCase();tag2=tags.get(1).replaceAll(" ","_").toUpperCase();}
//            	    
//            	    for(int j=0;j<clr.length;j++)
//            	    {if(cat.equalsIgnoreCase(clr[j][0]))
//            	    	cat=(clr[j][1]);
//            	    }
//            	    
//            	    cat=cat.trim().replaceAll(" ","_").toUpperCase();
//            	    
//            	    subcat=subcat.replaceAll(" ","_").toUpperCase();
//            	    subsubcat=subsubcat.replaceAll(" ","_").toUpperCase();
//            	     
//            	      
//             }
//         
//                   
//        
//    }
	public static void save() throws IOException {
		datastorage.fpurl.sort((p1, p2) -> p1.key - p2.key);
		HashSet<More> hh = new LinkedHashSet<>(2000);
		HashSet<String> z = new LinkedHashSet<>(2000);
		HashSet<String> sc = new LinkedHashSet<>(2000);
		HashSet<String> ssc = new LinkedHashSet<>(2000);
		HashSet<String> urlz = new LinkedHashSet<>(2000);
		for (int i = 0; i < datastorage.fpurl.size(); i++) {
			String cat = datastorage.fpurl.get(i).cat, subcat = datastorage.fpurl.get(i).subcat,
					subsubcat = datastorage.fpurl.get(i).subsubcat, producturl = datastorage.fpurl.get(i).producturl;
			ArrayList<String> tags = datastorage.fpurl.get(i).tags;
			int Sc = z.size(), Ssc = sc.size(), Sssc = ssc.size(), Surl = urlz.size();
			z.add(cat);
			sc.add(subcat);
			ssc.add(subsubcat);
			urlz.add(producturl);
			if ((Sc != z.size()) || (Ssc != sc.size()) || (Sc != z.size()) || (Sssc != ssc.size())
					|| (Surl != urlz.size()))
				hh.add(new More(cat, subcat, subsubcat, tags, producturl));
		}

		ArrayList<More> val = new ArrayList<>(hh);

		String path = System.getProperty("user.dir");
		String excelFileName = "";

		excelFileName = path + "\\data\\" + "aceuae";
		File ff = new File(excelFileName);
		ff.mkdirs();

		excelFileName += "\\category_MAP_ACE.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook();

		makesheet(wb, "MAPPING", val);

		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);

		fileOut.flush();
		fileOut.close();
		site3panel.pbar1.setValue(site3panel.pbar1.getMaximum());
	}
	public static void save2() throws IOException {
		datastorage.purls.sort((p1, p2) -> p1.key - p2.key);
 
		String path = System.getProperty("user.dir");
		String excelFileName = "";

		excelFileName = path + "\\data\\" + "aceuae";
		File ff = new File(excelFileName);
		ff.mkdirs();

		excelFileName += "\\productsurl_MAP_ACE.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook();

		makesheet2(wb, "MAPPING", datastorage.purls);

		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);

		fileOut.flush();
		fileOut.close();
		site3panel.pbar1.setValue(site3panel.pbar1.getMaximum());
	}

	
	public static void save3() throws IOException {
		datastorage.purls.sort((p1, p2) -> p1.key - p2.key);
 
		String path = System.getProperty("user.dir");
		String excelFileName = "";

		excelFileName = path + "\\ACEUAE\\" + "aceuae";
		File ff = new File(excelFileName);
		ff.mkdirs();

		excelFileName += "\\productsurl_MAP_ACE.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook();

		makesheet2(wb, "MAPPING", datastorage.purls);

		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);

		fileOut.flush();
		fileOut.close();
		site3panel.pbar1.setValue(site3panel.pbar1.getMaximum());
	}

	
	
	private static void makesheet(XSSFWorkbook wb, String catt, ArrayList<More> val) {
		datastorage.fpurl.clear();
		String sheetName = catt;// name of sheet

		XSSFSheet sheet = wb.createSheet(sheetName);
		CellStyle style = wb.createCellStyle();
		CellStyle style3 = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style3.setAlignment(HorizontalAlignment.CENTER);

		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style3.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = wb.createFont();
		Font font3 = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font3.setFontHeightInPoints((short) 11);
		font.setBold(true);
		font3.setBold(true);
		style.setFont(font);
		style3.setFont(font3);

		CellStyle style2 = wb.createCellStyle();
		Font font2 = wb.createFont();
		font2.setBold(true);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setFont(font2);
		// iterating r number of rows
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;

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

		for (int r = 0; r < val.size(); r++) {
			row = sheet.createRow(r + 1);

			{

				String cat = val.get(r).cat, subcat = val.get(r).subcat, subsubcat = val.get(r).subsubcat,
						producturl = val.get(r).producturl;
				ArrayList<String> tags = val.get(r).tags;
				String tag1 = "-", tag2 = "-";
				int c = tags.size();
				if (c == 1)
					tag1 = tags.get(0).replaceAll(" ", "_");
				else if (c == 2) {
					tag1 = tags.get(0).replaceAll(" ", "_").toUpperCase();
					tag2 = tags.get(1).replaceAll(" ", "_").toUpperCase();
				}

				for (int j = 0; j < clr.length; j++) {
					if (cat.equalsIgnoreCase(clr[j][0]))
						cat = (clr[j][1]);
				}

				cat = cat.trim().replaceAll(" ", "_").toUpperCase();

				subcat = subcat.replaceAll(" ", "_").toUpperCase();
				subsubcat = subsubcat.replaceAll(" ", "_").toUpperCase();

				cell = row.createCell(0);
				cell.setCellValue(cat);
				cell.setCellStyle(style3);
				cell = row.createCell(1);
				cell.setCellValue(subcat);
				cell.setCellStyle(style3);
				cell = row.createCell(2);
				cell.setCellValue(subsubcat);
				cell.setCellStyle(style3);
				cell = row.createCell(3);
				cell.setCellValue(tag1);
				cell = row.createCell(4);
				cell.setCellValue(tag2);
				cell = row.createCell(5);
				cell.setCellValue(producturl);
				datastorage.fpurl.add(new More(cat, subcat, subsubcat, tag1, tag2, producturl));

			}
		}
		Double vv = (41 / 1500.0);

		sheet.setColumnWidth(0, (int) (250 / vv));

		sheet.setColumnWidth(1, (int) (250 / vv));

		sheet.setColumnWidth(2, (int) (250 / vv));

		sheet.setColumnWidth(3, (int) (250 / vv));
		sheet.setColumnWidth(4, (int) (250 / vv));

		sheet.setColumnWidth(5, (int) (600 / vv));

	}
	private static void makesheet3(XSSFWorkbook wb,String catt,ArrayList<Info>val) {
		 
		String sheetName = catt;// name of sheet

		XSSFSheet sheet = wb.createSheet(sheetName);
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
		 
		cell = row.createCell(	0	);cell.setCellStyle(style);	cell.setCellValue( "	Category	 	".trim());

		cell = row.createCell(	1	);cell.setCellStyle(style);	cell.setCellValue( "	Sub-category	 	".trim());

		cell = row.createCell(	2	);cell.setCellStyle(style);	cell.setCellValue( "	Sub-sub-category	 	".trim());

		cell = row.createCell(	3	);cell.setCellStyle(style);	cell.setCellValue( "	tag1	 	".trim());

		cell = row.createCell(	4	);cell.setCellStyle(style);	cell.setCellValue( "	tag2	 	".trim());

		cell = row.createCell(	5	);cell.setCellStyle(style);	cell.setCellValue( "	Brand name	 	".trim());

		cell = row.createCell(	6	);cell.setCellStyle(style);	cell.setCellValue( "	Product name	 	".trim());

		cell = row.createCell(	7	);cell.setCellStyle(style);	cell.setCellValue( "	Price	 	".trim());

		cell = row.createCell(	8	);cell.setCellStyle(style);	cell.setCellValue( "	Old price	 	".trim());

		cell = row.createCell(	9	);cell.setCellStyle(style);	cell.setCellValue( "	SKU	 	".trim());

		cell = row.createCell(	10	);cell.setCellStyle(style);	cell.setCellValue( "	stock	 	".trim());

		cell = row.createCell(	11	);cell.setCellStyle(style);	cell.setCellValue( "	Description	 	".trim());

		cell = row.createCell(	12	);cell.setCellStyle(style);	cell.setCellValue( "	Keypoints	 	".trim());

		cell = row.createCell(	13	);cell.setCellStyle(style);	cell.setCellValue( "	Specification	 	".trim());

		cell = row.createCell(	14	);cell.setCellStyle(style);	cell.setCellValue( "	Weight	 	".trim());

		cell = row.createCell(	15	);cell.setCellStyle(style);	cell.setCellValue( "	imageurl	 	".trim());

		cell = row.createCell(	16	);cell.setCellStyle(style);	cell.setCellValue( "	URL	 	".trim());

		cell = row.createCell(	17	);cell.setCellStyle(style);	cell.setCellValue( "	Description (Tag)	 	".trim());


		 
		for (int r=0;r < val.size(); r++ )
		{
			  row = sheet.createRow(r+1);
 
		{
			String		cat	 =val.get(r).	cat	;
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
		
		sheet.setColumnWidth( 	0	, (int) (250 / vv));
		sheet.setColumnWidth( 	1	, (int) (250 / vv));
		sheet.setColumnWidth( 	2	, (int) (250 / vv));
		sheet.setColumnWidth( 	3	, (int) (250 / vv));
		sheet.setColumnWidth( 	4	, (int) (250 / vv));
		sheet.setColumnWidth( 	5	, (int) (250 / vv));
		sheet.setColumnWidth( 	6	, (int) (250 / vv));
		sheet.setColumnWidth( 	7	, (int) (250 / vv));
		sheet.setColumnWidth( 	8	, (int) (250 / vv));
		sheet.setColumnWidth( 	9	, (int) (250 / vv));
		sheet.setColumnWidth( 	10	, (int) (250 / vv));
		sheet.setColumnWidth( 	11	, (int) (250 / vv));
		sheet.setColumnWidth( 	12	, (int) (250 / vv));
		sheet.setColumnWidth( 	13	, (int) (250 / vv));
		sheet.setColumnWidth( 	14	, (int) (250 / vv));
		sheet.setColumnWidth( 	15	, (int) (250 / vv));
		sheet.setColumnWidth( 	16	, (int) (250 / vv));

		sheet.setColumnWidth(17, (int) (600 / vv));


		 
		 
		 
	}
	private static void makesheet2(XSSFWorkbook wb,String catt,ArrayList<productsurls>val) {
		 
		String sheetName = catt;// name of sheet

		XSSFSheet sheet = wb.createSheet(sheetName);
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
		 
		cell = row.createCell(	0	);cell.setCellStyle(style);	cell.setCellValue( "	Category	 	".trim());

		cell = row.createCell(	1	);cell.setCellStyle(style);	cell.setCellValue( "	Sub-category	 	".trim());

		cell = row.createCell(	2	);cell.setCellStyle(style);	cell.setCellValue( "	Sub-sub-category	 	".trim());

		cell = row.createCell(	3	);cell.setCellStyle(style);	cell.setCellValue( "	tag1	 	".trim());

		cell = row.createCell(	4	);cell.setCellStyle(style);	cell.setCellValue( "	tag2	 	".trim());

		cell = row.createCell(	5	);cell.setCellStyle(style);	cell.setCellValue( "	Brand name	 	".trim());

		cell = row.createCell(	6	);cell.setCellStyle(style);	cell.setCellValue( "	Product name	 	".trim());

		cell = row.createCell(	7	);cell.setCellStyle(style);	cell.setCellValue( "	Price	 	".trim());

		cell = row.createCell(	8	);cell.setCellStyle(style);	cell.setCellValue( "	Old price	 	".trim());

		cell = row.createCell(	9	);cell.setCellStyle(style);	cell.setCellValue( "	SKU	 	".trim());

		cell = row.createCell(	10	);cell.setCellStyle(style);	cell.setCellValue( "	stock	 	".trim());

		cell = row.createCell(	11	);cell.setCellStyle(style);	cell.setCellValue( "	Description	 	".trim());

		cell = row.createCell(	12	);cell.setCellStyle(style);	cell.setCellValue( "	Keypoints	 	".trim());

		cell = row.createCell(	13	);cell.setCellStyle(style);	cell.setCellValue( "	Specification	 	".trim());

		cell = row.createCell(	14	);cell.setCellStyle(style);	cell.setCellValue( "	Weight	 	".trim());

		cell = row.createCell(	15	);cell.setCellStyle(style);	cell.setCellValue( "	imageurl	 	".trim());

		cell = row.createCell(	16	);cell.setCellStyle(style);	cell.setCellValue( "	URL	 	".trim());

		cell = row.createCell(	17	);cell.setCellStyle(style);	cell.setCellValue( "	Description (Tag)	 	".trim());


		 
		for (int r=0;r < val.size(); r++ )
		{
			  row = sheet.createRow(r+1);
 
		{
			String		cat	 =val.get(r).	cat	;
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
//			cell = row.createCell(	11	);	cell.setCellValue(	des	 );           cell.setCellStyle(style3);
//			cell = row.createCell(	12	);	cell.setCellValue(	keypoints	 );           cell.setCellStyle(style3);
//			cell = row.createCell(	13	);	cell.setCellValue(	specs	 );           cell.setCellStyle(style3);
//			cell = row.createCell(	14	);	cell.setCellValue(	weight	 );           cell.setCellStyle(style3);
//			cell = row.createCell(	15	);	cell.setCellValue(	imageurl	 );           cell.setCellStyle(style3);
			cell = row.createCell(	16	);	cell.setCellValue(	url 	 );           cell.setCellStyle(style3);
//			cell = row.createCell(	17	);	cell.setCellValue(	deswithtags 	 );           cell.setCellStyle(style3);

				  
				
			}
		}
		Double vv = (41 / 1500.0);
		
		sheet.setColumnWidth( 	0	, (int) (250 / vv));
		sheet.setColumnWidth( 	1	, (int) (250 / vv));
		sheet.setColumnWidth( 	2	, (int) (250 / vv));
		sheet.setColumnWidth( 	3	, (int) (250 / vv));
		sheet.setColumnWidth( 	4	, (int) (250 / vv));
		sheet.setColumnWidth( 	5	, (int) (250 / vv));
		sheet.setColumnWidth( 	6	, (int) (250 / vv));
		sheet.setColumnWidth( 	7	, (int) (250 / vv));
		sheet.setColumnWidth( 	8	, (int) (250 / vv));
		sheet.setColumnWidth( 	9	, (int) (250 / vv));
		sheet.setColumnWidth( 	10	, (int) (250 / vv));
		sheet.setColumnWidth( 	11	, (int) (250 / vv));
		sheet.setColumnWidth( 	12	, (int) (250 / vv));
		sheet.setColumnWidth( 	13	, (int) (250 / vv));
		sheet.setColumnWidth( 	14	, (int) (250 / vv));
		sheet.setColumnWidth( 	15	, (int) (250 / vv));
		sheet.setColumnWidth( 	16	, (int) (250 / vv));

		sheet.setColumnWidth(17, (int) (600 / vv));


		 
		 
		 
	}
	 
}