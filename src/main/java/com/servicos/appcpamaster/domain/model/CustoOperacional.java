package com.servicos.appcpamaster.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class CustoOperacional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private BigDecimal valorIof;
	
	@NotNull
	private BigDecimal taxaPlataforma;
	
	@NotNull
	private BigDecimal impostos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long idCustoOper) {
		this.id = idCustoOper;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorIof() {
		return valorIof;
	}
	public void setValorIof(BigDecimal valorIof) {
		this.valorIof = valorIof;
	}
	public BigDecimal getTaxaPlataforma() {
		return taxaPlataforma;
	}
	public void setTaxaPlataforma(BigDecimal taxaPlataforma) {
		this.taxaPlataforma = taxaPlataforma;
	}
	public BigDecimal getImpostos() {
		return impostos;
	}
	public void setImpostos(BigDecimal impostos) {
		this.impostos = impostos;
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
		CustoOperacional other = (CustoOperacional) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
