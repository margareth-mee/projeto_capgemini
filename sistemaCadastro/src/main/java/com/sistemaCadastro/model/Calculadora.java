package com.sistemaCadastro.model;

/**
 * Classe que implementa uma calculadora para o cálculo do número máximo de visualizações
 * @author margo
 *
 */
public class Calculadora {

	/**
	 * Atributo Número de visualizações
	 */
	private double visualizacoesNum;
	private double compartilhamentosNum;
	private double cliquesNum;
	
	/**
	 * Construtor da classe Calculadora
	 */
	public Calculadora() {
		this.visualizacoesNum = 0;
		this.compartilhamentosNum = 0;
		this.cliquesNum = 0;
	}

	public double getVisualizacoesNum() {
		return visualizacoesNum;
	}

	public void setVisualizacoesNum(double visualizacoesNum) {
		this.visualizacoesNum = visualizacoesNum;
	}

	public double getCompartilhamentosNum() {
		return compartilhamentosNum;
	}

	public void setCompartilhamentosNum(double compartilhamentosNum) {
		this.compartilhamentosNum = compartilhamentosNum;
	}
	
	public double getCliquesNum() {
		return cliquesNum;
	}

	public void setCliquesNum(double cliquesNum) {
		this.cliquesNum = cliquesNum;
	}

	public double calculaCliques(double visualizacoes) {	
		return (12.0/100.0)*visualizacoes;
	}

	public double calculaCompartilhamentos(double cliques) {
	    return (3.0/20.0)*cliques;
	}

	public double calculaVisualizacoes(double compartilhamentos) {
		return 40.0*compartilhamentos;
	}
	
	/**
	 * Método para obter o número máximo de visualizações
	 * @param invest_total valor do investimento total
	 * @return número máximo de visualizações
	 */
	public double getVisualizacoesMax( double invest_total) {
		double visualizacoes = 30.0*invest_total;
		double cliques = 0;
		double compartilhamentos = 0;
		
		setVisualizacoesNum(visualizacoes);
		
		for (int i = 0; i<3 ; i++) {
			cliques= calculaCliques(visualizacoes);
			compartilhamentos = calculaCompartilhamentos(cliques);
			visualizacoes = calculaVisualizacoes(compartilhamentos);
			
			setVisualizacoesNum(getVisualizacoesNum() + visualizacoes);
			setCompartilhamentosNum(getCompartilhamentosNum() + compartilhamentos);
			setCliquesNum(getCliquesNum() + cliques);
		}		
		return getVisualizacoesNum();
	}	
}
	