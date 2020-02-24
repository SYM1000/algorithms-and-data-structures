import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyAVL<E extends Comparable<E>> {
	
	private NodoAVL<E> root;
	private int size;
	
	public MyAVL() {
		super();
	}
	
	//Metodo altura
	public int altura(NodoAVL<E> raiz){
		
		try {
			if(raiz == null) {
				return 0;
			}else {
				
				if(raiz.left != null && raiz.right != null) {
					//Escoger el subarbol mayor
					int hIzq = altura(raiz.left);
					int hDer = altura(raiz.right);
					
					if(hIzq > hDer) {
						return hIzq +1;
					}else {
						return hDer + 1;
					}
					
					
				}else if(raiz.left != null && raiz.right == null){
					return altura(raiz.left) +1;
					
					
				}else if(raiz.left == null && raiz.right != null) {
					return altura(raiz.right) +1;	
				}else {	
					return  0;
				}
				
				
			}
		}catch (NullPointerException e) {
			return 0;
		}
	}
	
	//Rotación simple Izquierda
	public void rotacionSimpleIzquierda(NodoAVL<E> pivote) {	
		NodoAVL<E> nuevoPivote = pivote.right;
		NodoAVL<E> medio = nuevoPivote.left;
		nuevoPivote.left = pivote;
		pivote.right = medio;

		pivote.factorBalanceo = (altura(pivote.right) - altura(pivote.left));
		nuevoPivote.factorBalanceo = (altura(nuevoPivote.right) - altura(nuevoPivote.left));
		//medio.factorBalanceo = (altura(medio.right) - altura(medio.left));
		System.out.println("Nuevo pivote en RSI:" + nuevoPivote.value);
	}
	
	//Rotacion simple Derecha
	public void rotacioneSimpleDerecha(NodoAVL<E> pivote) {
		NodoAVL<E> nuevoPivote = pivote.left;
		NodoAVL<E> medio = nuevoPivote.right;
		pivote.left = medio;
		nuevoPivote.right = pivote;
		
		pivote.factorBalanceo = (altura(pivote.right) - altura(pivote.left));
		nuevoPivote.factorBalanceo = (altura(nuevoPivote.right) - altura(nuevoPivote.left));
		System.out.println("Nuevo pivote en RSD:" + nuevoPivote.value);
	}
	
	//Rotacion Doble Izquierda
	public void rotacioneDobleIzquierda(NodoAVL<E> pivote){
		NodoAVL<E> subpivote = pivote.right;
		rotacioneSimpleDerecha(subpivote);
		rotacionSimpleIzquierda(pivote);
		
	}
	
	//Rotacioón doble Derecha
	public void rotacioneDobleDerecha(NodoAVL<E> pivote, NodoAVL<E> current ){	
		
	}
	
	
	
	//Metodo Insert
	public void insert(E value) {
		Stack<NodoAVL<E>> pila = new Stack<NodoAVL<E>>();
		NodoAVL<E> current = this.root;
		NodoAVL<E> NodoNuevo = new NodoAVL<E>(value, null, null);
		
		if(this.root == null) {
			this.root = new NodoAVL<E>(value, null, null);
			
		}else {
			
			
			while(current != null) {
				pila.add(current); //Se añade el nodo a la pila
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
		
		
		//Termina el Insert Normal
		
		//Inicia el equilibrio del arbol
		current = NodoNuevo;
		int FactorBalanceoNuevo = -1;
		NodoAVL<E> NodoPop = new NodoAVL<E>(value, null, null);
		
		while(!pila.isEmpty() && FactorBalanceoNuevo != 0) {

			NodoPop = pila.pop();
			FactorBalanceoNuevo = NodoPop.factorBalanceo;
			
			if(current == NodoPop.left) {
				FactorBalanceoNuevo-=1;
			}else {
				FactorBalanceoNuevo+=1;
			}
			
			NodoPop.factorBalanceo = FactorBalanceoNuevo;
			
			//En caso de que el factor de balanceo esté fuera de los rangos, se hace una rotación
			if(FactorBalanceoNuevo < -1 || FactorBalanceoNuevo > 1) {
				//Rotacion simple a la izquierda
				if(NodoPop.factorBalanceo > 1 && current.factorBalanceo >=0) {
					System.out.println("Se hace una rotacion simple a la izquierda en el nodo " + NodoPop.value + " que tiene un factor de balanceo de " + NodoPop.factorBalanceo);
					this.rotacionSimpleIzquierda(NodoPop);
					NodoAVL<E> aux = current;
					current = NodoPop;
					NodoPop =  aux;
					
					System.out.println("Se hace una rotacion simple a la izquierda en el nodo " + NodoPop.value + " que tiene un factor de balanceo de " + NodoPop.factorBalanceo);
					System.out.println("Nodo pivote es: " +  NodoPop.value + " fb: " + NodoPop.factorBalanceo );
					System.out.println("Nodo current es: " +  current.value + " fb: " + current.factorBalanceo );
					
				//Rotacion simple a la derecha
				}else if(NodoPop.factorBalanceo < 1 && current.factorBalanceo <=0) {
					System.out.println("Se hace una rotacion simple a la derecha en el nodo " + NodoPop.value + " que tiene un factor de balanceo de " + NodoPop.factorBalanceo);
					rotacioneSimpleDerecha(NodoPop);
					NodoAVL<E> aux = current;
					current = NodoPop;
					NodoPop =  aux;
				
					System.out.println("Nodo pivote es: " +  NodoPop.value + " fb: " + NodoPop.factorBalanceo );
					System.out.println("Nodo current es: " +  current.value + " fb: " + current.factorBalanceo );
				
				//Rotacion doble a la izquierda
				}else if(NodoPop.factorBalanceo > 1 && current.factorBalanceo <0) {
					System.out.println("Se hace una rotacion doble a la izquierda en el nodo " + NodoPop.value + " que tiene un factor de balanceo de " + NodoPop.factorBalanceo);
					rotacioneDobleIzquierda(NodoPop);
					System.out.println("Se hace una rotacion doble a la izquierda en el nodo " + NodoPop.value + " que tiene un factor de balanceo de " + NodoPop.factorBalanceo);
					
					
				//Rotacion doble a la derecha
				}else if(NodoPop.factorBalanceo < 1 && current.factorBalanceo <0) {
					System.out.println("Se hace una rotacion doble a la derecha en el nodo " + NodoPop.value + " que tiene un factor de balanceo de " + NodoPop.factorBalanceo);
					
				}			
			}
			
			
			current = NodoPop;
			
			
		}	
	}
	
	
	
	
	
	public static void main(String[] args) {
		MyAVL<Integer> arbol = new MyAVL<Integer>();
		/*
		arbol.insert(25);
		arbol.insert(30);
		arbol.insert(18);
		arbol.insert(15);
		arbol.insert(22);
		arbol.insert(35);
		arbol.insert(33);
		*/
		
		
		arbol.insert(5);
		arbol.insert(3);
		arbol.insert(2);
		System.out.println(arbol.root.value);
		
		/*
		arbol.insert(10);
		arbol.insert(5);
		arbol.insert(15);
		arbol.insert(13);
		arbol.insert(20);
		arbol.insert(14);
		*/
		
		
		
		
		
		
		
	}
	
	
}


class NodoAVL<E extends Comparable<E>>{
	final E value;
	int factorBalanceo;
	NodoAVL<E> left;
	NodoAVL<E>  right;
	
	public NodoAVL(E value, NodoAVL<E> left, NodoAVL<E> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public E getValue() {
		return value;
	}

	public NodoAVL<E> getLeft() {
		return left;
	}

	public void setLeft(NodoAVL<E> left) {
		this.left = left;
	}

	public NodoAVL<E> getRight() {
		return right;
	}

	public void setRight(NodoAVL<E> right) {
		this.right = right;
	}
	
	
	
	
}
