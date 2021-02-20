package com.servicos.appcpamaster.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicos.appcpamaster.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findByNome(String nome);
	List<Usuario> findByNomeContaining(String nome);
	Usuario findByEmail(String email);
}
