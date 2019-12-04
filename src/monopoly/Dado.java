package monopoly;

import java.util.Random;

class Dado {

     Random dado = new Random();
     int cara=0;

     public int tirarDados()
     {
         cara = dado.nextInt(6)+1;
         return cara;
     }


}
