package com.talcorpdz.api.internal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talcorpdz.api.internal.exception.IllegalGenericCrudArgumentsException;
import com.talcorpdz.api.internal.rest.utils.DTOConverter;

@RestController
public class GenericRestController<T,V> {

	@Autowired
	private MongoRepository<T,Long> repository;
	
	@Autowired
	private DTOConverter<T,V> dtoConverter;
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<V> insertDomain(@RequestBody T body) throws IllegalGenericCrudArgumentsException{
		T saved;
		try{
			saved = repository.save(body);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			throw new IllegalGenericCrudArgumentsException(body.getClass().getName(),
					body.toString(),e.getMessage());
		}
		V dto = dtoConverter.toDto(saved);
		return new ResponseEntity<V>(dto,HttpStatus.OK);
	}
	
	
}
