import java.util.Arrays;

/**
 * Bubble_Sort
 * Algoritmo para ordenar de menor a maor con bubble sort
 */
public class Bubble_Sort {
    public static void main(String[] args) {
        int arreglo [] = {0,777,6,3,50,7,7,63,28,31,200,100,300,3,5,8,1};

        int apuntador1;
        int apuntador2;
        int auxiliar;
        int cont = 0;

        for (int i = 0; i < arreglo.length; i++){
        for (int j = 0; j < arreglo.length; j++){

            apuntador1 = arreglo[cont];
            apuntador2 = arreglo[cont + 1];

            if (apuntador1 > apuntador2){
                auxiliar = apuntador2;
                arreglo[cont + 1] = apuntador1;
                arreglo[cont] = auxiliar;
                cont++;
            }else{
                cont++;
            }   

            if (cont + 1  == arreglo.length){
                cont = 0;
            }else{}
            
        }
    }

        System.out.println(Arrays.toString(arreglo));
    }
}