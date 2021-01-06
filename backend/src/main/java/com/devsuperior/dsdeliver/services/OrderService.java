package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	
	//anotação é um container de injeção de dependencias (nao precisa do NEW)
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository pdreposytory;
	//anotação utilizada para garantir que a coneção será fechada e não irá dar lock na tabela pois se trata de uma leitura.
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		
		List<Order> list = repository.findOrderWithProducts();
		
		//aqui a lista de produtos é convertida para uma lista de productDTO;
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
	
	//inserir novo pedido.
	@Transactional
	//o obj DTO tem dados do pedido e produtos
	public OrderDTO insert(OrderDTO dto) {
		//aqui começo a salvar um novo pedido order
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(),dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		
		//aqui é feito a varredura de todos os itens nos pedidos dto
		for (ProductDTO p : dto.getProducts()) {
			//aqui é instanciado um produto com base no id do p
			Product product = pdreposytory.getOne(p.getId());
			//adicionado ao produto.
			order.getProducts().add(product);
		}
		//salvando o pedido
		order = repository.save(order);
		
		return new OrderDTO(order);
	}
}
