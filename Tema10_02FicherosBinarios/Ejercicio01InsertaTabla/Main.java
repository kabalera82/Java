package Tema10_02FicherosBinarios.Ejercicio01InsertaTabla;

//importamos de java IO FileOut y ObjectOut
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    /**
     * Escribir en un archivo de datos.dat
     * los valores de una tabla de diez elementos
     */

    public static void main(String[] args) {

        // Variables.
        int [] tabla = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ObjectOutputStream flujoSalida = null;

        // Abrimos un flujo try - catch

        try{
            flujoSalida = new ObjectOutputStream( new FileOutputStream("datos.dat"));
            for (int n : tabla){
                flujoSalida.writeInt(n);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            {
                if  (flujoSalida != null){
                    try {
                        flujoSalida.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }

    }
}
