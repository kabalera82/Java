package com.marcos.pokeapi;


import Tema15ConexionAPIs.Ejercicio02PokeAPI.Conexion;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author kabal
 */
public class Form extends javax.swing.JFrame {

    // Variables principales
    private Conexion conexion;          // Maneja peticiones HTTP a la PokeAPI
    private JTable tablaResultados;     // Muestra datos de Pokémon encontrados

    /**
     * Constructor principal
     */
    public Form() {
        initComponents();           // Inicializa componentes visuales
        conexion = new Conexion();  // Crea instancia de conexión
        setupTable();               // Configura tabla de resultados
        setupButton();              // Configura eventos del botón
        setupFieldsAsReadOnly();    // Hace campos de solo lectura
    }

    // ===============================================
    // CONFIGURACIÓN DE COMPONENTES
    // ===============================================

    private void setupTable() {
        tablaResultados = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaResultados);

        // Agregar tabla al panel con scroll
        data.setLayout(new java.awt.BorderLayout());
        data.add(scrollPane, java.awt.BorderLayout.CENTER);

        // Personalizar apariencia
        tablaResultados.setFillsViewportHeight(true);
        tablaResultados.setRowHeight(25);
    }

    private void setupFieldsAsReadOnly() {
        // Hacer campos no editables
        name.setEditable(false);
        weight.setEditable(false);
        height.setEditable(false);
        exp.setEditable(false);

        // Cambiar color para indicar solo lectura
        name.setBackground(java.awt.Color.LIGHT_GRAY);
        weight.setBackground(java.awt.Color.LIGHT_GRAY);
        height.setBackground(java.awt.Color.LIGHT_GRAY);
        exp.setBackground(java.awt.Color.LIGHT_GRAY);
    }

    private void setupButton() {
        // Evento del botón buscar
        button.addActionListener(evt -> ejecutarBusquedaPokemon(evt));

        // Permitir buscar con ENTER
        search.addActionListener(evt -> ejecutarBusquedaPokemon(evt));
    }


    // LÓGICA DE BÚSQUEDA


    private void ejecutarBusquedaPokemon(java.awt.event.ActionEvent evt) {
        // Validar campo de búsqueda
        if (search.getText().trim().isEmpty()) {
            mostrarMensajeError("Ingrese nombre o número de Pokémon");
            return;
        }

        // Limpiar datos previos
        limpiarCamposDatos();

        // Cambiar estado del botón
        button.setText("Buscando...");
        button.setEnabled(false);

        try {
            // Ejecutar búsqueda en la API
            conexion.MostrarDatos(tablaResultados, search, name, weight, height, exp, img);

            // Actualizar campos individuales
            actualizarCamposIndividuales();

        } catch (Exception e) {
            mostrarMensajeError("Error al buscar Pokémon: " + e.getMessage());
        } finally {
            // Restaurar botón
            button.setText("Buscar");
            button.setEnabled(true);
        }
    }

    // MÉTODOS AUXILIARES

    private void actualizarCamposIndividuales() {
        if (tablaResultados.getRowCount() > 0) {
            // Obtener datos de la primera fila
            String nombrePokemon = tablaResultados.getValueAt(0, 0).toString();
            String pesoPokemon = tablaResultados.getValueAt(0, 1).toString();
            String alturaPokemon = tablaResultados.getValueAt(0, 2).toString();
            String experienciaPokemon = tablaResultados.getValueAt(0, 3).toString();

            // Mostrar en campos individuales
            name.setText(nombrePokemon);
            weight.setText(pesoPokemon + " kg");
            height.setText(alturaPokemon + " cm");
            exp.setText(experienciaPokemon + " XP");
        }
    }

    private void limpiarCamposDatos() {
        name.setText("");
        weight.setText("");
        height.setText("");
        exp.setText("");
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // ===============================================
    // CÓDIGO GENERADO POR NETBEANS
    // ===============================================

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Crear componentes
        Buscador = new javax.swing.JPanel();
        button = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();
        exp = new javax.swing.JTextField();
        height = new javax.swing.JTextField();
        img = new javax.swing.JPanel();
        data = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        // Configurar ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscador de Pokemons");

        // Configurar panel principal
        Buscador.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscador de Pokemons"));
        button.setText("Buscar");

        // Eventos de campos
        name.addActionListener(evt -> campoNombrePresionado(evt));
        exp.addActionListener(evt -> campoExperienciaPresionado(evt));
        height.addActionListener(evt -> campoAlturaPresionado(evt));

        // Panel de imagen
        img.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));

        javax.swing.GroupLayout imgLayout = new javax.swing.GroupLayout(img);
        img.setLayout(imgLayout);
        imgLayout.setHorizontalGroup(
                imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 401, Short.MAX_VALUE)
        );
        imgLayout.setVerticalGroup(
                imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 369, Short.MAX_VALUE)
        );

        // Panel de datos
        data.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        javax.swing.GroupLayout dataLayout = new javax.swing.GroupLayout(data);
        data.setLayout(dataLayout);
        dataLayout.setHorizontalGroup(
                dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 440, Short.MAX_VALUE)
        );
        dataLayout.setVerticalGroup(
                dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 410, Short.MAX_VALUE)
        );

        // Configurar etiquetas
        search.setToolTipText("Ingrese nombre o número del Pokémon");
        jLabel2.setText("Nombre:");
        jLabel3.setText("Peso:");
        jLabel4.setText("Altura:");
        jLabel5.setText("Experiencia:");
        jLabel6.setText("Buscar:");

        // Layout principal
        javax.swing.GroupLayout BuscadorLayout = new javax.swing.GroupLayout(Buscador);
        Buscador.setLayout(BuscadorLayout);
        BuscadorLayout.setHorizontalGroup(
                BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BuscadorLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(BuscadorLayout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(search)
                                                .addGap(18, 18, 18)
                                                .addComponent(button))
                                        .addGroup(BuscadorLayout.createSequentialGroup()
                                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(48, 48, 48)
                                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(height)
                                                                .addComponent(name)
                                                                .addComponent(weight, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(exp, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
        );
        BuscadorLayout.setVerticalGroup(
                BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BuscadorLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(BuscadorLayout.createSequentialGroup()
                                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button)
                                                        .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addGap(18, 18, 18)
                                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // ===============================================
    // EVENTOS DE CAMPOS
    // ===============================================

    private void campoNombrePresionado(java.awt.event.ActionEvent evt) {
        // Funcionalidad personalizable
    }

    private void campoAlturaPresionado(java.awt.event.ActionEvent evt) {
        // Funcionalidad personalizable
    }

    private void campoExperienciaPresionado(java.awt.event.ActionEvent evt) {
        // Funcionalidad personalizable
    }

    // ===============================================
    // MAIN
    // ===============================================

    public static void main(String args[]) {
        // Configurar Look and Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tema15ConexionAPIs.Ejercicio02PokeAPI.Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Crear y mostrar formulario
        java.awt.EventQueue.invokeLater(() -> new Tema15ConexionAPIs.Ejercicio02PokeAPI.Form().setVisible(true));
    }

    // Variables de componentes
    private javax.swing.JPanel Buscador;
    private javax.swing.JButton button;
    private javax.swing.JPanel data;
    private javax.swing.JTextField exp;
    private javax.swing.JTextField height;
    private javax.swing.JPanel img;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JTextField search;
    private javax.swing.JTextField weight;
}
