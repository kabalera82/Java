package Tema12AcesoDatos.ejercicio03.app;


import Tema12AcesoDatos.ejercicio03.csv.CsvPrinter;
import Tema12AcesoDatos.ejercicio03.csv.CsvTable;
import Tema12AcesoDatos.ejercicio03.csv.CsvUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class appLeerCsv {
    // Definimos la ruta
    private static final Path RUTA = Paths.get ("data","clientes.csv");

    public static void main(String[] args) {
    //asegurarse que existe el directorio del archivo
        try{
            Files.createDirectories(RUTA.getParent());

        } catch (IOException e) {
            System.err.println("No se pudo asegurar: " + e.getMessage());
        }

        CsvTable table = new CsvTable();

        //apertura y lectura linea a linea

        try(BufferedReader br = Files.newBufferedReader(RUTA, StandardCharsets.UTF_8)){

            String linea;

            linea = br.readLine();

            if(linea == null ){ // no tiene cabecera
                System.err.println("El archivo está vacio");
                return; // para que no siga buscando cabeceras
            }

            List<String> headers = CsvUtils.parseCSVLine(linea);
            table.setHeaders(headers);

            while(( linea = br.readLine()) != null){

                List<String> campos = CsvUtils.parseCSVLine(linea);


                table.addRow(campos);
            }



        } catch (NoSuchFileException e) {
            // Error durante de que no encuentra el archivo
            System.err.println("No aparece el archivo: " + RUTA.toAbsolutePath());
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Error durante de la lectura

            e.printStackTrace(); // Imprime la traza del error
        }


        // Mostrar el contenido en un a tabla
        CsvPrinter.print(table);

    }
}
