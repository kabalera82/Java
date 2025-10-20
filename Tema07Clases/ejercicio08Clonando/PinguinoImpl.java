package Tema07Clases.ejercicio08Clonando;

import java.math.BigInteger;
import java.util.Objects;

public class PinguinoImpl implements Pinguino {
    // Atributos
    private Integer id;
    private String name;
    private Integer alas;

    // Constructor
    public PinguinoImpl(Integer id, String nombre, Integer alas) {
        this.id = id;
        this.alas = alas;
        this.name = nombre;
    }

    public Integer getAlas() {
        return alas;
    }

    public void setAlas(Integer alas) {
        this.alas = alas;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PinguinoImpl pinguino = (PinguinoImpl) o;
        return Objects.equals(id, pinguino.id)
                && Objects.equals(name, pinguino.name)
                && Objects.equals(alas, pinguino.alas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alas);
    }

    @Override
    public PinguinoImpl clone() {
        try {
            return (PinguinoImpl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // no debería ocurrir si implementamos Cloneable
        }
    }
}
