package com.example.TesteCliente.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.TesteCliente.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT f FROM Pedido f WHERE LOWER(f.dataPedido) LIKE LOWER(CONCAT('%', :dataPedido, '%'))")
	static
	List<Pedido> findByNomeContaining(@Param("dataPedido") String dataPedido) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
