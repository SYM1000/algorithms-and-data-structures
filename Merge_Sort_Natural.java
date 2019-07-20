import java.util.Arrays;

/**
 * Merge_Sort de tipo natural
 */
public class Merge_Sort_Natural {

    public static mezclaDirecta2(int[] arreglo){
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
         arregloIzq= mezclaDirecta2(arregloIzq);
         arregloDer = mezclaDirecta2(arregloDer);
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

}

//Metodo mezcla natural
public static void mezclaNatural(int arreglo[]){
    int izquierda = 0;
    int izq = 0;
    int derecha = arreglo.length-1;
    int der = derecha;
    boolean ordenado = false;

    do{
        ordenado = true;
        izquierda = 0;
        while(izquierda < derecha){
            izq = izquierda;
            while (izquierda < derecha && arreglo[izq] <= arreglo[izq + 1]) {
                izq++;
            }
            der = izq + 1;
            while (der == derecha - 1 || der<derecha && arreglo[der] <= arreglo[der + 1]) {
                der++;
            }
            if(der <= derecha){
                mezclaDirecta2(arreglo);
                ordenado = false;

            }
            izquierda =  izq;
        }
    }while(!ordenado);

}



    public static void main(String[] args) {
        
        int arreglo [] = {55,4,43,44,2,10,45,67,638,3,0,-5,-9};
        System.out.println(Arrays.toString(arreglo));
        mezclaNatural(arreglo);
        System.out.println("Ordenado con mezcla natural " + Arrays.toString( arreglo));


        
  }
}