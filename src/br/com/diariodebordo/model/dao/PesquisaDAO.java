package br.com.diariodebordo.model.dao;

import br.com.diariodebordo.model.vo.Ocorrencia;
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
public class PesquisaDAO {

    public ArrayList<Ocorrencia> getPesquisa(String coordenador, String dataInicio, String dataFim, String grave) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement stm = null;

        try {

            conn = Conexao.getConexao();
            stm = conn.createStatement();

            String queryCoordenador = coordenador.equals("") ? "" : " AND SETORES.COORDENADOR='" + coordenador + "'";
            String queryData = " AND DATE(DIARIO.DATA_ATT) BETWEEN '" + dataInicio + "' and '" + dataFim + "'";
            String queryGrave = grave.equals("") ? "" : " AND DIARIO.GRAVE='" + grave.toLowerCase().charAt(0) + "'";

            ResultSet var = stm.executeQuery("SELECT DIARIO.UF,DIARIO.ATENDENTE, DIARIO.DATA_ATT,DIARIO.PERIODO,"
                    + "TECNICOS.NOME AS TECNICO,DIARIO.SETOR_GRA_AREA, SETORES.COORDENADOR, DIARIO.OCORRENCIAS,DIARIO.RECORRENCIA_SUP,"
                    + "DIARIO.RECORRENCIA_COORD,DIARIO.RECORRENCIA_GERENCIA,DIARIO.OBSERVACOES,DIARIO.GRAVE,"
                    + "DIARIO.USERNAME FROM DIARIO,TECNICOS, SETORES WHERE DIARIO.TECNICO = TECNICOS.MAT AND "
                    + "DIARIO.SETOR_GRA_AREA = SETORES.SETOR " + queryCoordenador + queryData + queryGrave
                    + " ORDER BY 3 ASC");

            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();

            while (var.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setUf(var.getString(1));
                o.setAtendente(var.getString(2));
                o.setData_att(var.getString(3));
                o.setPeriodo(var.getString(4));
                o.setTecnico(var.getString(5));
                o.setSetor_gra_area(var.getString(6));
                o.setCoordenador(var.getString(7));
                o.setOcorrencias(var.getString(8));
                o.setRecorrencia_sup(var.getString(9));
                o.setRecorrencia_coo(var.getString(10));
                o.setReccorencia_ger(var.getString(11));
                o.setObservacoes(var.getString(12));
                o.setGrave(var.getString(13));
                o.setUsername(var.getString(14));
                ocorrencias.add(o);
            }

            return ocorrencias;

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
