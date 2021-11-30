package dominio;

public interface RequisicaoMedica {
	
	void retirada(int quantidade, int idProduto, String lote);
	
	boolean saldo(int idProduto);
	
	boolean validadeProd(int idProduto);
		
}
