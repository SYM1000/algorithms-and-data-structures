package lista_tipo_pila;

import javax.swing.JOptionPane;

public class ClasePrincipal {

    public static void main(String[] args){
    
        int opcion = 0, nodo = 0;
        Pila pila = new Pila();
        
        do{
            try{
                
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Menu de opciones\n\n"
                        + "1. Instertar un nodo\n"
                        + "2. Eliminar un nodo\n"
                        + "3. ¿La pila esta vacía?\n"
                        + "4. ¿Cual es el ultimo valor ingresado en la pila?\n"
                        + "5. ¿Cuantos nodos tiene la pila?\n"
                        + "6. Vaciar pila\n"
                        + "7. Mostrar contenido de la pila\n"
                        + "8. Salir.\n\n"));
                
               switch (opcion){
                   case 1:
                       nodo = Integer.parseInt(JOptionPane.showInputDialog(null, 
                               "Porfavor ingresa el vlaor a guardar en el nodo" ));
                       pila.InsertarNodo(nodo);
                       break;
                       
                   case 2:
                       if(!pila.PilaVacia()){
                           JOptionPane.showMessageDialog(null, "Se ha eliminado un nodo con el valor " + pila.EliminarNodo());
                       }else{
                           JOptionPane.showMessageDialog(null, "La pila está vacía");
                       }
                       break;
                       
                   case 3:
                       if(pila.PilaVacia()){
                           JOptionPane.showMessageDialog(null, "La pila está vacía");
                       }else{
                           JOptionPane.showMessageDialog(null, "La pila NO está vacía");
                       }
                       break;
                       
                   case 4:
                       if(!pila.PilaVacia()){
                           JOptionPane.showMessageDialog(null, "El ultimo valor ingresado en la pila es: " + pila.MostrarUltimoValorIngresado());
                       }else{
                           JOptionPane.showMessageDialog(null, "La pila está vacía");
                       }
                       break;
                       
                   case 5:
                       JOptionPane.showMessageDialog(null, "la pila contiene " + pila.TamanoPila() + "nodos.");
                       break;
                       
                   case 6:
                       if(!pila.PilaVacia()){
                           pila.VaciarPila();
                           JOptionPane.showMessageDialog(null, "Se ha vaciado la pila correctamente");
                       }else{
                           JOptionPane.showMessageDialog(null, "la pila está vacia");
                       }
                       break;
                       
                   case 7:
                       pila.MostrarValores();
                       break;
                   case 8:
                       opcion = 8;
                       break;
                       
                   default:
                       JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelve intentar nuevamente.");
                       break;
            }
                
            }catch(NumberFormatException e){
            
            }
        
        }while(opcion != 8);
    
    }
   
}
