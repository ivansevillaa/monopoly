package monopoly;

public class Especiales extends Cuadrantes{

	private int numeroCasilla;
	private String tipo;
	
	
	public Especiales(String tipo, int numero) {
		
		super(numero);
		this.setTipo(tipo);
		this.numeroCasilla= numero;
		
	}
	
	public void ejecutarMetodos(Ficha jugador){//recibe la plata y un boolean que dice que es el turno del jugador para el metodo carcel
		//el boolean de la carcel se puede sacar hasta que se hagan bien los metodos, tambien sacar el metodo carcel si es necesario.
		
		if (this.getTipo()=="Carcel"){
			this.Carcel(jugador);
		}else if (this.getTipo() == "Fortuna"){
			this.Fortuna(jugador);
		}else if (this.getTipo() == "ParadaLibre"){
			this.ParadaLibre(jugador);
		}
		
	}
	
	/*public int Salida(int plata){//instanciar directamente desde tablero, cuando se haya definido que el jugador paso por la salida
		System.out.println("Salida");
		plata = plata+200;
		return plata;
	}*/
	private void Fortuna(Ficha jugador){//hacer metodo de castigo/beneficio random
		jugador.depositarDinero(100);
	}
	private void ParadaLibre(Ficha jugador){
		System.out.println("Parada Libre");
	}
	private void Carcel(Ficha jugador){//aca se me ocurre que los turnos sean booleanos que esten en los jugadores, y que se pregunten cada vez que terminan una accion
		jugador.setPenalizacion(true);
	}
	
	@Override
	public void listarAtributos(){
		System.out.println("\n\nCASILLA ESPECIAL: ");
		System.out.println("\nTipo: " + this.getTipo()
				+ "\n Numero de casilla: " + this.getNum()
				+ "\n Numero de la siguiente casilla: " + this.siguiente.getNum());
	}
	

	

}
