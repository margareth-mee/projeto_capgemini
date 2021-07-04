package com.sistemaCadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaCadastro.model.Anuncio;

/**
 * Repositório para o sistema de cadastro de anúncios
 * @author margo
 *
 */
@Repository
public interface SistemaCadastroRepository extends JpaRepository<Anuncio, Long>{

}