package dominio;

public class Medicamento implements RequisicaoMedica {
	private String IDlote;
	private int quantidade;
	private String validade;
	
	public Medicamento( String IDlote, String validade, int quantidade) {
		this.IDlote  = IDlote;
		this.validade = validade;
		this.quantidade = quantidade;
	}
	
	public boolean saldo(int idProduto) {
		if(this.quantidade >= 0) {
			return true;
		}
		return false;
	}
	
	public void retirada(int quantidade, int idProduto, String lote) {	
		this.quantidade -= quantidade;
		System.out.println("Requisição " + lote + " realizado com sucesso.");
				
		/*if(this.saldo(idProduto)) {
			this.quantidade -= quantidade;
			System.out.println("Requisi��o " + lote + " realizado com sucesso.");	
		}*/	
	}
	
	public boolean validadeProd(int idProduto) {
		//implementar...
		this.validade = "";
		return true;
	}
	
}
 