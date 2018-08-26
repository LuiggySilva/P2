package lab05_LuiggySilva;

public class Aposta {
	
	private TipoSeguro tipoSeguro;
	
	public Aposta(String nome, int aposta, String previsao, int seguroValor, int custo) {
		this.tipoSeguro = new ApostaAsseguradaValor(nome, aposta, previsao, seguroValor, custo);
	}
	
	public Aposta(String nome, int aposta, String previsao, double seguroTaxa, int custo) {
		this.tipoSeguro = new ApostaAsseguradaTaxa(nome, aposta, previsao, seguroTaxa, custo);
	}
	
	public void AlteraSeguroValor(int valor) {
		this.tipoSeguro = new ApostaAsseguradaValor(getNome(), getAposta(), getPrevisao(), valor, getCustoSeguro());
	}
	
	public void AlteraSeguroTaxa(double taxa) {
		this.tipoSeguro = new ApostaAsseguradaTaxa(getNome(), getAposta(), getPrevisao(), taxa, getCustoSeguro());
	}
	
	public int getAposta() {
		return this.tipoSeguro.getAposta();
	}
	
	public int getSeguro() {
		return this.tipoSeguro.getSeguro();
	}
	
	public int getCustoSeguro() {
		return this.tipoSeguro.getCustoSeguro();
	}
	
	public String getPrevisao() {
		return this.tipoSeguro.getPrevisao();
	}
	
	public String getNome() {
		return this.tipoSeguro.getNome();
	}
	
	public String toString() {
		return this.tipoSeguro.toString();
	}
}
