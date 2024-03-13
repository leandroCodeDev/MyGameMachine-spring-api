package com.gamer.start.controllers;

import com.gamer.start.Dtos.JogadorDto;
import com.gamer.start.services.JogadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping("/procurar")
    public JogadorDto getJogadorByNome(@RequestBody JogadorDto dto){
        return jogadorService.getJogadorByNome(dto.getNome());
    }

    @PostMapping
    public JogadorDto create(@RequestBody JogadorDto dto){
     return jogadorService.create(dto);
    }

    @GetMapping("{id}/historico")
    public List<String> getHistorico(@PathVariable Integer id) throws Exception {
        return jogadorService.motrarHistoricoJogador(id);
    }





}
