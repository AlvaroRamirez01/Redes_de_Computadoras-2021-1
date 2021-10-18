package Tarea1.Actividad1;

import java.util.LinkedList;

public class Domino {
    
    public static void main(String[] args) {
        Ficha ficha_1_2 = new Ficha(1,2);
        Ficha ficha_1_3 = new Ficha(1,3);
        Ficha ficha_1_4 = new Ficha(1,4);


        System.out.println(ficha_1_2.toString());

        LinkedList lista1 = new LinkedList<Ficha>();

        lista1.add(ficha_1_2);
        lista1.add(ficha_1_3);
        lista1.add(ficha_1_4);

        while (!(lista1.isEmpty())) {
            Ficha n = (Ficha) lista1.getFirst();
            System.out.println(n.toString());
            lista1.removeFirst();
        }

    }
    
}
