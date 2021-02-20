package com.servicos.appcpamaster.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicos.appcpamaster.domain.exception.NegocioException;
import com.servicos.appcpamaster.domain.model.Usuario;
import com.servicos.appcpamaster.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar (Usuario usuario) {
		Usuario clienteExistente = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(usuario)) {
			throw new NegocioException("Ja existe um cliente cadastrado com esse e-mail.");
		}
		
		return usuarioRepository.save(usuario);
	}
	
	public void excluir (Long cliente) {
		usuarioRepository.deleteById(cliente);
	}

}
