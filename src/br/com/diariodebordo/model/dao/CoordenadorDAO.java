package br.com.diariodebordo.model.dao;

import br.com.diariodebordo.model.vo.Coordenador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class CoordenadorDAO {
    
    public ArrayList<Coordenador> getCoordenadoresPorUF(String uf) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            ResultSet var = stm.executeQuery("SELECT DISTINCT coordenador FROM setores WHERE uf='" + uf + "' ORDER BY 1");
            ArrayList<Coordenador> coordenadores = new ArrayList<>();
            
            while (var.next()) {
                Coordenador c = new Coordenador();
                c.setNome(var.getString(1));
                coordenadores.add(c);
            }
            
            return coordenadores;
            
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
    
    public ArrayList<Coordenador> getCoordenadores() throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            ResultSet var = stm.executeQuery("SELECT DISTINCT COORDENADOR FROM SETORES ORDER BY 1");
            ArrayList<Coordenador> coordenadores = new ArrayList<>();
            
            while (var.next()) {
                
                Coordenador c = new Coordenador();
                c.setNome(var.getString(1));
                coordenadores.add(c);
                
            }
            
            return coordenadores;
            
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
    
    public String getUF(String coordenador) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            ResultSet var = stm.executeQuery("SELECT uf AS UF FROM setores WHERE coordenador ='" + coordenador + "'");
            String uf = "";
            
            while (var.next()) {
                
                uf = var.getString(1);
                
            }
            
            return uf;
            
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
