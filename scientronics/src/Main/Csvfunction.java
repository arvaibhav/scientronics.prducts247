package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import marksandspencer.com.data;
import marksandspencer.com.urldata;

public class Csvfunction {
 
	public static void main(String[] args) {
		LocalDate start = LocalDate.of( 2016 , 1 , 1 ) ;
		LocalDate stop = LocalDate.of( 2019 , 1 , 23 ) ;
		LocalDate today = LocalDate.of(2018,1,20);
		Boolean containsToday = ( ! today.isBefore( start ) ) && ( today.isBefore( stop ) ) ;
		System.out.println(containsToday);
	}
	
	
	
public static ArrayList<String> Listdates()
{ArrayList<String>name=new ArrayList<>(2000);
	try {
		File f=new File(System.getProperty("user.dir") + "\\CSV");
		f.mkdir();
		 
		File[]fs=f.listFiles((new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".csv");
		    }
		}));
		
		for (int i = 0; i < fs.length; i++) {
			String temp=(fs[i].getName());
			name.add(temp.substring(0,temp.lastIndexOf(".")));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
return name;
}
public static ArrayList<data> readcsv(String name) throws IOException
{ArrayList<data>temp=new ArrayList<>(80000);
	long start = System.currentTimeMillis();
	
		
	int count = 0;
	try (Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "\\CSV\\"+name+".csv"));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
		for (CSVRecord csvRecord : csvParser) {
			// Accessing Values by Column Index
			if (count++ > 0) {
				 
				String handel=csvRecord.get(0);
				String title=csvRecord.get(1);
				String producturl=csvRecord.get(2);
				String collection=csvRecord.get(3);
				String model=csvRecord.get(4);
				String type=csvRecord.get(5);
				String category=csvRecord.get(6);
				String subcategory=csvRecord.get(7);
				String price=csvRecord.get(8);
				String color=csvRecord.get(9);
				String size=csvRecord.get(10);
				String stypedecription=csvRecord.get(11);
				String img1=csvRecord.get(12);
				String img2=csvRecord.get(13);
				String img3=csvRecord.get(14);
				String img4=csvRecord.get(15);
				temp.add(new data(title, producturl, collection, model, type, category, subcategory, price, color, size, stypedecription, img1, img2, img3, img4,handel,count));
			}

		}
	}
	long end = System.currentTimeMillis();
	 NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
		return temp;
}
public static void writecsv(String name,ArrayList<data>datas) throws IOException
{
	 File chkdir=new File(System.getProperty("user.dir") + "\\CSV");
	chkdir.mkdir();
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get( System.getProperty("user.dir") + "\\CSV\\"+name+".csv"));

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Handel","Title","URL","Collection","Model/EAN/SKU","Type","Category","Sub Category","Price","Color","Size","StyleDescriptions","Img1","Img2","Img3","Img4"));) {

		for (int i = 0; i < datas.size(); i++) {
			String handel=datas.get(i).title.toLowerCase().replaceAll(" ","-");
			String title=datas.get(i).title;
			String producturl=datas.get(i).producturl;
			String collection=datas.get(i).collection;
			String model=datas.get(i).model;
			String type=datas.get(i).type;
			String category=datas.get(i).category;
			String subcategory=datas.get(i).subcategory;
			String price=datas.get(i).price;
			String color=datas.get(i).color;
			String size=datas.get(i).size;
			String stypedecription=datas.get(i).stypedecription;
			String img1=datas.get(i).img1;
			String img2=datas.get(i).img2;
			String img3=datas.get(i).img3;
			String img4=datas.get(i).img4;
			 
			csvPrinter.printRecord(handel, title, producturl, collection, model, type, category, subcategory, price, color, size, stypedecription, img1, img2, img3, img4 ); 
		}

		csvPrinter.flush();
	 
}}
}
