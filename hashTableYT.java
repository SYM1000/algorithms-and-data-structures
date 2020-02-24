import java.util.Arrays;

public class hashTableYT {
	
	String[] arreglo;
	int tamanio, contador;
	
	public hashTableYT(int tam) {
		this.tamanio = tam;
		this.arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
		
	}
	
	public void funcionHash(String[] cadenaArreglo, String[] arreglo) {
		int i;
		for(i = 0; i<cadenaArreglo.length; i++) {
			String elemento = cadenaArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 7;
			System.out.println("El indice es " +  indiceArreglo + "para el elemento"+ elemento);
			
			//Tratando las colisiones
			while(arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Ocurrio una colisión en el indice" + (indiceArreglo-1) + " cambiar al indice " + indiceArreglo);
				
				indiceArreglo%= tamanio;
			}
			
			arreglo[indiceArreglo] = elemento;
		}
		
	}
	
	//Funcion mostrar 
	
	//Metodo para buscar
	public String buscarClave(String elemento) {
		int indiceArreglo= Integer.parseInt(elemento)%7;
		int contador = 0;
		
		while(arreglo[indiceArreglo] != "-1") {
			if(arreglo[indiceArreglo] == elemento) {
				System.out.println("El elemento " + elemento +  "fue encontrado en el indice" + indiceArreglo);
				return arreglo[indiceArreglo];
			}
			indiceArreglo++;
			indiceArreglo%= tamanio;
			contador++;
			if (contador >7){
				break;
				}		
			}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		hashTableYT hash = new hashTableYT(8);
		String[] elementos = {"20", "33", "21", "10", "12", "14", "56", "100"};
		hash.funcionHash(elementos, hash.arreglo);
		//has.mostrar();
		String buscado = hash.buscarClave("33");
		if(buscado == null) {
			System.out.println("el elemento 33 no se encuentra en la tabla"  );
		}
	}

}
