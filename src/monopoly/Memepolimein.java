package monopoly;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import monopoly.Ficha;
import monopoly.Dado;
import monopoly.Tablero;

public class Memepolimein extends JFrame
{
    private JPanel contentIncluder;
    static JTextArea infoConsole;
    JPanel playerAssetsPanel;
    static int turnCounter = 0;
    JButton btnNextTurno;
    JButton btnRollDadin;
    JButton btnPagarRnt;
    JButton btnComprar;
  /*  JTextArea panelPlayer1TextArea;
    JTextArea panelPlayer2TextArea;*/
    Tablero Tableroenjuego;
    static int juegoON = 0;
    ArrayList<Ficha> jugadorenae = new ArrayList<>();
    Ficha jugador01;
    Ficha jugador02;
    boolean turnoPlayer1 = false;
    boolean turnoPlayer2 = false;
    CardLayout c1 = new CardLayout();
    Boolean doubleDiceForPlayer1 = false;
    Boolean doubleDiceForPlayer2 = false;





    public Memepolimein()
    {
        //Aca creamos el tablero y la ventana en si para que se ejecute dentro de esos parametros
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setSize(1080,720);
        contentIncluder = new JPanel();
        contentIncluder.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentIncluder);
        contentIncluder.setLayout(null);
//Seteamos la ventana principal vendria a ser el cuadrado donde va a estar todo no sabria explicar (el panel eso es)xd
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        layeredPane.setBounds(6, 6, 632, 630);
        contentIncluder.add(layeredPane);
//Hacemos el tablerito en juego xdxd
        Tableroenjuego = new Tablero(6,6,612,612);
        Tableroenjuego.setBackground(new Color(51, 255, 153));
        layeredPane.add(Tableroenjuego, new Integer(0));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        rightPanel.setBounds(640, 6, 419, 600);
        contentIncluder.add(rightPanel);
        rightPanel.setLayout(null);

        jugador01 = new Ficha(1, Color.BLACK);
        jugadorenae.add(jugador01);
        layeredPane.add(jugador01, new Integer(1));

        jugador02 = new Ficha(2, Color.PINK);
        jugadorenae.add(jugador02);
        layeredPane.add(jugador02, new Integer(2));


        btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

