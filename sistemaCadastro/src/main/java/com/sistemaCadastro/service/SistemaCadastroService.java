package com.sistemaCadastro.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sistemaCadastro.model.Anuncio;
import com.sistemaCadastro.repository.SistemaCadastroRepository;

/**
 * Classe de Serviço para o Sistema de Cadastro de Anúncios
 * @author margo
 *
 */
@Component
public class SistemaCadastroService {
	@Autowired
	private SistemaCadastroRepository sistemaCadastroRepository;
	
	public Anuncio create(Anuncio anuncio) {
		return sistemaCadastroRepository.save(anuncio);
	}
	
	public Anuncio update(Anuncio anuncio) {
		return sistemaCadastroRepository.save(anuncio);
	}
	
	public void delete(Long id) {
		sistemaCadastroRepository.deleteById(id);
	}
	
	public List<Anuncio> getAll() {
		return sistemaCadastroRepository.findAll();
	}
	
}

