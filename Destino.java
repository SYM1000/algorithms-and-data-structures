import java.lang.reflect.Array;
import java.util.ArrayList;

public class Destino {
	
	private int renglon;
	private int columna;
	private int codigo;
	
	int[][] matriz = {
		    {19, 17, 5, 7, 11, 3, 3, 2}, 
		    {19, 3, 17, 11, 7, 11, 19, 19},
		    {11, 19, 11, 2, 2, 5, 3, 2}, 
		    {3, 5, 11, 2, 5, 13, 17, 17},
		    {3, 3, 19, 11, 3, 13, 11, 17},
		    {5, 5, 5, 17, 17, 13, 19, 17},
		    {17, 11, 17, 19, 5, 7, 2, 2}};
	
	
	public Destino() {
		this.renglon = 0;
		this.columna = 0;
		this.codigo = matriz[0][0];
	}
	
	public Destino(int renglon, int c) {
		this.renglon = renglon;
		this.columna = c;
		this.codigo = matriz[renglon][c];
	}
	
	public Destino(int renglon, int c, int valor) {
		this.renglon = renglon;
		this.columna = c;
		this.codigo = valor;
	}
	
	
	public ArrayList<Destino> destinos(int iteraciones) {
		
		ArrayList<Destino> arreglo = new ArrayList<>();
		
		int renglonAnterior = this.renglon;
		int columnaAnterior = this.columna;
		
		
		for (int i = 0; i < iteraciones; i++) {
			int renglonNuevo =(renglonAnterior + this.matriz[renglonAnterior][columnaAnterior] )%7;
			int columnaNueva =(columnaAnterior + this.matriz[renglonAnterior][columnaAnterior] )%8;
			int valor = this.matriz[renglonNuevo][columnaNueva];
			
			Destino lugar = new Destino(renglonNuevo, columnaNueva, valor);
			arreglo.add(lugar);
			
			renglonAnterior = renglonNuevo;
			columnaAnterior = columnaNueva;
		}
		
		return arreglo;
		
		
	}
	
	
	
public static void main(String[] args) {
	//3,19,11
		Destino d = new Destino(6,2);		
		ArrayList<Destino> a = d.destinos(20);
		
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i).renglon + ", ");
			System.out.print(a.get(i).columna + ", ");
			System.out.print("valor: " + a.get(i).codigo);
			System.out.println();
		}
		
	
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				Destino f = new Destino(i,j);
				ArrayList<Destino> arr = f.destinos(20);
				
				for (int k = 0; k < arr.size(); k++) {
					try {
					
						if(arr.get(k).codigo == 3 && arr.get(k+1).codigo == 19 && arr.get(k+2).codigo == 11) {
							System.out.print(i + " " + j);
							System.out.println();
							
							break;
						}
					}catch (Exception e) {
						continue;
					}
					
					
				}
				
			}
			
		}
		
		
		
		

		
	}

}
