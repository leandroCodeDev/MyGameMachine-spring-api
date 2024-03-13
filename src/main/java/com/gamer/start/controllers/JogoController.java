package com.gamer.start.controllers;

import com.gamer.start.Dtos.JogadaDTO;
import com.gamer.start.Dtos.JogadorDto;
import com.gamer.start.services.JogadorService;
import com.gamer.start.services.JogoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService,JogadorService jogadorService) {
        this.jogoService = jogoService;
        this.jogoService.setJogadorService(jogadorService);
    }


    @PostMapping
    public String jogar(@RequestBody JogadaDTO dto) throws Exception{
        return jogoService.jogar(dto);
    }


    @GetMapping("/ranking")
    public List<String> getJogadorByNome(){
        return jogoService.getRanking();
    }



}
