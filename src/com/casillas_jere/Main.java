package monopoly;

public class Main {

	public static void main(String[] args) {
		
		//todo esto es para probar el funcionamiento de la lista, esta misma es instanciada en el tablero
		
		Lista lista = new Lista();
		
		int x=0;
		
		String [] nombresResidencias = new String [2];
		nombresResidencias[0] = "carlos";
		nombresResidencias[1] = "jorge";
		
		 int [] precio = new int [2];
		 precio[0]= 10;
		 precio [1] = 20;
		 
		 int [] alquiler = new int [2];
		 alquiler[0] = 1;
		 alquiler[1] = 2;
		 
		 String[] tipo = new String[2];
		 tipo[0] = "Salida";
		 tipo[1] = "Propiedad";
		
		 //cargo 2 casillas para probar, una de tipo especial y otra de tipo propiedad.
		lista.agregar(null, 0, 0, tipo[0], x);
		lista.agregar(nombresResidencias[x+1], precio[x+1], alquiler[x+1], tipo[x+1], x+1);
		
		lista.obtener(x).listarAtributos();
		lista.obtener(x+1).listarAtributos();
		
		lista.obtener(x).siguiente.listarAtributos();//tambien funciona con el siguiente del que encontras de esta manera
		
		
		
		
		
	}

}
