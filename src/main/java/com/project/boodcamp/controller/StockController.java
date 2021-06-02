package com.project.boodcamp.controller;



import com.project.boodcamp.model.dto.StockDTO;
import com.project.boodcamp.service.StockService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
	@Autowired
	private StockService service;
	
	//endpoints salvar POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
		return ResponseEntity.ok(service.save(dto));
		
	}
	
	//endpoints altera UPDATE
@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<StockDTO> Update(@Valid @RequestBody StockDTO dto){
	return ResponseEntity.ok(service.update(dto));
	
}

// endpoints  
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<StockDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}

@GetMapping(value = "/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<StockDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	
	
}
@GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<StockDTO> delete(@PathVariable Long id){
	return ResponseEntity.ok(service.delete(id));
}

@GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<StockDTO>> findByToday(){
	return ResponseEntity.ok(service.findByToday(     ));
	
}

}
