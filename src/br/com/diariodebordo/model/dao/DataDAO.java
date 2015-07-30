package br.com.diariodebordo.model.dao;

import br.com.diariodebordo.model.vo.Data;
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
public class DataDAO {
    
    public ArrayList<Data> getAnosBase() {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            ResultSet var = stm.executeQuery("SELECT DISTINCT strftime('%Y',data_att) FROM diario");
            ArrayList<Data> datas = new ArrayList<>();
            
            while (var.next()) {
                
                Data d = new Data();
                d.setAno(var.getInt(1));
                datas.add(d);
                
            }
            
            return datas;
            
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
