
public class merge {
	
	public static void mergesort(int[] datos) {
		mergesort(datos,0, datos.length-1);
	}

	public static void mergesort(int A[],int izq, int der){
	    if (izq<der){
	            int m=(izq+der)/2;
	            mergesort(A,izq, m);
	            mergesort(A,m+1, der);
	            mergeF(A,izq, m, der);
	    }
	}
	
	public static void mergeF(int A[],int izq, int m, int der){
		int i, j, k;
		//int [] B = new int[A.length]; //array auxiliar
		
		int[] B = A.clone();

		i=izq; j=m+1; k=izq;
		while (i<=m && j<=der) //copia el siguiente elemento más grande
		if (B[i]<=B[j])
		A[k++]=B[i++];
		else
		A[k++]=B[j++];
		while (i<=m) //copia los elementos que quedan de la
		A[k++]=B[i++]; //primera mitad (si los hay)
		}
	
	public static void main(String[] args) {
		int[] arreglo = {2,5,2,567,3,6,8,8,7,666,0};
		mergesort(arreglo);
		
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
	}
}
