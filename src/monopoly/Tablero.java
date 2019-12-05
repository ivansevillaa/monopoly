package monopoly;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Tablero extends JPanel
{
    private ArrayList<Cuadrantes> allCuadrantes = new ArrayList<Cuadrantes>();
    private ArrayList<Cuadrantes> Cuadrantesincomprables = new ArrayList<Cuadrantes>(); // Cuadrantes que ya se compraron o como el cuadrante00

    public ArrayList<Cuadrantes> getCuadrantesincomprables() {
        return Cuadrantesincomprables;
    }

    public ArrayList<Cuadrantes> getAllCuadrantes() {
        return allCuadrantes;
    }

    public Cuadrantes getCuadrantealinicio(int location) {
        return allCuadrantes.get(location);
    }

    public Tablero(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 612, 612);
        this.setLayout(null);
        iniciarCuadrantes();
    }

    private void iniciarCuadrantes()
    {
        //Aca se cargan todos los nombres de los cuadrantes vendrian a ser la residencia y avenidas todo el desastre

        String[] NombreCuadran =
                {
                        "Salida",
                        "Avenida Gastritis",
                        "Estacionamiento libre",
                        "UTN",
                        "Calle Shrek",
                        "CARCEL",
                        "Plaza Springboot",
                        "Estacionamiento libre",
                        "Maxikiosco 'EL ESCOCES'",
                        "Libreria Roberto",
                        "CARCEL 2.0",
                        "Gotham City",
                        "Estacionamiento libre",
                        "Club Nocturno LIV",
                        "Plaza ZinjaI",
                        "FORTUNA",
                        "Avenida El Bromas",
                        "Calle Probabilidades Thales",
                        "Estacionamiento libre",
                        "La casa del alfajor"
                };

        // Cuadrantes de Arriba vendria a ser toda la hilera de cuadros de arriba
        Cuadrantes cuadro00 = new Cuadrantes(6,6,100,100,NombreCuadran[0],135);
        this.add(cuadro00);
        allCuadrantes.add(cuadro00);
        Cuadrantesincomprables.add(cuadro00);

        // Primer cuadro que vendria a ser Avenida gastritis
        Cuadrantes cuadro01 = new Cuadrantes(106,6,100,100,NombreCuadran[1],180);
        this.add(cuadro01);
        allCuadrantes.add(cuadro01);

        Cuadrantes cuadro02 = new Cuadrantes(206,6,100,100,NombreCuadran[2],180);
        this.add(cuadro02);
        allCuadrantes.add(cuadro02);
        Cuadrantesincomprables.add(cuadro02);

        Cuadrantes cuadro03 = new Cuadrantes(306,6,100,100,NombreCuadran[3],180);
        this.add(cuadro03);
        allCuadrantes.add(cuadro03);

        Cuadrantes cuadro04 = new Cuadrantes(406,6,100,100,NombreCuadran[4],180);
        this.add(cuadro04);
        allCuadrantes.add(cuadro04);

        Cuadrantes cuadro05 = new Cuadrantes(506,6,100,100,NombreCuadran[5],-135);
        this.add(cuadro05);
        allCuadrantes.add(cuadro05);
        Cuadrantesincomprables.add(cuadro05);

        //Cuadrantes de la derecha

        Cuadrantes cuadro06 = new Cuadrantes(506,106,100,100,NombreCuadran[6],-90);
        this.add(cuadro06);
        allCuadrantes.add(cuadro06);
        Cuadrantesincomprables.add(cuadro06);

        Cuadrantes cuadro07 = new Cuadrantes(506,206,100,100,NombreCuadran[7],-90);
        this.add(cuadro07);
        allCuadrantes.add(cuadro07);
        Cuadrantesincomprables.add(cuadro07);

        Cuadrantes cuadro08 = new Cuadrantes(506,306,100,100,NombreCuadran[8],-90);
        this.add(cuadro08);
        allCuadrantes.add(cuadro08);

        Cuadrantes cuadro09 = new Cuadrantes(506,406,100,100,NombreCuadran[9],-90);
        this.add(cuadro09);
        allCuadrantes.add(cuadro09);

        Cuadrantes cuadro10 = new Cuadrantes(506,506,100,100,NombreCuadran[10],-45);
        this.add(cuadro10);
        allCuadrantes.add(cuadro10);
        Cuadrantesincomprables.add(cuadro10);

        //Cuadrantes del fondo

        Cuadrantes cuadro11 = new Cuadrantes(406,506,100,100,NombreCuadran[11],0);
        this.add(cuadro11);
        allCuadrantes.add(cuadro11);
        Cuadrantesincomprables.add(cuadro11);

        Cuadrantes cuadro12 = new Cuadrantes(306,506,100,100,NombreCuadran[12],0);
        this.add(cuadro12);
        allCuadrantes.add(cuadro12);
        Cuadrantesincomprables.add(cuadro12);

        Cuadrantes cuadro13 = new Cuadrantes(206,506,100,100,NombreCuadran[13],0);
        this.add(cuadro13);
        allCuadrantes.add(cuadro13);

        Cuadrantes cuadro14 = new Cuadrantes(106,506,100,100,NombreCuadran[14],0);
        this.add(cuadro14);
        allCuadrantes.add(cuadro14);

        Cuadrantes cuadro15 = new Cuadrantes(6,506,100,100,NombreCuadran[15],45);
        this.add(cuadro15);
        allCuadrantes.add(cuadro15);
        Cuadrantesincomprables.add(cuadro15);

        //Cuadrantes de la Izquierda

        Cuadrantes cuadro16 = new Cuadrantes(6,406,100,100,NombreCuadran[16],90);
        this.add(cuadro16);
        allCuadrantes.add(cuadro16);
        Cuadrantesincomprables.add(cuadro16);

        Cuadrantes cuadro17 = new Cuadrantes(6,306,100,100,NombreCuadran[17],90);
        this.add(cuadro17);
        allCuadrantes.add(cuadro17);

        Cuadrantes cuadro18 = new Cuadrantes(6,206,100,100,NombreCuadran[18],90);
        this.add(cuadro18);
        allCuadrantes.add(cuadro18);
        Cuadrantesincomprables.add(cuadro18);

        Cuadrantes cuadro19 = new Cuadrantes(6,106,100,100,NombreCuadran[19],90);
        this.add(cuadro19);
        allCuadrantes.add(cuadro19);

        //Seteo de los precios de las propiedades
        cuadro01.setPrecio(100);
        cuadro03.setPrecio(100);

        cuadro04.setPrecio(120);


        cuadro08.setPrecio(150);
        cuadro09.setPrecio(160);

        cuadro13.setPrecio(180);
        cuadro14.setPrecio(190);

        cuadro17.setPrecio(200);
        cuadro19.setPrecio(200);
        // Y asi con las demas

        //Seteo de los precios de las rentas
        cuadro01.setRentPrecio(10);
        cuadro03.setRentPrecio(15);
        cuadro04.setRentPrecio(15);

        cuadro08.setRentPrecio(25);
        cuadro09.setRentPrecio(25);

        cuadro13.setRentPrecio(30);
        cuadro14.setRentPrecio(25);

        cuadro17.setRentPrecio(30);
        cuadro19.setRentPrecio(35);
        // Y seguimos con cuadro 1 y 2 seteando

        // Aca creamos el tablero en si y dividimos las hileras para que quede de forma cuadrada
        JLabel lblMonopoly = new JLabel("MEMEPOLY")
        {

            protected void paintComponent(Graphics g)
            {
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                AffineTransform ahr = g2.getTransform();
                Shape formavieja = g2.getClip();
                double x = getWidth()/2.0;
                double y = getHeight()/2.0;
                ahr.rotate(Math.toRadians(-35), x, y);
                g2.setTransform(ahr);
                g2.setClip(formavieja);
                super.paintComponent(g);
            }
        };
        // Aca implementamos los colorsitos y too el desastre
        lblMonopoly.setForeground(Color.WHITE);
        lblMonopoly.setBackground(Color.RED);
        lblMonopoly.setOpaque(true);
        lblMonopoly.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonopoly.setFont(new Font("Arial", Font.PLAIN, 40));
        lblMonopoly.setBounds(179, 277, 263, 55);
        this.add(lblMonopoly);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}