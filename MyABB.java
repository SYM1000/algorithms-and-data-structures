
//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: MyABB.java
//Fecha: 09/10/19
//Comentarios: ninguno

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


public class MyABB<E extends Comparable<E>>{ //Crear relacion de orden para poder comparar y determinar cual es mayoy y menor
	
	private NodoABB<E> root;
	private int size;
	
	public MyABB() {
		super();
	}
	
	public E search(E value) {	
		NodoABB<E> current = this.root;
		
		while(current != null) {
			if (value.equals(current.value)) {
				return current.value;
			}else if(value.compareTo(current.value)<0) {
				current = current.left;
			}else {
				current = current.right;
			}
		}
		
		throw new NoSuchElementException("No se encontró el valor " + value + " en el árbol");
		
	}
	
	
	public void insert(E value) {
		//Considerar si el arbol está vacío
		//Tarea
		
		if(this.root == null) {
			this.root = new NodoABB<E>(value, null, null);
			
		}else {
			NodoABB<E> current = this.root;
			NodoABB<E> NodoNuevo = new NodoABB<E>(value, null, null);
			
			while(current != null) {
				if(value.compareTo(current.value)<0) {
					if(current.left != null) {
						current = current.left;
					}else {
						current.left = NodoNuevo;
						break;
					}
					
				}else {
					if(current.right != null) {
						current = current.right;
					}else {
						current.right = NodoNuevo;
						break;
					}
				}	
			}	
		}	
		size++;
	}
	
	
	public void preorden() {
		preorden(this.root);			
	}
	
	private void preorden(NodoABB<E> current) {
		
		if(current != null) {
			System.out.println(current.value + ",");
			preorden(current.left);
			preorden(current.right);
		}
	
	}
	
	private void inorden() {
		inorden(this.root);
	}
	
	private void inorden(NodoABB<E> current) {
		if(current != null) {
			inorden(current.left);
			System.out.println(current.value + ",");
			inorden(current.right);
		}
	}
	
	private void postorden() {
		postorden(this.root);
	}
	
	private void postorden(NodoABB<E> current) {
		if(current != null) {
			postorden(current.left);
			postorden(current.right);
			System.out.println(current.value + ",");
		}
	}
	
	public E remove(E value) {
		//Tarea terminar el remove y el nivel
		NodoABB<E> current = this.root,
					parent = this.root;
		
		try {
			
			if(value == this.root.value) {
				if(this.root.left != null && this.root.right == null) {
					E valor = this.root.value;
					this.root = root.left;
					size--;
					return valor;
					
				}else if(this.root.left == null && this.root.right != null) {
					E valor = this.root.value;
					this.root = root.right;
					size--;
					return valor;
					
				}else if(root.left == null && root.right == null) {
					this.root =  null;
					size--;
					return null;
				}
			}
			
		while(current != null && !current.value.equals(value)) {
			parent = current;
			current = value.compareTo(current.value)<0?current.left:current.right;
		}
		//Current está en el valor a borrar
		
		//Caso 1: No tiene hijos
		if(current.left==null && current.right==null) {
			if(parent.left == current) {
				parent.left= null;
			}else {
				parent.right= null;
			}
			size--;
			return current.value;
		
		//Caso 2: tiene un hijo(izquierda o derecha)
		}else if(current.left !=null && current.right==null) {
			if(parent.left == current) {
				parent.left= current.left;
			}else {
				parent.right= current.left;
			}
			size--;
			return current.value;
			
		}else if(current.left ==null && current.right!=null) {
			if(parent.left == current) {
				parent.left= current.right;
			}else {
				parent.right= current.right;
			}
			size--;
			return current.value;
			
		//caso 3
		}else {
			NodoABB<E> predecesor = current.left;
			NodoABB<E> copia;
			NodoABB<E> padrePredecesor = current;
			
			//Encontrar el predecesor
			while(predecesor.right != null) {
				padrePredecesor = predecesor;
				predecesor = predecesor.right;
			}
	
			//System.out.println("Predecesor: " + predecesor.value);
			
			if(predecesor.left != null) {
				//System.out.println("pred tiene un hijo");
				
				copia = predecesor;
				copia.right = current.right;
				
				if(current.left != predecesor) {
					//System.out.println("NO son iguales");
					padrePredecesor.right = predecesor.left; //Se elimina el predecesor
					copia.left = current.left;
					
				}else {
					//System.out.println("son iguales");
					copia = predecesor;
					copia.right = current.right;
					copia.left = predecesor.left;
					
				}
				
				//Identificar si el borrar(current) es la izquierda o derecha del padre
				if(parent.left == current) {
					parent.left = copia;
				}else {
					parent.right = copia;
				}		
						
			}else {
				//System.out.println("pred no tiene hijo");
				
				copia = predecesor;
				copia.right = current.right;
				
				if(current.left != predecesor) {
					//System.out.println("NO son iguales");
					padrePredecesor.right = null;
					copia.left = current.left;
	
				}else {
					//System.out.println("son iguales");
					copia.right = current.right;
					copia.left = null;
					
				}
				//Identificar si el borrar(current) es la izquierda o derecha del padre
				if(parent.left == current) {
					parent.left = copia;
					
				}else {
					parent.right = copia;
				}
			}
			
			if(current == this.root) {
				this.root = copia;
			}
				
			E valor = current.value;
			current =  null;
			size--;
			return valor;	
		}

		
		//Si no lo encuentra
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se encontró el valor " + value + " en el arbol");
			}		
		}
		
	
	
	public void nivel() {
		Queue<NodoABB<E>> cola = new LinkedList<NodoABB<E>>();
		
		try {
			cola.add(this.root);
			
			while(!cola.isEmpty()) {
				NodoABB<E> nodo = cola.poll();
				System.out.print(nodo.value + ", ");
				if(nodo.left != null) cola.add(nodo.left);
				if(nodo.right != null) cola.add(nodo.right);				
				
			}
			
			
		}catch(NullPointerException e) {
			throw new NullPointerException("El arbol está vacío");
		}
	}

	public static void main(String[] args) {

	}

}

class NodoABB<E extends Comparable<E>>{
	final E value;
	NodoABB<E>  left,
				right;
	
	public NodoABB(E value, NodoABB<E> left, NodoABB<E> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public E getValue() {
		return value;
	}

	public NodoABB<E> getLeft() {
		return left;
	}

	public void setLeft(NodoABB<E> left) {
		this.left = left;
	}

	public NodoABB<E> getRight() {
		return right;
	}

	public void setRight(NodoABB<E> right) {
		this.right = right;
	}
	
	
	
	
}
