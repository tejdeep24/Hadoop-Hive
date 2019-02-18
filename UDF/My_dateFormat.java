package hive_UDF;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.hive.ql.exec.UDF;

public class My_dateFormat extends UDF{
	
	public String evaluate(String s)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS a");
		Date d1 = null;
		DateFormat df1=null;
		try {
			d1 = df.parse(s);
			df1= new SimpleDateFormat("MM/dd/yyyy HH:mm");
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return df1.format(d1); 
	}

}
