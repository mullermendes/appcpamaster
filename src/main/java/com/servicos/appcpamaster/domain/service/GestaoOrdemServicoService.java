package com.servicos.appcpamaster.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicos.appcpamaster.domain.exception.NegocioException;
import com.servicos.appcpamaster.domain.model.Usuario;
import com.servicos.appcpamaster.domain.model.OrdemServico;
import com.servicos.appcpamaster.domain.model.StatuOrdemServico;
import com.servicos.appcpamaster.domain.repository.UsuarioRepository;
import com.servicos.appcpamaster.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Usuario usuario = usuarioRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Usuario não encontrado."));
		
		ordemServico.setCliente(usuario);
		ordemServico.setStatus(StatuOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
		
	}

}