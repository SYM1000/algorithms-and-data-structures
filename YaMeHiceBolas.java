//Autor: Santiago Yeomans - A01251000
//Nombre de la Clase: YaMeHiceBolas.java
//Fecha: 26/08/19
//Comentarios: Fue una tarea muy divertida e interesante 

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics;

public class YaMeHiceBolas extends JFrame{
	int x1;
	int y1;
	int largo;
	int nivel;
	
	public YaMeHiceBolas(){
		super("YaMeHiceBolas");
		this.setSize(720,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.x1 = 50;
		this.largo = 600;
		this.y1 = 350- (largo/2);
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Elige un nivel: "));
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		this.pintaCirculos(g, nivel, x1, y1, largo);
	}

	public void pintaCirculos(Graphics g, int nivel, int x1, int y1, int largo) {
		if(nivel==0) {
			g.drawOval(x1, y1, largo, largo);
		}else {
				this.pintaCirculos(g, nivel-1, x1, y1 + ((largo/2)/2), largo/2);
				this.pintaCirculos(g, nivel-1, (largo/2) + x1, y1 + ((largo/2)/2),largo/2);
				this.pintaCirculos(g, nivel-1, x1, y1, largo);			
		}
	}
	
	public static void main(String[] args) {
		YaMeHiceBolas bolas = new YaMeHiceBolas();
	}
}