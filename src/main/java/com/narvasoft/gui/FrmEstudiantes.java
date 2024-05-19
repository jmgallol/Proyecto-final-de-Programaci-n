package com.narvasoft.gui;


import static com.narvasoft.gui.Archivos.Escribirtxt;
import static com.narvasoft.gui.Archivos.Mostrar_mensaje;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.*;

public class FrmEstudiantes extends javax.swing.JFrame {

    private JButton btnSave;
    private static JLabel lblId3;
    private static JLabel lblJuegof;
    private static JLabel lblLevel;
    private static JLabel lblNombre;
    private static JLabel lblScore;
    private static JTextField txtId;
    private static JTextField txtJuego;
    private static JTextField txtNombre;
    private static JTextField txtScore;
    private static JTextArea txtArea;
    private static JScrollPane jScrollPane1;
    private static JButton btnBuscar;
    private static JButton btnEliminar;
    private static JButton btnActualizar;
    private static JButton btnListar;
    private static JComboBox jComboBox1;

    static ArrayList<Jugadores> jugadores = new ArrayList<>();
    

    static void seleccionarOpcion(String opcion) {
        switch (opcion) {
            case "E":
                jComboBox1.setSelectedIndex(1);
                break;
            case "A":
                jComboBox1.setSelectedIndex(2);
                break;
            case "B":
                jComboBox1.setSelectedIndex(3);
                break;
            case "H":
                jComboBox1.setSelectedIndex(4);
                break;
        }

    }

    static void limpiarForm() {
        txtId.setText("");
        txtJuego.setText("");
        jComboBox1.setSelectedIndex(0);
        txtNombre.setText("");
        txtScore.setText("");
    }

    public void addJugador()  {
        Jugadores jugador = new Jugadores(txtNombre.getText(), txtJuego.getText(), jComboBox1.getSelectedItem().toString().charAt(0), Integer.parseInt(txtScore.getText()));
        jugadores.add(jugador);
        listarJugadores();
        limpiarForm();
        Escribirtxt(jugadores);
        Mostrar_mensaje();
    }

    public void listarJugadores() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("************Listado de Jugadores***************\n");
        //System.out.println("************Listado de Jugadores***************");
        for (int i=0;i<jugadores.size();i++)  //txtArea.setText("Id. "+jugador.getId()+"Nombre del Jugador:" +jugador.getNombre() + " Puntaje: "+jugador.getMaxScore());
        //System.out.println("Id. "+jugador.getId()+"Nombre del Jugador:" +jugador.getNombre() + " Puntaje: "+jugador.getMaxScore()); 
        {
            stringBuilder.append("Id. ").append(jugadores.get(i).getId())
                    .append(" Juego favorito: ").append(jugadores.get(i).getJuegoFavorito())
                    .append(" Nombre del Jugador: ").append(jugadores.get(i).getNombre())
                    .append(" Puntaje: ").append(jugadores.get(i).getMaxScore())
                    .append("\n");
        }
        txtArea.setText(stringBuilder.toString());
        Escribirtxt(jugadores);
        
        
    }

    public FrmEstudiantes() {
        initComponents();
    }

    public void buscarJugador() {
        int id = Integer.parseInt(txtId.getText());
        if (jugadores.size() > 0) {
            for (Jugadores jugador : jugadores) {
                if (jugador.getId() == id) {
                    txtNombre.setText(jugador.getNombre());
                    txtJuego.setText(jugador.getJuegoFavorito());
                    txtScore.setText(String.valueOf(jugador.getMaxScore()));
                    seleccionarOpcion(Character.toString(jugador.getLevel()));
                    btnActualizar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    txtArea.setText("");
                    break;
                } else {
                    txtArea.setText("!El jugador con el Id número: " + id + " no existe!");
                }
            }
        } else {
            txtArea.setText("!No existe ningún jugador!");
        }
        Escribirtxt(jugadores);
        
        
    }

    public void eliminarJugador() {
        int id = Integer.parseInt(txtId.getText());
        for (int i=0;i<jugadores.size();i++) {
            if (jugadores.get(i).getId() == id) {
                String mensaje = ("Se ha eliminado el jugador con el ID:" + jugadores.get(i).getId());
                jugadores.remove(jugadores.get(i));
                btnActualizar.setEnabled(false);
                btnEliminar.setEnabled(false);
                limpiarForm();
                listarJugadores();
                JOptionPane.showInternalMessageDialog(null, mensaje);
            }
        }
        Escribirtxt(jugadores);
        Mostrar_mensaje();
    }

    public void ActualizarJugador() {
        int id = Integer.parseInt(txtId.getText());
        for (Jugadores jugador : jugadores) {
            if (jugador.getId() == id) {
                jugador.setNombre(txtNombre.getText());
                jugador.setJuegoFavortio(txtJuego.getText());
                jugador.setMaxScore(Integer.parseInt(txtScore.getText()));
                jugador.setLevel(jComboBox1.getSelectedItem().toString().charAt(0));
                String mensaje = ("Se ha Actualizado el jugador con el ID:" + jugador.getId());
                JOptionPane.showInternalMessageDialog(null, mensaje);
                btnActualizar.setEnabled(false);
                btnEliminar.setEnabled(false);
                limpiarForm();
            }
        }
        Escribirtxt(jugadores);
        Mostrar_mensaje();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblJuegof = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblId3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtJuego = new javax.swing.JTextField();
        txtScore = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNombre.setText("Nombre del jugador:");

        lblLevel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLevel.setText("Nivel:");
        lblLevel.setToolTipText("'");

        lblJuegof.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblJuegof.setText("Juego Favorito:");

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblScore.setText("Score:");

        lblId3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblId3.setText("ID:");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSave.setBackground(new java.awt.Color(102, 102, 102));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\gui\\src\\main\\java\\com\\narvasoft\\gui\\Crear.png")); // NOI18N
        btnSave.setText("Crear");
        btnSave.setToolTipText("Guardar el Jugador Actual");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\gui\\src\\main\\java\\com\\narvasoft\\gui\\Buscar.png")); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Guardar el Jugador Actual");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\gui\\src\\main\\java\\com\\narvasoft\\gui\\Eliminar.png")); // NOI18N
        btnEliminar.setText("ELiminar");
        btnEliminar.setToolTipText("Guardar el Jugador Actual");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(102, 102, 102));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\gui\\src\\main\\java\\com\\narvasoft\\gui\\Actualizar.png")); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnListar.setBackground(new java.awt.Color(102, 102, 102));
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Documents\\gui\\src\\main\\java\\com\\narvasoft\\gui\\Listar.png")); // NOI18N
        btnListar.setText("Listar Jugadores");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "              --Selecionar--", "Experto", "Avanzado", "Basico ", "Horrible" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJuegof, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addComponent(txtScore, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJuego, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar)
                    .addComponent(btnListar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJuegof, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
          addJugador();
                // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarJugador();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarJugador();

        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        ActualizarJugador();

       
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        listarJugadores();
    }//GEN-LAST:event_btnListarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEstudiantes().setVisible(true);
            }
        });
    }
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId3;
    private javax.swing.JLabel lblJuegof;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblScore;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJuego;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtScore;
    // End of variables declaration//GEN-END:variables
*/
}
