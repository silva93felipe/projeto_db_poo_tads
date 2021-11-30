package dominio;

public class Medicamento implements RequisicaoMedica {
	private int quantidade;
	private String validade;
	private String lote;
	
	public Medicamento() { }
	
	public boolean saldo(int idProduto) {
		if(this.quantidade >= 0) {
			return true;
		}
		return false;
	}
	
	public void retirada(int quantidade, int idProduto, String lote) {
		
		if(this.saldo(idProduto)) {
			this.quantidade -= quantidade;
			System.out.println("Requisição " + lote + " realizado com sucesso.");			
		}
	}
	
	public boolean validadeProd(int idProduto) {
		//implementar...
		this.validade = "";
		return true;
	}
	
}
 