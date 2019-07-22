/**
 * 
 */
package dbs.sample.dbssamplenew.dto;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import dbs.sample.dbssamplenew.*;

/**
 * @author PramitKarmakar
 *
 */
@Document(collection="orders")
public class OrderDTO {
	
	private String fileName;
	private String fileType;
	private String fileContent;
	private long customerId;
	private LoactionDTO location;
	private long retailerId;
	private String status;
	@Id
	private String orderId;
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderDTO(String fileName, String fileType, String fileContent, long customerId, LoactionDTO location,
			long retailerId, String status, String orderId) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileContent = fileContent;
		this.customerId = customerId;
		this.location = location;
		this.retailerId = retailerId;
		this.status = status;
		this.orderId = orderId;
	}


	public long getRetailerId() {
		return retailerId;
	}


	public void setRetailerId(long retailerId) {
		this.retailerId = retailerId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public LoactionDTO getLocation() {
		return location;
	}

	public void setLocation(LoactionDTO location) {
		this.location = location;
	}

	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
}
