package br.com.alura.projetoBuscaFipe.principal;

import br.com.alura.projetoBuscaFipe.model.Dados;
import br.com.alura.projetoBuscaFipe.servicos.ConsumindoApi;
import br.com.alura.projetoBuscaFipe.servicos.ConverterDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner (System.in);
    final String URL_LINK = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumindoApi consumo = new ConsumindoApi();
    private ConverterDados conversor = new ConverterDados();

    public void exibirMenu(){

        var menu = """
                *** OPÇÔES ***
                
                Carro
                Caminhão
                Moto
                
                Digite a sua escolha:
                """;

        System.out.print(menu);
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

        var marcas = conversor.obterLista(json, Dados.class);
        System.out.println("Retorno obtido:");
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);
        System.out.print("/nInforme o código da marca para consulta: ");



    }
}
