import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Semanai {
	
	public static void problemaA() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Long> a = new HashMap<Long, Long>(); //Key: numeor de la ruta, Value: La diferencia contra la hora el morrito
		
		long nRutas = sc.nextInt();
		long llegadaMorrito = sc.nextInt();
		
		for (int i = 1; i <= nRutas; i++) {
			//i es el nombre del ruta
			long llegadaCamion = sc.nextInt();
			long diferencia = sc.nextInt();
			
			if(llegadaMorrito == llegadaCamion) {
				System.out.println(i);
				break;
			}
			
			if(llegadaCamion > llegadaMorrito) {
				a.put((long) i, llegadaCamion - llegadaMorrito);
				
			}else {
				while(llegadaCamion < llegadaMorrito) {
					llegadaCamion += diferencia;
				}
				
				if(llegadaMorrito == llegadaCamion) {
					System.out.println(i);
					break;
				}
				a.put((long) i, llegadaCamion - llegadaMorrito);	
			}		
		}
		
		Entry<Long, Long> min = null;
		for(Entry<Long, Long> entry : a.entrySet()) {
	        if (min == null || min.getValue() >= entry.getValue()) {
	            if(min == null || min.getValue() > entry.getValue()){
	                min = entry;
	            }
	        }
	    }
		System.out.println(min.getKey());
	}

	public static void problemaB() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int limite = (int)(n/2) + 1;
		int contCeros = 0;
		int contNegativos = 0;
		int contPositivos = 0;
		String[] arreglo = null;
		
		
		try {
			arreglo = br.readLine().split(" ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			for (int i = 0; i < arreglo.length; i++) {
				int numero = Integer.parseInt(arreglo[i]);
				
				if (numero == 0) {
					contCeros++;
				}else if (numero < 0) {
					contNegativos++;
				}else if(numero > 0) {
					contPositivos++;
				}
				
			}
		}catch (Exception e) {	
		}
		
		
		if(contCeros >= limite) {
			System.out.println("0");
		}else if(contNegativos >= limite) {
			System.out.println("-1");
		}else {
			System.out.println("1");
		}
	}
	
	public static void problemaC() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int base = sc.nextInt();
		int exponente = sc.nextInt();
		String[] arreglo = null;
		int contador = 0;
		
		try {
			arreglo = br.readLine().split(" ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		
		try {
			int exp = exponente;
			for (int i = 0; i < arreglo.length; i++) {
				int numero = Integer.parseInt(arreglo[i]);
				contador += numero * (Math.pow(base, exp-1));
				exp--;	
			}
		}catch (Exception e) {	
		}
		
		if(contador%2 == 0) {
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
		
	}
		
	public static void problemaE() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long tamaño = sc.nextLong();
		long[] moneda = new long[2];
		String[] linea = null;
		long DistanciaBlanco = 0;
		long DistanciaNegro = 0;
		long[] blanco = {1,1};
		long[] negro = {tamaño, tamaño};
		long moneda0 = sc.nextLong();
		long moneda1 = sc.nextLong();
		
		//leer a la moneda
		/*
		try {
			linea = br.readLine().split(" ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		//Convertir la moneda a int
		try {
			for (int i = 0; i < linea.length; i++) {
				moneda[i] = Integer.parseInt(linea[i]);	
			}
		}catch (Exception e) {	
		}
		*/
		
		//Comparar
		DistanciaBlanco = (moneda0 - 1) + (moneda1 - 1);
		DistanciaNegro = (tamaño - moneda0) + (tamaño - moneda1);
		
		if(DistanciaBlanco == DistanciaNegro) {
			System.out.println("White");
		}else if(DistanciaBlanco < DistanciaNegro) {
			System.out.println("White");
		}else {
			System.out.println("Black");
		}
		
		
		
	}

	public static void problemaF() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sc.nextInt();
		long habilidad = sc.nextInt();
		
		String[] linea = null;
		long contador =0;
		
		try {
			linea = br.readLine().split(" ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		long[] arreglo = new long[linea.length];
		
		try {
			for (int i = 0; i < arreglo.length; i++) {
				arreglo[i] = Integer.parseInt(linea[i]);
			}
		}catch (Exception e) {	
		}
		
		while(arreglo.length>0) {
			while(habilidad >= arreglo[0]) {
				contador++;
				arreglo = Arrays.copyOfRange(arreglo, 1, arreglo.length);
				
				if(arreglo.length == 0 ) break;
			}
			
			if (arreglo.length >0) {
				while(habilidad >= arreglo[arreglo.length-1]) {
					contador++;
					//arreglo = Arrays.copyOfRange(arreglo, 1, arreglo.length);
					arreglo = Arrays.copyOfRange(arreglo, 0, arreglo.length-1);
				}
			}
			
		}
		
		
		System.out.println(contador);
		
		
		
	}
	
	public static void problemaG() {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tamaño = sc.nextInt();
		int integrantes = sc.nextInt();
		String[] linea = null;
		ArrayList<Integer> fini = new ArrayList<Integer>();
		HashMap<String, String> a = new HashMap<String, String>();
		
		try {
			linea = br.readLine().split(" ");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		for (int i = 0; i < linea.length; i++) {
			if(a.isEmpty()) {
				a.put(linea[i], linea[i]);
				fini.add(i + 1);
			}else {
				if(a.containsKey(linea[i])) {
					continue;
				}else {
					a.put(linea[i], linea[i]);
					fini.add(i + 1);
				}
			}
		}
		
		if(fini.size() != integrantes) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
			System.out.println(fini.toString());
		}
		
	}
	
	public static void problemaH() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		String[] linea = null;
		
		for (int i = 0; i < n; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			
			if(x - y > 1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}

			
		}
	}
	
	public static void main(String[] args) {
		
		problemaA();
		
	}//Termina el main
	
	
}
