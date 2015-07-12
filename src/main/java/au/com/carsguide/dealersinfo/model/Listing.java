package au.com.carsguide.dealersinfo.model;

import java.util.Date;

/**
 * Listing Object
 * @author jsbonso
 *
 */
public class Listing {

	int id;
	Date eventDate;
	int pageviews;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public int getPageviews() {
		return pageviews;
	}
	
	public void setPageviews(int pageviews) {
		this.pageviews = pageviews;
	}
	
}
