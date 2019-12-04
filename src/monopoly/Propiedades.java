package monopoly;

public class Propiedades extends Cuadrantes{
	private boolean comprada;
	private int numJugador;
	private int alquiler;
	private int numeroCasilla;
	private String nombresResidencias;
	private String tipo;
	private int Precio;
	private String respuesta;

	public Propiedades(int xCoord, int yCoord, int width, int height, String labelString, int rotacionGrado) {
		super(xCoord, yCoord, width, height, labelString, rotacionGrado);
	}

	/*
	public Propiedades(String nombresResidencias,int precio, int alquiler, int numero, String tipo){
		super(numero);
		this.setNumeroCasilla(numero);
		this.setAlquiler(alquiler);
		this.setNombresResidencias(nombresResidencias);
		this.setPrecio(precio);
		this.setComprada(false);
		this.setTipo(tipo);
		this.setRespuesta("No");
	}
	*/
	public void comprar(Ficha jugador){
		//en el tablero: if jugador desea comprar esta prop, y tiene plata suficiente entonces Comprar();
		//me devuelve mi nuevo monto y setea a la prop como comprada por el jugador numero taltaltal
		this.setComprada(true);
		this.setNumJugador(jugador.getNroJugador());
		jugador.retirarDinero(this.getPrecio());
		jugador.comprarTituloDePropiedad(this.getNumeroCasilla());
		this.setRespuesta("Si");
	}
	
	public void alquiler(Ficha[] jugadores, int index){
		
		jugadores[index].retirarDinero(this.getAlquiler());
		jugadores[numJugador].depositarDinero(this.getAlquiler());

	}


	
	/*@Override
	public void listarAtributos(){
		System.out.println("\n\nCASILLA DE PROPIEDAD: ");
		System.out.println("\nTipo: " + this.getTipo()
				+ "\nNumero de casilla: " + this.getNum()
				+ "\nNumero de la siguiente casilla: " + this.siguiente.getNum()
				+ "\nNombre residencia: " + this.getNombresResidencias()
				+ "\nPrecio: " + this.getPrecio()
				+ "\nComprada?: " + this.getRespuesta());
		if (this.getRespuesta() == "Si"){
			System.out.println("\nDue�o: jugador nro" + this.getNumJugador());
		}
	}*/

	private String getRespuesta() {
		return respuesta;
	}

	private void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public boolean isComprada() {
		return comprada;
	}

	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}

	public int getNumJugador() {
		return numJugador;
	}

	public void setNumJugador(int numJugador) {
		this.numJugador = numJugador;
	}

	public int getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}

	public int getNumeroCasilla() {
		return numeroCasilla;
	}

	public void setNumeroCasilla(int numeroCasilla) {
		this.numeroCasilla = numeroCasilla;
	}

	public String getNombresResidencias() {
		return nombresResidencias;
	}

	public void setNombresResidencias(String nombresResidencias) {
		this.nombresResidencias = nombresResidencias;
	}


	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}
}
