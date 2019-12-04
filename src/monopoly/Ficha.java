package monopoly;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Ficha extends JPanel
{

    private ArrayList<Integer> tituloPropiedades = new ArrayList<Integer>();
    private int dinero = 1500;
    private int posicionDeCasilleroActual = 0;
    private boolean penalizacion;
    private HashMap<Integer, Integer> controlPropiedaesCompradas = new HashMap<>();
    static HashMap<Integer, Integer> Filmina = new HashMap<>();
    private boolean turno;
    private int Numerojug=0;
    JLabel lbNumerojug;

    int[] jugador01x = {31, 131, 231, 331, 431, 531,
            531, 531, 531, 531, 531,
            431, 331, 231, 131, 31,
            31, 31, 31, 31};

    int[] jugador01y = {33, 33, 33, 33, 33, 33,
            133, 233, 333, 433, 533,
            533, 533, 533, 533, 533,
            433, 333, 233, 133};

    int[] jugador02x = {61, 191, 291, 361, 461, 561,
            561, 561, 561, 561, 561,
            461, 361, 261, 161, 61,
            61, 61, 61, 61};

    int[] jugador02y = {33, 33, 33, 33, 33, 33,
            133, 233, 333, 433, 533,
            533, 533, 533, 533, 533,
            433, 333, 233, 133};



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
        return Numerojug;
    }

    public boolean conTituloDePropiedades(int numeroCasilla) {
        return tituloPropiedades.contains(numeroCasilla) ? true : false;
    }

    public void PagarDeuda(int deuda) {
        if(deuda > dinero) {
            setVisible(false);
            System.out.println("El Jugador "+ Numerojug + " Quedo en banca rota!");
        } else {
            dinero -= deuda;
        }
    }

    public void comprarTituloDePropiedad(int numeroCasilla) {
        if (controlPropiedaesCompradas.containsKey(numeroCasilla)) {
            System.out.println("Esta propiedad ya esta comprada");
        } else {
            tituloPropiedades.add(this.getPosicionDeCasilleroActual());
            controlPropiedaesCompradas.put(numeroCasilla, this.getNroJugador());
        }
    }

    public Ficha(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 20, 20);
        this.setLayout(null);
    }

    public Ficha(int Numerojugarode, Color color)
    {

        this.Numerojug = Numerojugarode;
        this.setBackground(color);
        lbNumerojug = new JLabel(""+Numerojugarode);
        lbNumerojug .setFont(new Font("Arial Grande", Font.BOLD, 15));
        lbNumerojug .setForeground(Color.WHITE);
        this.add(lbNumerojug );
        this.setBounds(Numerojugarode*30, 33, 30, 28);
        Numerojug++;
    }

    public boolean getPenalizacion() {
        return penalizacion;
    }
    public void setPenalizacion(boolean penalizacion) {
        this.penalizacion=penalizacion;
    }

    public Ficha(int nroJugador) {
        this.Numerojug = nroJugador;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    public void moverse(int casillasAMoverse)
    {
        if (posicionDeCasilleroActual + casillasAMoverse > 19) {
            depositarDinero(200);

            int objetivo = (posicionDeCasilleroActual + casillasAMoverse);

            if (Memepolimein.juegoON == 1) {

                this.setLocation(jugador01x[objetivo], jugador01y[objetivo]);


            } else {

                this.setLocation(jugador02x[objetivo], jugador02y[objetivo]);

            }
        }
    }

    public void pagarCarcel(Ficha ficha)
    {
        retirarDinero(100);
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
