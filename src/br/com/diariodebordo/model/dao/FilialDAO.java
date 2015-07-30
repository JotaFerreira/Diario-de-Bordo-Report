package br.com.diariodebordo.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.diariodebordo.model.vo.Setor;

/**
 *
 * @author joao.oliveira
 */
public class FilialDAO {

    public ArrayList<Setor> getSetoresPorUF(String uf) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String query;
            ArrayList<Setor> setores = new ArrayList<>();

            query = "SELECT setor,coordenador FROM setores WHERE uf='" + uf + "'";

            ResultSet var = stm.executeQuery(query);

            while (var.next()) {

                Setor Setor = new Setor();
                Setor.setNome(var.getString(1));
                Setor.setCoordenador(var.getString(2));
                setores.add(Setor);

            }

            return setores;

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
