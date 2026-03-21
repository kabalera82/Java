package org.kabalera82.gui;

// Imports
import org.kabalera82.conexion.Conexion;
import org.kabalera82.dao.IUsuarioDAO;
import org.kabalera82.dao.UsuarioDAO;
import org.kabalera82.model.Usuario;

import java.util.Scanner;

/**
 * Clase principal que arranca la aplicación de consola para la gestión
 * de usuarios en la base de datos.
 *
 * <p>El programa presenta un menú interactivo que permite al usuario
 * ejecutar operaciones CRUD (Create, Read, Update, Delete) sobre
 * la entidad {@link Usuario}, a través de la interfaz {@link IUsuarioDAO}
 * y su implementación {@link UsuarioDAO}.</p>
 *
 * <h2>Opciones del menú:</h2>
 * <ul>
 *     <li>1. Listar usuarios</li>
 *     <li>2. Buscar usuario por ID</li>
 *     <li>3. Agregar usuario</li>
 *     <li>4. Modificar usuario</li>
 *     <li>5. Eliminar usuario</li>
 *     <li>6. Salir</li>
 * </ul>
 *
 * @author Marcos
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que lanza la aplicación de consola.
     *
     * @param args argumentos de la línea de comandos (no usados en este caso).
     */
    public static void main(String[] args) {
        Conexion.inicializarBD();
        menuUsuarios();
    }

    /**
     * Método que inicia el menú interactivo de gestión de usuarios.
     * Permite elegir las distintas opciones CRUD.
     */
    private static void menuUsuarios() {
        boolean salir = false;
        Scanner consola = new Scanner(System.in);

        // Creamos un objeto de UsuarioDAO para acceder a la base de datos
        IUsuarioDAO usuarioDao = new UsuarioDAO();

        while (!salir) {
            try {
                int opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, usuarioDao);
            } catch (Exception e) {
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    /**
     * Muestra el menú en consola y captura la opción elegida por el usuario.
     *
     * @param consola objeto {@link Scanner} para leer entrada por teclado.
     * @return entero con la opción elegida.
     */
    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                *** GESTIÓN DE USUARIOS ***
                1. Listar Usuarios
                2. Buscar Usuario por ID
                3. Agregar Usuario
                4. Modificar Usuario
                5. Eliminar Usuario
                6. Salir
                Elije una opción:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param consola objeto {@link Scanner} para leer datos.
     * @param opcion número de opción elegida en el menú.
     * @param usuarioDAO DAO para acceder a los datos de {@link Usuario}.
     * @return {@code true} si se debe salir del menú, {@code false} en caso contrario.
     */
    private static boolean ejecutarOpciones(Scanner consola, int opcion,
                                            IUsuarioDAO usuarioDAO) {
        boolean salir = false;

        switch (opcion) {
            case 1 -> { // 1. Listar usuarios
                System.out.println("--- Listado de Usuarios ---");
                var usuarios = usuarioDAO.listarUsuarios();
                usuarios.forEach(System.out::println);
            }
            case 2 -> { // 2. Buscar usuario por id
                System.out.print("Introduce el id del Usuario a buscar: ");
                int idUsuario = Integer.parseInt(consola.nextLine());
                Usuario usuario = new Usuario(idUsuario);
                boolean encontrado = usuarioDAO.buscarUsuarioId(usuario);
                if (encontrado)
                    System.out.println("Usuario encontrado: " + usuario);
                else
                    System.out.println("Usuario NO encontrado con id=" + idUsuario);
            }
            case 3 -> { // 3. Agregar usuario
                System.out.println("--- Agregar Usuario ---");
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Primer Apellido: ");
                String primerApellido = consola.nextLine();
                System.out.print("Segundo Apellido: ");
                String segundoApellido = consola.nextLine();
                System.out.print("Teléfono: ");
                String telefono = consola.nextLine();
                System.out.print("Email: ");
                String email = consola.nextLine();

                Usuario usuario = new Usuario(nombre, primerApellido, segundoApellido, telefono, email);
                boolean agregado = usuarioDAO.agregarUsuario(usuario);

                if (agregado)
                    System.out.println("Usuario agregado: " + usuario);
                else
                    System.out.println("Usuario NO agregado.");
            }
            case 4 -> { // 4. Modificar usuario
                System.out.println("--- Modificar Usuario ---");
                System.out.print("Id Usuario: ");
                int idUsuario = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Primer Apellido: ");
                String primerApellido = consola.nextLine();
                System.out.print("Segundo Apellido: ");
                String segundoApellido = consola.nextLine();
                System.out.print("Teléfono: ");
                String telefono = consola.nextLine();
                System.out.print("Email: ");
                String email = consola.nextLine();

                Usuario usuario = new Usuario(idUsuario, nombre, primerApellido, segundoApellido, telefono, email);
                boolean modificado = usuarioDAO.modificarUsuario(usuario);

                if (modificado)
                    System.out.println("Usuario modificado: " + usuario);
                else
                    System.out.println("Usuario NO modificado.");
            }
            case 5 -> { // 5. Eliminar usuario
                System.out.println("--- Eliminar Usuario ---");
                System.out.print("Id Usuario: ");
                int idUsuario = Integer.parseInt(consola.nextLine());
                Usuario usuario = new Usuario(idUsuario);
                boolean eliminado = usuarioDAO.eliminarUsuario(usuario);

                if (eliminado)
                    System.out.println("Usuario Eliminado con id=" + idUsuario);
                else
                    System.out.println("Usuario NO eliminado con id=" + idUsuario);
            }
            case 6 -> { // 6. Salir
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida: " + opcion);
        }
        return salir;
    }
}
