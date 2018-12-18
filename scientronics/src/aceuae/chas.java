package aceuae;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.jsoup.nodes.Element;

public class chas {
	String a;
	String b;

	public chas(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		String date = dateFormat.format(new Date()).toString();
		System.out.println(date);
	
	}

}
