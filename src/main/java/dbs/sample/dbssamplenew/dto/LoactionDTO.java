/**
 * 
 */
package dbs.sample.dbssamplenew.dto;

/**
 * @author PramitKarmakar
 *
 */
public class LoactionDTO {
	
	double latitude;
	double longitude;
	public LoactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoactionDTO(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
