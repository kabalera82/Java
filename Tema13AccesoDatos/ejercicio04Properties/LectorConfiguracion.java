import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Ejercicio 04 - Ficheros .properties
 *
 * Un fichero .properties almacena pares clave=valor en texto plano.
 * Se usa tipicamente para configuracion de la aplicacion (URLs, puertos,
 * credenciales, mensajes, etc.) — asi el codigo no tiene valores hardcodeados.
 *
 * Formato del fichero:
 *   db.url=jdbc:mysql://localhost:3306/tutorial
 *   db.usuario=root
 *   db.password=secreto
 *   app.nombre=Mi Aplicacion
 */
public class LectorConfiguracion {

    public static void main(String[] args) {

        String rutaConfig = "ejercicio04Properties/config.properties";

        // 1. Crear y guardar un fichero .properties
        Properties config = new Properties();
        config.setProperty("db.url", "jdbc:mysql://localhost:3306/tutorial");
        config.setProperty("db.usuario", "root");
        config.setProperty("db.password", "NO_GUARDAR_EN_REPOSITORIO");
        config.setProperty("app.nombre", "Gestion de Usuarios");
        config.setProperty("app.version", "1.0.0");
        config.setProperty("app.max_conexiones", "10");

        try (FileOutputStream fos = new FileOutputStream(rutaConfig)) {
            config.store(fos, "Configuracion de la aplicacion");
            System.out.println("Fichero config.properties creado.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }

        // 2. Leer el fichero .properties
        Properties leido = new Properties();
        try (FileInputStream fis = new FileInputStream(rutaConfig)) {
            leido.load(fis);
            System.out.println("\n=== Configuracion cargada ===");
            System.out.println("URL BD:          " + leido.getProperty("db.url"));
            System.out.println("Usuario BD:      " + leido.getProperty("db.usuario"));
            System.out.println("App nombre:      " + leido.getProperty("app.nombre"));
            System.out.println("App version:     " + leido.getProperty("app.version"));

            // getProperty con valor por defecto — si la clave no existe
            int maxConex = Integer.parseInt(
                leido.getProperty("app.max_conexiones", "5")
            );
            System.out.println("Max conexiones:  " + maxConex);

            // Clave inexistente con valor por defecto
            String debug = leido.getProperty("app.debug", "false");
            System.out.println("Modo debug:      " + debug);

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        // 3. Modificar una propiedad y volver a guardar
        try (FileInputStream fis = new FileInputStream(rutaConfig)) {
            leido.load(fis);
            leido.setProperty("app.version", "1.1.0");
            leido.remove("db.password"); // eliminar credencial del fichero

            try (FileOutputStream fos = new FileOutputStream(rutaConfig)) {
                leido.store(fos, "Configuracion actualizada");
                System.out.println("\nFichero actualizado: version 1.1.0, password eliminada.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
