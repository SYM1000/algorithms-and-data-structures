
public class ArrayHandler {
	
	static char[] myName = {'J', 'u', 'a', 'n'};
	
	static int[] arreglo = {0,1,2,3,4,5,6,77};
	static int acumulador  = 0;
	
	public static void main(String [] args) {
		
		for (int i = 0; i < myName.length; i++) {
			
			System.out.println(myName[i]);
		}
		
		
		for (int i = 0; i < arreglo.length; i++) {
			acumulador+=arreglo[i];		
		}
		System.out.println(acumulador);
	}

}
