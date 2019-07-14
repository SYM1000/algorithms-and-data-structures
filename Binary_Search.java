import java.util.Arrays;

/**
 * Binary_Search
 * codigo para algoritmo de busqueda binaria
 * 
 * Reglas:  1. Lista ordenada de menor a mayor
 *          2. No valores repetidos 
 * 
 * NOTA: Cantidad máxima de intentos se calcula:
 * Logartimo natural del largo del arreglo
 */
public class Binary_Search {
    public static void main(String[] args) {

        int arreglo [] = {10,20,30,40,50,60,70,80};
        int valorBuscado =  55;
        int cont = 0;
        int estimacion_intentos = (int) Math.log(arreglo.length);
        int apuntador1_pos = 1;
        int apuntador2_pos = arreglo.length;

        int apuntadorPM_pos = (int)((apuntador1_pos + apuntador2_pos)/2);
        int apuntadorPM = arreglo[apuntadorPM_pos - 1];

        System.out.println("arreglo: " + Arrays.toString(arreglo));
        System.out.println("valor buscado: " + valorBuscado);

        while (valorBuscado != apuntadorPM) {

            if (estimacion_intentos == cont && valorBuscado != apuntadorPM){
                break;
            }

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
            //Cuando se encuentre el valor se imprime la posicion en la que está y el numero de intentos que tomó encontrarlo
            //Si el valor no existe en el arreglo, se imprime "El valor buscado no existe en el arreglo"
            if(valorBuscado == apuntadorPM){
                System.out.print("\nSe encontró el valor en la posicion ");
                System.out.print(apuntadorPM_pos + " en un numero de " + cont + " intentos");
            }else{
                System.out.println("\nEl valor buscado no existe en el arreglo");
            }
            
        }  
    }