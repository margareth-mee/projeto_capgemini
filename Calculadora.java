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

	//método para obter o número de visualizacões
	public double getVisualizacoesNum() {
		return visualizacoesNum;
	}

	//método para atualizar o número de visualizações
	public void setVisualizacoesNum(double visualizacoesNum) {
		this.visualizacoesNum = visualizacoesNum;
	}

	//método para calcular o número de cliques dado o número de visualizacoes
	public double calculaCliques(double visualizacoes) {	
		return (12.0/100.0)*visualizacoes;
	}

	//método para calcular o número de compartilhamentos dado o número de visualizacoes
	public double calculaCompartilhamentos(double visualizacoes) {
	    return (3.0/20.0)*calculaCliques(visualizacoes);
	}

	//método para calcular o número de visualizacoes dado o número de visualizacoes inicial
	public double calculaVisualizacoes(double visualizacoes) {
	    return 40.0*calculaCompartilhamentos(visualizacoes);
	}
	
	//método para obter o número de visualizacoes máximas
	public double getVisualizacoesMax( double invest_total) {
		double aux = 30*invest_total;
		setVisualizacoesNum(aux);
		
		for (int i = 0; i<3 ; i++) {
			aux = calculaVisualizacoes(aux);
			setVisualizacoesNum(getVisualizacoesNum() + aux);
		}
		
		return getVisualizacoesNum();
	}
	
	// Testes unitários
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
	