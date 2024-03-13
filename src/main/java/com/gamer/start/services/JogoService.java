package com.gamer.start.services;


import com.gamer.start.Dtos.JogadaDTO;
import com.gamer.start.Dtos.JogadorDto;
import com.gamer.start.models.JogadorModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class JogoService {

    private JogadorService jogadorService;

    public void setJogadorService(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    public String jogar(JogadaDTO dto) throws Exception {
        JogadorDto jogadorDto = jogadorService.getJogadorById(dto.getId());
        Random random = new Random();
        int jogadaComputador = random.nextInt(0, 10);

        int calculaJogada = jogadaComputador + dto.getJogada();

        String resultado = calculaJogada % 2 == 0 ? "par" : "impar";


        String situacao = "";
        if (resultado.equalsIgnoreCase(dto.getEscolha())) {
            jogadorService.registrarVitoria(dto.getId());
            situacao += "Vitória!";
        } else {
            jogadorService.registrarDerrota(dto.getId());
            situacao += "derrota.";
        }
        String historico = montarHistorico(jogadorDto.getNome(), dto.getEscolha(), dto.getJogada(), jogadaComputador, situacao);
        jogadorService.regitrarHistorico(dto.getId(), historico);

        return historico;
    }

    private String montarHistorico(String Jogador, String escolha, Integer jogada, Integer computadorJogada, String situacao) {

        return Jogador + ": " + escolha + "" +
                ", jogou: " + jogada + ", Computador: " + computadorJogada + ", Resultado: " + situacao;
    }

    public List<String> getRanking() {
        ArrayList<JogadorModel> jogadores = jogadorService.getallJogadores();

        ArrayList<JogadorModel> sortedJogadores = jogadores.stream()
                .sorted(Comparator.comparing(JogadorModel::getPontuacao).reversed())
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> ranking = new ArrayList<>();

        for (JogadorModel j : sortedJogadores) {
            ranking.add("Nome: " + j.getNome() + " Pontução: " + j.getPontuacao());
        }

        return ranking;

    }
}
