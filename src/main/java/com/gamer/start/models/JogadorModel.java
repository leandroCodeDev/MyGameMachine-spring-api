package com.gamer.start.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JogadorModel {

    private static HashMap<String,JogadorModel> jogadoresModels = new HashMap<>();
    private static Integer contador = 1;
    private Integer id;
    private String nome;
    private int pontuacao;
    private List<String> historicos;

    private static Integer  gerarId(){
        return contador++;
    }

    public JogadorModel(){}


    public JogadorModel(String nome, int pontuacao) {
        this.id = gerarId();
        this.nome = nome;
        this.pontuacao = pontuacao;
        historicos = new ArrayList<>();

    }

    public JogadorModel(String nome) {
        this.id = gerarId();
        this.nome = nome;
        pontuacao = 0;
        historicos = new ArrayList<>();

    }

    public static void adicionarJogador(JogadorModel jogador){
        jogadoresModels.putIfAbsent(jogador.getNome(), jogador);
    }

    public static boolean jaExiste(String nome) {
        return jogadoresModels.containsKey(nome);
    }

    public void registrarVitoria() {
        pontuacao += 1;
    }


    public void registrarDerrota() {
        if (pontuacao >= 1) {
            pontuacao -= 1;
        }
    }


    public void adicionarHistorico(String jogada) {
        historicos.add(jogada);
    }



    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Integer getId() {
        return id;
    }

    public List<String> getHistoricos() {
        return historicos;
    }

    public static JogadorModel getJogadorByID(Integer id) throws Exception {
        for (JogadorModel j: jogadoresModels.values()){
            if(j.id.equals(id)) {
                return j;
            }
        }

        throw new Exception("Jogador invalido");

    }

    public static JogadorModel getJogadorByNome(String nome){
        return jogadoresModels.get(nome);
    }

    public static ArrayList<JogadorModel> getJogadores(){
        return new ArrayList<>(jogadoresModels.values());
    }
}
