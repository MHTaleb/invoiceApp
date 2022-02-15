package com.talcorpdz.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.talcorpdz.domain.Tva;

@Repository
public interface TvaRepository extends MongoRepository<Tva, Long>{

	
	@Query
	List<Tva> findByRateBetweenOrderByNameAsc(Double rate,Double rate2);
}
