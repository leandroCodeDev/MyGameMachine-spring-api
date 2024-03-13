package com.gamer.start;

import com.gamer.start.models.JogadorModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {

		JogadorModel.adicionarJogador(new JogadorModel("jogador 1",5));
		JogadorModel.adicionarJogador(new JogadorModel("jogador 2",8));
		JogadorModel.adicionarJogador(new JogadorModel("jogador 3",9));
		JogadorModel.adicionarJogador(new JogadorModel("jogador 4",5));
		JogadorModel.adicionarJogador(new JogadorModel("jogador 5",2));
		JogadorModel.adicionarJogador(new JogadorModel("jogador 6",3));

		SpringApplication.run(StartApplication.class, args);
	}

}
