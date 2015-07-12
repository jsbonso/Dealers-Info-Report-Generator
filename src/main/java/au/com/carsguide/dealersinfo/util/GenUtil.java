package au.com.carsguide.dealersinfo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * General Utility class.
 * 
 * @author jsbonso
 *
 */
public class GenUtil {

	/**
	 * Shows the opening banner
	 */
	public static void bannerStart(){
		System.out.println("=====================================");
		System.out.println("===   Cars Guide Dealers info     ===");
		System.out.println("=====================================");
	}

	
	/**
	 * Shows the end of the banner
	 */
	public static void bannerEnd(){
		System.out.println("\n====================================");
	}
	
	
	/**
	 * Returns the Month End date for the given date.
	 * @param date
	 * @return
	 */
	public static Date getMonthEndDate(Date date){
		
		Calendar monthEnd = Calendar.getInstance();
		monthEnd.setTime(date);
		monthEnd.set(Calendar.DAY_OF_MONTH, monthEnd.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return monthEnd.getTime();
	}
}
