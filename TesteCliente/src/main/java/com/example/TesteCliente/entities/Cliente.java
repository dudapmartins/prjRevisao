package com.example.TesteCliente.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Cliente")

public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteID;


	private String clienteNome;
	
	private String clienteEmail;
	private String clienteCampo;
	private String clienteTelefone;

	public Long getClienteID() {
		return clienteID;
	}

	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	
	public String getClienteCampo() {
		return clienteCampo;
	}

	public void setClienteCampo(String clienteCampo) {
		this.clienteCampo = clienteCampo;
	}
	
	public String getClienteTelefone() {
		return clienteTelefone;
	}

	public void setclienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}
	


}
