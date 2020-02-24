
public class hanoiProblema {
	
	public void torresHanoi(int discos, int torre1, int torre2, int torre3 ){
		
		//caso base
		if(discos == 1) {
			System.out.println("Mover disco de torre " + torre1 + " torre " + torre3);
		}else {
			//Dominio
			torresHanoi(discos-1, torre1, torre3, torre2);
			System.out.println("Mover disco de torre " + torre1 + " torre " + torre3);
			torresHanoi(discos-1, torre2, torre1, torre3);
		}
	}
	
	public static void main(String[] args) {
		
		hanoiProblema objHanoi = new hanoiProblema();
		objHanoi.torresHanoi(5, 1, 2, 3);
	}
	
}
