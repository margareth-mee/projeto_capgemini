package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

//Classe Calculadora
public class Calculadora {

	//atributos 
	private double visualizacoesNum;
	
	//construtor
	public Calculadora() {
		this.visualizacoesNum = 0;
	}

	//m�todo para obter o n�mero de visualizac�es
	public double getVisualizacoesNum() {
		return visualizacoesNum;
	}

	//m�todo para atualizar o n�mero de visualiza��es
	public void setVisualizacoesNum(double visualizacoesNum) {
		this.visualizacoesNum = visualizacoesNum;
	}

	//m�todo para calcular o n�mero de cliques dado o n�mero de visualizacoes
	public double calculaCliques(double visualizacoes) {	
		return (12.0/100.0)*visualizacoes;
	}

	//m�todo para calcular o n�mero de compartilhamentos dado o n�mero de visualizacoes
	public double calculaCompartilhamentos(double visualizacoes) {
	    return (3.0/20.0)*calculaCliques(visualizacoes);
	}

	//m�todo para calcular o n�mero de visualizacoes dado o n�mero de visualizacoes inicial
	public double calculaVisualizacoes(double visualizacoes) {
	    return 40.0*calculaCompartilhamentos(visualizacoes);
	}
	
	//m�todo para obter o n�mero de visualizacoes m�ximas
	public double getVisualizacoesMax( double invest_total) {
		double aux = 30*invest_total;
		setVisualizacoesNum(aux);
		
		for (int i = 0; i<3 ; i++) {
			aux = calculaVisualizacoes(aux);
			setVisualizacoesNum(getVisualizacoesNum() + aux);
		}
		
		return getVisualizacoesNum();
	}
	
	// Testes unit�rios
	@Test
	void test() {
		Calculadora calculadora = new Calculadora();
		double resultado = calculadora.getVisualizacoesMax(0.0);
		assertEquals("0,00", String.format("%.2f", resultado ) );
		
		resultado = calculadora.getVisualizacoesMax(100.0);
		assertEquals("7834,94", String.format("%.2f", resultado) );
		
		resultado = calculadora.getVisualizacoesMax(30.8);
		assertEquals("2413,16", String.format("%.2f", resultado ) );		
		
		resultado = calculadora.getVisualizacoesMax(0.5);
		assertEquals("39,17", String.format("%.2f", resultado ) );		
		
		resultado = calculadora.getVisualizacoesMax(5000);
		assertEquals("391747,20", String.format("%.2f", resultado ) );
		
		resultado = calculadora.getVisualizacoesMax(1.7);
		assertEquals("133,19", String.format("%.2f", resultado ) );
		
	}

}
//FIM
	