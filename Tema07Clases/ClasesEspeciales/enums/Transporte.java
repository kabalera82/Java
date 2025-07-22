package Tema07Clases.ClasesEspeciales.enums;

public enum Transporte {

    //Los tipos de los Enums se declaran en mayuscula
    COCHE(160), AUTOBUS(110), CAMION(100), MOTO(180);

    //Variables de instancia
    private int velocidad;

    //constructor
    private Transporte(int velocidad) {
        this.velocidad = velocidad;
    }

    //metodos
    public int getVelocidad() {
        return velocidad;
    }
}
