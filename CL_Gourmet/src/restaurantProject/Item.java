package restaurantProject;
import java.math.BigDecimal;

public class Item {
	private String nomeProduto;
	private BigDecimal precoProduto;
	
	
	
	public Item(String nomeProduto, BigDecimal precoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }
	
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}
	
	

}
