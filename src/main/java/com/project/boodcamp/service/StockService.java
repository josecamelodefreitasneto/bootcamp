package com.project.boodcamp.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.boodcamp.mapper.StockMapper;
import com.project.boodcamp.model.Stock;
import com.project.boodcamp.model.dto.StockDTO;
import com.project.boodcamp.repository.StockRepository;

import java.time.LocalDate;
import java.util.List;
import exceptions.BusinessException;
import exceptions.NotFoundException;
import util.MessageUtils;

// PARTE NEGOCIAL DA ENTIDADE STOCK REGRAS DE NEGOCIO

@Service
public class StockService {
	
	// CONEXÃO COM REPOSITORY
	@Autowired
	private StockRepository repository;
	
	@Autowired
	private StockMapper mapper;

	

	@Transactional
	public StockDTO save(StockDTO dto) {
		Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(),dto.getDate());
		
		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.ToDto(stock);
		
		
	}
	@Transactional
	public StockDTO delete(Long id) {
		StockDTO dto = this.findById(id);
		repository.deleteById(id);
		return dto;
		
	}
	
	@Transactional
	public StockDTO update(StockDTO dto) {
       Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
		
		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.ToDto(stock);
		
	}
	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {		
		return mapper.toDto(repository.findAll());
	}
	
	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {
		return repository.findById(id).map(mapper::ToDto).orElseThrow(NotFoundException::new);
		
	}
	@Transactional(readOnly = true)
	public List<StockDTO> findByToday() {
		return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
		
	}

}
