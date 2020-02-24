import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: EvaluarExpresion.java
//Fecha: 23/09/19
public class EvaluarExpresion {

	String expresionInfija;

	// Constructor
	public EvaluarExpresion(String expresionInfija) {
		this.expresionInfija = expresionInfija;
	}

	// Setter
	public void setexpresionInfija(String expInfija) {
		this.expresionInfija = expInfija;
	}

	// Metodos
	//Evaluar la expresion en postfija
	public double evaluaExpresion() {
		int apuntador = 2;
		String[] arreglo = expresionPostfijo().split(" ");
		LinkedList<String> listaPost = new LinkedList<>(Arrays.asList(arreglo));

		while (listaPost.size() != 1) {
			String dato = listaPost.get(apuntador);
			
			boolean numerico;
            try {
                Double.parseDouble(dato);
                numerico = true;
            } catch(NumberFormatException e) {
                numerico = false;
            }

			if (numerico ==  true) {
				apuntador++;
			}else if (dato.compareTo("^") == 0) {
				listaPost.set(apuntador - 2, Double.toString(Math.pow(Double.parseDouble(listaPost.get(apuntador - 2)),
						Double.parseDouble(listaPost.remove(apuntador - 1)))));
				listaPost.remove(apuntador - 1);
				apuntador--;
			} else if (dato.compareTo("/") == 0) {
				listaPost.set(apuntador - 2, Double.toString(Double.parseDouble(listaPost.get(apuntador - 2))
						/ Double.parseDouble(listaPost.remove(apuntador - 1))));
				listaPost.remove(apuntador - 1);
				apuntador--;
			} else if (dato.compareTo("*") == 0) {
				listaPost.set(apuntador - 2, Double.toString(Double.parseDouble(listaPost.get(apuntador - 2))
						* Double.parseDouble(listaPost.remove(apuntador - 1))));
				listaPost.remove(apuntador - 1);
				apuntador--;
			} else if (dato.equals("+")) {
				listaPost.set(apuntador - 2, Double.toString(Double.parseDouble(listaPost.get(apuntador - 2))
						+ Double.parseDouble(listaPost.remove(apuntador - 1))));
				listaPost.remove(apuntador - 1);
				apuntador--;
			} else if (dato.equals("-")) {
				listaPost.set(apuntador - 2, Double.toString(Double.parseDouble(listaPost.get(apuntador - 2))
						- Double.parseDouble(listaPost.remove(apuntador - 1))));
				listaPost.remove(apuntador - 1);
				apuntador--;
			} else {

			}
		}

		return Double.parseDouble(listaPost.getFirst());
	}
	
	//convertir de infja a postfija
	public String expresionPostfijo() {
		String expPost = ""; 
		MyStack<String> pila = new MyStack<>(); 
		MiListaEnlazada<String> listaE = new MiListaEnlazada<>();
		
		String[] arreglo = expresionInfija.split(" "); 
		Map<String,Integer> Prioridades = new HashMap<>(); 

        Prioridades.put("(", 0); 
		Prioridades.put(")", 0);
		Prioridades.put("+", 1); 
		Prioridades.put("-", 1); 
		Prioridades.put("*", 2);
		Prioridades.put("/", 2); 
		Prioridades.put("^", 3);
		 

        for (int i=0; i <arreglo.length; i++) {
            String dato = arreglo[i];
            
            boolean numerico;
            try {
                Double.parseDouble(dato);
                numerico = true;
            } catch(NumberFormatException e) {
                numerico = false;
            }
            
            if (numerico == true) {	
            	listaE.insertAtLast(dato);
            	
            }else if (dato.compareTo(")")==0) {
            	
                while (pila.top().compareTo("(")!=0) { 
                	listaE.insertAtLast(pila.pop());
                }
                pila.pop(); 
                
            }else if (dato.compareTo("(")==0 || pila.isEmpty()) { 
            	pila.push(dato);
            	
            } else {
                while (!pila.isEmpty() && Prioridades.get(dato) <= Prioridades.get(pila.top())) listaE.insertAtLast(pila.pop());
                pila.push(dato);
            }
        }
        
        while (pila.isEmpty() == false) { 
        	listaE.insertAtLast(pila.pop());
        }
        
        int tamaño = listaE.size();
        for (int i=0; i<tamaño;i++) {
        	expPost += listaE.removeFirst() + " ";
        }
       
 
        return expPost;
        
	    }

	//********************************************************************************************************************
	
	public double evaluarPostfija() {
		String[] arreglo = expresionPostfijo().split(" ");
		Stack<Integer> pila = new Stack<Integer>();
		String operador;
		int x = 0;
		int y = 0;
		int z = 0;
		double resultado;
		
		for (int i = 0; i < arreglo.length; i++) {
			
			try {
				pila.add(Integer.parseInt(arreglo[i]));
			}catch (NumberFormatException e) {
				operador = arreglo[i];
				x = (int) pila.pop();
				y = (int) pila.pop();
				
				//Evaluar la operacion
				if (operador.equals("+")) {
					z = y + x;
				}else if(operador.equals("-")) {
					z = y - x;
				}else if(operador.equals("*")) {
					z = y * x;
				}else if(operador.equals("/")) {
					z = y / x;
				}else if(operador.equals("^")) {
					z = (int) Math.pow(y, z);
				}
				
				pila.add(z);
			}
			continue;
		}
		resultado = pila.pop();
		return resultado;
	}
	
	public void convertiraPostfija() {
		String expPost = ""; 
		Stack<String> pila = new Stack<String>();
		String[] arreglo = expresionInfija.split(" ");
		
		for (int i = 0; i < arreglo.length; i++) {
			
			try {
				expPost += Integer.parseInt(arreglo[i]) + " ";
			}catch(NumberFormatException e){
				
				if(!pila.isEmpty()) {
					pila.add(arreglo[i]);
				}else {
					
					
					
					
				}
				
			}
			
			
			
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		String exp = "10 + 20 * ( 50 / 2 ) - 5";
		EvaluarExpresion evaluarExp = new EvaluarExpresion(exp);
		System.out.println(evaluarExp.expresionPostfijo());
		System.out.println(evaluarExp.evaluaExpresion());
		System.out.println(evaluarExp.evaluarPostfija());
	}
	
	
}