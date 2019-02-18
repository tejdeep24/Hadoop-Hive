package hive_UDF;

import org.apache.hadoop.hive.ql.exec.UDF;

public class My_zigzag extends UDF{

	StringBuffer sb = new StringBuffer();
	@SuppressWarnings("static-access")
	public String evaluate(String data)
	{
		Character ch = null;
		 String out = null;
		 if(ch.isLowerCase(data.charAt(0)))
		 {
			 char chr[] = data.toCharArray();
			 int length = chr.length;
			 for(int i=1;i<length;i++)
			 {
				 if(i%2==0)
				 {
					 char c = Character.toLowerCase(chr[i]);
					 chr[i]=c;
				 }
				 else
				 {
					 char c = Character.toUpperCase(chr[i]);
					 chr[i]=c;
				 }
			 }
			 out = new String(chr);
		 }
		 else if(ch.isUpperCase(data.charAt(0)))
		 {
			 char chr[] = data.toCharArray();
			 int length = chr.length;
			 for(int i=1;i<length;i++)
			 {
				 if(i%2==0)
				 {
					 char c = Character.toUpperCase(chr[i]);
					 chr[i]=c;
				 }
				 else
				 {
					 char c = Character.toLowerCase(chr[i]);
					 chr[i]=c;
				 }
			 }
			 out = new String(chr);
		 }
		 else
		 {
			 char chr[] = data.toCharArray();
			 int length = chr.length;
			 if(ch.isUpperCase(chr[1]))
			 {
				 for(int i=2;i<length;i++)
				 {
					 if(i%2==0)
					 {
						 char c = Character.toLowerCase(chr[i]);
						 chr[i]=c;
					 }
					 else
					 {
						 char c = Character.toUpperCase(chr[i]);
						 chr[i]=c;
					 }
				 }
				 out = new String(chr);
			 }
			 else
			 {
				 for(int i=2;i<length;i++)
				 {
					 if(i%2==0)
					 {
						 char c = Character.toUpperCase(chr[i]);
						 chr[i]=c;
					 }
					 else
					 {
						 char c = Character.toLowerCase(chr[i]);
						 chr[i]=c;
					 }
				 }
				 out = new String(chr);
			 }
		 }
		return out;
		
	}

}
