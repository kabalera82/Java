package Tema07Clases.CasteoDeClases;

public class Profesor extends Persona{

    //Atributos
    private String titulo;

    //Constructores
    public Profesor(){};

    public Profesor (String titulo) {
        this.titulo = titulo;
    }
    public Profesor(String titulo, String dni) {
        super(dni);
        this.titulo = titulo;
    }

    //Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void saludar() {
        System.out.println("Saludar desde Profesor");
    }
}
