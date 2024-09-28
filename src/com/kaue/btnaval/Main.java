package com.kaue.btnaval;
import com.kaue.btnaval.*;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Iniciando o jogo");
		
		String p1Nome = Utils.Input("Nome do jogador 1: ");
		String p2Nome = Utils.Input("Nome do jogador 2: ");
		
		Jogador player1 = new Jogador(p1Nome); // Criando um jogador
		Jogador player2 = new Jogador(p2Nome); // Criando um jogador
		
		Tabuleiro tab1 = new Tabuleiro(player1); // Criando um tabuleiro para cada
		Tabuleiro tab2 = new Tabuleiro(player2); // Criando um tabuleiro para cada
		
		Tabuleiro.PosicionarPecas(tab1); // Aleatorizando as peças
		Tabuleiro.PosicionarPecas(tab2); // Aleatorizando as peças
		
		boolean jogo = true;
		boolean turnoJogador = false; // false = player1, true = player 2
		
		while(jogo) {
			if (!turnoJogador) {
				System.out.println("Visão de:"+player1.getNome()+"\n");
				
				Tabuleiro.MostrarFalso(tab2); // mostra o mar inimigo
				
				System.out.println(player1.getNome()+" ataque o jogador "+player2.getNome());
				
				String linha = Utils.Input("Digite a linha: ");
				int lin = Integer.parseInt(linha);
				String coluna = Utils.Input("Digite a coluna: ");
				int col = Integer.parseInt(coluna);
				boolean ataque = tab1.Atacar(tab2, lin, col);
				if (ataque) {
					Tabuleiro.RevelarNavio(tab2, lin, col);
					Utils.LimparConsole();
					System.out.println("Acertou \n");
				}else {
					Tabuleiro.MarcarX(tab2, lin, col);
					Utils.LimparConsole();
					System.out.println("Errou \n");
				}
				turnoJogador = !turnoJogador;
				
				if (player2.getPontos() == 0) {
					jogo = false;
					System.out.println("Jogador 1 venceu");
				}
			}
			else {
				System.out.println("Visão de:"+player2.getNome()+"\n");
				
				Tabuleiro.MostrarFalso(tab1); // mostra o mar inimigo
				
				System.out.println(player2.getNome()+" ataque o jogador "+player1.getNome());
				
				String linha = Utils.Input("Digite a linha: ");
				int lin = Integer.parseInt(linha);
				String coluna = Utils.Input("Digite a coluna: ");
				int col = Integer.parseInt(coluna);
				boolean ataque = tab1.Atacar(tab1, lin, col);
				if (ataque) {
					Tabuleiro.RevelarNavio(tab1, lin, col);
					
					Utils.LimparConsole();
					System.out.println("Acertou \n");
					
				}else {
					Tabuleiro.MarcarX(tab1, lin, col);
					
					Utils.LimparConsole();
					System.out.println("Errou \n");
				}
				
				turnoJogador = !turnoJogador;
				
				if (player1.getPontos() == 0) {
					jogo = false;
					System.out.println("Jogador 2 venceu");
				}
			}
		}

		
	}
}
