/**
 * @author Samuel Ponce Luna
 * @version 1.1
 */

 package src.views;

 import java.awt.Dimension;
 import java.io.EOFException;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
 import javax.swing.DefaultListModel;
 import javax.swing.JOptionPane;
 import javax.swing.JToggleButton;
 import javax.swing.JComboBox;
 import java.util.Collections;
 import java.util.Comparator;
 import java.util.List;
 import java.util.ArrayList;
 
 import src.controllers.Tarea;
 
 /**
  * Clase Formulario: Interfaz gráfica para gestión de tareas
  * 
  * Características:
  * - Agregar, editar y eliminar tareas.
  * - Guardar y cargar tareas desde un archivo.
  * - Ordenar tareas por Nombre, Fecha o Hora.
  * - Buscar tareas por nombre.
  */
 public class Formulario extends javax.swing.JFrame {
 
     // Modelo para manejar la lista de tareas
     private DefaultListModel<Tarea> model;
 
     /**
      * Constructor de la clase Formulario
      * Inicializa componentes de la interfaz, listeners y carga tareas guardadas.
      */
     public Formulario() {
         initComponents();
         
         model = new DefaultListModel<>();
         jList1.setModel(model);
 
         // Listener para selección de tareas
         jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jList1.getSelectedIndex() != -1) {
                Tarea t = jList1.getSelectedValue();
                inputNombre.setText(t.getNombre());
                jTextArea1.setText(t.getHoraMaxima()); 
                inputHoraMáxima.setText(t.getDescripcion()); 
                inputMaxFecha.setText(t.getFechaMaxima());
                checkRealizada.setSelected(t.isRealizada());
        
                // debugging
                System.out.println("Nombre: " + t.getNombre());
                System.out.println("Descripción: " + t.getDescripcion());
                System.out.println("Hora Máxima: " + t.getHoraMaxima());
                System.out.println("Fecha Máxima: " + t.getFechaMaxima());
                System.out.println("Realizada: " + t.isRealizada());
            }
        });
        
        
     
         cargarTareas();
     }
 
     @SuppressWarnings("unchecked")
     private void initComponents() {
 
         jPanel1 = new javax.swing.JPanel();
 
         jScrollPane1 = new javax.swing.JScrollPane();
         jList1 = new javax.swing.JList<>();
         jScrollPane1.setViewportView(jList1);
 
         jScrollPane2 = new javax.swing.JScrollPane();
         jTextArea1 = new javax.swing.JTextArea();
 
         inputNombre = new javax.swing.JTextField();
         inputHoraMáxima = new javax.swing.JTextField();
         inputMaxFecha = new javax.swing.JTextField();
 
         
         jToggleButton1 = new javax.swing.JToggleButton();
         jToggleButton2 = new javax.swing.JToggleButton();
         jToggleButton3 = new javax.swing.JToggleButton();
         jToggleButton4 = new javax.swing.JToggleButton();
         
       
         jToggleButton5 = new javax.swing.JToggleButton(); // Botón Editar
         jToggleButton6 = new javax.swing.JToggleButton(); // Botón Ordenar
         jToggleButton7 = new javax.swing.JToggleButton(); // Botón Buscar
         inputBuscar = new javax.swing.JTextField();       // Campo de búsqueda
         comboOrdenar = new javax.swing.JComboBox<>();       // Combo de ordenación
 
         checkRealizada = new javax.swing.JCheckBox();
 
         // Configuración de componentes
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
         jTextArea1.setColumns(20);
         jTextArea1.setRows(5);
         jScrollPane2.setViewportView(jTextArea1);
 
         inputNombre.setText("Nombre");
         inputHoraMáxima.setText("Hora máxima");
         inputMaxFecha.setText("Fecha máxima");
 
         // Botón Agregar
         jToggleButton1.setText("Agregar");
         jToggleButton1.addActionListener(e -> agregarTarea());
 
         // Botón Limpiar
         jToggleButton2.setText("Limpiar");
         jToggleButton2.addActionListener(e -> limpiarCampos());
 
         // Botón Cancelar
         jToggleButton3.setText("Cancelar");
         jToggleButton3.addActionListener(e -> {
             int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas salir?");
             if (respuesta == JOptionPane.YES_OPTION) {
                 dispose();
             }
         });
 
         // Botón Eliminar
         jToggleButton4.setText("Eliminar");
         jToggleButton4.addActionListener(e -> {
             Tarea tareaSeleccionada = jList1.getSelectedValue();
             eliminarTarea(tareaSeleccionada);
         });
 
         // Botón Editar 
         jToggleButton5.setText("Editar");
         jToggleButton5.addActionListener(e -> editarTarea());
 
         // Configuración del campo de búsqueda
         inputBuscar.setText("Buscar por nombre");
 
         // Botón Buscar 
         jToggleButton7.setText("Buscar");
         jToggleButton7.addActionListener(e -> buscarTarea());
 
       
         comboOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Fecha", "Hora" }));
        
         jToggleButton6.setText("Ordenar");
         jToggleButton6.addActionListener(e -> ordenarTareas());
 
         checkRealizada.setText("Realizada");
 
     
         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(20)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(20)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(inputNombre)
                     .addComponent(inputHoraMáxima)
                     .addComponent(inputMaxFecha)
                     .addComponent(jScrollPane2)
                     .addComponent(checkRealizada)
                    
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addComponent(inputBuscar)
                         .addGap(10)
                         .addComponent(jToggleButton7))
                   
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addComponent(jToggleButton1)
                         .addGap(10)
                         .addComponent(jToggleButton2)
                         .addGap(10)
                         .addComponent(jToggleButton5))
                  
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(10)
                         .addComponent(jToggleButton6)
                         .addGap(10)
                         .addComponent(jToggleButton4)
                         .addGap(10)
                         .addComponent(jToggleButton3)))
                 .addGap(20))
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createSequentialGroup()
             .addGap(20)
             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGroup(jPanel1Layout.createSequentialGroup()
                     .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(10)
                     .addComponent(inputHoraMáxima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(10)
                     .addComponent(inputMaxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(10)
                     .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(10)
                     .addComponent(checkRealizada)
                     .addGap(10)
                
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jToggleButton7))
                     .addGap(10)
                   
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jToggleButton1)
                         .addComponent(jToggleButton2)
                         .addComponent(jToggleButton5))
                     .addGap(10)
                   
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jToggleButton6)
                         .addComponent(jToggleButton4)
                         .addComponent(jToggleButton3))))
             .addGap(20)
         );
 
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createSequentialGroup()
             .addComponent(jPanel1)
         );
         layout.setVerticalGroup(
             layout.createSequentialGroup()
             .addComponent(jPanel1)
         );
 
         setMinimumSize(new Dimension(800, 600));
         setLocationRelativeTo(null);
         this.setTitle("Gestor de tareas");
         
         pack();
     }
 
     // funcionalidad : agregar tarea
     private void agregarTarea() {
         String nombre = inputNombre.getText();
         String descripcion = jTextArea1.getText();
         String fecha = inputMaxFecha.getText();
         String hora = inputHoraMáxima.getText();
         boolean realizada = checkRealizada.isSelected();
 
         if (nombre.isEmpty() || descripcion.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos.");
             return;
         }
 
         if (descripcion.length() > 240) {
             JOptionPane.showMessageDialog(this, "La descripción no puede tener más de 240 caracteres.");
             return;
         }
 
         if (!hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
             JOptionPane.showMessageDialog(this, "La hora debe tener el formato HH:MM.");
             return;
         }
 
         if (!fecha.matches("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9]{4}")) {
             JOptionPane.showMessageDialog(this, "La fecha debe tener el formato DD/MM/YYYY.");
             return;
         }
 
         Tarea nuevaTarea = new Tarea(nombre, descripcion, fecha, hora, realizada);
         model.addElement(nuevaTarea);
         guardarTareas();
     }
 
     // funcionalidad: editar tarea seleccionada
     private void editarTarea() {
         int indice = jList1.getSelectedIndex();
         if (indice == -1) {
             JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para editar.");
             return;
         }
         
         String nombre = inputNombre.getText();
         String descripcion = jTextArea1.getText();
         String fecha = inputMaxFecha.getText();
         String hora = inputHoraMáxima.getText();
         boolean realizada = checkRealizada.isSelected();
 
         if (nombre.isEmpty() || descripcion.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos.");
             return;
         }
 
         if (descripcion.length() > 240) {
             JOptionPane.showMessageDialog(this, "La descripción no puede tener más de 240 caracteres.");
             return;
         }
 
         if (!hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
             JOptionPane.showMessageDialog(this, "La hora debe tener el formato HH:MM.");
             return;
         }
 
         if (!fecha.matches("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9]{4}")) {
             JOptionPane.showMessageDialog(this, "La fecha debe tener el formato DD/MM/YYYY.");
             return;
         }
         
         // Actualiza la tarea seleccionada con los nuevos datos
         Tarea tareaEditada = new Tarea(nombre, descripcion, fecha, hora, realizada);
         model.set(indice, tareaEditada);
         guardarTareas();
     }
 
     // funcionalidad: eliminar tarea seleccionada
     private void eliminarTarea(Tarea tareaAEliminar) {
         if (tareaAEliminar != null) {
             model.removeElement(tareaAEliminar);
             actualizarArchivo();
         }
     }
 
     // funcionalidad: limpiar campos de entrada
     private void limpiarCampos() {
         inputNombre.setText("");
         inputHoraMáxima.setText("");
         inputMaxFecha.setText("");
         jTextArea1.setText("");
         checkRealizada.setSelected(false);
         jList1.clearSelection();
         inputBuscar.setText("Buscar por nombre");
     }
 
     // funcionalidad: cargar tareas desde archivo
     private void cargarTareas() {
         File file = new File("tareas.dat");
         if (file.exists()) {
             try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                 while (true) {
                     try {
                         Tarea tarea = (Tarea) ois.readObject();
                         boolean tareaExistente = false;
                         for (int i = 0; i < model.getSize(); i++) {
                             Tarea tareaExistenteEnLista = model.getElementAt(i);
                             if (tareaExistenteEnLista.equals(tarea)) { 
                                 model.set(i, tarea);
                                 tareaExistente = true;
                                 break;
                             }
                         }
                         if (!tareaExistente) {
                             model.addElement(tarea);
                         }
                     } catch (EOFException e) {
                         break;
                     }
                 }
             } catch (IOException | ClassNotFoundException e) {
                 System.out.println("Error al cargar tareas: " + e.getMessage());
             }
         } else {
             System.out.println("El archivo no existe.");
         }
     }
 
     // funcionalidad: actualizar archivo de tareas
     private void actualizarArchivo() {
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tareas.dat"))) {
             for (int i = 0; i < model.size(); i++) {
                 oos.writeObject(model.getElementAt(i));
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 
     // funcionalidad: guardar tareas en archivo
     private void guardarTareas() {
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tareas.dat"))) {
             for (int i = 0; i < model.size(); i++) {
                 oos.writeObject(model.getElementAt(i));
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 
     // funcionalidad: ordenar tareas según el criterio seleccionado
     private void ordenarTareas() {
         String criterio = (String) comboOrdenar.getSelectedItem();
         List<Tarea> listaTareas = new ArrayList<>();
         for (int i = 0; i < model.size(); i++) {
             listaTareas.add(model.getElementAt(i));
         }
 
         switch (criterio) {
             case "Nombre":
                 Collections.sort(listaTareas, Comparator.comparing(Tarea::getNombre, String.CASE_INSENSITIVE_ORDER));
                 break;
             case "Fecha":
                 Collections.sort(listaTareas, Comparator.comparing(Tarea::getFechaMaxima));
                 break;
             case "Hora":
                 Collections.sort(listaTareas, Comparator.comparing(Tarea::getHoraMaxima));
                 break;
             default:
                 break;
         }
 
         model.removeAllElements();
         for (Tarea t : listaTareas) {
             model.addElement(t);
         }
         guardarTareas();
     }
 
     // funcionalidad: buscar tareas por nombre y mostrar resultados
     private void buscarTarea() {
         String busqueda = inputBuscar.getText().trim().toLowerCase();
         if (busqueda.isEmpty() || busqueda.equals("buscar por nombre")) {
             JOptionPane.showMessageDialog(this, "Por favor, ingresa un término de búsqueda.");
             return;
         }
         StringBuilder resultados = new StringBuilder("Tareas encontradas:\n");
         for (int i = 0; i < model.size(); i++) {
             Tarea t = model.getElementAt(i);
             if (t.getNombre().toLowerCase().contains(busqueda)) {
                 resultados.append("- ").append(t.getNombre()).append("\n");
             }
         }
         JOptionPane.showMessageDialog(this, resultados.toString());
     }
 
     /**
      * Método principal para iniciar la aplicación.
      */
     public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(() -> new Formulario().setVisible(true));
     }
 
     // Declaración de componentes
     private javax.swing.JCheckBox checkRealizada;
     private javax.swing.JTextField inputHoraMáxima;
     private javax.swing.JTextField inputMaxFecha;
     private javax.swing.JTextField inputNombre;
     private javax.swing.JTextField inputBuscar;
     private javax.swing.JList<Tarea> jList1;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JTextArea jTextArea1;
     private javax.swing.JToggleButton jToggleButton1; // Agregar
     private javax.swing.JToggleButton jToggleButton2; // Limpiar
     private javax.swing.JToggleButton jToggleButton3; // Cancelar
     private javax.swing.JToggleButton jToggleButton4; // Eliminar
     private javax.swing.JToggleButton jToggleButton5; // Editar
     private javax.swing.JToggleButton jToggleButton6; // Ordenar
     private javax.swing.JToggleButton jToggleButton7; // Buscar
     private javax.swing.JComboBox<String> comboOrdenar;
 }
 