package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

//import marksandspencer.com.data;

public class settingsdata {
	public	double from=0;
	public	double to=0;
	public double factor=0;
	
	public settingsdata(double from, double to, double factor) {
		super();
		this.from = from;
		this.to = to;
		this.factor = factor;
	}
	static int count=1;
	public static void addrule(String froms, String tos, String factors) {
		 System.out.println("from"+froms);
		if(!setttingpanell.rules.isEmpty())
		{ 
		try {
			double from = Double.parseDouble(froms);
			double to =  Double.parseDouble(tos);
			double factor =  Double.parseDouble(factors);
//			System.err.println(setttingpanell.rules.get(setttingpanell.rules.size()-1).to);
			if (to>setttingpanell.rules.get(setttingpanell.rules.size()-1).to) {
				if (to > from && factor > 0) {
					setttingpanell.model.addRow(new Object[] { settingsdata.count++, from, to, factor });
					
					setttingpanell.rules.add(new settingsdata(from, to, factor));
					System.out.println("size "+setttingpanell.rules.size());
				} 
			}
		} catch (NumberFormatException e) {}
		}else{
			try {
				double from = Double.parseDouble(froms);
				double to =  Double.parseDouble(tos);
				double factor =  Double.parseDouble(factors);
//				
//				if (this.to>setttingpanell.rules.get(setttingpanell.rules.size()-1).to) {
				if (to > from && factor > 0) {
					setttingpanell.model.addRow(new Object[] { settingsdata.count++, from, to, factor });
					setttingpanell.rules.add(new settingsdata(from, to, factor));
					System.out.println("size "+setttingpanell.rules.size());
				} 
			} catch (NumberFormatException e) {}
			}}
	
	
	
	
	public static ArrayList<settingsdata> readrule( ) throws IOException
	{ArrayList<settingsdata>temp=new ArrayList<>(80000);
		long start = System.currentTimeMillis();
		File ch=new File(System.getProperty("user.dir") + "\\data\\"+"rule"+".csv");
		if(!ch.exists())
		{ 
		 addrule("0", "150", "0.25");
		 addrule("151", "150000", "1.25");
		writerule( setttingpanell.rules);	
//		System.err.println("size paa"+te.size());
		return null;
		}
			
		int count = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "\\data\\"+"rule"+".csv"));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
		 
			for (CSVRecord csvRecord : csvParser) {
				
				// Accessing Values by Column Index
				if (count++ > 0) {
//					System.err.println("here");
//					String handel=csvRecord.get(0);
				try {
						System.err.println("value "+ csvRecord.get(0));
					addrule( csvRecord.get(0), csvRecord.get(1), csvRecord.get(2));
				} catch (NumberFormatException e) {e.printStackTrace();}
				
				}

			}
		}
		long end = System.currentTimeMillis();
//		 NumberFormat formatter = new DecimalFormat("#0.00000");
//			System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
			return temp;
	}
	public static void writerule( ArrayList<settingsdata>datas) throws IOException
	{System.err.println("write size"+datas.size());
		 File chkdir=new File(System.getProperty("user.dir") +"\\data");
		chkdir.mkdir();
			try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(System.getProperty("user.dir") +"\\data\\"+"rule"+".csv"));

				CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("From","To","Factor"));) {

			for (int i = 0; i < datas.size(); i++) {
			String  from=Double.toString(datas.get(i).from);
			String  to=Double.toString(datas.get(i).to);
			String  factor=Double.toString(datas.get(i).factor);
			
				csvPrinter.printRecord(from,to,factor); 
			}

			csvPrinter.flush();
		 
	}}
}
