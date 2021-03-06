package br.com.diariodebordo.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.diariodebordo.model.vo.Ocorrencia;

/**
 *
 * @author joao.oliveira
 */
public class DetalhesForm extends javax.swing.JFrame {

    /**
     * Creates new form DetalhesForm
     */
    public DetalhesForm() {
        initComponents();
    }

    private ArrayList<Ocorrencia> ocorrencias;
    private String dataInicial;
    private String dataFinal;

    public DetalhesForm(ArrayList<Ocorrencia> ocorrencias) {

        this.ocorrencias = ocorrencias;
        initComponents();

    }

    public DetalhesForm(ArrayList<Ocorrencia> ocorrencias, String dataInicial, String dataFinal) {

        this.ocorrencias = ocorrencias;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalhesTable = new javax.swing.JTable();
        periodoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes da Ocorrencia");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        detalhesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(detalhesTable);

        periodoLabel.setText("Período:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(periodoLabel)
                            .addComponent(btnExportar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(periodoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        String[] colunas = {"UF", "ATENDENTE", "DATA", "PERIODO", "TECNICO", "GRA/SETOR/AREA", "OCORRENCIA", "RECORRENCIA SUP",
            "RECORRENCIA COO", "RECORRENCIA GER", "OBSERVACOES", "GRAVE", "USERNAME"};

      //  System.out.println(dataInicial + " 1| " + dataFinal);

        if (dataInicial != null | dataFinal != null) {

            final String OLD_FORMAT = "yyyy-MM-dd";
            final String NEW_FORMAT = "dd/MM/yyyy";

            SimpleDateFormat sdf1 = new SimpleDateFormat(OLD_FORMAT);
            SimpleDateFormat sdf2 = new SimpleDateFormat(OLD_FORMAT);
            Date di;
            Date df;

            try {

                di = sdf1.parse(dataInicial);
                df = sdf2.parse(dataFinal);

             //   System.out.println(di + " 2| " + df);

                sdf1.applyPattern(NEW_FORMAT);
                sdf2.applyPattern(NEW_FORMAT);
                dataInicial = sdf1.format(di);
                dataFinal = sdf2.format(df);

           //     System.out.println(dataInicial + " 3| " + dataFinal);

                this.periodoLabel.setText("Período: " + dataInicial + " - " + dataFinal);

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }

        DefaultTableModel model = new DefaultTableModel(new Object[0][0], colunas) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        for (Ocorrencia ocorr : ocorrencias) {

            String valores[] = {ocorr.getUf(), ocorr.getAtendente(), ocorr.getData_att(), ocorr.getPeriodo(), ocorr.getTecnico(),
                ocorr.getSetor_gra_area(), ocorr.getOcorrencias(), ocorr.getRecorrencia_sup(), ocorr.getRecorrencia_coo(),
                ocorr.getReccorencia_ger(), ocorr.getObservacoes(), ocorr.getGrave(), ocorr.getUsername()};
            model.addRow(valores);

        }

        this.detalhesTable.setModel(model);

    }//GEN-LAST:event_formWindowOpened

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed

        diario.de.bordo.relatorio.ExcelExporter ExExcel = new diario.de.bordo.relatorio.ExcelExporter();
        ExExcel.saveFile(this, this.detalhesTable);

    }//GEN-LAST:event_btnExportarActionPerformed

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
            java.util.logging.Logger.getLogger(DetalhesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalhesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalhesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalhesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalhesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JTable detalhesTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel periodoLabel;
    // End of variables declaration//GEN-END:variables
}
