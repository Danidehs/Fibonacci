/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacciwords;

/**
 *
 * @author Daniel
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FibonacciWords {
	
	Map<String, String> miMapa = new HashMap < String, String > ();
	
	public String generarFibonacci(int n) {
		if(n == 0)
			return "0";
		else if(n == 1)	
			return "1";
		else {
			return ((miMapa.containsKey(n-1)) ? miMapa.get(n-1) : generarFibonacci(n-1)) 
				 + ((miMapa.containsKey(n-2)) ? miMapa.get(n-2) : generarFibonacci(n-2));      // 1 2 3 4 5 6 7
		}
	}

	public String obtenerFibonacci(int n){
		if(miMapa.containsKey(n))
			return miMapa.get(n);
		return generarFibonacci(n);
	}
	
	public  int contarCaracteres(String cadena, String caracter) {
		int posicion = cadena.indexOf(caracter), contador = 0;
		while(posicion != -1){
			contador++;
			posicion = cadena.indexOf(caracter, posicion + 1);
		}return contador;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		FibonacciWords miClase = new FibonacciWords();
		int valor, contador = 1;
		while((valor = teclado.nextInt()) != -1){
			System.out.println("Case " + contador + ": " + miClase.contarCaracteres(miClase.obtenerFibonacci(valor), teclado.next()));
			contador++;
		}
	}
}
