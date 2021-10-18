package Tarea1.Actividad1;

public class Ficha {
    
    /* Cara 1 de la ficha */
    private int cara1;

    /* Cara 2 de la ficha */
    private int cara2;

    /**
     * Constructor de la clase Ficha.
     * @param cara1 una de las caras de la ficha
     * @param cara2 una de las caras de la ficha.
     */
    public Ficha(int cara1, int cara2){
        this.cara1 = cara1;
        this.cara2 = cara2;

    }

    /**
     * Regresa la cara 1 de la ficha.
     * @return la cara 1 de la ficha.
     */
    public int getCara1(){
        return cara1;
    }
}
