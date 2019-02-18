package hive_UDF;

import java.util.Calendar;

import org.apache.hadoop.hive.ql.exec.UDF;

public class age_calc extends UDF{
	
	public String evaluate(String s)
	{
		String st[] =s.split("-");
		Calendar c = Calendar.getInstance();
		int currentYear=c.get(Calendar.YEAR);
		int currentMonth=c.get(Calendar.MONTH)+1;
		int currentDay=c.get(Calendar.DATE);
		int birthYear = Integer.parseInt(st[2]);
		int birthMonth = Integer.parseInt(st[0]);
		int birthday = Integer.parseInt(st[1]);
		
		int no_of_years = currentYear-birthYear;
		int no_of_days = currentDay-birthday;
		int no_of_months = currentMonth-birthMonth;
		if(no_of_months<0)
		{
			no_of_years--;
			no_of_months = 12-birthMonth+currentMonth;
		}
		else if(no_of_months == 0)
		{
			if(currentDay < birthday)
			{
				no_of_years--;
			}
		}
		
		return no_of_years+"Y"+no_of_months+"M"+no_of_days+"D";
		
	}

}
