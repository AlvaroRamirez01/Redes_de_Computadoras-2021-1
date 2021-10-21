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

    /**
     * Modifica la cara 1 de la ficha.
     */
    public void setCara1(int cara1){
        this.cara1 = cara1;
    }

    /**
     * Regresa la cara 2 de la ficha.
     * @return la cara 2 de la ficha.
     */
    public int getCara2(){
        return cara2;
    }

    /**
     * Modifica la cara 2 de la ficha.
     */
    public void setCara2(int cara2){
        this.cara2 = cara2;
    }

    /**
     * Regresa la representacion en cadena de una ficha.
     */
    @Override public String toString(){
        String cadena = String.format("[%d|%d]", this.cara1,this.cara2);
        return cadena;
    }

    /**
     * Nos permite comparar si la ficha recibida es igual a la ficha que 
     * mando a llamar el metodo.
     * @param ficha2
     */
    public boolean equals(Ficha ficha2){
        return (this == null || !(ficha2.cara1 != (cara1)) || !(ficha2.cara2 != (cara2))) 
            ? false : true;
    }

}
