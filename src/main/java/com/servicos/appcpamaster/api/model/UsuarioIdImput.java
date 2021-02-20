package com.servicos.appcpamaster.api.model;

import javax.validation.constraints.NotNull;

public class UsuarioIdImput {
	
	@NotNull
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
