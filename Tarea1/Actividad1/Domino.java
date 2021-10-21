package Tarea1.Actividad1;

import java.util.LinkedList;

public class Domino {
    
    private static LinkedList<Ficha> lista1 = new LinkedList<Ficha>();

    public static void main(String[] args) {

        generaFichas();
        
        

    }
    /**
     * Este metodo nos ayuda a generar las fichas al inicio de una nueva partida.
     */
    private static void generaFichas(){
        // creamos las fichas de domino
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

        /**
         * Agregamos las fichas a la lista la cual nos ayudara a 
         * hacer las funciones de revolver fichas y de repartir fichas
         * al inicio de la partida y cuando querramos comer mas fichas.
         */
        lista1.add(ficha_0_0);
        lista1.add(ficha_0_1);
        lista1.add(ficha_0_2);
        lista1.add(ficha_0_3);
        lista1.add(ficha_0_4);
        lista1.add(ficha_0_5);
        lista1.add(ficha_0_6);

        lista1.add(ficha_1_1);
        lista1.add(ficha_1_2);
        lista1.add(ficha_1_3);
        lista1.add(ficha_1_4);
        lista1.add(ficha_1_5);
        lista1.add(ficha_1_6);

        lista1.add(ficha_2_2);
        lista1.add(ficha_2_3);
        lista1.add(ficha_2_4);
        lista1.add(ficha_2_5);
        lista1.add(ficha_2_6);

        lista1.add(ficha_3_3);
        lista1.add(ficha_3_4);
        lista1.add(ficha_3_5);
        lista1.add(ficha_3_6);

        lista1.add(ficha_4_4);
        lista1.add(ficha_4_5);
        lista1.add(ficha_4_6);

        lista1.add(ficha_5_5);
        lista1.add(ficha_5_6);

        //System.out.println(ficha_5_6.toString());
        //ficha_5_6.giraFicha(ficha_5_6.getCara1(),ficha_5_6.getCara2());
        //System.out.println(ficha_5_6.toString());

        for (Ficha ficha : lista1) {
            System.out.print(","+ficha.toString());
        }
    }
    
}
