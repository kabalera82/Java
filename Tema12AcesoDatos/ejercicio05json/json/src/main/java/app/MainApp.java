package src.main.java.app;

import src.main.java.model.Biblioteca;
import src.main.java.model.Cliente;
import src.main.java.model.Usuario;
import src.main.java.util.JsonIO;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class MainApp {

    private static final Path RUTA = Paths.get("data", "biblioteca.json");



    private static Biblioteca cargaDatos() {

        Biblioteca b = new Biblioteca("Biblioteca Cher");

        List<Usuario> usuarios = List.of(

                new Usuario(1, "Manolo", "manolo@hotmail.com", true),
                new Usuario(2, "Lucía", "lucia@gmail.com", true),
                new Usuario(3, "Carlos", "carlos@yahoo.es", false),
                new Usuario(4, "María", "maria@outlook.com", true),
                new Usuario(5, "Andrés", "andres@gmail.com", false),
                new Usuario(6, "Elena", "elena@empresa.com", true)

        );

        List<Cliente> c = List.of(
                new Cliente(1, "Manolo", "666666666", 4000),
                new Cliente(2, "Lucía", "555555555", 3000),
                new Cliente(3, "Carlos", "444444444", 10000)
        );
        b.setUsuarios(usuarios);
        b.setClientes(c);
        return b;
    }

    public static void main(String[] args) {
        try {

            File json = RUTA.toFile();

            if (!json.exists()) {
                Biblioteca biblio = cargaDatos();

                JsonIO.write(json, biblio);

                System.out.println(" 👌Exportado con exito👌" + json.getAbsolutePath());

            }

        } catch (Exception e) {
            System.err.println("❌ Error al ejecutar la app ❌" + e.getMessage());
        }
        cargaDatos();
    }


    }


