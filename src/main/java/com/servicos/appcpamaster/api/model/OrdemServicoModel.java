package com.servicos.appcpamaster.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.servicos.appcpamaster.domain.model.StatuOrdemServico;

public class OrdemServicoModel {
	
	private Long id;
	private UsuarioResumoModel cliente;
	private String descricao;
	private BigDecimal preco;
	private StatuOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UsuarioResumoModel getCliente() {
		return cliente;
	}
	public void setCliente(UsuarioResumoModel cliente) {
		this.cliente = cliente;
	}
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
	public StatuOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatuOrdemServico status) {
		this.status = status;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
}