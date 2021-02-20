package com.servicos.appcpamaster.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servicos.appcpamaster.domain.model.Usuario;
import com.servicos.appcpamaster.domain.repository.UsuarioRepository;
import com.servicos.appcpamaster.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();		
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long clienteId) {
		Optional<Usuario> usuario = usuarioRepository.findById(clienteId);
		
		if(usuario.isPresent()){
			return ResponseEntity.ok(usuario.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return cadastroUsuarioService.salvar(usuario);
		
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> atualizar(@Valid @PathVariable Long clienteId,
			@RequestBody Usuario usuario){
		
		if(!usuarioRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.setId(clienteId);
		usuario = cadastroUsuarioService.salvar(usuario);
		
		return ResponseEntity.ok(usuario);
		
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> remover (@PathVariable Long clienteId){
		
		if(!usuarioRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroUsuarioService.excluir(clienteId);
		
		return ResponseEntity.noContent().build();
	}
	
}
