package br.com.diariodebordo.model.dao;

import br.com.diariodebordo.model.vo.Tecnico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class TecnicoDAO {

    public ArrayList<Tecnico> getTecnicosPorUF(String uf) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();
            ResultSet var = stm.executeQuery("SELECT DISTINCT nome AS TECNICO FROM TECNICOS WHERE uf ='" + uf
                    + "' ORDER BY 1 ASC");
           
            ArrayList<Tecnico> tecnicos = new ArrayList<>();
            while(var.next()){
                
                Tecnico t = new Tecnico();
                t.setNome(var.getString(1));
                tecnicos.add(t);
            }

            return tecnicos;
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {

            try {
                stm.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
