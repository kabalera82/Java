package Tema13Streams;

public class Cliente {
    private String id;
    private String nombre;
    private String fechaAlta;

    public Cliente(String id, String nombre, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }
}
