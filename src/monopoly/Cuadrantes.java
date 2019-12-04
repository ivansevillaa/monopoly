package monopoly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Cuadrantes extends JPanel {

    int numb;
    private String nombre;
    String description;
    JLabel nombreLabel;
    static int totalCuadrantes = 0;
    private int precio;
    private int rentPrecio;

    public void setRentPrecio(int rentPrecio) {
        this.rentPrecio = rentPrecio;
    }

    public int getRentPrecio() {
        return rentPrecio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public String getName() {
        return nombre;
    }


    public Cuadrantes(int xCoord, int yCoord, int width, int height, String labelString, int rotacionGrado) {
        //Aca hacemos que avanze el cuadrante dependiendo el numero del jugador que despues vemos como implementamos xd
        numb = totalCuadrantes;
        totalCuadrantes++;

        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, width, height);
        nombre = labelString;
        this.setLayout(null);

        if(rotacionGrado == 0) {
            nombreLabel = new JLabel(labelString);
            nombreLabel.setFont(new Font("Arial", Font.PLAIN, 9));
            nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nombreLabel.setBounds(0,20,this.getWidth(),20);
            this.add(nombreLabel);
        } else {

            nombreLabel = new JLabel(labelString) {
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth()/2.0;
                    double y = getHeight()/2.0;
                    aT.rotate(Math.toRadians(rotacionGrado), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };
            //Hacemos dependiendo de los grados se formen las hileras de forma cuadrada
            if(rotacionGrado == 90) {
                nombreLabel.setBounds(20, 0, this.getWidth(), this.getHeight());
            }
            if(rotacionGrado == -90) {
                nombreLabel.setBounds(-10, 0, this.getWidth(), this.getHeight());
            }
            if(rotacionGrado == 180) {
                nombreLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            if(rotacionGrado == 135 || rotacionGrado == -135 || rotacionGrado == -45 || rotacionGrado == 45) {
                nombreLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            nombreLabel.setFont(new Font("Arial", Font.PLAIN, 9));
            nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);

            this.add(nombreLabel);
        }

    }
    // En resumen aca pintamos los colores que tiene cada avenida o residencia en especial
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.numb == 1 || this.numb == 3 || this.numb == 4) {
            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
            g.setColor(Color.YELLOW);
            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
        }
        if(this.numb == 6 || this.numb == 8 || this.numb == 9) {
            g.drawRect(0, 0, 20, this.getHeight());
            g.setColor(Color.RED);
            g.fillRect(0, 0, 20, this.getHeight());
        }
        if(this.numb == 11 || this.numb == 13 || this.numb == 14) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if(this.numb == 16 || this.numb == 17 || this.numb == 19) {
            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
            g.setColor(Color.CYAN);
            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
        }

    }

    private boolean Rentapaga = false;
    public boolean isRentapaga() {
        return Rentapaga;
    }
    public void setRentapaga(boolean pagar) {
        Rentapaga = pagar;
    }

}
