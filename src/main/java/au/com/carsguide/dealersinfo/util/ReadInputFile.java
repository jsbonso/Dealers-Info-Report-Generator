package au.com.carsguide.dealersinfo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import au.com.carsguide.dealersinfo.exceptions.DealersInfoException;
import au.com.carsguide.dealersinfo.model.Dealer;
import au.com.carsguide.dealersinfo.model.Input;
import au.com.carsguide.dealersinfo.model.Listing;

/**
 * Reads and parses the Input file.
 * @author jsbonso
 *
 */
public class ReadInputFile {
	
	private static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");


	/**
	 * Get and Parse the Input file 
	 * @return 
	 * @return
	 * @throws Exception 
	 */
	public static List<Input> getInputList(File input) throws Exception{
		
		List<Input> inputList = new ArrayList<Input>();
		
		try(Scanner scanner = new Scanner(new FileInputStream(input));
				){
			//Skip the CSV Header
			scanner.nextLine();

			while (scanner.hasNextLine()){
				
				//Input in = convertToInput(scanner.nextLine());
				
				inputList.add(convertToInput(scanner.nextLine()));
			}

		}catch(Exception e){
			throw new DealersInfoException(e.getMessage());
		}

		return inputList;

	}

	
	/**
	 * Overloaded method that gets and parse the Input file through InputStream
	 * Used by the test class.
	 * @return 
	 * @return
	 * @throws Exception 
	 */
	public static List<Input> getInputList(InputStream inputStream) throws Exception{
		
		List<Input> inputList = new ArrayList<Input>();
		
		try(Scanner scanner = new Scanner(inputStream);
				){
			//Skip the CSV Header
			scanner.nextLine();

			while (scanner.hasNextLine()){
				
				//Input in = convertToInput(scanner.nextLine());
				
				inputList.add(convertToInput(scanner.nextLine()));
			}

		}catch(Exception e){
			throw new DealersInfoException(e.getMessage());
		}

		return inputList;

	}

	/**
	 * Converts the CSV Line to an Input Object.
	 * @param input
	 * @return
	 * @throws ParseException 
	 */
	public static Input convertToInput(String input) throws ParseException {

		String[] records= input.split(",");

		Input in = new Input();;

		in.setDealerId(records[0].trim());
		in.setParentDealerId(records[1].trim());
		in.setListingId(Integer.parseInt(records[2].trim()));

		Date eventDate = dateFormatter.parse(records[3].trim());

		in.setEventDate(eventDate);
		in.setPageViews(Integer.parseInt(records[4].trim()));

		return in;

	}

}
