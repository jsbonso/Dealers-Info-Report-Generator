package au.com.carsguide.dealersinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import au.com.carsguide.dealersinfo.model.Input;
import au.com.carsguide.dealersinfo.processes.Process;
import au.com.carsguide.dealersinfo.util.ReadInputFile;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Dealers Info Report Generator.
 */
public class DealersInfoReportGeneratorTest extends TestCase{

	List<Input> inputlist;
	
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 * @throws Exception 
	 */

	public DealersInfoReportGeneratorTest( String testName ) throws Exception{
		super( testName );
	
		InputStream is = DealersInfoReportGeneratorTest.class.getResourceAsStream("/input.csv");
		
		if(is !=null){
			inputlist = ReadInputFile.getInputList(is);
		}else{
			
		}
		
		
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite(){
		return new TestSuite( DealersInfoReportGeneratorTest.class );
	}


	/**
	 * Test for the Generation of both reports.
	 * @throws Exception
	 */
	public void testDealersInfo() throws Exception
	{
		System.out.println("Testing MonthlyDealerReport and MonthlyParentDealerReport...");

		DealersInfoReportGenerator.generateMonthlyDealerReport(inputlist);
		DealersInfoReportGenerator.generateMonthlyParentDealerReport(inputlist);

		assertTrue(inputlist.size() != 0 && inputlist != null );

	}


	/**
	 * Test for Monthly Dealers Report
	 * 
	 * @throws Exception
	 */
	public void testMonthlyDealersReport() throws Exception{

		System.out.println("Testing Monthly Dealers Report...");

		assertTrue( DealersInfoReportGenerator.generateMonthlyDealerReport(inputlist));

	}


	/**
	 * Test for Monthly Parent Dealers Report
	 * 
	 * @throws Exception
	 */
	public void testMonthlyParentDealersReport() throws Exception{

		System.out.println("Testing Monthly Parent Dealers Report...");

		assertTrue( DealersInfoReportGenerator.generateMonthlyParentDealerReport(inputlist) );

	}
	
	

}
