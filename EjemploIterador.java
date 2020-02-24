import java.util.Iterator;
import java.util.NoSuchElementException;

public class EjemploIterador implements Iterable<Integer>{

	private Integer[] valores;
	private int size;


	public EjemploIterador(Integer[] valores) {
		this.valores = valores;
		this.size = valores.length;
	}


	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			int pos  = 0;
			boolean callRemove = false;

			@Override
			public boolean hasNext() {
				return pos<size;
			}

			@Override
			public Integer next() {
				if(hasNext()) {
					callRemove = true;
					return valores[pos++];
				}else {
					throw new NoSuchElementException("No hay mas elementos por regresar");
				}
			}

			@Override
			public void remove() {
				if(this.callRemove) {
					for (int i = pos; i < size; i++) {
						valores[i-1] = valores[i];
					}
					valores[size-1] = null;
					size--;
					pos--;
					this.callRemove = false;
				}else {
					throw new IllegalStateException("Primero debe llamarse a next");
				}
			}
		};
	}



	public static void main(String[] args) {
		Integer[] valores = {1,2,3,4,5,6,7,8,9,10};
		EjemploIterador ei = new EjemploIterador(valores);

		for (Integer tmp : ei) {
			System.out.println(tmp);
		}

		Iterator<Integer> it = ei.iterator();
		Integer tmp;
		while(it.hasNext()) {
			if(it.next().equals(4))
				it.remove();
		}

		for (Integer txp : ei) {
			System.out.println(txp);
		}


	}

}
