package com.servicos.appcpamaster.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoImput {
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@Valid
	@NotNull
	private UsuarioIdImput cliente;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public UsuarioIdImput getClienteIdImput() {
		return cliente;
	}
	public void setClienteIdImput(UsuarioIdImput usuarioIdImput) {
		this.cliente = usuarioIdImput;
	}

}
