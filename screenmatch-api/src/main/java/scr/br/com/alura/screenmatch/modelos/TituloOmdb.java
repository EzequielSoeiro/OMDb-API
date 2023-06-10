package scr.br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;



public class TituloOmdb {

	@SerializedName(value = "Title")
	String nome;
	
	@SerializedName(value = "Year")
	String anoLancamento;
	
	@SerializedName(value= "Runtime")
	String duracaoEmMinutos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(String duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
	
	
}
