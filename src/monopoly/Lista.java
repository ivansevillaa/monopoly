package monopoly;


//Casillas == Nodo;
public class Lista {
	
	private Casillas inicio;
	private Casillas fin;
	private int size;
	
	public Lista(){
		this.inicio = null;
		this.fin = null;
		this.size = 0;
	}
	
	
	
	//verifica si la lista esta vacia
	public boolean vacia(){
		return this.inicio == null;
	}
	
	//este metodo recorre pero en bucle, lo dejo porque les puede servir para algo especifico
	public void mostrarLista(){
		
		Casillas recorrer = inicio;
		while(recorrer != null){
			System.out.println("[" + recorrer.getTipo() + "]--->");
			recorrer = recorrer.siguiente;
		}
		
	}
	
	//agregar casillas
	public void agregar(String nombresResidencias,int precio, int alquiler, String tipo, int x){
		if (tipo=="Propiedad"){
			Casillas nuevo = new Propiedades(nombresResidencias, precio, alquiler, x, tipo);
			
			if (vacia()){
				
				this.inicio = nuevo;
				this.fin = nuevo;
				this.fin.enlazarSiguiente(this.inicio);
				
			} else{
				this.fin.enlazarSiguiente(nuevo);
				nuevo.enlazarSiguiente(this.inicio);
				fin = nuevo;
			}
			this.size++;
		}else{
				Casillas nuevo = new Especiales(tipo, x);
				if (vacia()){
					
					this.inicio = nuevo;
					this.fin = nuevo;
					this.fin.enlazarSiguiente(this.inicio);
					
				} else{
					this.fin.enlazarSiguiente(nuevo);
					nuevo.enlazarSiguiente(this.inicio);
					fin = nuevo;
				}
				this.size++;
		
		}
		
		
		
		
	}
	
	
	public Casillas obtener(int index){//mandar el numero de la casilla que desea obtener contando desde el inicio.
		int contador = 0;
		Casillas temporal = inicio;
		while(contador < index){
			temporal = temporal.obtenerSiguiente();
			contador++;
			
		}
		
		return temporal;
	}
	
	
	
	public void cortar (int index){
		int contador = 0;
		Casillas temporal = inicio;
		while(contador < index -1){
			temporal = temporal.obtenerSiguiente();
			contador++;
		}
		temporal.enlazarSiguiente(null);
		size = index;
	}
	
	public void eliminar(int index){
		if (index == 0){
			inicio = inicio.obtenerSiguiente();
			
		}else{
			int contador = 0;
			Casillas temporal = inicio;
			while(contador < index -1){
				temporal = temporal.obtenerSiguiente();
				contador++;
				
			}
			temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
		}
		size--;
	}
		
	public int size(){
		return size;
	}
	
	

}
