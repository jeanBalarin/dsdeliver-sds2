package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
	//montando  a consulta para mostrar apenas os pedidos pendentes
	//os nome da tabela tem que ser o mesmo nome da classe
	//o nome das colunas é o mesmo dos atributos da classe de mapeamento
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products " 
	+ " WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrderWithProducts();
	
}
