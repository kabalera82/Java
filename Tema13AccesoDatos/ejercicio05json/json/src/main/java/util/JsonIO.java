package src.main.java.util;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonIO {


    private static final ObjectMapper MAPPER = new ObjectMapper()
                    .enable(SerializationFeature
                    .INDENT_OUTPUT);

    // Si no pones nada por defecto el constructor es publico para eso lo hacemos y privado.
     private JsonIO () {};

     // <T> es un tipo de dato genérico desconocido para poder mantener el tipado.
     // var se resuleve en tiempo de compilacoin por lo que solo funcionaría dentro de un metodo concreto

     public static <T> void write(File file, T data) throws IOException {
         file.getParentFile().mkdirs();
         MAPPER.writeValue(file, data);
     }

     public static <T> T  read (File file, Class <T> type) throws IOException {
         return MAPPER.readValue(file, type);
     }



}
