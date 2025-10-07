package Tema10_01FicherosDeTexto.Ejercicio02Bonana.ui;

import Tema10_01FicherosDeTexto.Ejercicio02Bonana.persistence.FrutaFileDao;

import java.util.Scanner;

public class Menu {

    public static void addFruit(){
        System.out.println("añadir");
    }
    public static void listFruit(){
        System.out.println("añadir");
    }
    public static void exportFruitsLists(){
        System.out.println("añadir");
    }
    public static void importFruitLists(){
        System.out.println("añadir");
    }
    public static void deleteFruit(){
        System.out.println("añadir");
    }


    public static void main(String[] args) {

        boolean salir = false;
        int opcion;
        FrutaFileDao dao = new FrutaFileDao();
        do{
            try {


                System.out.println(
                        "-------------- Menu --------------" + "\n" +
                                " - Selecciona una opción - " + "\n" +
                                "\n" +
                                "- 1. Añadir Fruta -" + "\n" +
                                "- 2. Listar Frutas de sesión-" + "\n" +
                                "- 3. Exportar Listado Frutas -" + "\n" +
                                "- 4. Importar Listado Frutas Fruta -" + "\n" +
                                "- 5. Eliminar Fruta -" + "\n" +
                                "- 6. Salir -" + "\n" +
                                "\n" +
                                " -----------------------------------"
                );

                Scanner sc = new Scanner(System.in);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        addFruit();
                        continue;
                    case 2:
                        listFruit();
                        continue;
                    case 3:
                        exportFruitsLists();
                        continue;
                    case 4:
                        importFruitLists();
                        continue;
                    case 5:
                        deleteFruit();
                        continue;
                    case 6:
                        salir = true;
                        System.out.println("Adios");
                        continue;
                    default:
                        System.out.println("Introduce una opción valida");
                }
        } catch (Exception e) {
            System.out.println("Error al seleccionar: "+ e);
        }
        }while (!salir);

    }
}
