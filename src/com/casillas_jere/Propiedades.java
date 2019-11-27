package monopoly;

public class Propiedades extends Casillas{

	private boolean comprada;
	private int numJugador;
	private int alquiler;
	private int numeroCasilla;
	private String nombresResidencias;
	private String tipo;
	private int Precio;
	private String respuesta;
	
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
	
	public int Comprar(int plata, int numJugador){
		//en el tablero: if jugador desea comprar esta prop, y tiene plata suficiente entonces Comprar();
		//me devuelve mi nuevo monto y setea a la prop como comprada por el jugador numero taltaltal
		this.setComprada(true);
		this.setNumJugador(numJugador);
		plata= plata - this.getPrecio();
		this.setRespuesta("Si");
		
		return plata;
		
	}
	
	public int alquiler(int plata){
		
		plata = plata - this.getAlquiler();
		return plata;
	}

	private int getAlquiler() {
		return alquiler;
	}

	private void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}

	private int getNumeroCasilla() {
		return numeroCasilla;
	}

	private void setNumeroCasilla(int numeroCasilla) {
		this.numeroCasilla = numeroCasilla;
	}

	private String getNombresResidencias() {
		return nombresResidencias;
	}

	private void setNombresResidencias(String nombresResidencias) {
		this.nombresResidencias = nombresResidencias;
	}

	private int getPrecio() {
		return Precio;
	}

	private void setPrecio(int precio) {
		Precio = precio;
	}

	private boolean isComprada() {
		return comprada;
	}

	private void setComprada(boolean comprada) {
		this.comprada = comprada;
	}

	private int getNumJugador() {
		return numJugador;
	}

	private void setNumJugador(int numJugador) {
		this.numJugador = numJugador;
	}
	
	@Override
	public void listarAtributos(){
		System.out.println("\n\nCASILLA DE PROPIEDAD: ");
		System.out.println("\nTipo: " + this.getTipo()
				+ "\nNumero de casilla: " + this.getNum()
				+ "\nNumero de la siguiente casilla: " + this.siguiente.getNum()
				+ "\nNombre residencia: " + this.getNombresResidencias()
				+ "\nPrecio: " + this.getPrecio()
				+ "\nComprada?: " + this.getRespuesta());
		if (this.getRespuesta() == "Si"){
			System.out.println("\nDueño: jugador nro" + this.getNumJugador());
		}
	}

	private String getRespuesta() {
		return respuesta;
	}

	private void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
}
