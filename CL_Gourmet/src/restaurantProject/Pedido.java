package restaurantProject;
import java.util.ArrayList;
import java.math.BigDecimal;



public class Pedido {
	private String nomeCliente;
	private int numeroPedido;
	private ArrayList<Item> listaItens;
	
	
	
	 public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public int getNumeroPedido() {
		return numeroPedido;
	}


	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}


	public ArrayList<Item> getListaItens() {
		return listaItens;
	}


	public void setListaItens(ArrayList<Item> listaItens) {
		this.listaItens = listaItens;
	}

	
	

	public Pedido(int numero, String nomeCliente) {
	        this.numeroPedido = numero;
	        this.nomeCliente = nomeCliente;
	        this.listaItens = new ArrayList<>();
	    }

	 
	 public void adicionarItem(Item item) {
	        this.listaItens.add(item);
	    }
	 
	 
	 public BigDecimal calcularTotal() {
	        BigDecimal total = BigDecimal.ZERO;
	        for (Item item : listaItens) {
	            total = total.add(item.getPrecoProduto());
	        }
	        return total;
	    }
}
