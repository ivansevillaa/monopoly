package monopoly;


import java.util.ArrayList;
import java.util.HashMap;

public class Ficha 
{
    private int nroJugador;
    private ArrayList<Integer> tituloPropiedades = new ArrayList<Integer>();;
    private int dinero = 1500;
    private int posicionDeCasilleroActual = 0;
    private HashMap<Integer, Integer> controlPropiedaesCompradas = new HashMap<>();

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

    public Ficha(int nroJugador) {
        this.nroJugador = nroJugador;
    }

    public void moverse(int casillasAMoverse) {
        if(posicionDeCasilleroActual + casillasAMoverse > 40) {
            depositarDinero(200);
            posicionDeCasilleroActual += casillasAMoverse - 40;
        } else {
            posicionDeCasilleroActual += casillasAMoverse;
        }
    }
}
