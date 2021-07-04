package com.sistemaCadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaCadastro.model.Anuncio;
import com.sistemaCadastro.service.SistemaCadastroService;

/**
 * Classe para controle do sistema de cadastro de anúncios
 * @author margo
 *
 */
@RestController
public class SistemaCadastroController {
	@Autowired
	private SistemaCadastroService sistemaCadastroService;
	
	@GetMapping(value = "anuncios", produces = "application/json")
	public List<Anuncio> getAll() {
		return sistemaCadastroService.getAll();
	}
	
	@PostMapping(value = "anuncios", produces = "application/json")
	public Anuncio create(@RequestBody Anuncio anuncio) {
		return sistemaCadastroService.create(anuncio);
	}
	
	@DeleteMapping(value = "anuncios/{id}", produces = "application/json")
	public void create(@PathVariable Long id) {
		sistemaCadastroService.delete(id);;
	}
	
	@PutMapping(value = "anuncios", produces = "application/json")
	public Anuncio update(@RequestBody Anuncio anuncio) {
		return sistemaCadastroService.create(anuncio);
	}
	
	
}