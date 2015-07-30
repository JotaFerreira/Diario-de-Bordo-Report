package br.com.diariodebordo.model.vo;

/**
 *
 * @author joao.oliveira
 */
public class Ocorrencia {

    private String uf;
    private String atendente;
    private String data_att;
    private String periodo;
    private String tecnico;
    private String setor_gra_area;
    private String ocorrencias;
    private String recorrencia_sup;
    private String recorrencia_coo;
    private String reccorencia_ger;
    private String observacoes;
    private String grave;
    private String username;
    private String contagem;
    private String coordenador;
    private String supervisor;

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getContagem() {
        return contagem;
    }

    public void setContagem(String contagem) {
        this.contagem = contagem;
    }

    public Ocorrencia(String uf, String atendente, String data_att, String periodo, String tecnico, String setor_gra_area, String ocorrencias, String recorrencia_sup, String recorrencia_coo, String reccorencia_ger, String observacoes, String grave, String username) {

        this.uf = uf;
        this.atendente = atendente;
        this.data_att = data_att;
        this.periodo = periodo;
        this.tecnico = tecnico;
        this.setor_gra_area = setor_gra_area;
        this.ocorrencias = ocorrencias;
        this.recorrencia_sup = recorrencia_sup;
        this.recorrencia_coo = recorrencia_coo;
        this.reccorencia_ger = reccorencia_ger;
        this.observacoes = observacoes;
        this.grave = grave;
        this.username = username;

    }

    public Ocorrencia() {

    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getData_att() {
        return data_att;
    }

    public void setData_att(String data_att) {
        this.data_att = data_att;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getSetor_gra_area() {
        return setor_gra_area;
    }

    public void setSetor_gra_area(String setor_gra_area) {
        this.setor_gra_area = setor_gra_area;
    }

    public String getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(String ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public String getRecorrencia_sup() {
        return recorrencia_sup;
    }

    public void setRecorrencia_sup(String recorrencia_sup) {
        this.recorrencia_sup = recorrencia_sup;
    }

    public String getRecorrencia_coo() {
        return recorrencia_coo;
    }

    public void setRecorrencia_coo(String recorrencia_coo) {
        this.recorrencia_coo = recorrencia_coo;
    }

    public String getReccorencia_ger() {
        return reccorencia_ger;
    }

    public void setReccorencia_ger(String reccorencia_ger) {
        this.reccorencia_ger = reccorencia_ger;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getGrave() {
        return grave;
    }

    public void setGrave(String grave) {
        this.grave = grave;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
