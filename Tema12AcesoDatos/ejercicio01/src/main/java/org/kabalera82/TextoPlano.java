package org.kabalera82;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextoPlano {
    // Ruta del Path
    private static final Path RUTA = Paths.get("clientes.txt");

    public static void main(String[] args) {

        // Creamos lista clientes (Esto seria una llamada a un select
        // Esto es lo mismo que List <Cliente> clientes = new ArrayList <>();
        List<Cliente> clientes = List.of(
                new Cliente(1, "Ana", "ana@correo.com", 1200),
                new Cliente(2, "Luis", "luis@correo.com", 950),
                new Cliente(3, "María", "maria@correo.com", 1800),
                new Cliente(4, "Carlos", "carlos@correo.com", 750),
                new Cliente(5, "Elena", "elena@correo.com", 2100),
                new Cliente(6, "Javier", "javier@correo.com", 1300)
        );

        // Ponemos entre parentesis para que java detecte el tipo de error que puede pasar
        try (
                BufferedWriter bw = Files.newBufferedWriter(RUTA, StandardCharsets.UTF_8)
        ) {
            for (Cliente c : clientes) {
                //texto en cada linea
                bw.write(c.getId() + ";" + c.getNombre() + ";" + c.getEmail() + ";" + c.getSaldo());
                //salto de linea
                bw.newLine();

            }
            //toRoutePath para que nos pinte toda la ruta
            System.out.println("Escrito en " + RUTA.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lista de Clientes Leidos
        List<Cliente> leidos = new ArrayList<>();

        try (
                BufferedReader br = Files.newBufferedReader(RUTA, StandardCharsets.UTF_8)

        ) {

            String linea;

            while ((linea = br.readLine()) != null){
                // El -1 significa si no hay nada entre separadores generas posicion vacia
                String[] partes = linea.split(";", -1);

                if (partes.length != 4){
                    System.err.println("Linea con formato incorrecto: " + linea);
                }
                try {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String email = partes[2];
                    double saldo = Double.parseDouble(partes[3]);

                    leidos.add(new Cliente(id, nombre, email, saldo));

                } catch (NumberFormatException ex){
                    System.err.println("Err: " + linea);
                }

            }

        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Leidos: ");
        leidos.forEach(System.out::println);

    }
}
