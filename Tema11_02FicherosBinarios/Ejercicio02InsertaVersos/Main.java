package Tema10_02FicherosBinarios.Ejercicio02InsertaVersos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *  Escribe como una cadena, en el fichero binario
 *  cancionPirata.dat, la siguiente estrofa:
 *  Con diez cañones por banda,
 *  viento a popa a toda vela,
 *  no corta el mar sino vuela,
 *  un velero bergantín.
 */


public class Main {

    public static void CrearFile (String recibido) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("./Tema10_02FicherosBinarios/cancionPirata.dat"))){
            salida.writeObject(recibido);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String versos = (
                "Con diez cañones por banda,\n" +
                        "viento en popa, a toda vela,\n" +
                        "no corta el mar, sino vuela\n" +
                        "un velero bergantín.\n" +
                        "\n" +
                        "Bajel pirata que llaman,\n" +
                        "por su bravura, el Temido,\n" +
                        "en todo mar conocido\n" +
                        "del uno al otro confín.\n" +
                        "\n" +
                        "La luna en el mar riela,\n" +
                        "en la lona gime el viento,\n" +
                        "y alza en blando movimiento\n" +
                        "olas de plata y azul;\n" +
                        "\n" +
                        "y ve el capitán pirata,\n" +
                        "cantando alegre en la popa,\n" +
                        "Asia a un lado, al otro Europa,\n" +
                        "y allá a su frente, Estambul.\n"
        );

        CrearFile(versos);

    }
}
