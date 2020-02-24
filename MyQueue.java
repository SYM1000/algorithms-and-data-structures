import java.util.NoSuchElementException;

public class MyQueue<E> {
	private MiListaEnlazada<E> lista;
	
	public MyQueue() {
		this.lista = new MiListaEnlazada<E>();
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.isEmpty();
	}
	
	public void flush() {
		this.lista = new MiListaEnlazada<>();
		System.gc();
	}
	
	public void enqueue(E dato) {
		this.lista.insertAtFirst(dato);
	}
	
	public E dequeue() {
		try {
			return this.lista.removeFirst();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una cola vacía");
		}
		
	}
		
	public E next() {
		try {
			return this.lista.first();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un next de una cola vacia");
		}
		
	}
	
	public static void main(String[] args) {
		MyQueue<String> cola = new MyQueue<>();
		cola.enqueue("J");
		cola.enqueue("C");
		cola.enqueue("O");
		cola.enqueue("L");
		cola.enqueue("A");
		cola.enqueue("R");
		cola.enqueue("s");
		
		for(int i = 0; i < cola.size();i++) { 
			System.out.println(cola.dequeue() + ",");
			
		}
		
		
		while(!cola.isEmpty()) {
			System.out.println(cola.dequeue() + ",");
		}
		System.out.println();
	}
}
