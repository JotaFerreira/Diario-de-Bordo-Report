package br.com.diariodebordo.model.vo;

/**
 *
 * @author joao.oliveira
 */
public class Setor {
    
    private String nome;
    private String uf;
    private String coordenador;

    public Setor(String nome, String uf, String coordenador) {
        this.nome = nome;
        this.uf = uf;
        this.coordenador = coordenador;
    }
    
    public Setor(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }
     
}
