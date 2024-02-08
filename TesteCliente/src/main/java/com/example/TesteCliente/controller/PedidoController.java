package com.example.TesteCliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TesteCliente.entities.Pedido;
import com.example.TesteCliente.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

private final PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findPedidobyId(@PathVariable Long id) {
		Pedido pedido = pedidoService.getPedidoById(id);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/nome/{funnome}")
	public ResponseEntity<List<Pedido>> findPedidosByNomeAproximado(@PathVariable String dataPedido) {
	    List<Pedido> pedidos = pedidoService.getPedidosByFunnomeAproximado(dataPedido);
	    if (!pedidos.isEmpty()) {
	        return ResponseEntity.ok(pedidos);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	

	@GetMapping("/")
	public ResponseEntity<List<Pedido>> findAllUsuarioscontrol() {
		List<Pedido> pedido = pedidoService.getAllPedidos();
		return ResponseEntity.ok(pedido);
	}

	@PostMapping("/")
	public ResponseEntity<Pedido> insertUsuariosControl(@RequestBody Pedido pedido) {
		Pedido novopedido = pedidoService.savePedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(novopedido);
	}


	@DeleteMapping("/id")
	public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long pedidoID) {
		boolean remover =pedidoService.deletePedido(pedidoID);
		if (remover) {
			return ResponseEntity.ok().body("Pedido Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
