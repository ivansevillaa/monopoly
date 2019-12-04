package monopoly;


import java.util.ArrayList;
import java.util.HashMap;

public class Ficha 
{
    private int nroJugador;
    private ArrayList<Integer> tituloPropiedades = new ArrayList<Integer>();;
    private int dinero = 1500;
    private int posicionDeCasilleroActual = 0;
    private boolean penalizacion;
    private HashMap<Integer, Integer> controlPropiedaesCompradas = new HashMap<>();
    private boolean turno;

    public ArrayList<Integer> getTituloPropiedades() {
        return tituloPropiedades;
    }

    public int getDinero() {
        return dinero;
    }

    public void retirarDinero(int montoARetirar) {
        if(montoARetirar > dinero) {
            System.out.println("Jugador " + getNroJugador() + " está en bancarrota");
        } else {
            dinero -= montoARetirar;
        }
    }

    public void depositarDinero(int montoADepositar) {
        dinero += montoADepositar;
        System.out.println("El jugador " + getNroJugador() + "recibió $" + montoADepositar);
    }

    public int getPosicionDeCasilleroActual() {
        return posicionDeCasilleroActual;
    }

    public int getNroJugador() {
        return nroJugador;
    }

    public boolean conTituloDePropiedades(int numeroCasilla) {
        return tituloPropiedades.contains(numeroCasilla) ? true : false;
    }

    public void comprarTituloDePropiedad(int numeroCasilla) {
        if (controlPropiedaesCompradas.containsKey(numeroCasilla)) {
            System.out.println("Esta propiedad ya esta comprada");
        } else {
            tituloPropiedades.add(this.getPosicionDeCasilleroActual());
            controlPropiedaesCompradas.put(numeroCasilla, this.getNroJugador());
        }
    }

    public Ficha(int coordenadaX, int coordenadaY, int ancho, int alto) {
        /*
        * Aca deberian setear el tablero con la ficha. Supongo, no sé la verdad.
        *
        * */
    }

    public boolean getPenalizacion() {
        return penalizacion;
    }
    public void setPenalizacion(boolean penalizacion) {
        this.penalizacion=penalizacion;
    }

    public Ficha(int nroJugador) {
        this.nroJugador = nroJugador;
    }

    public void moverse(int casillasAMoverse) {
        if(posicionDeCasilleroActual + casillasAMoverse > 39) {
            depositarDinero(200);
            posicionDeCasilleroActual+=casillasAMoverse-39;
        }else{
            posicionDeCasilleroActual+=casillasAMoverse;
        }
    }

    public void pagarCarcel() {
        retirarDinero(1000);
        setPenalizacion(true);
    }

    public void generarFortuna() {
        int azar = (int) ((Math.random() * ((10 - 1) + 1)) + 1);
        if (azar >= 1 && azar < 3) {
            retirarDinero(200);
        } else if(azar >= 3 && azar < 6) {
            depositarDinero(700);
        } else {
            retirarDinero(600);
        }
    }
}
