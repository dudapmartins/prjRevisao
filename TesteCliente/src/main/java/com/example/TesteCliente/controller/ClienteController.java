package com.example.TesteCliente.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MariaEduardaPedroza.PrjEmpresa.entities.Departamento;
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
	public ResponseEntity<Cliente> getCliente(@PathVariable Long depCodigo) {
		Cliente cliente = clienteService.getClienteById(depCodigo);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";// nome do seu arquivo HTML (sem a extensão)
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long depCodigo) {
		clienteService.deleteCliente(depCodigo);
	}

	// Utilizando o ResponseEntity e RequestEntity
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllCliente(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Cliente> cliente = clienteService.getAllCliente();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(cliente);
	}

}
