//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: Recursividad.java
//Fecha: 19/08/19
//Comentarios: Fue una tarea desafiante 

public class Recursividad {
	
	//Problema 1
	public static int multiplicacionSigno(int n, int m) {		
		if(n>0 && m>0 || n<0 && m<0) {
			return 1;
		} else if(n < 0 || m < 0) {
			return -1;
		} else {
			return -1;
		}
	}
	
	
	public static int multiplicacion(int n, int m) {		

		int numero1 = Math.abs(n);
		int numero2 = Math.abs(m);
		if (n == 0 || m == 0) { return 0; }
		
		if( m < 0 ) {
			return - n + multiplicacion(n, m + 1);
		}else if(n < 0) {
			return n + multiplicacion(n, m - 1);
		}else{
			if (m <= 1) {
				return n * multiplicacionSigno(n, m);
			}else {
				return numero1 + multiplicacion(n, numero2-1);
			}
		}
	}
	
	//Problema 2
	public static String base10a2(int n) {
		if (n <=1) {
			return String.valueOf(n);
		}else {
			if(n%2 == 0) {
				return String.valueOf(base10a2(n/2) + 0);
				
			}else if(n%2 == 1){
				return String.valueOf(base10a2(n/2) + 1);
			}	
		}
		return null;
	}
	

	public static void main(String[] args) {
		System.out.println("Resultado de la multiplicacion: " + multiplicacion(69,-10));
		System.out.println("Base10a2: " + base10a2(32));
		
	}

}
