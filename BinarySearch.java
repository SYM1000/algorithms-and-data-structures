
public class BinarySearch {
	
	/*
	public static int binarySearch(int valor, int[] valores) {
		int min = 0,
			max = valores.length-1,
			avg;
		
		min = valores[0];
		max = valores[valores.length -1];
		avg = valores[(max - min) / 2];
				
		while(min <= max) {
			avg = (min + max)/2;
			//Si el valor buscado está en avg, regresar la posicio; si no revisar si es mayor o menor 
			//el valor buscado y actulalizar los inidces
			
			if(valor == valores[avg]) {
				return avg;
			}else if(valor < valores[avg]){
				max = avg -1;
			}else {
				min = avg + 1;
			}		
		}
		return -1;	
		
	}
	
	public static int binarySearch(String valor, String[] valores) {
		int min = 0,
			max = valores.length-1,
			avg;
		
		while(min <= max) {
			avg = (min + max)/2;
			//Si el valor buscado está en avg, regresar la posicio; si no revisar si es mayor o menor 
			//el valor buscado y actulalizar los inidces
			
			if(valor.equals(valores[avg])) {
				return avg;
			}else if(valor.compareTo(valores[avg])<0){
				max = avg -1;
			}else {
				min = avg + 1;
			}		
		}
		return -1;	
		
	}
	
	
	
	//Genericos
	public static <E extends Comparable <E>> int binarySearch(E valor, E[] valores) {
		int min = 0,
			max = valores.length-1,
			avg;
		
		while(min <= max) {
			avg = (min + max)/2;
			//Si el valor buscado está en avg, regresar la posicio; si no revisar si es mayor o menor 
			//el valor buscado y actulalizar los inidces
			
			if(valor == valores[avg]) {
				return avg;
			}else if(valor.compareTo(valores[avg])<0){
				max = avg -1;
			}else {
				min = avg + 1;
			}		
		}
		return -1;	
		
	}
	*/

	//----------------------------------------------------------------------------------------
	
	//TAREA:
	/*
	 * Autor: Santiago Yeomans - A01251000
	 * Nombre de la Clase: BinarySearch.java
     * Fecha: 26/08/19
     * Comentarios: Me parecio muy interesante conocer la fotma en la que se puede combinar
     * 				un algoritmo de busqueda binaria con la recursividad y recordar un poco sobre 
     * 				como usar genericos.
	 */
	
	public static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,E valor) {
        //Función de preparación
		
		int minimo = 0;
		int maximo = valores.length -1;
		
		while(minimo <= maximo) {
			return binarySearchRec(valores, valor, minimo, maximo);	
		}		
		return -1;
				
}

	private static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,E valor,int minimo,int maximo) {
        //Función recursiva
		
		int avg = (minimo + maximo)/2;
		
		if(valor == valores[avg]) {
			return avg;
		}else if(minimo > maximo) {
			return -1;
		}else if(valor.compareTo(valores[avg])<0){
			maximo = avg -1;
			return binarySearchRec(valores, valor, minimo, avg-1);
		}else {
			minimo = avg + 1;
			return binarySearchRec(valores, valor, minimo, maximo);
		}
}
	
	
	
	public static void main(String[] args) {
		/*
		 
		System.out.println(binarySearch(5, numeros));
		
		String[] nombres = {"Jose", "Santiago","Yeomans","Molina"};
		System.out.println(binarySearch("Yeomans", nombres));
		
		System.out.println(binarySearch(5, numeros));
		*/
		
		
		Integer[] numeros = {12,30,50,69,79,90,1000};
		String[] nombres = {"Jose", "Santiago","Yeomans","Molina"};
		System.out.println(binarySearchRec(numeros, 90));
		System.out.println(binarySearchRec(nombres , "Yeomans"));
		
		
	}

}
