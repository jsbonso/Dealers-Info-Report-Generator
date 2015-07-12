package au.com.carsguide.dealersinfo.model;

import java.util.Date;

/**
 * Object Representation of the Input file.
 * @author jsbonso
 *
 */

public class Input {

	String dealerId;
	String parentDealerId;
	int listingId;
	Date eventDate;
	int pageViews;
	
	public String getDealerId() {
		return dealerId;
	}
	
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	
	public String getParentDealerId() {
		return parentDealerId;
	}
	
	public void setParentDealerId(String parentDealerId) {
		this.parentDealerId = parentDealerId;
	}
	
	public int getListingId() {
		return listingId;
	}
	
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	
	public Date getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public int getPageViews() {
		return pageViews;
	}
	
	public void setPageViews(int pageViews) {
		this.pageViews = pageViews;
	}
	
}
