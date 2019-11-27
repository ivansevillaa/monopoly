package monopoly;

public class Tablero {

    private int numeroCasillas=40;
    private Ficha jugadores[] = new Ficha[2];
    private Lista listaCasillas=new Lista();
    private String[] nombresResidencias = {
            "Avenida Artrosis",
            "Avenida Gastritis",
            "Edificio Globant",
            "UTN",
            "Campus Virtual",
            "Calle Shrek",
            "Calle Shrek 2",
            "Plaza Springboot",
            "Avenida Walter White",
            "Maxikiosco 'EL ESCOCES'",
            "Libreria Roberto",
            "Iglesia San Braida",
            "Calle Shrek 3",
            "Gotham City",
            "Avenida El Oso Prato",
            "Torre Osama",
            "Torre Bien Loco",
            "Maxikiosco de Seba",
            "Club Nocturno LIV",
            "Plaza ZinjaI",
            "Parque de diversiones Iron Man",
            "Parque de diversiones Muere en Avengers End Game",
            "Heladeria Ujujuy esta fria la taza",
            "Galeria Tipico",
            "Avenida El Bromas",
            "Calle Probabilidades Thales",
            "Puente Resistencia-Vilelas",
            "La casa del alfajor",
            "Concurso Diseña el logo de TUP",
            "Rascacielos Fumes"};
    private int[] preciosResidencias={
            150,
            250,
            400,
            500,
            450,
            200,
            700,
            350,
            650,
            500,
            450,
            650,
            400,
            500,
            450,
            200,
            700,
            950,
            650,
            500,
            800,
            750,
            400,
            500,
            450,
            900,
            700,
            350,
            650,
            1000
    };
    private int[] alquilerResidencias={
            15,
            25,
            40,
            50,
            45,
            20,
            70,
            35,
            65,
            50,
            45,
            65,
            40,
            50,
            45,
            20,
            70,
            95,
            65,
            50,
            80,
            75,
            40,
            50,
            45,
            90,
            70,
            35,
            65,
            100
    };
    int turnoDe=0;

    public Tablero() {
        jugadores[0]=new Ficha(1);
        jugadores[1]=new Ficha(2);
        this.cargarLista();
    }
    public void cargarLista(){
        int numRes=0;
        for (int x=0;x<numeroCasillas;x++){
            if (x==0){
                listaCasillas.agregar(null,0,0,"Salida",x);
            }
            else if (x==2 || x==7 || x==17 || x== 22 || x==33 || x==36){
                listaCasillas.agregar(null,0,0,"Fortuna",x);
            }else if(x==10 || x==20){
                listaCasillas.agregar(null,0,0,"ParadaLibre",x);
            }else if(x==30){
                listaCasillas.agregar(null,0,0,"Carcel",x);
            }else{
                listaCasillas.agregar(nombresResidencias[numRes],preciosResidencias[numRes],alquilerResidencias[numRes],"Propiedad",x);
                numRes++;
            }
        }
    }
    public void tirarDado(){
        if (jugadores[turnoDe].getPenalizacion()==false){
            int valor;
            valor=(int)Math.random() * (13 - 1) + 1;
            jugadores[turnoDe].moverse(valor);
            Casillas casillaActual = listaCasillas.obtener(jugadores[turnoDe].getPosicionDeCasilleroActual());
            if (casillaActual.getClass().getSimpleName().equals("Especiales")){
                ((Especiales)casillaActual).ejecutarMetodos(jugadores[turnoDe]);
            }else{
                if (((Propiedades)casillaActual).isComprada()){
                    ((Propiedades)casillaActual).alquiler(jugadores, turnoDe);
                }else{
                    System.out.println("Esta propiedad está a la venta, por un monto de: "+((Propiedades)casillaActual).getPrecio());
                    System.out.println("Desea comprarla S/N");
                    int respuesta=0;
                    //Entrada de la respuesta.
                    if (respuesta==1){
                        ((Propiedades)casillaActual).comprar(jugadores[turnoDe]);
                    }
                }
            }
        }else{
            jugadores[turnoDe].setPenalizacion(true);
        }
        if (turnoDe==0){
            turnoDe=1;
        }else{
            turnoDe=0;
        }
    }
}