            //turnCounter--;
            Ficha currentPlayer = jugadorenae.get(juegoON);
            infoConsole.setText("You bought "+Tableroenjuego.getAllCuadrantes().get(currentPlayer.getPosicionDeCasilleroActual()).getName());
            currentPlayer.buyTitleDeed(currentPlayer.getPosicionDeCasilleroActual());
            int Retirarmonto = Tableroenjuego.getAllCuadrantes().get(currentPlayer.getPosicionDeCasilleroActual()).getPrecio();
            currentPlayer.Retirardinero(Retirarmonto);
            btnComprar.setEnabled(false);
            //updatePanelPlayer1TextArea();
            //updatePanelPlayer2TextArea();
            //turnCounter++;
            }
        });
        btnComprar.setBounds(81, 478, 117, 29);
        rightPanel.add(btnComprar);
        btnComprar.setEnabled(false);

        btnPagarRnt = new JButton("Pagar renta");

        btnPagarRnt.setBounds(210, 478, 117, 29);
        rightPanel.add(btnPagarRnt);
        btnPagarRnt.setEnabled(false);

        btnPagarRnt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // turnCounter--;
                Ficha currentPlayer = jugadorenae.get(juegoON);
                Ficha dueñoDelCuadrante = jugadorenae.get((Ficha.Filmina.get(currentPlayer.getPosicionDeCasilleroActual()))==1?0:1);
                infoConsole.setText("You paid to the player "+dueñoDelCuadrante.getNumerojug());

                int withdrawAmount = Tableroenjuego.getAllCuadrantes().get(currentPlayer.getPosicionDeCasilleroActual()).getRentPrecio();
                System.out.println(withdrawAmount);
                currentPlayer.PagarDeuda(withdrawAmount);
                dueñoDelCuadrante.PagarDeuda(withdrawAmount);

                btnNextTurno.setEnabled(true);
                btnPagarRnt.setEnabled(false);
                //currentPlayer.withdrawFromWallet(withdrawAmount);
               // updatePanelPlayer1TextArea();
                //updatePanelPlayer2TextArea();
                //turnCounter++;
                //gameBoard.getAllSquares().get(player1.getCurrentSquareNumber()).setRentPaid(true);
            }

        });


        Dado dado1 = new Dado(244, 406, 40, 40);
        layeredPane.add(dado1, new Integer(1));

        Dado dado2 = new Dado(333, 406, 40, 40);
        layeredPane.add(dado2, new Integer(1));

        btnRollDadin = new JButton("Tirar Dados");
        btnRollDadin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (juegoON == 0) {
                    // player1's turn
                    int dice1OldValue = dado1.getFaceValue();
                    int dice2OldValue = dado2.getFaceValue();
                    dado1.tirarDados();
                    dado2.tirarDados();
                    int dicesTotal = dado1.getFaceValue() + dado2.getFaceValue();
                    if (dado1.getFaceValue() == dado2.getFaceValue()) {
                        doubleDiceForPlayer1 = true;
                    } else {
                        doubleDiceForPlayer1 = false;
                    }
                    jugador01.moverse(dicesTotal);
                    if (Ficha.Filmina.containsKey(jugador01.getPosicionDeCasilleroActual()) // if bought by someone
                            && Ficha.Filmina.get(jugador01.getPosicionDeCasilleroActual()) != jugador01.getNumerojug() // not by itself
                    ) {
                        btnComprar.setEnabled(false);
                        btnRollDadin.setEnabled(false);
                        btnNextTurno.setEnabled(false);
                        btnPagarRnt.setEnabled(true);
                    }
                    if (Ficha.Filmina.containsKey(jugador01.getPosicionDeCasilleroActual()) // if bought by someone
                            && Ficha.Filmina.get(jugador01.getPosicionDeCasilleroActual()) == jugador01.getNumerojug()) { // and by itself
                        btnComprar.setEnabled(false);
                        btnPagarRnt.setEnabled(false);
                        btnNextTurno.setEnabled(true);
                    }
                    if (Tableroenjuego.getCuadrantesincomprables().contains(Tableroenjuego.getAllCuadrantes().get(jugador01.getPosicionDeCasilleroActual()))) {
                        btnComprar.setEnabled(false);
                        btnNextTurno.setEnabled(true);
                    } else if (!Ficha.Filmina.containsKey(jugador01.getPosicionDeCasilleroActual())) { // if not bought by someone
                        btnComprar.setEnabled(true);
                        btnNextTurno.setEnabled(true);
                        btnPagarRnt.setEnabled(false);
                    }


                } else {
                    // player2's turn
                    int dice1OldValue = dado1.getFaceValue();
                    int dice2OldValue = dado2.getFaceValue();
                    dado1.tirarDados();
                    dado2.tirarDados();
                    int dicesTotal = dado1.getFaceValue() + dado2.getFaceValue();
                    if (dado1.getFaceValue() == dado2.getFaceValue()) {
                        doubleDiceForPlayer2 = true;
                    } else {
                        doubleDiceForPlayer2 = false;
                    }
                    jugador02.moverse(dicesTotal);
                    if (Ficha.Filmina.containsKey(jugador02.getPosicionDeCasilleroActual()) // if bought by someone
                            && Ficha.Filmina.get(jugador02.getPosicionDeCasilleroActual()) != jugador02.getNumerojug() // not by itself
                    ) {
                        btnComprar.setEnabled(false);
                        btnRollDadin.setEnabled(false);
                        btnNextTurno.setEnabled(false);
                        btnPagarRnt.setEnabled(true);
                    }
                    if (Ficha.Filmina.containsKey(jugador02.getPosicionDeCasilleroActual()) // if bought by someone
                            && Ficha.Filmina.get(jugador02.getPosicionDeCasilleroActual()) == jugador02.getNumerojug()) { // and by itself
                        btnComprar.setEnabled(false);
                        btnPagarRnt.setEnabled(false);

                    }
                    if (Tableroenjuego.getCuadrantesincomprables().contains(Tableroenjuego.getAllCuadrantes().get(jugador02.getPosicionDeCasilleroActual()))) {
                        btnComprar.setEnabled(false);
                        btnNextTurno.setEnabled(true);
                    } else if (!Ficha.Filmina.containsKey(jugador02.getPosicionDeCasilleroActual())) { // if not bought by someone
                        btnComprar.setEnabled(true);
                        btnNextTurno.setEnabled(true);
                        btnPagarRnt.setEnabled(false);
                    }

                }

                btnRollDadin.setEnabled(false);
                if (doubleDiceForPlayer1 || doubleDiceForPlayer2) {
                    infoConsole.setText("Click Next Turn to allow player " + (juegoON == 0 ? 1 : 2) + " to Roll Dice!");
                } else {
                    infoConsole.setText("Click Next Turn to allow player " + (juegoON == 0 ? 2 : 1) + " to Roll Dice!");
                }


                // we have to add below 2 lines to avoid some GUI breakdowns.
                layeredPane.remove(Tableroenjuego);
                layeredPane.add(Tableroenjuego, new Integer(0));

                //updatePanelPlayer1TextArea();
            //updatePanelPlayer2TextArea();

            }
        });
        btnRollDadin.setBounds(81, 413, 246, 53);
        rightPanel.add(btnRollDadin);



        btnNextTurno = new JButton("Siguiente Turno");
        btnNextTurno.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                btnRollDadin.setEnabled(true);
                btnComprar.setEnabled(false);
                btnPagarRnt.setEnabled(false);
                btnNextTurno.setEnabled(false);

                if (juegoON == 0 && doubleDiceForPlayer1) {
                    juegoON = 0;
                    doubleDiceForPlayer1 = false;
                } else if (juegoON == 1 && doubleDiceForPlayer2) {
                    juegoON = 1;
                    doubleDiceForPlayer2 = false;
                } else if (!doubleDiceForPlayer1 && !doubleDiceForPlayer2) {
                    juegoON = (juegoON + 1) % 2;
                }


                c1.show(playerAssetsPanel, "" + (juegoON == 0 ? 1 : 2)); // maps 0 to 1 and 1 to 2
                //updatePanelPlayer1TextArea();
                //updatePanelPlayer2TextArea();
                infoConsole.setText("It's now player "+(juegoON==0 ? 1 : 2)+"'s turn!");
            }

        });

        btnNextTurno.setBounds(81, 519, 246, 53);
        rightPanel.add(btnNextTurno);
        btnNextTurno.setEnabled(false);

}

    public static void main(String[] args)
    {
        //Ejecutamos todo en el metodo principal ozea que vamos a poner todo el desatre de main hay dentro sino su bardo
        Memepolimein frame = new Memepolimein();
        frame.setVisible(true);
    }
}