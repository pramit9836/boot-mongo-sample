package dbs.sample.dbssamplenew.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author PramitKarmakar
 *
 */
@Document(collection="retailers")
public class RetailerDTO {
    @Id
    private long id;

    private String name;
    private LoactionDTO location;
    private String email;
    private String phoneNo;
    private String pass;
    private String gstNo;
    private String licenseNo;
    private double rating;
    private double maxDistance;

    public RetailerDTO(long id, String name, LoactionDTO location, String email, String phoneNo, String pass,
			String gstNo, String licenseNo, double rating, double maxDistance) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.email = email;
		this.phoneNo = phoneNo;
		this.pass = pass;
		this.gstNo = gstNo;
		this.licenseNo = licenseNo;
		this.rating = rating;
		this.maxDistance = maxDistance;
	}
    
    public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LoactionDTO getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPass() {
        return pass;
    }

    public String getGstNo() {
        return gstNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }



}

