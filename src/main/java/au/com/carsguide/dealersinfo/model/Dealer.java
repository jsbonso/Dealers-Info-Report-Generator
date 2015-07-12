package au.com.carsguide.dealersinfo.model;

/**
 * Dealer Class
 * @author jsbonso
 *
 */
public class Dealer {

	int id;
	Listing listing;
	Dealer parentDealer;
	Dealer childDealer;
	
	public Listing getListing() {
		return listing;
	}
	
	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	public Dealer getParentDealer() {
		return parentDealer;
	}
	
	public void setParentDealer(Dealer parentDealer) {
		this.parentDealer = parentDealer;
	}

	public Dealer getChildDealer() {
		return childDealer;
	}

	public void setChildDealer(Dealer childDealer) {
		this.childDealer = childDealer;
	}
	
}
