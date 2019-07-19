import java.util.Arrays;

/**
 * Insertion_Sort
 */
public class Insertion_Sort {
    public static void main(String[] args) {
        
        int arreglo [] = {5,7,11,15,4,12,23,3,4,2,1,45,13};
        System.out.println(Arrays.toString(arreglo));

        int aux;
        int cont1;
        int cont2;

        for(cont1 = 1; cont1<arreglo.length; cont1++){

            aux = arreglo[cont1];
            for(cont2 = cont1-1; cont2 >= 0 && arreglo[cont2]> aux; cont2--){

                arreglo[cont2 +1] = arreglo[cont2];
                arreglo[cont2] = aux;

            }
        }
        System.out.println(Arrays.toString(arreglo));
    }   
}