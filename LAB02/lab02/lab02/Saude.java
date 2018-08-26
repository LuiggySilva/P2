package lab02;
/**
* A classe Saude administrao estado de saude do aluno.
* @author Luiggy Silva
**/
public class Saude {
	private String saudeMental = "boa";
	private String saudeFisica = "boa";
   /**
   * retorna o status geral da saude do aluno. 
   **/
	public String getStatusGeral() {
		if(saudeMental.equals("boa") && saudeFisica.equals("boa")) {
			return "boa";
		}
		else if(saudeMental.equals("fraca") && saudeFisica.equals("fraca")){
			return "fraca";
		}
		return "ok";
	}
	
   /**
   * armazena a saude mental do aluno.
   * @param  
   **/
	public void defineSaudeMental(String mental) {
		this.saudeMental = mental;
	}
   /**
   * armazena a saude fisica do aluno.
   * @param 
   **/
	public void defineSaudeFisica(String fisica) {
		this.saudeFisica = fisica;
		
	}

}
