package com.gamer.start.Dtos;

import java.util.List;

public class JogadorDto {
    private Integer id;
    private String nome;
    private int pontuacao;
    private List<String> historicos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<String> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<String> historicos) {
        this.historicos = historicos;
    }
}
