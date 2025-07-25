package Tema04_01Metodos;

import java.text.DecimalFormat;


public class Ejercicio03Redondeo {

    public static void main(String[] args) {
        // Método para redondear un número
        // Mayor a .5 redondea hacia arriba
        var numero = 8.4569;
        var redondear = Math.round(numero);
        System.out.println("Valor " + numero + " redondeado: " + redondear);

        //Formato de redondeo

        var patron = "#.##";// a mas # mas se redondea
        var decimalFormat = new DecimalFormat(patron);
        var numeroFormateado = decimalFormat.format(numero);
        System.out.println("Valor " + numero + " formateado: " + numeroFormateado);
    }
}