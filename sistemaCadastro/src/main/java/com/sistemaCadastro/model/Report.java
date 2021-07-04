package com.sistemaCadastro.model;

import java.time.temporal.ChronoUnit;

/**
 * Classe Report: gera o relatório do alcance de um anúncio
 * @author margo
 *
 */
public class Report {

	Calculadora calculadora = new Calculadora();

	private double investTotal;
	private double visualizNum;
	private double cliquesNum;
	private double compartilhamentosNum;

	public Report() {
		
	}

	public double calculaInvestimento(Anuncio anuncio) {
		long difDias = ChronoUnit.DAYS.between(anuncio.getInicio(), anuncio.getFim());	
		double valor = difDias * anuncio.getInvestPorDia();
		
		setInvestTotal(valor);
		return valor;
	}

	public double getInvestTotal() {
		return investTotal;
	}

	public void setInvestTotal(double investTotal) {
		this.investTotal = investTotal;
	}

	public double getVisualizacaoNum() {
		return visualizNum;
	}

	public void setVisualizacaoNum(double visualizNum) {
		this.visualizNum = visualizNum;
	}

	public double getCliquesNum() {
		return cliquesNum;
	}

	public void setCliquesNum(double cliquesNum) {
		this.cliquesNum = cliquesNum;
	}

	public double getCompartilhamentosNum() {
		return compartilhamentosNum;
	}

	public void setCompartilhamentosNum(double compartilhamentosNum) {
		this.compartilhamentosNum = compartilhamentosNum;
	}

	/**
	 * Função que gera o relatório completo do alcance do anúncio
	 * @param anuncio 
	 * @return string com o relatório do anúncio em questão
	 */
	public String makeReport(Anuncio anuncio) {
		
		setInvestTotal(calculaInvestimento(anuncio)); 
		
		Calculadora calculadora = new Calculadora();
		
		calculadora.getVisualizacoesMax(this.investTotal);
		setVisualizacaoNum(calculadora.getVisualizacoesNum());
		setCliquesNum(calculadora.getCliquesNum());
		setCompartilhamentosNum(calculadora.getCompartilhamentosNum());
		
		return  "Investimento total: " + getInvestTotal() + ". Número máximo de visualizações: " + String.format("%.0f", getVisualizacaoNum()) + ". Número máximo de cliques: " + String.format("%.0f", getCliquesNum()) + ". Número máximo de compartilhamentos: " + String.format("%.0f", getCompartilhamentosNum()) + "." ; 
	}

}