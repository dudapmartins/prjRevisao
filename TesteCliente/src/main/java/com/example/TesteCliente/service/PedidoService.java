package com.example.TesteCliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TesteCliente.entities.Pedido;
import com.example.TesteCliente.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido getPedidoById(long pedidoID) {
		return pedidoRepository.findById(pedidoID).orElse(null);
	}

	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public List<Pedido> getPedidosByFunnomeAproximado(String dataPedido) {
        return PedidoRepository.findByNomeContaining(dataPedido);
    }

	public boolean deletePedido(Long id) {
		Optional<Pedido>pedidoExistente = pedidoRepository.findById(id);
		if (pedidoExistente.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	
}
