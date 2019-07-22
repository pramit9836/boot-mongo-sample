/**
 * 
 */
package dbs.sample.dbssamplenew.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import dbs.sample.dbssamplenew.dto.*;
import dbs.sample.dbssamplenew.dao.*;

/**
 * @author PramitKarmakar
 *
 */
@Service
public class OrderPlacementService{

	@Autowired
	OrderPlacementDAO orderPlacementDAO;
	
	@Autowired
	RetailerRepository retailRepo;
	
	@Autowired
	OrderRepository orderRepo;

	public String placeOrder(OrderDTO orderDTO){
		
		//ArrayList<RetailerDTO> retailersList = orderPlacementDAO.getReailersByRating();
		double lat1 = orderDTO.getLocation().getLatitude();
		double long1 = orderDTO.getLocation().getLongitude();
		Sort sort = new Sort(Direction.DESC, "rating");
		
		ArrayList<RetailerDTO> retailersList = (ArrayList<RetailerDTO>)retailRepo.findAll(sort);
		
		
		for(RetailerDTO retailer : retailersList){
			double lat2 = retailer.getLocation().getLatitude();
			double long2 = retailer.getLocation().getLongitude();
			
			double distance = distance(lat1, lat2, long1, long2, 0, 0);
			
			if(distance <= retailer.getMaxDistance()){
				orderDTO.setRetailerId(retailer.getId());
				orderDTO.setStatus("pending");
				orderRepo.insert(orderDTO);
				return "success";
			}
			
		}
		
		return "failed";
	}
	
	public ArrayList<OrderDTO> getOrders(long retailerId){
		
		ArrayList<OrderDTO> orderList = (ArrayList<OrderDTO>)orderRepo.findByRetailerIdAndStatus(retailerId, "pending");
		
		
		return orderList;
		
	}
	
	
	public String updateOrderStatus(OrderDTO orderDTO){
		
		if(orderDTO.getStatus() == null || orderDTO.getStatus().equalsIgnoreCase("pending")){
			orderDTO.setStatus("accepted");
			orderRepo.save(orderDTO);
			return "Order Accepted";
		}
		return "Failed to Accept Order";
		
	}
	
	public static double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance);
	}
}
