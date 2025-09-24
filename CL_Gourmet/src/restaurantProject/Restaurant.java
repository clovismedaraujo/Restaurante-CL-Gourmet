package restaurantProject;

import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigDecimal;


public class Restaurant {
	private ArrayList<Pedido> listaPedidos;
	private static int proximoNumeroPedido = 1;
	
	public Restaurant() {
        this.listaPedidos = new ArrayList<>();
    }
	
	
	public void exibirMenu() {
		System.out.println("\n===== Menu dos Pedidos =====");
		System.out.println("1. Registrar Pedido");
		System.out.println("2. Remover Pedido");
		System.out.println("3. Listar Pedidos");
		System.out.println("4. Sair");
		System.out.println("Escolha uma das opções acima:");
	}
	
	public void executarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcao) {
                    case 1:
                        registrarPedido(scanner);
                        break;
                    case 2:
                        removerPedido(scanner);
                        break;
                    case 3:
                        listarPedidos();
                        break;
                    case 4:
                        System.out.println("Obrigado por usar o sistema! Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 4.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcao = 0;
                 
            }
        } while (opcao != 4);
	}
	
	
	
	
	public void exibirRecibo(Pedido pedido) {
		System.out.println("\n========================================"); 
		System.out.println("Restaurante CLgourmet"); 
		System.out.println("========================================"); 
		System.out.println("Pedido N°: " + pedido.getNumeroPedido()); 
		System.out.println("Cliente: " + pedido.getNomeCliente()); 
		System.out.println("----------------------------------------"); 
		System.out.println("Itens:"); 
		
		for (Item item : pedido.getListaItens()) { 
		 
		System.out.println("- " + item.getNomeProduto() + " R$ " + item.getPrecoProduto()); 
		} 
		System.out.println("----------------------------------------"); 
		
		System.out.println("Total: R$ " + pedido.calcularTotal()); 
		System.out.println("========================================"); 
		System.out.println("   Obrigado pela preferência! :)    "); 
		System.out.println("========================================\n"); 
		
	}
	
	
	
	
	public void registrarPedido(Scanner scanner) {
		int numeroPedidoAtual = proximoNumeroPedido;
		System.out.println("\n--- Registrar Novo Pedido ---");
		System.out.println("Digite o nome do cliente:");
		String nomeCliente = scanner.nextLine();
		Pedido novoPedido = new Pedido(numeroPedidoAtual, nomeCliente);
		char continuar;
		do {
			System.out.println("digite o nome do produto:");
			String nomeProduto = scanner.nextLine();
			System.out.println("preco do produto:");
			String precoString = scanner.nextLine();
			BigDecimal precoProduto = new BigDecimal(precoString);
			Item novoItem = new Item(nomeProduto, precoProduto);
			novoPedido.adicionarItem(novoItem);
			System.out.println("Deseja adicionar mais itens?(s/n)");
			continuar = scanner.next().charAt(0);
			scanner.nextLine();
		} while ( continuar == 's');
		this.listaPedidos.add(novoPedido);
		
		exibirRecibo(novoPedido);
		 
		
		proximoNumeroPedido++;
	}
	
	
	
	
	public void removerPedido(Scanner scanner) {
		System.out.println("\n--- Remover Pedido ---");
		System.out.println("Digite o número do pedido que deseja remover:");
		int numeroParaRemover = scanner.nextInt();
		scanner.nextLine(); 
		Pedido pedidoEncontrado = null;
		
		
	    for (Pedido pedido : this.listaPedidos) {
	        
	        if (pedido.getNumeroPedido() == numeroParaRemover) {
	            pedidoEncontrado = pedido; 
	            break; 
	        }
	    }

	    if (pedidoEncontrado != null) {
	   
	        this.listaPedidos.remove(pedidoEncontrado);
	        System.out.println("Pedido " + numeroParaRemover + " removido com sucesso!");
	    } else {
	
	        System.out.println("Pedido com o número " + numeroParaRemover + " não encontrado.");
	      }
	
	}
	
	
	
	public void listarPedidos() {
		for (Pedido pedido : this.listaPedidos) {
			System.out.println("\n========================================"); 
			System.out.println("Restaurante CLgourmet"); 
			System.out.println("========================================"); 
			System.out.println("Pedido N°: " + pedido.getNumeroPedido()); 
			System.out.println("Cliente: " + pedido.getNomeCliente()); 
			System.out.println("----------------------------------------"); 
			System.out.println("Itens:"); 
			
			for (Item item : pedido.getListaItens()) { 
			 
			System.out.println("- " + item.getNomeProduto() + " R$ " + item.getPrecoProduto()); 
			} 
			System.out.println("----------------------------------------"); 
			
			System.out.println("Total: R$ " + pedido.calcularTotal()); 
			System.out.println("========================================"); 
			System.out.println("========================================\n"); 
			
				
		}
		
	}
	
	
	
}
	