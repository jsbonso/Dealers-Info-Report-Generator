package au.com.carsguide.dealersinfo.processes;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import au.com.carsguide.dealersinfo.DealersInfoReportGenerator;
import au.com.carsguide.dealersinfo.exceptions.DealersInfoException;
import au.com.carsguide.dealersinfo.model.Dealer;
import au.com.carsguide.dealersinfo.model.DealerInfo;
import au.com.carsguide.dealersinfo.model.Input;
import au.com.carsguide.dealersinfo.util.GenUtil;

public class Process {

	private static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	private final static Logger log = Logger.getLogger(Process.class);


	/**
	 * Calculate Monthly Dealer Total
	 */
	public static Map<Integer, DealerInfo> calculateMonthlyDealerTotal(List<Input> inputList){


		System.out.println("\nCalculating Monthly Dealer Totals Report...");
		log.info("Calculating Monthly Dealer Totals Report...");
		
		Map<Integer, DealerInfo> resultMap = new HashMap<Integer, DealerInfo>();

		for (Input input: inputList){

			int listingId = input.getListingId();
			DealerInfo dInfo = new DealerInfo();

			dInfo.setDate(GenUtil.getMonthEndDate(input.getEventDate()));
			dInfo.setListingId(listingId);
			dInfo.setDealerId(input.getDealerId());
			dInfo.setParentDealerId(input.getParentDealerId());
			// Check if the entry already exists
			if(resultMap.containsKey(listingId)){

				// Fetch the entry and add it on 
				// the existing Page View count to get the sum.

				dInfo.setSumPageViews(resultMap.get(listingId).getSumPageViews() + 
						input.getPageViews());

			}else{
				dInfo.setSumPageViews(input.getPageViews());
			}


			resultMap.put(input.getListingId(), dInfo);

		}


		System.out.println("Calculation Done.");
		log.info("Calculation Done.");

		return resultMap;
	}


	/**
	 * Generates the Monthly Dealer Total Report CSV file
	 * @throws DealersInfoException 
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void generateMonthlyDealerTotalReport(Map<Integer, DealerInfo> monthlyDealerReport) throws DealersInfoException {

		System.out.println("Generating Monthly Dealer Totals Report...");
		log.info("Generating Monthly Dealer Totals Report...");
		
		try(PrintWriter writer = new PrintWriter("Monthly Dealer Totals Report.csv", "UTF-8")){

			// Report Header.
			writer.println(
					"dealer_id,listing_id,date,sum_pageviews");

			// Report Body
			for (Map.Entry<Integer, DealerInfo> mReport : monthlyDealerReport.entrySet() ){

				writer.println(
						mReport.getValue().getDealerId() + "," + 
								mReport.getKey() + "," + 
								dateFormatter.format(mReport.getValue().getDate()) + "," + 
								mReport.getValue().getSumPageViews());

			}

			System.out.println("Successfully generated the Monthly Dealer Totals Report.csv output file.");
			log.info("Successfully generated the Monthly Dealer Totals Report.csv output file.");
			
		} catch (FileNotFoundException e) {
			log.error(e.toString());
			throw new DealersInfoException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			log.error(e.toString());
			throw new DealersInfoException(e.getMessage());
		} catch (Exception e){
			log.error(e.toString());
			throw new DealersInfoException(e.getMessage());
		}
	}


	/**
	 * Generates the Monthly Parent Dealer Total Report CSV file
	 * @throws DealersInfoException 
	 */
	public static void generateMonthlyParentDealerTotalReport(Map<String, List<DealerInfo>> monthlyParentDealerReport) throws DealersInfoException{

		System.out.println("Generating Monthly Parent Dealer Totals Report...");
		log.info("Generating Monthly Parent Dealer Totals Report...");

		try(PrintWriter writer = new PrintWriter("Monthly Parent Dealer Totals Report.csv", "UTF-8")){

			// Report Header.
			writer.println(
					"dealer_id,child_dealer_id,date,sum_pageviews");
			for (Entry<String, List<DealerInfo>> mReport : monthlyParentDealerReport.entrySet() ){

				List<DealerInfo> dInfoList = mReport.getValue();

				// Report Body.
				for(DealerInfo dItem : dInfoList){
					writer.println(
							dItem.getParentDealerId()+ "," +
									dItem.getDealerId()+ "," + 
									dateFormatter.format(dItem.getDate())+ "," + 
									dItem.getSumPageViews());
				}

			}

			System.out.println("Successfully generated the Monthly Parent Dealer Totals Report.csv output file.");
			log.info("Successfully generated the Monthly Parent Dealer Totals Report.csv output file.");
			
		} catch (FileNotFoundException e) {
			log.error(e.toString());
			throw new DealersInfoException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			log.error(e.toString());
			throw new DealersInfoException(e.getMessage());
		} catch (Exception e){
			log.error(e.toString());
			throw new DealersInfoException(e.getMessage());
		}
	}


	/**
	 * Calculate Monthly Dealer Total
	 */
	public static Map<String, List<DealerInfo>> calculateMonthlyParentDealerTotal(List<Input> inputList){

		String parentDealerId = "";
		System.out.println("\nCalculating Monthly Parent Dealer Totals Report...");
		log.info("Calculating Monthly Parent Dealer Totals Report...");

		Map<String, List<DealerInfo>> resultMap = new HashMap<String, List<DealerInfo>>();

		for (Input input: inputList){

			if(input.getParentDealerId()!= null ){
				parentDealerId = input.getParentDealerId();
			}

			DealerInfo dInfo = new DealerInfo();

			dInfo.setDate(GenUtil.getMonthEndDate(input.getEventDate()));
			dInfo.setDealerId(input.getDealerId());
			dInfo.setParentDealerId(input.getParentDealerId());
			dInfo.setSumPageViews(input.getPageViews());

			// Check if the entry already exists
			if(resultMap.containsKey(parentDealerId)){

				List<DealerInfo> dInfoList = resultMap.get(parentDealerId);

				if (isInTheList( dInfoList, input.getDealerId())){

					for (DealerInfo dItem : dInfoList){
						if(input.getDealerId().equals(dItem.getDealerId())){

							// Increment the Page View
							int sumPageViews = dItem.getSumPageViews() +  input.getPageViews();
							dItem.setSumPageViews(sumPageViews);
						}
					}

				}else{
					dInfoList.add(dInfo);
				}


			}else{
				List<DealerInfo> dInfoList = new ArrayList<DealerInfo>();
				dInfoList.add(dInfo);

				if (!parentDealerId.equals("null") && parentDealerId!=null){
					resultMap.put(parentDealerId, dInfoList);				
				}
			}

		}

		System.out.println("Calculation Done.");
		log.info("Calculation Done.");

		return resultMap;
	}


	/**
	 * Utility method to check if a specific item is already in the list.
	 * @param dInfoList
	 * @param dealerId
	 * @return
	 */
	private static boolean isInTheList(List<DealerInfo> dInfoList, String dealerId){
		for (DealerInfo dItem : dInfoList){
			if(dealerId.equals(dItem.getDealerId())){
				return true;
			}
		}
		return false;
	}
}
