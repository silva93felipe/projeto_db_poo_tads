package dominio;

public class Medicamento implements RequisicaoMedica {
	private int IdProduto;
	private String IDlote;
	private int quantidade;
	private String descricaProduto;
	
	public Medicamento() {}
	
	public Medicamento( int IdProduto, int quantidade, String descricaProduto) {
		this.IdProduto = IdProduto;
		this.quantidade = quantidade;
		this.descricaProduto =  descricaProduto;
	}
	
	public int getIdProduto() {
		return this.IdProduto;
	}

	public void setIdProduto(int idProduto) {
		this.IdProduto = idProduto;
	}

	public String getIDlote() {
		return this.IDlote;
	}

	public void setIDlote(String iDlote) {
		this.IDlote = iDlote;
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

	public void retirada(int quantidade, int idProduto) {
		if(this.quantidade - quantidade <= 0) {
			System.out.println(this.descricaProduto + " nao tem saldo.");
		}else {
			this.quantidade -= quantidade;
			System.out.println("Retidade de " + quantidade + "do produto " +  this.descricaProduto + " realizada.");			
		}
				
	}
	
}
 