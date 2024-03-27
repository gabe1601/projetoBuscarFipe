package br.com.alura.projetoBuscaFipe;

import br.com.alura.projetoBuscaFipe.servicos.ConsumindoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoBuscaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBuscaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumindoApi consumindoApi = new ConsumindoApi();

		System.out.println(consumindoApi.conectandoApi());

	}
}
