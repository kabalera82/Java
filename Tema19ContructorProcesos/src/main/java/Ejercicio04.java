package Tema19ContructorProcesos.src.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio04 {

        public static void main(String[] args) {
            try {
                ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir");
                pb.directory(new File("C:\\Windows"));
                pb.inheritIO();
                pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
