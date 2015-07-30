package br.com.diariodebordo.model.vo;

import br.com.diariodebordo.model.vo.Coordenador;

/**
 *
 * @author joao.oliveira
 */
public class Filial {
    
    private String nome;
    private Setor[] setores;
    private Coordenador[] coordenadores;

    public Filial(String nome, Setor[] setores, Coordenador[] coordenadores) {
        this.nome = nome;
        this.setores = setores;
        this.coordenadores = coordenadores;
    }
    
    public Filial() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor[] getSetores() {
        return setores;
    }

    public void setSetores(Setor[] setores) {
        this.setores = setores;
    }

    public Coordenador[] getCoordenadores() {
        return coordenadores;
    }

    public void setCoordenadores(Coordenador[] coordenadores) {
        this.coordenadores = coordenadores;
    }
    
}
