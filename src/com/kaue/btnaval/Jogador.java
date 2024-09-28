package com.kaue.btnaval;
import com.kaue.btnaval.Tabuleiro;

public class Jogador {
	
	private String nome;
	private int pontos;
	
	public Jogador(String nome) {
		this.nome = nome;
		this.pontos = 5; // Os pontos se referem ao número de navios
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getPontos() {
		return this.pontos;
	}
	
	public void PerdeuPonto(Jogador player) {
		player.pontos -= 1;
	}
	
	@Override
	public String toString() {
		return "Nome: "+this.nome+"\nPontos: "+this.pontos;
	}
}
