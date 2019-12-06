package monopoly;

public class Manual {
   
    private String contenido;
    
    public Manual(){
    	this.contenido = "Bienvenido a memepoly, jugar es muy simple.\nTira los dados para avanzar, puedes caer en 5 diferentes tipos de casillas.\nLas casillas de colores, son propiedades, puedes comprarla para cobrar renta sobre ellas al otro jugador." +
                "\nLas casillas de estacionamiento libre, no hacen nada, son buenas para avanzar mucha cantidad de casillas sin pagar nada, recuerda que cada vez que pases por la casilla de salida, recibirás $200!"+
                "\nLas casillas de carcel, te quitarán dinero, tienes que pagar la fianza para salir.\nLas casillas de forutna, pueden darte un buen dinero!, o quitartelo..."+"\nAhora, buena suerte, unete a otro jugador, y vean quien gana, haciendo que el otro pierda todo su dinero!";
    }

    @Override
    public String toString(){
        return contenido;
    }
}
