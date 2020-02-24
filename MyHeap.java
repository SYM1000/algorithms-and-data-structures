import java.util.Arrays;

//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: MyHeap.java
//Fecha: 24/10/19
//Comentarios: ninguno

public class MyHeap<E extends Comparable<E>> {
	
	//Atributos
	private E[] heap;
	private int size;
	
	//Constructor por default
	public MyHeap() {
		this.heap = (E[]) new Comparable[127];
		this.size = 0;
	}
	
	//Constructor con parametros
	public MyHeap(E[] arreglo) {
		this.size= arreglo.length;
		this.heap = arreglo;
		this.heapify();
		
	}
	
	public void heapify() {
		int i = (this.heap.length/2)-1;
		int hijoizq;
		int hijoDer;
		int mayor;
		E temp;
		
		while(i>-1) {
			hijoizq = 2 * i + 1;
			hijoDer = 2 * i + 2;
			
			if(hijoizq < heap.length) {
				mayor = i;
				
				if(heap[mayor].compareTo(heap[hijoizq])<0) {
					mayor = hijoizq;
				}
				
				if(hijoDer<heap.length) {
					
					if(heap[mayor].compareTo(heap[hijoDer])<0) {
						mayor = hijoDer;
					}
					
				}
				
				if(i!=mayor) {
					temp = heap[i];
					heap[i] = heap[mayor];
					heap[mayor] = temp;
					i = mayor;
					continue;
				}
			}
			i-=1;
		}	
	}
	
	
	
	//Metodo Insertar
	public void insert(E valor) {
		if(this.size == 0) {
			this.heap[0] = valor;
			this.size++;
		}else {
			this.heap = Arrays.copyOf(this.heap, ++this.size);
			this.heap[size-1] = valor;
			this.heapify();
		}
		
		
	}
	
	
	//Metodo Eliminar
	public E delete() {
		
		if (this.size == 0) {
			return null;
		}else {

			E max = heap[0]; 
		    E ultimoElemento = this.heap[this.heap.length-1];
		      int current = 0;
		      int hijo = 1;   
		      
		      while (hijo <= size){
		         if (hijo < size && heap[hijo].compareTo(heap[hijo + 1]) < 0){
		        	 hijo++;
		         }

		         if (ultimoElemento.compareTo(heap[hijo]) >= 0) {
		        	 break; 
		         }else {
		        	 heap[current] = heap[hijo];
			         current = hijo; 
			         hijo *= 2;
		         }
		      }
		      heap[current] = (E) ultimoElemento;
		      this.heap = Arrays.copyOf(this.heap, this.heap.length-1);
		     
		      this.size--;
		      this.heapify();
		      return (E) max;
		}		
	}
	
	//Metodo esta vacío
	public boolean isEmpty() {
		if (this.heap.length != 0) {
			return false;
		}else {
			return true;
		} 
	}
	
	//Metodo tamaño
	public int size() {
		return this.size;
	}
	
	//Metodo para imprimir
	public String toString() {
		String respuesta  = "";
		
		for (E e : heap) {
			respuesta += e + ",";
		}
		
		return respuesta;	
	}	
	
	
	
	//Problema A
			/*
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br.readLine();
			
			
			Scanner sc = new Scanner(System.in);
			int nRutas = sc.nextInt();
			int llegadaServal = sc.nextInt();
			*/

}
