/**
 * 
 */
package dbs.sample.dbssamplenew.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import dbs.sample.dbssamplenew.dto.RetailerDTO;

/**
 * @author PramitKarmakar
 *
 */
public interface RetailerRepository extends MongoRepository<RetailerDTO, Long> {
	
	public ArrayList<RetailerDTO> findAll(Sort sort);

}
