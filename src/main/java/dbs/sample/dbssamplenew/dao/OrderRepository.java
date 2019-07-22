package dbs.sample.dbssamplenew.dao;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import dbs.sample.dbssamplenew.dto.OrderDTO;

public interface OrderRepository extends MongoRepository<OrderDTO, String> {
	
	public OrderDTO insert(OrderDTO order);
	
	public ArrayList<OrderDTO> findByRetailerIdAndStatus(long retailerId, String status);
	
	public OrderDTO save(OrderDTO orderDTO);
	
	

}
