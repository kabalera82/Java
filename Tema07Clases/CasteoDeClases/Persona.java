package Tema07Clases.CasteoDeClases;

public abstract class Persona {

    //Atributos
    protected String  dni;

    //Constructores
    public Persona() {}
    public Persona(String dni) {
        this.dni = dni;
    }

    //
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //Metodos
    public abstract void saludar();
}
