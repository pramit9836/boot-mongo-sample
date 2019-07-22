package dbs.sample.dbssamplenew.dao;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import dbs.sample.dbssamplenew.dto.*;;

/**
 * 
 */

/**
 * @author PramitKarmakar
 *
 */

@Repository
public class OrderPlacementDAO {
	
	@Autowired
    MongoTemplate mongoOperations;
	
	
	public ArrayList<RetailerDTO> getReailersByRating(){
		
		ArrayList<RetailerDTO> retailer = (ArrayList<RetailerDTO>) mongoOperations.findAll(RetailerDTO.class);
		Query query = new Query();
		query.with(new Sort(new Order(Direction.ASC, "rating")));
		ArrayList<RetailerDTO> retailerList = (ArrayList<RetailerDTO>) mongoOperations.find(query, RetailerDTO.class);
		return retailerList;
	}
	
	/*public static ArrayList<RetailerDTO> sortByQuery(Query query) {  
	  ArrayList<RetailerDTO> retailers = (ArrayList<RetailerDTO>) mongoOperations.find(query, RetailerDTO.class);
	  System.out.println();
	  System.out.println("Executed Query :- " + query);
	  System.out.println();
	  return retailers;
	 }*/

}
