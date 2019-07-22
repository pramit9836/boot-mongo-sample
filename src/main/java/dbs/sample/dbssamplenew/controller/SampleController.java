/**
 * 
 */
package dbs.sample.dbssamplenew.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dbs.sample.dbssamplenew.dto.OrderDTO;
import dbs.sample.dbssamplenew.service.*;

/**
 * @author PramitKarmakar
 *
 */

@RestController
public class SampleController {
	
	@GetMapping(path="/test")
	public String testApi(){
		return "testing";
	}
	
	@Autowired
	OrderPlacementService orderPlacementService;
	
	Gson gson = new Gson();
	
	@PostMapping(path = "/placeOrder", consumes = "application/json", produces = "application/json")
	public String uploadFile(@RequestBody String requestBody/*, @PathVariable String customerId*/){
		
		
		
		OrderDTO orderDTO = gson.fromJson(requestBody, OrderDTO.class);
		
		String returnValue = orderPlacementService.placeOrder(orderDTO);
		JsonObject response = new JsonObject();
		response.addProperty("status", returnValue);
		response.addProperty("code", HttpStatus.OK.toString());
		
		return gson.toJson(response);
		
	}
	
	@GetMapping(path="/{retailerId}/getOrders")
	public String getOrders(@PathVariable long retailerId){
		
		ArrayList<OrderDTO> orderList = orderPlacementService.getOrders(retailerId);
		
		
		return gson.toJson(orderList);
		
	}
	
	@PostMapping(path = "/updatedOrderStatus", consumes = "application/json", produces = "application/json")
	public String updatedOrderStatus(@RequestBody String requestBody){
		
		OrderDTO orderDTO = gson.fromJson(requestBody, OrderDTO.class);
		String returnValue = orderPlacementService.updateOrderStatus(orderDTO);
		
		JsonObject response = new JsonObject();
		response.addProperty("status", returnValue);
		response.addProperty("code", HttpStatus.OK.toString());
		
		return gson.toJson(response);
	}
	
}