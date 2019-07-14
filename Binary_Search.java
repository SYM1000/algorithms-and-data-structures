import java.util.Arrays;

/**
 * Binary_Search
 * codigo para algoritmo de busqueda binaria
 * 
 * Reglas:  1. Lista ordenada de menor a mayor
 *          2. No valores repetidos 
 */
public class Binary_Search {
    public static void main(String[] args) {

        int arreglo [] = {10,20,30,40,50,60,70,80};
        int valorBuscado =  30;
        System.out.println("arreglo: " + Arrays.toString(arreglo));
        int cont = 0;
        int apuntador1_pos = 1;
        //int apuntador1 = arreglo[apuntador1_pos - 1];

        int apuntador2_pos = arreglo.length;
        //int apuntador2 = arreglo[apuntador1_pos - 1];

        int apuntadorPM_pos = (int)((apuntador1_pos + apuntador2_pos)/2);
        int apuntadorPM = arreglo[apuntadorPM_pos - 1];

        System.out.println("valor buscado: " + valorBuscado);

        while (valorBuscado != apuntadorPM) {

            if (valorBuscado > apuntadorPM){
                apuntador1_pos = apuntadorPM_pos + 1;
                apuntadorPM_pos = (int)((apuntador1_pos + apuntador2_pos)/2);
                apuntadorPM = arreglo[apuntadorPM_pos - 1];
                cont++;
                continue;
            }else if(valorBuscado < apuntadorPM){
                apuntador2_pos = apuntadorPM_pos - 1;
                apuntadorPM_pos = (int)((apuntador1_pos + apuntador2_pos)/2);
                apuntadorPM = arreglo[apuntadorPM_pos - 1];
                cont++;
                continue;
            }

            }
            if(valorBuscado == apuntadorPM){
                System.out.print("\nse encontró el valor en la posicion ");
                System.out.print(apuntadorPM_pos + " en un numero de " + cont + " intentos");
            }
            
        }  
    }