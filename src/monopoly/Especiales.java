package monopoly;

public class Especiales extends Casillas{

	private int numeroCasilla;
	private String tipo;
	
	
	public Especiales(String tipo, int numero) {
		
		super(numero);
		this.setTipo(tipo);
		this.numeroCasilla= numero;
		
	}
	
	public void ejecutarMetodos(int plata, boolean turno){//recibe la plata y un boolean que dice que es el turno del jugador para el metodo carcel
		//el boolean de la carcel se puede sacar hasta que se hagan bien los metodos, tambien sacar el metodo carcel si es necesario.
		
		if (this.getTipo()=="Carcel"){
			this.Carcel(turno);
		}else if (this.getTipo() == "Fortuna"){
			this.Fortuna(plata);
		}else if (this.getTipo() == "ParadaLibre"){
			this.ParadaLibre(plata);
		}
		
	}
	
	public int Salida(int plata){//instanciar directamente desde tablero, cuando se haya definido que el jugador paso por la salida
		System.out.println("Salida");
		plata = plata+200;
		return plata;
	}
	private int Fortuna(int plata){//hacer metodo de castigo/beneficio random
		
		plata= plata + 100;
		return plata;
	}
	private int ParadaLibre(int plata){
		//ni idea que hace esto(?
		
		return plata;
	}
	private void Carcel(boolean turno ){//aca se me ocurre que los turnos sean booleanos que esten en los jugadores, y que se pregunten cada vez que terminan una accion
		turno = false;						//que no puedan estar los dos al mismo tiempo, que al final de la ejecucion de cada jugador tenga un if que diga
										//if turno == false entonces el otro jugador(turno true)
	}
	
	@Override
	public void listarAtributos(){
		System.out.println("\n\nCASILLA ESPECIAL: ");
		System.out.println("\nTipo: " + this.getTipo()
				+ "\n Numero de casilla: " + this.getNum()
				+ "\n Numero de la siguiente casilla: " + this.siguiente.getNum());
	}
	

	

}
