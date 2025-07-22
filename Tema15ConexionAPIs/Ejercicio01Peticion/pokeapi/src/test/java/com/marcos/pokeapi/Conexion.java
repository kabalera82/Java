package Tema15ConexionAPIs.Ejercicio01Peticion.pokeapi.src.test.java.com.marcos.pokeapi;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

public class Conexion {

    public void MostrarDatos(JTable datos,
                             JTextField search,
                             JTextField name,
                             JTextField weight,
                             JTextField height,
                             JTextField exp,
                             JPanel imgPanel) {

        // Configurar las columnas de la tabla
        String[] nombreColumnas = {"Nombre", "Peso", "Altura", "Experiencia"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombreColumnas);

        datos.setModel(modelo);

        try {
            // Obtenemos los datos del pokemon
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + search.getText().toLowerCase());
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            // Usaremos BufferReader y StringBuilder para leer y almacenar los datos obtenido
            BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String lineas;

            //Utilizamos el bucle while para recorrer todas las lineas
            while ((lineas = lector.readLine()) != null) {
                respuesta.append(lineas);
            }
            lector.close();

            // PROCESAMIENTO DEL JSON Y EXTRACCIÓN DE DATOS
            JSONObject objetoJson = new JSONObject(respuesta.toString());

            System.out.println("a ver sie esto: " +respuesta);
            // Declara una variable del json que buscaras un string que coincida con " XXXX "
            String pokemonName = objetoJson.getString("name");
            int pokemonWeight = objetoJson.getInt("weight");
            int pokemonHeight = objetoJson.getInt("height");
            int baseExperience = objetoJson.getInt("base_experience");

            // EXTRACCIÓN DE LA URL DE LA IMAGEN
            String urlImg = objetoJson.getJSONObject("sprites").getString("front_default");

            // Agregar datos a la tabla (solo 4 columnas, sin urlImg)
            modelo.addRow(new Object[]{pokemonName, pokemonWeight, pokemonHeight, baseExperience});

            // Llenar los campos de texto individuales
            name.setText(pokemonName);
            weight.setText(String.valueOf(pokemonWeight));
            height.setText(String.valueOf(pokemonHeight));
            exp.setText(String.valueOf(baseExperience));

            // Mostrar imagen en el panel (verificar que la URL no sea null)
            if (urlImg != null && !urlImg.equals("null")) {
                // Debug: mostrar la URL de la imagen
                System.out.println("URL de imagen: " + urlImg);

                ImageIcon icon = new ImageIcon(new URL(urlImg));
                JLabel labelImg = new JLabel(icon);

                // Configurar el tamaño del label para que se vea la imagen
                labelImg.setHorizontalAlignment(JLabel.CENTER);
                labelImg.setVerticalAlignment(JLabel.CENTER);
                labelImg.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));

                // Limpiar el panel y agregar la imagen
                imgPanel.removeAll();
                imgPanel.setLayout(new java.awt.BorderLayout());
                imgPanel.add(labelImg, java.awt.BorderLayout.CENTER);
                imgPanel.revalidate();
                imgPanel.repaint();

                // Debug: confirmar que se agregó la imagen
                System.out.println("Imagen agregada al panel");
            } else {
                // Debug: mostrar si la URL es null
                System.out.println("URL de imagen es null o vacía");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduce el dato correcto");
        }
        System.out.println(modelo);

    }
    /*
    public static String getPokemonData(String pokemonName) {

    try {
        URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemonName.toLowerCase());
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String lineas;

        while ((lineas = lector.readLine()) != null) {
            respuesta.append(lineas);
        }
        lector.close();

        JSONObject objetoJson = new JSONObject(respuesta.toString());
        String nombre = objetoJson.getString("name");
        int peso = objetoJson.getInt("weight");
        int altura = objetoJson.getInt("height");
        int experiencia = objetoJson.getInt("base_experience");

        return String.format("Nombre: %s | Peso: %d hg | Altura: %d dm | Exp: %d",
                           nombre, peso, altura, experiencia);

    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
    */

}
