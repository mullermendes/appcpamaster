package com.servicos.appcpamaster.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Campanha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataCampanha;
	
	@NotNull
	private BigDecimal valorCampanha;
	
	@NotNull
	private BigDecimal valorFaturamento;
	
	@Valid
	@ManyToOne
	private Produto produto;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public OffsetDateTime getDataCampanha() {
		return dataCampanha;
	}
	public void setDataCampanha(OffsetDateTime dataCampanha) {
		this.dataCampanha = dataCampanha;
	}
	public BigDecimal getValorCampanha() {
		return valorCampanha;
	}
	public void setValorCampanha(BigDecimal valorCampanha) {
		this.valorCampanha = valorCampanha;
	}
	public BigDecimal getValorFaturamento() {
		return valorFaturamento;
	}
	public void setValorFaturamento(BigDecimal valorFaturamento) {
		this.valorFaturamento = valorFaturamento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campanha other = (Campanha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
