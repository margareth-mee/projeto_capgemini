package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

/**
 * Classe que implementa uma calculadora para o cálculo do número máximo de visualizações de um anúncio
 * @author margo
 *
 */
public class Calculadora {

	/**
	 * Atributo Número de visualizações
	 */
	private double visualizacoesNum;
	
	/**
	 * Construtor da classe Calculadora
	 */
	public Calculadora() {
		this.visualizacoesNum = 0;
	}

	public double getVisualizacoesNum() {
		return visualizacoesNum;
	}

	public void setVisualizacoesNum(double visualizacoesNum) {
		this.visualizacoesNum = visualizacoesNum;
	}

	public double calculaCliques(double visualizacoes) {	
		return (12.0/100.0)*visualizacoes;
	}

	public double calculaCompartilhamentos(double visualizacoes) {
	    return (3.0/20.0)*calculaCliques(visualizacoes);
	}

	public double calculaVisualizacoes(double visualizacoes) {
	    return 40.0*calculaCompartilhamentos(visualizacoes);
	}
	
	/**
	 * Método para obter o número máximo de visualizações
	 * @param invest_total valor do investimento total
	 * @return número máximo de visualizações
	 */
	public double getVisualizacoesMax(double invest_total) {
		double aux = 30.0*invest_total;
		setVisualizacoesNum(aux);
		
		for (int i = 0; i<3 ; i++) {
			aux = calculaVisualizacoes(aux);
			setVisualizacoesNum(getVisualizacoesNum() + aux);
		}		
		return getVisualizacoesNum();
	}
	
	/**
	 * Testes unitários
	 */
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
