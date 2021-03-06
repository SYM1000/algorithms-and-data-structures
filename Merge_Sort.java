import java.util.Arrays;

/**
 * Merge_Sort
 */
public class Merge_Sort {

    public static int[] mezclaDirecta(int[] arreglo){
        int i,j,k;
     if(arreglo.length>1){
         int nElementosIzq = arreglo.length/2;
         int nElementosDer = arreglo.length - nElementosIzq;
         int arregloIzq[] = new int[nElementosIzq];
         int arregloDer[] = new int[nElementosDer];

         //Copiando los elementos de la primera parte al arreglo izquiero
         for (i = 0; i < nElementosIzq; i++) {
            arregloIzq[i] = arreglo[i];
         }
        //Copiando los elementos de la segunda parte al arreglo derecho
        for (i = nElementosIzq; i < nElementosDer + nElementosIzq; i++) {
            arregloDer[i - nElementosIzq] = arreglo[i];         
         }

         //Recurisvidad
         arregloIzq= mezclaDirecta(arregloIzq);
         arregloDer = mezclaDirecta(arregloDer);
        i = 0; 
        j = 0;
        k = 0;

        while(arregloIzq.length != j && arregloDer.length != k){
            if(arregloIzq[j] < arregloDer[k]){
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }else{
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }

        }

        //arregloFinal
        while(arregloIzq.length != j ){
            arreglo[i] = arregloIzq[j];
            i++;
            j++;
            }
        while(arregloDer.length != k){
            arreglo[i] = arregloDer[k];
            i++;
            k++;
        }

     } //Fin del if

     return arreglo;

}

    public static void main(String[] args) {
        
        int arreglo [] = {55,4,43,44,2,10,45,67,638,3,0,-5,-9};
        System.out.println(Arrays.toString(arreglo));

        System.out.println("\nOrdenado con merge sort: " + Arrays.toString(mezclaDirecta(arreglo)));

        
  }
}