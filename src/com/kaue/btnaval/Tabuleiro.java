package com.kaue.btnaval;
import java.util.Random;
import java.util.ArrayList;

public class Tabuleiro {
	
	private String[][] tabuleiro = new String[5][5];
	private String[][] tabuleiroFalso = new String[5][5];
	private Jogador player;
	private int[] posicoes = new int[5]; // Isso aqui guarda as posições em que tem peça
	
	public Tabuleiro(Jogador player) {
		this.player = player;
		
		for (int l = 0; l<5 ; l++) {
			 for (int c = 0; c<5; c++) {
				 this.tabuleiro[l][c] = "~";	 
			 }
		}
		
		for (int l = 0; l<5 ; l++) {
			 for (int c = 0; c<5; c++) {
				 this.tabuleiroFalso[l][c] = "~";	 
			 }
		}
	}
	
	private int getItemPosicoes(int posicao) {
		return this.posicoes[posicao];
	}
	
	private void setPosicoes(int contador, int valor) {
		this.posicoes[contador] = valor;
	}
	
	public static void RevelarNavio(Tabuleiro tab, int l, int c) {
		tab.tabuleiroFalso[l][c] = "X";
	}
	public static void MarcarX(Tabuleiro tab, int l, int c) {
		tab.tabuleiroFalso[l][c] = "0";
	}
	
	public static void MostrarFalso(Tabuleiro tabuleiro) {
		String tab = "";
		
		for (int l = 0; l<5; l++) {
			for (int c = 0; c<5; c++) {
				tab += tabuleiro.tabuleiroFalso[l][c];
			 }
			tab += "\n";
		}
		
		System.out.println(tab);
	}
	
	@Override
	public String toString() {
		String tab = "";
		
		for (int l = 0; l<5; l++) {
			for (int c = 0; c<5; c++) {
				tab += tabuleiro[l][c];
			 }
			tab += "\n";
		}
		return tab +"\n"+this.player;
	}
	
	static public void PosicionarPecas(Tabuleiro tab) {
		System.out.print("Posicionando peças do Jogador: ");
		System.out.println(tab.player.getNome());
		
		Random random = new Random();
		
		int contador = 0;
		
		while (tab.getItemPosicoes(4) == 0) {
			int linha = random.nextInt(5);
			int coluna = random.nextInt(5);
			
			if (contador > 4) {
				break;
			}
			
			if (tab.tabuleiro[linha][coluna] == "N") {
				// Não faz nada
			}
			else {
				String formatando = String.valueOf(linha) + String.valueOf(coluna);
				tab.setPosicoes(contador, Integer.parseInt(formatando));
				contador += 1;
				tab.tabuleiro[linha][coluna] = "N";
			}
		}
	}
	
	public boolean Atacar(Tabuleiro atacado, int linha, int coluna) {
		// Atacado se refere ao tabuleiro do outro jogador
		
		String formatando = String.valueOf(linha) + String.valueOf(coluna);
		int posicaoAtaque = Integer.parseInt(formatando);
		
		for (int pos:atacado.posicoes) {
			if (pos == posicaoAtaque) {
				return true;
			}
		}
		return false;
	}
	
}
