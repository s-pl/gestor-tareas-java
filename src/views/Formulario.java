package src.views;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import src.controllers.Tarea;

public class Formulario extends javax.swing.JFrame {

    private DefaultListModel<Tarea> model;

    public Formulario() {
        initComponents();
        model = new DefaultListModel<>();
        jList1.setModel(model);

        jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jList1.getSelectedIndex() != -1) {
                Tarea t = jList1.getSelectedValue();
                inputNombre.setText(t.getNombre());
                inputHoraMáxima.setText(t.getHoraMaxima());
                inputMaxFecha.setText(t.getFechaMaxima());
                jTextArea1.setText(t.getDescripcion());
                checkRealizada.setSelected(t.isRealizada());
            }
        });
    
        cargarTareas();
    }

    @SuppressWarnings("unused")
    private void initComponents() {

        //generado con netbeans
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
        checkRealizada = new javax.swing.JCheckBox();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        inputNombre.setText("Nombre");
        inputHoraMáxima.setText("Hora máxima");
        inputMaxFecha.setText("Fecha máxima");

        jToggleButton1.setText("Agregar");
        jToggleButton1.addActionListener(e -> {
            try {
                agregarTarea();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        

        jToggleButton2.setText("Limpiar");
        jToggleButton2.addActionListener(e -> limpiarCampos());

        jToggleButton3.setText("Cancelar");
        jToggleButton3.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas salir?");
            if (respuesta == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        jToggleButton4.setText("Eliminar");
        jToggleButton4.addActionListener(e -> eliminarTarea());

        checkRealizada.setText("Realizada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputNombre)
                                        .addComponent(inputHoraMáxima)
                                        .addComponent(inputMaxFecha)
                                        .addComponent(jScrollPane2)
                                        .addComponent(checkRealizada)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jToggleButton1)
                                                .addGap(10)
                                                .addComponent(jToggleButton2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jToggleButton4)
                                                .addGap(10)
                                                .addComponent(jToggleButton3)))
                                .addGap(20)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addGap(20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(inputHoraMáxima, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(inputMaxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(checkRealizada)
                                        .addGap(10)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jToggleButton1)
                                                .addComponent(jToggleButton2))
                                        .addGap(10)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jToggleButton4)
                                                .addComponent(jToggleButton3)))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(jPanel1));
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(jPanel1));

        setMinimumSize(new Dimension(800, 600));

        setLocationRelativeTo(null);
        this.setTitle("Gestor de tareas");
        
        pack();
        //generado con netbeans hasta aquí
    }

    private void agregarTarea() throws IOException { // tuve que mirar con chatgpt por que no sabía como solucionar el que se sobreescribiera
        // Abrir el archivo en modo append para no sobrescribir
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("tareas.dat"), true)) {
            @Override
            protected void writeStreamHeader() throws IOException {
                // No escribir el encabezado para que no se sobrescriban los datos previos
            }
        };
    
        String nombre = inputNombre.getText().trim();
        String hora = inputHoraMáxima.getText().trim();
        String fecha = inputMaxFecha.getText().trim();
        String descripcion = jTextArea1.getText().trim();
        boolean realizada = checkRealizada.isSelected();
    
        if (nombre.isEmpty() || hora.isEmpty() || fecha.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "todos los campos son obligatorios!");
            oos.close();
            return;
        }
    
        try {
            Tarea tarea = new Tarea(nombre, hora, fecha, descripcion, realizada);
            oos.writeObject(tarea);
            model.addElement(tarea);
            oos.close();
            limpiarCampos();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    

    private void eliminarTarea() {
        int index = jList1.getSelectedIndex();
        if (index != -1) {
            model.remove(index);

            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para eliminar.");
        }
    }

    private void limpiarCampos() {
        if (inputNombre.getText().equals("") &&
                inputHoraMáxima.getText().equals("") &&
                inputMaxFecha.getText().equals("") &&
                jTextArea1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No puedes limpiar algo que no existe ! ;)");
        } else {
            inputNombre.setText("");
            inputHoraMáxima.setText("");
            inputMaxFecha.setText("");
            jTextArea1.setText("");
            checkRealizada.setSelected(false);
            jList1.clearSelection();
        }
    }
    
    private void cargarTareas() {
        File file = new File("tareas.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Tarea tarea;
                while ((tarea = (Tarea) ois.readObject()) != null) {
                    model.addElement(tarea);
                }
            } catch (IOException | ClassNotFoundException e) {
                if (!(e instanceof java.io.EOFException)) {
                    System.out.println("Error al cargar tareas: " + e.getMessage());
                }
            }
        } else {
            System.out.println("el archivo no existe");
        }
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Formulario().setVisible(true));
      
    }

    private javax.swing.JCheckBox checkRealizada;
    private javax.swing.JTextField inputHoraMáxima;
    private javax.swing.JTextField inputMaxFecha;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JList<Tarea> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
}