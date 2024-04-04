package br.com.alura.projetoBuscaFipe.principal;

import br.com.alura.projetoBuscaFipe.servicos.ConsumindoApi;

import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner (System.in);
    final String URL_LINK = "https://parallelum.com.br/fipe/api/v1/";
    ConsumindoApi consumo = new ConsumindoApi();

    public void exibirMenu(){

        var menu = """
                *** OPÇÔES ***
                
                Carro
                Caminhão
                Moto
                
                Digite a sua escolha:
                """;

        System.out.println(menu);
        var escolha = sc.nextLine();
        String endereco;

        if(escolha.toLowerCase().contains("carr")){
            endereco = URL_LINK + "carros/marcas";
        }else if(escolha.toLowerCase().contains("camin")) {
            endereco = URL_LINK + "caminhoes/marcas";
        }else{
            endereco = URL_LINK + "motos/marcas";
        }

        var json = consumo.conectandoApi(endereco);
        System.out.println(json);

    }
}
