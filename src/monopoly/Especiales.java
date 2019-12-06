package monopoly;

public class Especiales{

	public static Especiales especiales=new Especiales();

	private Especiales() {

	}

	public static void Fortuna(Ficha jugador){
		int i =(int) (Math.random()*1000-500);
		if (i>0){
			System.out.println("la recompensa de la fortuna es: " + i);
			jugador.depositarDinero(i);

		}else{
			System.out.println("el castigo de la fortuna es: "+ i);
			jugador.retirarDinero(i);
		}

	}
	public static void Carcel(Ficha jugador){
		System.out.println("Pagaste fianza de 1000 peso");
		jugador.retirarDinero(1000);
	}



}
