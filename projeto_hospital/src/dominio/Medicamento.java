package dominio;

public class Medicamento implements RequisicaoMedica {
	private int quantidade;
	private String IdProduto;
	private String descricaProduto;
	
	public Medicamento() {}
	
	public Medicamento( int quantidade, String IdProduto, String descricaProduto) {
		this.IdProduto = IdProduto;
		this.quantidade = quantidade;
		this.descricaProduto =  descricaProduto;
	}
	
	public String getIdProduto() {
		return this.IdProduto;
	}

	public void setIdProduto(String idProduto) {
		this.IdProduto = idProduto;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricaProduto() {
		return this.descricaProduto;
	}

	public void setDescricaProduto(String descricaProduto) {
		this.descricaProduto = descricaProduto;
	}

	public void retirada(int quantidade, String idProduto) {
		if(this.quantidade - quantidade <= 0) {
			System.out.println(this.descricaProduto + " nao tem saldo.");
		}else {
			this.quantidade -= quantidade;
			System.out.println("Retirada de " + quantidade + " do produto " +  this.descricaProduto + " realizada.");			
		}
				
	}
	
}
 