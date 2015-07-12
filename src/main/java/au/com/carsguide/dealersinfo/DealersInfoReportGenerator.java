package au.com.carsguide.dealersinfo;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import au.com.carsguide.dealersinfo.exceptions.DealersInfoException;
import au.com.carsguide.dealersinfo.model.DealerInfo;
import au.com.carsguide.dealersinfo.model.Input;
import au.com.carsguide.dealersinfo.util.GenUtil;
import au.com.carsguide.dealersinfo.util.ReadInputFile;
import au.com.carsguide.dealersinfo.processes.Process;

/**
 * Car Dealers Info
 *
 */
public class DealersInfoReportGenerator {

	private final static Logger log = Logger.getLogger(DealersInfoReportGenerator.class);
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main( String[] args ){

		log.info("START - Dealers Info Report Generator.");
		
		GenUtil.bannerStart();

		try {
			
			/*
			 * Get User Input.
			 */
			List<Input> inputlist = ReadInputFile.getInputList(
					new File(getFilePath()));
			
			generateMonthlyDealerReport(inputlist);
			generateMonthlyParentDealerReport(inputlist);
			

		} catch (DealersInfoException de) {
			de.printStackTrace();

		}catch (Exception e) {
			e.printStackTrace();
		}

		GenUtil.bannerEnd();

		log.info("END - Dealers Info Report Generator.");
	}
	
	/**
	 * Generate Monthly Dealer Report
	 * @param inputlist
	 * @throws DealersInfoException, Exception 
	 */
	public static boolean generateMonthlyDealerReport(List<Input> inputlist) throws DealersInfoException, Exception{
		/*
		 * Generate Monthly Parent Dealer Report
		 */
		
		Map<Integer, DealerInfo> monthlyDealerReport = 
				Process.calculateMonthlyDealerTotal(inputlist);

		Process.generateMonthlyDealerTotalReport(monthlyDealerReport);	
		
		return true;
	}
	

	/**
	 * Generate Monthly Parent Dealer Report
	 * @param inputlist
	 * @throws DealersInfoException, Exception 
	 */
	public static boolean generateMonthlyParentDealerReport(List<Input> inputlist) throws DealersInfoException, Exception{
		
		/*
		 * Generate Monthly Parent Dealer Report
		 */
		Map<String, List<DealerInfo>> monthlyParentDealerReport = 
				Process.calculateMonthlyParentDealerTotal(inputlist);
		
		Process.generateMonthlyParentDealerTotalReport(monthlyParentDealerReport);
		
		return true;
		
	}


	/**
	 * Get the FilePath from user input.
	 * @return
	 */
	private static String getFilePath(){
		log.info("Getting the FilePath from user input...");
		System.out.print("Enter the file path for the input.csv : ");
		return new Scanner(System.in).next();
	}
}
