package projeto_hospital;

public interface Produto {
	void retirada(int quantidade, int idProduto, String lote);
	
	boolean saldo(int idProduto);
	
	boolean validadeProd(int idProduto);
		
}
