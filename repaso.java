import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class repaso {
	
	/*
	 * 
	 * RADIX SORT
	 * 
	 */
	
	/*
	 * El numero de iteraciones depende del numero de digitos del numero mas grande
	 * se tiene 10 colas (0 - 9)
	 * por cada iteracion se va incrementado en 1 el indice del numero a comparar
	 * a los numeros que tienen menos digitos que el mayor se completa con 0s 
	 * a medida que se van haciendo los iteraciones se tiene que relleanar el arreglo con 
	   las colas vaciandose
	 */
	
	//RADIX SORT CON COLAS
	
	//Metodo que encuentra el numero mas grande
	public static int max(int[] arreglo) {
		int maximo = arreglo[0];
		
		for (int i = 1; i < arreglo.length; i++) {
			if(arreglo[i] > maximo) {
				maximo = arreglo[i];
			}
		}

		return maximo;
	}
	
	//Metodo que calcula el numero de digitos
	public static int contDigitios(int numeroMaximo) {
		int digitos = 0;
		int numero = numeroMaximo;
		
		while(numero != 0) {
			numero = numero/10;
			digitos ++ ;	
		}
		return digitos; //Regresa el numero de digitos del numero maximo
	}
	
	//Metodo completar numeros con zeros
	
	//Metodo quitar los zeros a los numeros
	
	//Ordenamiento por Radix
	public static void OrdenamientoRadix(int[] arreglo) {
		
		int digitos = contDigitios(max(arreglo));
		
		Queue<Integer>[] arregloColas = (Queue<Integer>[]) new LinkedList[10];
		Queue<Integer> cola0 = new LinkedList<Integer>();
		arregloColas[0] = cola0;
		Queue<Integer> cola1 = new LinkedList<Integer>();
		arregloColas[1] = cola1;
		Queue<Integer> cola2 = new LinkedList<Integer>();
		arregloColas[2] = cola2;
		Queue<Integer> cola3 = new LinkedList<Integer>();
		arregloColas[3] = cola3;
		Queue<Integer> cola4 = new LinkedList<Integer>();
		arregloColas[4] = cola4;
		Queue<Integer> cola5 = new LinkedList<Integer>();
		arregloColas[5] = cola5;
		Queue<Integer> cola6 = new LinkedList<Integer>();
		arregloColas[6] = cola6;
		Queue<Integer> cola7 = new LinkedList<Integer>();
		arregloColas[7] = cola7;
		Queue<Integer> cola8 = new LinkedList<Integer>();
		arregloColas[8] = cola8;
		Queue<Integer> cola9 = new LinkedList<Integer>();
		arregloColas[9] = cola9;
		
		int modulo = 10;
		for (int i = 0; i < digitos; i++) {	
			int divisor = modulo / 10;
			
			for (int j = 0; j < arreglo.length; j++) {
				
				int valor = (int)((arreglo[j]%modulo) / divisor ); //encontrar el valor
				
				//meter el valor a la pila correspondiente
				if (valor == 0) {
					cola0.add(arreglo[j]);
				}else if(valor == 1) {
					cola1.add(arreglo[j]);
				}else if(valor == 2) {
					cola2.add(arreglo[j]);
				}else if(valor == 3) {
					cola3.add(arreglo[j]);
				}else if(valor == 4) {
					cola4.add(arreglo[j]);
				}else if(valor == 5) {
					cola5.add(arreglo[j]);
				}else if(valor == 6) {
					cola6.add(arreglo[j]);
				}else if(valor == 7) {
					cola7.add(arreglo[j]);
				}else if(valor == 8) {
					cola8.add(arreglo[j]);
				}else if(valor == 9) {
					cola9.add(arreglo[j]);
				}
			}
					
				//Reordenar el arreglo con lo que tienen las colas
				int numero = 0;
				Queue<Integer> cola;
				for (int k = 0; k < arregloColas.length; k++) {
					 cola = arregloColas[k];
					 
					while(!cola.isEmpty()) {
						arreglo[numero] = cola.poll();
						numero ++;
					}
				}	
			
			modulo = modulo*10;
		}
		
	}
	
	/*
	 * 
	 * RADIX SORT
	 * 
	 */
	
	
	//***********************************************************************************************
	
	
	/*
	 * 
	 * NOTACION POLACA / INFIJA Y POSTFIJA
	 * 
	 */
	
	//Convertir de infija a postfija     ----> Meto a la pila los operadores
	public static String convertiraPostfija(String infija) {
		
		String postfija = "";
		String[] arreglo = infija.split(" ");
		Stack<String> pila = new Stack<String>();
		boolean volver = true;
		
		for (int i = 0; i < arreglo.length; i++) {
			
			try {
				postfija += Integer.parseInt(arreglo[i]) + " ";
				continue;
			}catch(NumberFormatException e){ //------> Paso 3
				volver = true;
				while(volver == true) {
					
				if(pila.isEmpty()) {
					pila.add(arreglo[i]);
					volver = false;
					continue;
				}else { //la pila no está vacia y se compara por prioridades

					if(arreglo[i].equals("(")) { //Operador Leido
						pila.add(arreglo[i]);
						volver = false;
						continue;
						/*
						if(pila.lastElement().equals("(")) {
							postfija += pila.pop() + " ";
							volver = true;
							
						}else if(pila.lastElement().equals("+") || pila.lastElement().equals("-")) {
							postfija += pila.pop() + " ";
							volver = true;
							
						}else if(pila.lastElement().equals("*") || pila.lastElement().equals("/")) {
							postfija += pila.pop() + " ";
							volver = true;
							
						}else {
							//"^"
							postfija += pila.pop() + " ";
							volver = true;
						}
						*/
						
					}else if(arreglo[i].equals("+") || arreglo[i].equals("-")) {//Operador Leido
						
						if(pila.lastElement().equals("(")) {
							pila.add(arreglo[i]);
							volver = false;
							continue;
							
						}else if(pila.lastElement().equals("+") || pila.lastElement().equals("-")) {
							postfija += pila.pop() + " ";
							volver = true;
							
						}else if(pila.lastElement().equals("*") || pila.lastElement().equals("/")) {
							postfija += pila.pop() + " ";
							volver = true;
							
						}else {
							//"^"
							postfija += pila.pop() + " ";
							volver = true;
						}
						
					}else if(arreglo[i].equals("*") || arreglo[i].equals("/")) { //Operador Leido
						if(pila.lastElement().equals("(")) {
							pila.add(arreglo[i]);
							volver = false;
							continue;
							
						}else if(pila.lastElement().equals("+") || pila.lastElement().equals("-")) {
							pila.add(arreglo[i]);
							volver = false;
							continue;
							
						}else if(pila.lastElement().equals("*") || pila.lastElement().equals("/")) {
							postfija += pila.pop() + " ";
							volver = true;
							
						}else {
							//"^"
							postfija += pila.pop() + " ";
							volver = true;
						}
						
					}else if(arreglo[i].equals("^")) { //Operador Leido
						if(pila.lastElement().equals("(")) {
							pila.add(arreglo[i]);
							volver = false;
							continue;
							
						}else if(pila.lastElement().equals("+") || pila.lastElement().equals("-")) {
							pila.add(arreglo[i]);
							volver = false;
							continue;
							
						}else if(pila.lastElement().equals("*") || pila.lastElement().equals("/")) {
							pila.add(arreglo[i]);
							volver = false;
							continue;
							
						}else {
							//"^"
							postfija += pila.pop() + " ";
							volver = true;
						}
						
						
					}else if(arreglo[i].equals(")")) { //Si es parentesis derecho
						//postfija+= pila.pop() + " ";

						while(!pila.lastElement().equals("(")){
							postfija+= pila.pop() + " ";
						}
						pila.pop();
						volver= false;
						continue;
					}			
				}
			}//Fin del while
	
			}			
		}
		while(!pila.isEmpty()){
			postfija+= pila.pop() + " ";
		}
		
		return postfija;
		
	}
	
	
	//Evaluacion de la expresión en postfija   ----> Meto a la pila los operandos
	public static double evaluarPostfija(String postfija) {
		String[] arreglo = postfija.split(" ");
		Stack<Integer> pila = new Stack<Integer>();
		String operador;
		int x = 0;
		int y = 0;
		int z = 0;
		double resultado;
		
		for (int i = 0; i < arreglo.length; i++) {
			
			try {
				pila.add(Integer.parseInt(arreglo[i]));
			}catch (NumberFormatException e) {
				operador = arreglo[i];
				x = (int) pila.pop();
				y = (int) pila.pop();
				
				//Evaluar la operacion
				if (operador.equals("+")) {
					z = y + x;
				}else if(operador.equals("-")) {
					z = y - x;
				}else if(operador.equals("*")) {
					z = y * x;
				}else if(operador.equals("/")) {
					z = y / x;
				}else if(operador.equals("^")) {
					z = (int) Math.pow(y, z);
				}
				
				pila.add(z);
			}
			continue;
		}
		resultado = pila.pop();
		return resultado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		/*
		 * Piezas de codigo importante(memoria)
		 * 
		 * 
		 * String[] arreglo = expresionPostfijo().split(" ");
		   
		 * 
		 * 
		 * Iterator<MyNodoHT<K, V>> current = subLista.iterator();
		 * while (current.hasNext()) {
				Nodo = current.next();
		 * 
		 * 
		 * current.remove();
		 * 
		 * 
		 * 
		 * 
		 */
		
		// + + + + + + + + + + + + + + + + RADIX SORT + + + + + + + + + + + + + + + + + + + + + + +
		
		/*
		int[]  arreglo = {10,9,8,7,6,5,4,3,2,1,0, 100};
		int[] arreglo2 = {32,431,1,4,5,42,89,547,0,48,24,5};
		//for (int i = 0; i < arreglo.length; i++) {
		//	System.out.print(arreglo[i] + " " );
		//}
		//System.out.println();
		OrdenamientoRadix(arreglo2);
		
		for (int i = 0; i < arreglo2.length; i++) {
			System.out.print(arreglo2[i] + " " );
		}
		*/
		
		
		// + + + + + + + + + + + NOTACION POLACA / INFIJA Y POSTFIJA + + + + + + + + + + + + + + +
		/*
		//String exp = "10 + 20 * ( 50 / 2 ) - 5";
		String exp = "( 5 + 10 ) * 3";
		System.out.println("Expresion infija es: " + exp);
		//System.out.println("Postija correcta: 10 20 50 2 / * + 5 - ");
		System.out.println("Mi expresion: "+ convertiraPostfija(exp));
		System.out.println();
		*/
		
		
		Queue<Integer> cola = new LinkedList<Integer>();
		cola.add(1);
		cola.add(2);
		cola.add(3);
		cola.add(4);
		//System.out.println(cola.peek());
		//System.out.println(cola.poll());
		//System.out.println(cola.peek());
		
		
		Stack<Integer> pila = new Stack<Integer>();
		pila.add(1);
		pila.add(2);
		pila.add(3);
		System.out.println(pila.lastElement());
		System.out.println(pila.contains(3));
		System.out.println(pila.remove(2));
		System.out.println(pila.contains(3));
		
		
		HashMap<String, Integer> mapa = new HashMap<>();
		mapa.put("+", 1);
		mapa.put("-", 1);
		mapa.put("*", 2);
		mapa.put("/", 2);
		//System.out.println(mapa.get("*");
		
		
		
		LinkedList<Integer> lista = new LinkedList<Integer>();
		
		
	}

}
