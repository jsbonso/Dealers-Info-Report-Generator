package au.com.carsguide.dealersinfo.exceptions;

/**
 * Custom Exception Class for Dealers Info app.
 * @author jsbonso
 *
 */
public class DealersInfoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DealersInfoException(){}
	
	public DealersInfoException(String message){
		super(message);
	}

}
