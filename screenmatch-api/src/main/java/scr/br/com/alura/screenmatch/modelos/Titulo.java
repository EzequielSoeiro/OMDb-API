package scr.br.com.alura.screenmatch.modelos;


public class Titulo implements Comparable<Titulo> {
	

    private String nome;

    private int anoDeLancamento;
	
    private boolean incluidoNoPlano;
    
    private double somaDasAvaliacoes;
    
    private int totalDeAvaliacoes;
    
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTitulo) {
		this.nome=meuTitulo.getNome();
		
		if(meuTitulo.getAnoLancamento().length() > 4)
			meuTitulo.setAnoLancamento(meuTitulo.getAnoLancamento().substring(0,3));
			
		this.anoDeLancamento=Integer.valueOf(meuTitulo.getAnoLancamento());
		
		//se a duração do json vinher como N/A automaticamente é setada como 0 
		if(meuTitulo.getDuracaoEmMinutos().equals("N/A"))
			this.duracaoEmMinutos=0;
		else
			this.duracaoEmMinutos=Integer.valueOf(meuTitulo.getDuracaoEmMinutos().substring(0,3).replace(" ","" ));

	}

	public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

	@Override
	public String toString() {
		return "[nome=" + nome + ", anoDeLancamento=" + anoDeLancamento + ", duracaoEmMinutos="
				+ duracaoEmMinutos + "]";
	}
    
    
}
