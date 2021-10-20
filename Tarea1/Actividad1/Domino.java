package Tarea1.Actividad1;

import java.util.LinkedList;

public class Domino {
    
    private static LinkedList<Ficha> lista1;

    public static void main(String[] args) {
        //Ficha ficha_1_2 = new Ficha(1,2);
        //Ficha ficha_1_3 = new Ficha(1,3);
        //Ficha ficha_1_4 = new Ficha(1,4);
        Ficha ficha_0_0= new Ficha(0,0);
        Ficha ficha_0_1= new Ficha(0,1);
        Ficha ficha_0_2= new Ficha(0,2);
        Ficha ficha_0_3= new Ficha(0,3);
        Ficha ficha_0_4= new Ficha(0,4);
        Ficha ficha_0_5= new Ficha(0,5);
        Ficha ficha_0_6= new Ficha(0,6);

        Ficha ficha_1_1= new Ficha(1,1);
        Ficha ficha_1_2= new Ficha(1,2);
        Ficha ficha_1_3= new Ficha(1,3);
        Ficha ficha_1_4= new Ficha(1,4);
        Ficha ficha_1_5= new Ficha(1,5);
        Ficha ficha_1_6= new Ficha(1,6);

        Ficha ficha_2_2= new Ficha(2,2);
        Ficha ficha_2_3= new Ficha(2,3);
        Ficha ficha_2_4= new Ficha(2,4);
        Ficha ficha_2_5= new Ficha(2,5);
        Ficha ficha_2_6= new Ficha(2,6);

        Ficha ficha_3_3= new Ficha(3,3);
        Ficha ficha_3_4= new Ficha(3,4);
        Ficha ficha_3_5= new Ficha(3,5);
        Ficha ficha_3_6= new Ficha(3,6);

        Ficha ficha_4_4= new Ficha(4,4);
        Ficha ficha_4_5= new Ficha(4,5);
        Ficha ficha_4_6= new Ficha(4,6);

        Ficha ficha_5_5= new Ficha(5,5);
        Ficha ficha_5_6= new Ficha(5,6);
        
        Ficha ficha_6_6= new Ficha(6,6);

        lista1.add(ficha_0_0);
        lista1.add(ficha_0_1);
        lista1.add(ficha_0_2);
        lista1.add(ficha_0_3);
        lista1.add(ficha_0_4);
        lista1.add(ficha_0_5);
        lista1.add(ficha_0_6);


        System.out.println(ficha_1_2.toString());
        int aux = ficha_1_2.getCara2();
        ficha_1_2.setCara2(ficha_1_2.getCara1());
        ficha_1_2.setCara1(aux);
        System.out.println(ficha_1_2.toString());

        lista1 = new LinkedList<Ficha>();

        //lista1.add(ficha_1_2);
        //lista1.add(ficha_1_3);
        //lista1.add(ficha_1_4);

        //while (!(lista1.isEmpty())) {
        //    Ficha n = lista1.getFirst();
        //    System.out.println(n.toString());
        //    lista1.removeFirst();
        //}

    }
    
}
