import java.util.Arrays;

/**
 * Shell_Sort
 */
public class Shell_Sort {
    public static void main(String[] args) {
     int arreglo [] = {5,7,11,15,4,12,23,3,4,2,1,45,13};
     System.out.println(Arrays.toString(arreglo));
     
     int salto, i, j ,k, auxiliar;
     salto = arreglo.length/2;

     while(salto > 0){
        for(i = salto; i < arreglo.length; i++){
            j = i - salto;
            while(j>= 0){
                k = j + salto;
                if(arreglo[j] <= arreglo[k]){
                    j = -1;
                    }else{
                        auxiliar = arreglo[j];
                        arreglo[j] = arreglo[k];
                        arreglo[k] = auxiliar;
                        j-= salto;
                        }
            }
        }
        salto = salto / 2;
        }
        System.out.println("Ordenado con Shell: "+ Arrays.toString(arreglo)); 
    }
}