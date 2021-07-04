package com.sistemaCadastro.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe Anuncio: realiza o cadastro de anuncios  
 * @author margo
 *
 */
@Entity
public class Anuncio {	
	@Id
	@GeneratedValue
	private Long iduser;
	
	@Column
	private String nome;
	
	@Column
	private String cliente;
		
	@Column
    @JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate inicio;
	
	@Column
    @JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate fim;
	
	@Column
	private double investPorDia;
	
	public Anuncio() {}
	
	public Anuncio(Long iduser, String nome, String cliente, LocalDate inicio, LocalDate fim, double investPorDia) {
		this.iduser = iduser;
		this.nome = nome;
		this.cliente = cliente;
		this.inicio = inicio;
		this.fim = fim;
		this.investPorDia = investPorDia;
	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public double getInvestPorDia() {
		return investPorDia;
	}

	public void setInvestPorDia(double investPorDia) {
		this.investPorDia = investPorDia;
	}

}