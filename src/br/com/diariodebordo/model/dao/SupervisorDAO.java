package br.com.diariodebordo.model.dao;

import br.com.diariodebordo.model.vo.Supervisor;
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
public class SupervisorDAO {
    
    public ArrayList<Supervisor> getSupervisoresPorUF(String uf) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            ResultSet var = stm.executeQuery("SELECT DISTINCT SUPERVISOR AS SUPERVISOR FROM TECNICOS WHERE uf='"
                    + uf + "' ORDER BY 1 ASC");
            
            ArrayList<Supervisor> supervisores = new ArrayList<>();
            
            while (var.next()) {
                Supervisor s = new Supervisor();
                s.setNome(var.getString(1));
                supervisores.add(s);
                
            }
            
            return supervisores;
            
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
