package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	
	//anotação é um container de injeção de dependencias (nao precisa do NEW)
	@Autowired
	private ProductRepository repository;
	
	//anotação utilizada para garantir que a coneção será fechada e não irá dar lock na tabela pois se trata de uma leitura.
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		
		List<Product> list = repository.findAllByOrderByNameAsc();
		
		//aqui a lista de produtos é convertida para uma lista de productDTO;
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		
	}
	
}
