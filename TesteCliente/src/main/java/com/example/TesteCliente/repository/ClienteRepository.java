package com.example.TesteCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TesteCliente.entities.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
