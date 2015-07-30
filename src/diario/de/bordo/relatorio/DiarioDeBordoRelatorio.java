package diario.de.bordo.relatorio;

import br.com.diariodebordo.model.dao.Conexao;
import javax.swing.JOptionPane;
import br.com.diariodebordo.view.PrincipalForm;

/**
 *
 * @author joao.oliveira
 */
public class DiarioDeBordoRelatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                String pastaRaiz = System.getProperty("user.dir");

                if (pastaRaiz.contains("CONTROLE LOCAL DIR_CE")) {

                    JOptionPane.showMessageDialog(null, "Não é permitido executar o programa no caminho de rede! \r\n COPIE o arquivo para seu computador e execute!");
                    return;

                }

                Conexao.copiarBanco();
                PrincipalForm frm = new PrincipalForm();
                frm.setVisible(true);

            }
        });

    }

}
