package com.project.boodcamp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.project.boodcamp.model.dto.StockDTO;
import com.project.boodcamp.model.Stock;


@Component
public class StockMapper {

	 public Stock toEntity(StockDTO dto) {
		
		Stock stock = new Stock();
		
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		stock.setDate(dto.getDate());
		
		return stock;
	}
	 

	public StockDTO ToDto(Stock stock) {
		
		StockDTO dto = new StockDTO();
		
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		dto.setDate(stock.getDate());
		
		return dto;
	}
	
	
	public List<StockDTO> toDto(List<Stock> listStock){
		return listStock.stream().map(this::ToDto).collect(Collectors.toList());
	}
		
		
	 }

