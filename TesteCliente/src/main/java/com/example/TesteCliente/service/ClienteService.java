package com.example.TesteCliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TesteCliente.entities.Cliente;
import com.example.TesteCliente.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente getClienteById(Long clienteID) {
		return clienteRepository.findById(clienteID).orElse(null);

	}

	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	public void deleteCliente(Long clienteID) {
		clienteRepository.deleteById(clienteID);
	}

}
