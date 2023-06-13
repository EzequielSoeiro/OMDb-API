package scr.br.com.alura.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import scr.br.com.alura.screenmatch.modelos.Titulo;
import scr.br.com.alura.screenmatch.modelos.TituloOmdb;
import scr.br.com.alura.screenmatch.requisicao.requisicaoApi;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
    	
        Scanner leitura = new Scanner(System.in);
        ArrayList<Titulo> titulos = new ArrayList<Titulo>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String busca = "";

        
        for(int i=0; i<5; i++) {
        System.out.println("\nDigite um filme para busca: ");
        busca = leitura.nextLine();
        
        if(busca.equalsIgnoreCase("sair"))
        	break;

        requisicaoApi requisicao = new requisicaoApi(busca);
        TituloOmdb meuTitulo = requisicao.realizaRequisicao(gson);
        Titulo titulo = new Titulo(meuTitulo);
        
        titulos.add(titulo);
  
    } 
        System.out.println(titulos);
        FileWriter arquivoJson = new FileWriter("filmes.json");
        arquivoJson.write(gson.toJson(titulos));
        arquivoJson.close();
  }
}
