package DBconnectpkg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateticovet {

	public static void main(String[] args) {
		Date dt = StringtoDateConvertion("2018-05- 01");

		System.out.println(dt);
	}

	public static Date StringtoDateConvertion(String date) {

		/* date should be in yyyy /mdd formate */

		DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
			dt = (Date) formatter1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dt;
	}

}
