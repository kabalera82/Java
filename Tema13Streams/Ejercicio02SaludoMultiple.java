package Tema13Streams;

import Tema13Streams.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio02SaludoMultiple {

    // Método genérico que aplica un saludo a un grupo
    static <T> List <String> saludarGrupo(T[] grupo, ISaludo<T> saludo) {
        List<String> res = new ArrayList<>();
        for (T e : grupo) {
            res.add(saludo.saludar(e));
        }
        return res;
    }

    public static void main(String[] args) {
        Cliente[] grupoClientes = {
                new Cliente("111", "Marta", "12/02/2010"),
                new Cliente("112", "Pedro", "12/08/2000"),
                new Cliente("113", "Laia", "12/02/2040"),
                new Cliente("114", "Marcos", "11/02/2000"),
                new Cliente("115", "Maria", "12/02/2020")
        };

        // Implementación del saludo para Cliente usando lambda
        ISaludo<Cliente> saludoCliente = c -> "Buenos días " + c.getNombre() + "!";

        // Llamada al método y obtención de resultados
        List<String> saludos = saludarGrupo(grupoClientes, saludoCliente);

        // Mostrar saludos
        saludos.forEach(System.out::println);
    }
}
