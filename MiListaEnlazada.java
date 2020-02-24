//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: MiListaEnlazada.java
//Fecha: 19/11/19
//Comentarios: ninguno
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MiListaEnlazada<E> implements Iterable<E>{
	
	private NodoLE<E> first;
	private NodoLE<E> last;
	private int size;
	
	public MiListaEnlazada() {
		this.first=this.last=null;
		this.size=0;
	}
	
	public MiListaEnlazada(E[] datos) {
		for (int i = 0; i < datos.length; i++) {
			this.insertAtLast(datos[i]);
		}
	}
	
	public E first() {
		try {
			return this.first.getDato();
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede obtener el primer dato de una lista vacia");
		}
	}
	
	public E last() {
		try {
			return this.last.getDato();
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede obtener el ultimo dato de una lista vacia");
		}
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public void insertAtFirst(E dato) {
		
		NodoLE<E> nvo= new NodoLE<>(dato, first);
		this.first=nvo;
		this.size++;
		if(this.last==null) {
			this.last=this.first;
		}
	}
	
	public void insertAtLast(E dato) {
		if(this.size==0) {
			this.insertAtFirst(dato);
		}else {
		
			NodoLE<E> nvo=new NodoLE<>(dato);
			this.last.setNext(nvo);
			this.last=nvo;
			this.size++;
		}
	}
	
	public void insertAt(E dato, int pos) {
		if(pos<0 || pos>size) {
			throw new IndexOutOfBoundsException(); 
		}
		try {
			NodoLE<E> nodo=first;
			NodoLE<E> nvo=new NodoLE<>(dato);
			NodoLE<E> anterior=null;
			
			if(pos==0) {
				nvo.setNext(first);
				first=nvo;
			}else {
				for (int i = 0; i <=pos ; i++) {
					if(i==pos-1) {
						anterior=nodo;
					}
					if(i==pos) {
						nvo.setNext(anterior.getNext());
						anterior.setNext(nvo);
					}
					nodo=nodo.getNext();
				}
			}
		}catch(NullPointerException e) {
			System.out.println("");
		}
	}
	
	public E removeFirst() {
		try {
			E dato=this.first();
			this.first=this.first.getNext();
			this.size--;
			if(this.size==0) {
				this.first=null;
				this.last=null;
			}
			return dato;
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede borrar el elemento de una lista vacia");
		}
	}
	
	public E removeLast() throws NoSuchElementException{
		try {
			if(this.size<=1) {
				return this.removeFirst();
			}else {
				E dato=this.last();
				NodoLE<E> current=this.first;
				for(int i=0; i<this.size-2;i++) { //Si debe ser size -1
					current=current.next;
				}
				current.next=null;//cuando llega al penultimo, apountar a null
				this.last=current;
				this.size--;
				return dato;
			}
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede borrar el ultimo elemento de la lsita");
		}
	}
	
	public E removeAt(int pos) throws IndexOutOfBoundsException{
	//returna el elemento que borro	
		if(pos<0 || pos>=this.size) {
			throw new IndexOutOfBoundsException("No se puede borrar el elemento en la posición "+pos+" en una lista de tamaño "+this.size);
		}else if(pos==0) {
			return this.removeFirst();
		}else if(pos==this.size-1) {
			return this.removeLast();
		}else {
			
			NodoLE<E> current=this.first;
			E dato;
			for(int i=0; i<pos-1;i++) {
				current=current.next;
			}
			dato=current.getNext().getDato();
			current.setNext(current.next.next);
			return dato;
		}
		
	}
	
	public void setAt(E dato, int pos) {
		if(pos<0 || pos>=this.size) {
			throw new IndexOutOfBoundsException("No se puede insertar en la posicion "+pos+" en una lista de tamaño "+this.size);
		}else if(pos==this.size-1){
			this.last.setDato(dato);
		}else {
			NodoLE<E> current=this.first;
			for (int i = 0; i < pos; i++) {
				current=current.next; //aqui lo recorre hasta encontrar el nodo donde la deseas ingresar
			}
			current.setDato(dato);
			//current.dato=dato;
		}
		
	}
	
	public String toString() {
		NodoLE<E> current=this.first;
		String res="";
		while(current!=null) {
			res+=current.getDato()+",";
			current=current.next;
		}
		return res;

	}
	
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			int pos = 0;
			NodoLE<E> current = first;
			NodoLE<E> prev = first;
			boolean callRemove = false;
			
			@Override
			public boolean hasNext() {
				return pos<size;
			}
			
			@Override
			public E next(){
				if(hasNext()){
                    callRemove = true;
                    pos++;
                    if (pos > 1) {
					    prev = current;
					    current = current.getNext();
					}
					return (pos == 1) ? first() : current.getDato();
				}
				else throw new NoSuchElementException("No hay mas elementos por regresar");
			}
			
			@Override
			public void remove() {
				if(callRemove){
                    try {
                        if(pos == 1) {
                            while (current.getDato().equals(current.getNext().getDato())) {
                                current = current.getNext();
                                size--;
                            }
                            first = current.getNext();
                            size--;
                        }
                        else {
                            E nodo = null;

                            if (pos<size - 1) {
                                while (current.getDato().equals(current.getNext().getDato()) && pos < size - 1) {
                                    current = current.getNext();
                                    nodo = current.getDato();
                                    size--;
                                }
                            }
                            prev.setNext(current.getNext());
                            current = prev.getNext();

                            if (current.getNext() == null && current.getDato().equals(nodo)) {
                            	prev.setNext(null);
                                last = prev;
                                size--;
                            }
                            this.callRemove = false;
                            size--;
                            
                        }
                    } catch (NullPointerException e) {
                        throw new NoSuchElementException();
                    }  
				}else{
					throw new IllegalStateException("Primero debe llamarse a next");
				}
			}
			
			
		};		
		
	}
	
	public static void main(String[] args) {
		
	}


class NodoLE<E> {
	E dato;
	NodoLE<E> next;
	
	public NodoLE(E dato, NodoLE<E> next){
		this.dato=dato;
		this.next=next;
	}
	
	public NodoLE(E dato) {
		this(dato, null);
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public NodoLE<E> getNext() {
		return next;
	}

	public void setNext(NodoLE<E> next) {
		this.next = next;
	}	
}}
