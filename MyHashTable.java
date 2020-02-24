//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: MyHashTable.java
//Fecha: 02/10/19
//Comentarios: ninguno

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashTable<K,V>{
	
	private LinkedList<MyNodoHT<K,V>>[] tabla;
	private int size;
	private static final double loadFactor = 0.75;
	
	//Constructor sin parametros
	public MyHashTable() {
		this.tabla = (LinkedList<MyNodoHT<K,V>>[]) new LinkedList[11];  //<--------- DUDA
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i] = new LinkedList<>();
		}
		this.size = 0;
	}
	
	//Constructor con parametros
	public MyHashTable(int tamaño) {
		this.tabla = (LinkedList<MyNodoHT<K,V>>[]) new LinkedList[tamaño]; //Hacer el casting
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i] = new LinkedList<>();
		}
		this.size = 0;
	}
	
	//Metodo insertar
	public void put(K llave, V valor) {
		
		if((double)this.size/this.tabla.length > MyHashTable.loadFactor) {
			rehashing();
		}
		
		int pos = Math.abs(llave.hashCode())%this.tabla.length;
		this.tabla[pos].add(new MyNodoHT<K,V>(llave, valor));
		this.size++;
	}
	
	//metodo Get
		public V get(K llave){
			int pos = Math.abs(llave.hashCode())%this.tabla.length;
			LinkedList<MyNodoHT<K, V>> subLista = tabla[pos];
			
			for (MyNodoHT<K, V> myNodoHT : subLista) {
				if(myNodoHT.llave.equals(llave)) {
					return myNodoHT.valor;
				}
			}
			
			throw new NoSuchElementException("No se encontró la llave");
			
		}
		
	//Metodo remove
	public V remove(K llave) {
			int pos = Math.abs(llave.hashCode())%this.tabla.length;
			LinkedList<MyNodoHT<K, V>> subLista = tabla[pos];
			
			Iterator<MyNodoHT<K, V>> current = subLista.iterator();
			//Nodo copia
			MyNodoHT<K, V> Nodo;
			
			while (current.hasNext()) {
				Nodo = current.next();
				
				if(Nodo.llave.equals(llave)) {
					current.remove();
					this.size--;
					return Nodo.valor;
				}
			}
			throw new NoSuchElementException("La llave no existe en la hash table");	
	}
	
	
	//Metodo rehashing
	private void rehashing() {
		
		LinkedList<MyNodoHT<K,V>>[] copia = this.tabla;
		this.tabla = (LinkedList<MyNodoHT<K,V>>[]) new LinkedList[(2 * copia.length) + 1];
		
		//Llenar la tabla 2n+1 con listas enlazadas vacias
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i] = new LinkedList<>();
		}
		
		//Mover los elemetos de la tabla "copia" a la nueva tabla
		for (int i = 0; i < this.tabla.length; i++) {
			for (MyNodoHT<K, V> Nodo : this.tabla[i]) {

				K llaveOG = Nodo.llave;
				int posNueva = Math.abs(llaveOG.hashCode())%this.tabla.length;
				this.tabla[posNueva].add(new MyNodoHT<K,V>(llaveOG, Nodo.valor));
			}
		}
		
	}
	
	//Metodo Contains
	public boolean containsKey(K llave) { 		
		try {
			int pos = Math.abs(llave.hashCode())%this.tabla.length;
			LinkedList<MyNodoHT<K,V>> subLista = tabla[pos];
			
			for (MyNodoHT<K, V> myNodoHT : subLista) {
				if(myNodoHT.llave.equals(llave)) {
					return true;
				}	
			}
			
			return false;
		
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("La llave no existe en la tabla");
		}		
	}
		
	/*
	public static void main(String[] args) {
		MyHashTable<Integer, String> ht = new MyHashTable<>();
		ht.put(1, "uno");
		ht.put(2, "dos");
		ht.put(3, "tres");
		ht.put(4, "cuatro");
		ht.put(5, "cinco");
		ht.rehashing();
		
		System.out.println(ht.get(3));
		System.out.println(ht.containsKey(3));
		System.out.println(ht.remove(3));
		System.out.println(ht.containsKey(3));		
		
	}*/

}

class MyNodoHT<K,V>{
	K llave;
	V valor;
	
	public MyNodoHT(K llave, V valor) {
		this.llave = llave;
		this.valor = valor;
	}
	
	public String toString() {
		return "Key: " + this.llave + " Value: " + this.valor;
	}
}
