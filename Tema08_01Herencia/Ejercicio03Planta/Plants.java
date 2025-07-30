package Tema08_01Herencia.Ejercicio03Planta;


public class Plants {

    public static void main(String[] args) {

        // 🌸 Crear una flor
        Flower flower = new Flower(
                "Rosa",        // name
                0.45,          // height
                true,          // sheets
                "Templado",    // weather
                "Rojo",        // colorPetals
                5,             // quantityPetal
                "Silvestre",   // variety
                "Primavera"    // station
        );

        // 🌳 Crear un árbol
        Tree tree = new Tree(
                "Roble",       // name
                5.8,           // height
                true,          // sheets
                "Frío",        // weather
                "Alcornoque",  // variety
                "Grueso",      // typeTrunk
                "Verde",       // color
                "Caduca"       // tipeSheet
        );

        // 🌿 Crear un arbusto
        Bush bush = new Bush(
                "Arbusto de lavanda", // name
                1.2,                  // height
                true,                 // sheets
                "Seco",               // weather
                3.5,                  // weight
                false                 // savage
        );

        // 🗣️ Mostrar quién es quién
        flower.saidWhoIam(); // I am a Flower
        tree.saidWhoIam();   // I am a Tree
        bush.saidWhoIam();   // I am a Bush
    }
}
