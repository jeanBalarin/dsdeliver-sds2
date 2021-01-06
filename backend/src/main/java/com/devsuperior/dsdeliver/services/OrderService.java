package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	
	//anotação é um container de injeção de dependencias (nao precisa do NEW)
	@Autowired
	private OrderRepository repository;
	
	//anotação utilizada para garantir que a coneção será fechada e não irá dar lock na tabela pois se trata de uma leitura.
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		
		List<Order> list = repository.findOrderWithProducts();
		
		//aqui a lista de produtos é convertida para uma lista de productDTO;
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
}
