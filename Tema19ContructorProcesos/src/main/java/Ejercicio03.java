package Tema19ContructorProcesos.src.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Ejercicio03 {

    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","comando_inexistente");
            Process p = pb.start();

            BufferedReader err = new BufferedReader(
                    new InputStreamReader(p.getErrorStream())
            );
            String linea;
            while((linea = err.readLine()) != null){
                System.out.println("ERROR:"+linea);
            }

            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
