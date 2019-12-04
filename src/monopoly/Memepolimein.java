package monopoly;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

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
    JTextArea panelPlayer1TextArea;
    JTextArea panelPlayer2TextArea;
    Tablero Tableroenjuego;



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

        btnPagarRnt = new JButton("Pagar renta");

        btnPagarRnt.setBounds(210, 478, 117, 29);
        rightPanel.add(btnPagarRnt);
        btnPagarRnt.setEnabled(false);


    }

    public static void main(String[] args)
    {
        //Ejecutamos todo en el metodo principal ozea que vamos a poner todo el desatre de main hay dentro sino su bardo
        Memepolimein frame = new Memepolimein();
        frame.setVisible(true);
    }
}