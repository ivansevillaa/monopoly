package monopoly;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Memepolimein extends JFrame
{
    private JPanel contentIncluder;
    static JTextArea infoConsole;
    JPanel playerAssetsPanel;
    static int turnCounter = 0;
    JButton btnNextTurno;
    JButton btnRollDadin;
    JButton btnPagarRnt;
    JButton btnPagar;
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
    Dado dado = new Dado();




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


        btnPagar = new JButton("Comprar");
        btnPagar.setBounds(81, 478, 117, 29);
        rightPanel.add(btnPagar);
        btnPagar.setEnabled(false);

        btnPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //turnCounter--; // decrease because we increased at the end of the rolldice
                Ficha currentPlayer = jugadorenae.get(juegoON);
                infoConsole.setText("Tu pagaste "+Tableroenjuego.getAllCuadrantes().get(currentPlayer.getPosicionDeCasilleroActual()).getName());
                //currentPlayer.buyTitleDeed(currentPlayer.getCurrentSquareNumber());
                int deuda = Tableroenjuego.getAllCuadrantes().get(currentPlayer.getPosicionDeCasilleroActual()).getPrecio();
                currentPlayer.PagarDeuda(deuda);
                btnPagar.setEnabled(false);
                //updatePanelPlayer1TextArea();
                //updatePanelPlayer2TextArea();
                //turnCounter++;
            }
        });

        btnPagarRnt = new JButton("Pagar renta");

        btnPagarRnt.setBounds(210, 478, 117, 29);
        rightPanel.add(btnPagarRnt);
        btnPagarRnt.setEnabled(false);

        btnPagarRnt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // turnCounter--;
                Ficha currentPlayer = jugadorenae.get(juegoON);
                Ficha dueñoDelCuadrante = jugadorenae.get((Ficha.Filmina.get(currentPlayer.getPosicionDeCasilleroActual()))==1?0:1);
                infoConsole.setText("You paid to the player "+dueñoDelCuadrante.getNroJugador());

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

        jugador01 = new Ficha(1, Color.BLACK);
        jugadorenae.add(jugador01);
        layeredPane.add(jugador01, new Integer(1));

        jugador02 = new Ficha(2, Color.PINK);
        jugadorenae.add(jugador02);
        layeredPane.add(jugador02, new Integer(2));

        btnNextTurno= new JButton("Siguiente Turno");
        btnNextTurno.setBounds(81, 519, 246, 53);
        rightPanel.add(btnNextTurno);
        btnNextTurno.setEnabled(false);

        btnNextTurno.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                btnRollDadin.setEnabled(true);
                btnPagar.setEnabled(false);
                btnPagarRnt.setEnabled(false);
                btnNextTurno.setEnabled(false);

                if(juegoON == 0 && turnoPlayer1) {
                    juegoON = 0;
                    turnoPlayer1 = false;
                } else if(juegoON == 1 && turnoPlayer1) {
                    juegoON = 1;
                    turnoPlayer2 = false;
                } else if(!turnoPlayer1 && !turnoPlayer2) {
                    juegoON = (juegoON + 1) % 2;
                }


                c1.show(playerAssetsPanel, ""+(juegoON==0 ? 1 : 2)); // maps 0 to 1 and 1 to 2
                //updatePanelPlayer1TextArea();
                //updatePanelPlayer2TextArea();
                infoConsole.setText("It's now player "+(juegoON==0 ? 1 : 2)+"'s turn!");
            }



        });

        btnRollDadin = new JButton("Tirar Dado");
        btnRollDadin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(juegoON == 0) {
                    // turno del player 1
                    jugador01.moverse(dado.tirarDados());
                    if(Ficha.Filmina.containsKey(jugador01.getPosicionDeCasilleroActual()) // si fue comprado x alguno
                            && Ficha.Filmina.get(jugador01.getPosicionDeCasilleroActual()) != jugador01.getNroJugador() // no x ete
                    ) {
                        btnPagar.setEnabled(false);
                        btnRollDadin.setEnabled(false);
                        btnNextTurno.setEnabled(false);
                        btnPagarRnt.setEnabled(true);

                    }
                    if (Ficha.Filmina.containsKey(jugador01.getPosicionDeCasilleroActual()) // si ta comprado
                            && Ficha.Filmina.get(jugador01.getPosicionDeCasilleroActual()) == jugador01.getNroJugador()) { // y por el mismo
                        btnPagar.setEnabled(false);
                        btnPagarRnt.setEnabled(false);
                        btnNextTurno.setEnabled(true);
                        juegoON++;
                    }
                    if(Tableroenjuego.getCuadrantesincomprables().contains(Tableroenjuego.getAllCuadrantes().get(jugador01.getPosicionDeCasilleroActual()))) {
                        btnPagar.setEnabled(false);
                        btnNextTurno.setEnabled(true);
                    } else if (!Ficha.Filmina.containsKey(jugador01.getPosicionDeCasilleroActual())) { // si no ta comprado
                        btnPagar.setEnabled(true);
                        btnNextTurno.setEnabled(true);
                        btnPagarRnt.setEnabled(false);
                    }


                } else {
                    // player2's turn
                    if(juegoON==1){
                    jugador02.moverse(dado.tirarDados());
                    if(Ficha.Filmina.containsKey(jugador02.getPosicionDeCasilleroActual()) // if bought by someone
                            && Ficha.Filmina.get(jugador02.getPosicionDeCasilleroActual()) != jugador02.getNroJugador() // not by itself
                    ) {
                        btnPagar.setEnabled(false);
                        btnRollDadin.setEnabled(false);
                        btnNextTurno.setEnabled(false);
                        btnPagarRnt.setEnabled(true);
                    }
                    if(Ficha.Filmina.containsKey(jugador02.getPosicionDeCasilleroActual()) // if bought by someone
                            && Ficha.Filmina.get(jugador02.getPosicionDeCasilleroActual()) == jugador02.getNroJugador()) { // and by itself
                        btnPagar.setEnabled(false);
                        btnPagarRnt.setEnabled(false);

                    }
                    if(Tableroenjuego.getCuadrantesincomprables().contains(Tableroenjuego.getAllCuadrantes().get(jugador02.getPosicionDeCasilleroActual()))) {
                        btnPagar.setEnabled(false);
                        btnNextTurno.setEnabled(true);
                    } else if (!Ficha.Filmina.containsKey(jugador02.getPosicionDeCasilleroActual())) { // if not bought by someone
                        btnPagar.setEnabled(true);
                        btnNextTurno.setEnabled(true);
                        btnPagarRnt.setEnabled(false);
                    }

                }

                btnRollDadin.setEnabled(false);
                if(turnoPlayer1 ||turnoPlayer2) {
                    infoConsole.setText("Click Next Turn to allow player "+ (juegoON==0 ? 1 : 2) +" to Roll Dice!");
                } else {
                    infoConsole.setText("Click Next Turn to allow player "+ (juegoON==0 ? 2 : 1) +" to Roll Dice!");
                }


                // we have to add below 2 lines to avoid some GUI breakdowns.
                layeredPane.remove(Tableroenjuego);
                layeredPane.add(Tableroenjuego, new Integer(0));

               // updatePanelPlayer1TextArea();
               // updatePanelPlayer2TextArea();
                }

            }
        });
        btnRollDadin.setBounds(81, 413, 246, 53);
        rightPanel.add(btnRollDadin);


}

    public static void main(String[] args)
    {
        //Ejecutamos todo en el metodo principal ozea que vamos a poner todo el desatre de main hay dentro sino su bardo
        Memepolimein frame = new Memepolimein();
        frame.setVisible(true);
    }
}