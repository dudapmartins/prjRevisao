package com.example.TesteCliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TesteCliente.entities.Cliente;
import com.example.TesteCliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteID) {
		Cliente cliente = clienteService.getClienteById(clienteID);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long clienteID) {
		clienteService.deleteCliente(clienteID);
	}

	@GetMapping
	public List<Cliente> getAllCliente() {
		return clienteService.getAllCliente();
	}

}
