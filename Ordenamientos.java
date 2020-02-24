//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: Ordenamientos.java
//Fecha: 2/09/19
//Comentarios: ninguno

import java.util.Arrays;

public class Ordenamientos {
	
	public static <E extends Comparable<E>> void bubbleSort(E[] datos) {
		boolean desordenados = true;
		for (int i = 0; i < datos.length-1 && desordenados; i++) {
			desordenados=false;
			for (int j = 0; j < datos.length-1-i; j++) {
				if(datos[j].compareTo(datos[j+1]) > 0) {
					swap(datos, j, j+1);
					desordenados = true;
				}
			}
		}
		
		/*
		 * implementacion propia
		int temporal;
		for (int j = 0; j < datos.length-1; j++) {
			for (int i = 0; i < datos.length -1; i++) {
				if(datos[i] > datos[i + 1]) {
					temporal = datos[i];
					datos[i] = datos[i + 1];
					datos[i + 1] = temporal;					
				}else {
					continue;
				}
			}
		}*/
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Tarea y con genericos
	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos,0, datos.length-1);
	}
	
	private static <E extends Comparable<E>> void mergesort(E[] datos, int ini, int fin) {
		
		if (ini < fin) {
			int mid = (ini + fin) / 2;
			mergesort(datos, ini, mid);
			mergesort(datos, mid+1, fin);
			merge(datos, ini, fin);
			
		}
	}
	
	private static <E extends Comparable<E>> void merge(E[] datos, int ini, int fin) {
		int mid = (ini + fin) / 2;
		int i = ini,
			j = mid+1,
			k = ini;
		E[] auxiliar = datos.clone();
		
		while (i <= mid && j <= fin) {
			if (auxiliar[i].compareTo(auxiliar[j]) <0) {
				datos[k++] =auxiliar[i++];
			}else {
				datos[k++] = auxiliar[j++];
			}		
		} 
		
		while (i<=mid) {
			datos[k++]=auxiliar[i++];
			}
		}
		
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static <E extends Comparable<E>> void quicksort(E[] datos) {
		quicksort(datos,0, datos.length-1);
	}
	
	private static <E extends Comparable<E>> void quicksort(E[] datos, int left, int right) {
		if(left<right) {
			int p = particionar(datos,left,right);
			quicksort(datos,left,p-1);
			quicksort(datos, p+1, right);
		}
		
	}
	
	private static <E extends Comparable<E>> int particionar(E[] datos, int left, int right) {
		//regresa la posición donde quedó el pivote
	
		E pivote = datos[right];
	    int i = (left-1);
	 
	    for (int j = left; j < right; j++) {
	        if (datos[j].compareTo(pivote) <0) {
	            i++;
	            swap(datos,i,j);
	        }
	    }
	    swap(datos,i+1,right);	 
	    return i+1;
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//Metodo para hacer intercambios de datos
	public static <E> void swap(E[] datos, int i, int j) {
		E temp = datos[i];
		datos[i] = datos[j];
		datos[j] = temp;
		
	}
	
	
	public static <E> void imprimeArreglo(E[] arreglo) {
		//Imprimir el arreglo separado por comas y sin espacios
		for (E valor:arreglo) {
			System.out.print(valor + ", ");
		}
		System.out.println();
	}
	
public static void main(String[] args) {
		
		Integer[] numeros = {0,1,2,56,2,6,2,67,32,2,1};
		Integer[] numeros2 = {32,431,1,4,5,42,89,547,0,48,24,5};
		String[] nombres = {"z", "f","v","a","p","l","f","w","r","z","a"};
		
		//bubbleSort(numeros);
		//imprimeArreglo(numeros);
		
		//bubbleSort(nombres);
		//imprimeArreglo(nombres);
		
		//mergesort(numeros);
		//imprimeArreglo(numeros);
		
		//quicksort(numeros, 0, numeros.length-1);
		quicksort(numeros);
		imprimeArreglo(numeros);
		
	}

}
