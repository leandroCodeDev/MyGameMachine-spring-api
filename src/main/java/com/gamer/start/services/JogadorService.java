package com.gamer.start.services;

import com.gamer.start.Dtos.JogadorDto;
import com.gamer.start.models.JogadorModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorService {
    public JogadorDto create(@RequestBody JogadorDto dto){
        if(!JogadorModel.jaExiste(dto.getNome())) {
            JogadorModel jogador = new JogadorModel(dto.getNome());
            JogadorModel.adicionarJogador(jogador);
            BeanUtils.copyProperties(jogador, dto);
            return dto;
        }
        return  null;
    }

    public List<String> motrarHistoricoJogador(Integer id) throws Exception {
        JogadorModel jogador = JogadorModel.getJogadorByID(id);
        if(jogador == null){
            return new ArrayList<>();
        }
        return  jogador.getHistoricos();
    }

    public JogadorDto getJogadorByNome(String nome) {
        JogadorModel jogador = JogadorModel.getJogadorByNome(nome);
        if(jogador == null){
            return null;
        }
        JogadorDto dto = new JogadorDto();
        BeanUtils.copyProperties(jogador,dto);
        return dto;
    }

    public JogadorDto getJogadorById(Integer id) throws Exception {
        JogadorModel jogador = JogadorModel.getJogadorByID(id);
        JogadorDto dto = new JogadorDto();
        BeanUtils.copyProperties(jogador,dto);
        return dto;
    }


    public void registrarVitoria(Integer id)  throws Exception{
        JogadorModel jogador = JogadorModel.getJogadorByID(id);
        jogador.registrarVitoria();
    }

    public void registrarDerrota(Integer id)  throws Exception{
        JogadorModel jogador = JogadorModel.getJogadorByID(id);
        jogador.registrarDerrota();
    }

    public void regitrarHistorico(Integer id, String historico) throws Exception {
        JogadorModel jogador = JogadorModel.getJogadorByID(id);
        jogador.adicionarHistorico(historico);
    }

    public ArrayList<JogadorModel> getallJogadores() {
        return JogadorModel.getJogadores();
    }
}
