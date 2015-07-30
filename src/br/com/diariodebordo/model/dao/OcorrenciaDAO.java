package br.com.diariodebordo.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.diariodebordo.model.vo.Ocorrencia;

/**
 *
 * @author joao.oliveira
 */
public class OcorrenciaDAO {
    
    public ArrayList<Ocorrencia> getContagemOcorrenciasCoo(String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String[] ufs = {"CE", "MA", "PI"};
            String query = "";
            
            for (int i = 0; i <= ufs.length - 1; i++) {
                
                query += "select '" + ufs[i] + "' as 'uf_coordenador',count(ocorrencias) as 'contagem_ocorrencias'  "
                        + "from diario where date(data_att) between '" + dtInicial + "' and '" + dtFinal + "' and uf = '" + ufs[i] + "' \n"
                        + "union all\n"
                        + "select setores.coordenador,count(diario.ocorrencias) as 'contagem' from diario,setores where date(diario.data_att)"
                        + " between '" + dtInicial + "' and '" + dtFinal + "' and diario.uf = '" + ufs[i] + "' and diario.setor_gra_area = setores.setor "
                        + "group by setores.coordenador";
                
                if (i != ufs.length - 1) {
                    
                    query += " union all ";
                    
                }
                
            }
            
            ResultSet var = stm.executeQuery(query);
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while (var.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setCoordenador(var.getString(1));
                o.setContagem(var.getString(2));
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
    
    public ArrayList<Ocorrencia> getContagemOcorrenciasSup(String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String[] ufs = {"CE", "MA", "PI"};
            String query = "";
            
            for (int i = 0; i <= ufs.length - 1; i++) {
                
                query += "select '" + ufs[i] + "' as 'uf_supervisor',count(ocorrencias) as 'contagem_ocorrencias'  "
                        + "from diario where date(data_att) between '" + dtInicial + "' and '" + dtFinal + "' and uf = '" + ufs[i] + "' \n"
                        + "union all\n"
                        + "select tecnicos.supervisor as supervisor,count(diario.ocorrencias) as 'contagem' "
                        + "from diario,tecnicos where date(diario.data_att)"
                        + " between '" + dtInicial + "' and '"
                        + dtFinal + "' and tecnicos.funcao in ('SUPERVISOR','TECNICO') and diario.uf = '" + ufs[i]
                        + "' and diario.setor_gra_area = tecnicos.setor and diario.tecnico = tecnicos.MAT group by tecnicos.supervisor";
                
                if (i != ufs.length - 1) {
                    
                    query += " union all ";
                    
                }
                
            }
            
            ResultSet var = stm.executeQuery(query);
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while (var.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setSupervisor(var.getString(1));
                o.setContagem(var.getString(2));
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
    
    public ArrayList<Ocorrencia> getContagemOcorrenciasTec(String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String[] ufs = {"CE", "MA", "PI"};
            String query = "";
            
            for (int i = 0; i <= ufs.length - 1; i++) {
                
                query += "select '" + ufs[i] + "' as 'uf_tecnico',count(ocorrencias) as 'contagem_ocorrencias'  "
                        + "from diario where date(data_att) between '" + dtInicial + "' and '" + dtFinal + "' and uf = '" + ufs[i] + "' \n"
                        + "union all\n"
                        + "select tecnicos.nome as tecnico,count(diario.ocorrencias) as 'contagem' from diario,tecnicos where date(diario.data_att)"
                        + " between '" + dtInicial + "' and '" + dtFinal + "' and tecnicos.funcao = 'TECNICO' and diario.uf = '" + ufs[i] + "' and diario.setor_gra_area = tecnicos.setor and diario.tecnico = tecnicos.MAT  "
                        + "group by tecnicos.nome";
                
                if (i != ufs.length - 1) {
                    
                    query += " union all ";
                    
                }
                
            }
            
            ResultSet var = stm.executeQuery(query);
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while (var.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setTecnico(var.getString(1));
                o.setContagem(var.getString(2));
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
    
    public ArrayList<Ocorrencia> getOcorrenciasPorCoordenador(String uf, String coordenador, String ocorrencia, String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String queryCoord = coordenador.equals("") | coordenador.equals("<Selecione uma UF>") ? "" : " and setores.Coordenador ='" + coordenador + "' ";
            String queryOcorrencia = ocorrencia.equals("") ? "" : " and diario.ocorrencias ='" + ocorrencia + "' ";
            String queryUF = uf.equals("") ? "" : " and diario.uf='" + uf + "'";
            String query = "";
            
            query += "select setores.Coordenador as coordenador, diario.ocorrencias as ocorrencia,"
                    + "count(diario.ocorrencias) as 'contagem _de_ocorrencias' from diario, setores "
                    + "where setores.setor = diario.setor_gra_area and date(diario.data_att) "
                    + "between '" + dtInicial + "' and '" + dtFinal + "' " + queryUF + queryCoord + queryUF + queryOcorrencia
                    + " group by setores.coordenador, diario.ocorrencias order by 1";
            
            ResultSet var = stm.executeQuery(query);
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while (var.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setCoordenador(var.getString(1));
                o.setOcorrencias(var.getString(2));
                o.setContagem(var.getString(3));
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
    
    public ArrayList<Ocorrencia> getOcorrenciasPorSupervisor(String uf, String supervisor, String ocorrencia, String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String querySup = supervisor.equals("") | supervisor.equals("<Selecione uma UF>") ? "" : " and tecnicos.supervisor ='" + supervisor + "' ";
            String queryOcorrencia = ocorrencia.equals("") ? "" : " and diario.ocorrencias ='" + ocorrencia + "' ";
            String queryUF = uf.equals("") ? "" : " and diario.uf='" + uf + "'";
            String query = "";
            
            query += "select tecnicos.supervisor as supervisor, diario.ocorrencias as ocorrencia,"
                    + " count(diario.ocorrencias) as 'contagem _de_ocorrencias' from diario, tecnicos "
                    + " where tecnicos.setor = diario.setor_gra_area and tecnicos.funcao in ('SUPERVISOR','TECNICO') "
                    + " and diario.tecnico = tecnicos.MAT and "
                    + " date(diario.data_att) between '" + dtInicial
                    + "' and '" + dtFinal + "' " + queryUF + querySup + queryUF + queryOcorrencia
                    + " group by tecnicos.supervisor, diario.ocorrencias order by 1";
            
            ResultSet var = stm.executeQuery(query);
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while (var.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setSupervisor(var.getString(1));
                o.setOcorrencias(var.getString(2));
                o.setContagem(var.getString(3));
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
    
    public ArrayList<Ocorrencia> getOcorrenciasPorTecnico(String uf, String tecnico, String ocorrencia, String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String queryTec = tecnico.equals("") | tecnico.equals("<Selecione uma UF>") ? "" : " and tecnicos.nome ='" + tecnico + "' ";
            String queryOcorrencia = ocorrencia.equals("") ? "" : " and diario.ocorrencias ='" + ocorrencia + "' ";
            String queryUF = uf.equals("") ? "" : " and diario.uf='" + uf + "'";
            String query = "";
            
            query += "select tecnicos.nome as tecnico, diario.ocorrencias as ocorrencia,"
                    + "count(diario.ocorrencias) as 'contagem _de_ocorrencias' from diario, tecnicos "
                    + "where tecnicos.setor = diario.setor_gra_area and tecnicos.funcao = 'TECNICO' and diario.tecnico = tecnicos.MAT and "
                    + "date(diario.data_att) between '" + dtInicial
                    + "' and '" + dtFinal + "' " + queryUF + queryTec + queryUF + queryOcorrencia
                    + " group by tecnicos.nome, diario.ocorrencias order by 1";
            
            ResultSet var = stm.executeQuery(query);
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while (var.next()) {
                Ocorrencia o = new Ocorrencia();
                o.setTecnico(var.getString(1));
                o.setOcorrencias(var.getString(2));
                o.setContagem(var.getString(3));
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
    
    public ArrayList<Ocorrencia> getItensOcorrencias() throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            ResultSet var = stm.executeQuery("SELECT ocorrencia AS OCORRENCIA FROM ocorrencias ORDER BY 1");
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            while (var.next()) {
                
                Ocorrencia o = new Ocorrencia();
                o.setOcorrencias(var.getString(1));
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
    
    public ArrayList<Ocorrencia> getRegistroOcorrenciaSupervisor(String supervisor, String ocorrencia, String dataInicial,
            String dataFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String query;
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            query = "SELECT diario.uf,diario.atendente,diario.data_att,diario.periodo,tecnicos.nome,diario.setor_gra_area,"
                    + "diario.ocorrencias,diario.recorrencia_sup,diario.recorrencia_coord,diario.recorrencia_gerencia,"
                    + "diario.observacoes,diario.grave,diario.username FROM diario,tecnicos WHERE tecnicos.setor = diario.setor_gra_area "
                    + "AND tecnicos.supervisor ='" + supervisor + "' AND diario.tecnico = tecnicos.MAT AND "
                    + "DATE(diario.data_att) between '" + dataInicial + "' AND '" + dataFinal + "' AND diario.ocorrencias ='" 
                    + ocorrencia + "'";
            
            ResultSet var = stm.executeQuery(query);
            
            while (var.next()) {
                
                Ocorrencia ocorr = new Ocorrencia();
                
                ocorr.setUf(var.getString(1));
                ocorr.setAtendente(var.getString(2));
                ocorr.setData_att(var.getString(3));
                ocorr.setPeriodo(var.getString(4));
                ocorr.setTecnico(var.getString(5));
                ocorr.setSetor_gra_area(var.getString(6));
                ocorr.setOcorrencias(var.getString(7));
                ocorr.setRecorrencia_sup(var.getString(8));
                ocorr.setRecorrencia_coo(var.getString(9));
                ocorr.setReccorencia_ger(var.getString(10));
                ocorr.setObservacoes(var.getString(11));
                ocorr.setGrave(var.getString(12));
                ocorr.setUsername(var.getString(13));
                
                ocorrencias.add(ocorr);
                
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
    
    public ArrayList<Ocorrencia> getRegistroOcorrenciaTecnico(String tecnico, String ocorrencia, String dataInicial,
            String dataFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String query;
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            query = "SELECT diario.uf,diario.atendente,diario.data_att,diario.periodo,tecnicos.nome,diario.setor_gra_area,"
                    + "diario.ocorrencias,diario.recorrencia_sup,diario.recorrencia_coord,diario.recorrencia_gerencia,"
                    + "diario.observacoes,diario.grave,diario.username FROM diario,tecnicos WHERE tecnicos.setor = diario.setor_gra_area AND tecnicos.nome ='"
                    + tecnico + "' AND diario.tecnico = tecnicos.MAT AND DATE(diario.data_att) between '" + dataInicial
                    + "' AND '" + dataFinal + "' AND diario.ocorrencias ='" + ocorrencia + "'";
            
            ResultSet var = stm.executeQuery(query);
            
            while (var.next()) {
                
                Ocorrencia ocorr = new Ocorrencia();
                
                ocorr.setUf(var.getString(1));
                ocorr.setAtendente(var.getString(2));
                ocorr.setData_att(var.getString(3));
                ocorr.setPeriodo(var.getString(4));
                ocorr.setTecnico(var.getString(5));
                ocorr.setSetor_gra_area(var.getString(6));
                ocorr.setOcorrencias(var.getString(7));
                ocorr.setRecorrencia_sup(var.getString(8));
                ocorr.setRecorrencia_coo(var.getString(9));
                ocorr.setReccorencia_ger(var.getString(10));
                ocorr.setObservacoes(var.getString(11));
                ocorr.setGrave(var.getString(12));
                ocorr.setUsername(var.getString(13));
                
                ocorrencias.add(ocorr);
                
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
    
    public ArrayList<Ocorrencia> getRegistroOcorrenciaCoordenador(String coordenador, String ocorrencia, String dataInicial,
            String dataFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String query;
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            query = "SELECT * FROM diario,setores WHERE setores.setor = diario.setor_gra_area AND setores.coordenador ='"
                    + coordenador + "' AND DATE(diario.data_att) between '" + dataInicial
                    + "' AND '" + dataFinal + "' AND diario.ocorrencias ='" + ocorrencia + "'";
            
            ResultSet var = stm.executeQuery(query);
            
            while (var.next()) {
                
                Ocorrencia ocorr = new Ocorrencia();
                
                ocorr.setUf(var.getString(1));
                ocorr.setAtendente(var.getString(2));
                ocorr.setData_att(var.getString(3));
                ocorr.setPeriodo(var.getString(4));
                ocorr.setTecnico(var.getString(5));
                ocorr.setSetor_gra_area(var.getString(6));
                ocorr.setOcorrencias(var.getString(7));
                ocorr.setRecorrencia_sup(var.getString(8));
                ocorr.setRecorrencia_coo(var.getString(9));
                ocorr.setReccorencia_ger(var.getString(10));
                ocorr.setObservacoes(var.getString(11));
                ocorr.setGrave(var.getString(12));
                ocorr.setUsername(var.getString(13));
                
                ocorrencias.add(ocorr);
                
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
    
    public ArrayList<Ocorrencia> getContagemOcorrenciaSetores(String uf, String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String query;
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            query = "SELECT setores.setor,setores.coordenador,count(diario.ocorrencias) as qtdOcorrencias FROM setores,diario "
                    + "WHERE setores.setor = diario.setor_gra_area AND diario.uf='" + uf + "' AND DATE(diario.data_att) "
                    + "BETWEEN '" + dtInicial + "' AND '" + dtFinal + "' GROUP BY 1 ORDER BY 3 DESC";
            
            ResultSet var = stm.executeQuery(query);
            
            while (var.next()) {
                
                Ocorrencia Ocorrencia = new Ocorrencia();
                Ocorrencia.setSetor_gra_area(var.getString(1));
                Ocorrencia.setCoordenador(var.getString(2));
                Ocorrencia.setContagem(var.getString(3));
                ocorrencias.add(Ocorrencia);
                
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
    
    public ArrayList<Ocorrencia> getOcorrenciasSetores(String setor, String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String query;
            ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
            
            query = "SELECT UPPER(DIARIO.ATENDENTE),DIARIO.PERIODO,"
                    + "TECNICOS.NOME AS TECNICO,SETORES.COORDENADOR, DIARIO.OCORRENCIAS,DIARIO.RECORRENCIA_SUP,"
                    + "DIARIO.RECORRENCIA_COORD,DIARIO.RECORRENCIA_GERENCIA,DIARIO.OBSERVACOES,DIARIO.GRAVE"
                    + " FROM diario,setores,tecnicos "
                    + "WHERE diario.setor_gra_area = '" + setor + "' AND setores.setor ='" + setor + "' AND DIARIO.TECNICO = TECNICOS.MAT AND DATE(diario.data_att) "
                    + "BETWEEN '" + dtInicial + "' AND '" + dtFinal + "' ORDER BY 1 DESC";
            
            ResultSet var = stm.executeQuery(query);
            
            while (var.next()) {
                
                Ocorrencia Ocorrencia = new Ocorrencia();
                Ocorrencia.setAtendente(var.getString(1));
                Ocorrencia.setPeriodo(var.getString(2));
                Ocorrencia.setTecnico(var.getString(3));
                Ocorrencia.setCoordenador(var.getString(4));
                Ocorrencia.setOcorrencias(var.getString(5));
                Ocorrencia.setRecorrencia_sup(var.getString(6));
                Ocorrencia.setRecorrencia_coo(var.getString(7));
                Ocorrencia.setReccorencia_ger(var.getString(8));
                Ocorrencia.setObservacoes(var.getString(9));
                Ocorrencia.setGrave(var.getString(10));
                ocorrencias.add(Ocorrencia);
                
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
    
    public int getContagemOcorrenciaSetor(String setor, String dtInicial, String dtFinal) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        Statement stm = null;
        
        try {
            
            conn = Conexao.getConexao();
            stm = conn.createStatement();
            
            String query;
            
            query = "SELECT count(diario.ocorrencias) as qtdOcorrencias FROM diario "
                    + "WHERE diario.setor_gra_area = '" + setor + "' AND DATE(diario.data_att) "
                    + "BETWEEN '" + dtInicial + "' AND '" + dtFinal + "' ORDER BY 1 DESC";
            
            ResultSet var = stm.executeQuery(query);
            int contagem = 0;
            
            while (var.next()) {
                
                contagem = var.getInt(1);
                
            }
            
            return contagem;
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
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
