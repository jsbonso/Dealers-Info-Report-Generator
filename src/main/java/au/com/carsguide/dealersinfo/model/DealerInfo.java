package au.com.carsguide.dealersinfo.model;

import java.util.Date;

/**
 * Dealer Info Class
 * @author jsbonso
 *
 */
public class DealerInfo {

	String dealerId;
	String parentDealerId;
	int listingId;
	Date date;
	int sumPageViews;
	
	public String getDealerId() {
		return dealerId;
	}
	
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	
	public int getListingId() {
		return listingId;
	}
	
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getSumPageViews() {
		return sumPageViews;
	}
	
	public void setSumPageViews(int sumPageViews) {
		this.sumPageViews = sumPageViews;
	}

	public String getParentDealerId() {
		return parentDealerId;
	}

	public void setParentDealerId(String parentDealerId) {
		this.parentDealerId = parentDealerId;
	}
	
}
