package scr.br.com.alura.screenmatch.requisicao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import scr.br.com.alura.screenmatch.modelos.TituloOmdb;


public class requisicaoApi {

	public String busca;
	
	public requisicaoApi(String busca) {
		this.busca=busca;
	}

	public TituloOmdb realizaRequisicao(Gson gson) {

		try {
			//url da api com o parametro de busca + minha apikey 
			String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=46940921";
			
			//request e response 
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			//print do corpo do reposte(json)
			System.out.println(response.body());

			//conversao do json pra um objeto do tipo TituloOmdb
			TituloOmdb meuTitulo = gson.fromJson(response.body(), TituloOmdb.class);
			
			return meuTitulo;
			
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return null;
	}
}
