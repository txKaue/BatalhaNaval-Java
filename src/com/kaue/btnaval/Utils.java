package com.kaue.btnaval;
import java.util.Scanner;

public class Utils {
	
	public static String Input(String mensagem) {
		Scanner scan = new Scanner(System.in);
		System.out.print(mensagem);
		String resposta = scan.next();
		return resposta;
	}
	
	public static void LimparConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println("");  // Imprime várias linhas vazias
	    }
	}
}
