package crud;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Aplicacao {
	 private List<Produto> produtos;

	    public Aplicacao() {
	        produtos = new ArrayList<>();
	    }
	    
	    public void IncluirProd() {
	    	Scanner sc = new Scanner(System.in);
	    	
	    	int id;
	    	String nome, descricao, fabricante, codBarras, sku, categoria;
	    	double peso, preco;
	    	
	    	System.out.println("Digite o ID do produto:");
	        id = sc.nextInt();
	        sc.nextLine();
	        
	        System.out.println("Informe o código de barras: ");
	        codBarras = sc.next();
	        sc.nextLine();
	        
	        System.out.println("Informe o SKU do produto:");
	        sku = sc.nextLine();
	        sc.nextLine();
	        
	        System.out.println("Nome do produto:");
	        nome = sc.nextLine();

	        System.out.println("Descrição do produto:");
	        descricao = sc.nextLine();

	        System.out.println("Categoria do produto:");
	        categoria = sc.nextLine();

	        System.out.println("Preço do produto:");
	        preco = sc.nextDouble();
	        sc.nextLine();
	       
	        System.out.println("Peso do produto:");
	        peso = sc.nextDouble();
	        
	        sc.nextLine();
	        System.out.println("Informe o fabricante do produto:");
	        fabricante = sc.nextLine();
	        
	        Produto novoProduto = new Produto(id, codBarras, sku, nome, descricao, categoria,preco, peso, fabricante);
	        produtos.add(novoProduto);
	        System.out.println("Produto incluído com sucesso!");
	        
	        sc.close();
	    }
	    
	    public void AlterarProd() {
	    	
	    Scanner sc = new Scanner(System.in);
	    
	    int id, idAlt;
	       String novoCodBarras, novaDescricao, novoSku, novoNome, novaCategoria, novoFabricante;
	       double novoPreco, novoPeso;
	       
	       System.out.println("Informe o ID do produto que deseja alterar:");
	       idAlt = sc.nextInt();
	       
	       Produto produtoExiste = null;
	       
	       for(Produto produto : produtos)
	       {
	    	   if(produto.getId()==idAlt)
	    	   {
	    		   produtoExiste = produto;
	    				   break;
	    	   }
	       }
	       
	       if (produtoExiste != null)
	       {
	    	   System.out.println("Entre com o novo nome: ");
	    	   novoNome = sc.next();
	    	   
	    	   System.out.println("Entre com o novo código de barras: ");
	    	   novoCodBarras = sc.next();
	    	   
	    	   System.out.println("Entre com o novo sku: ");
	    	   novoSku = sc.next();
	    	   
	    	   System.out.println("Entre com a descrição: ");
	    	   novaDescricao = sc.next();
	    	   
	    	   System.out.println("Entre com a nova categoria: ");
	    	   novaCategoria = sc.next();
	    	   
	    	   System.out.println("Entre com o novo fabricante: ");
	    	   novoFabricante = sc.next();
	    	   
	    	   System.out.println("Entre com o novo preço: ");
	    	   novoPreco = sc.nextDouble();
	    	   sc.next();
	    	   
	    	   System.out.println("Entre com o novo peso: ");
	    	   novoPeso = sc.nextDouble();
	    	   
	    	   Produto novoProduto = new Produto(idAlt, novoCodBarras, novoSku, novoNome,
	    			   novaDescricao, novaCategoria, novoPreco, novoPeso, novoFabricante);
	    	   
	    	   produtos.remove(produtoExiste);
	    	   produtos.add(novoProduto);
	    	   
	    	   System.out.println("Produto alterado!");
	    	   
	       }
	       else
	       {
	    	   System.out.println("Produto não encontrado");
	       }
	       
	    }

	    public void excluirProd() {
	    	Scanner sc = new Scanner(System.in);
	    	
	    	int idExcluir;
	    	
	    	System.out.println("Digite o id do produto que deseja alterar: ");
	    	idExcluir = sc.nextInt();
	    	sc.next();
	    	
	    	Produto produtoExiste = null;
	    	
	    	for(Produto produto : produtos)
	    	{
	    		if(produto.getId() == idExcluir)
	    		{
	    			produtoExiste = produto;
	    			break;
	    		}
	    	}
	    	
	    	if(produtoExiste != null)
	    	{
	    		produtos.remove(produtoExiste);
	    		System.out.println("Produto alterado com sucesso!");
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Produto não encontrado");
	    	}
	    }
	    
	    public void listarTodosProd() {
	    	
	    	if(produtos.isEmpty())
	    	{
	    		System.out.println("Não tem nada aqui");
	    	}
	    	else
	    	{
	    		System.out.println("Lista: ");
	    		
	    		for(Produto produto : produtos)
	    		{
	    			System.out.println("Nome: " + produto.getNome());
	                System.out.println("Descrição: " + produto.getDescricao());
	                System.out.println("Categoria: " + produto.getCategoria());
	                System.out.println("Preço: " + produto.getPreco());
	                System.out.println("Peso: " + produto.getPeso());
	                System.out.println("Fabricante: " + produto.getFabricante());
	    		}
	    	}
	    }
	    
	    public void listarProduto() {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	int idListar;
	    	
	    	System.out.println("Digite o id do produto que deseja listar: ");
	    	idListar = sc.nextInt();
	    	sc.next();
	    	
	    	Produto produtoExiste = null;
	    	for(Produto produto : produtos)
	    	{
	    		if(produto.getId() == idListar)
	    		{
	    			produtoExiste = produto;
	    			break;
	    		}
	    	}
	    	
	    	if (produtoExiste != null)
	    	{
	    		System.out.println("Nome: " + produtoExiste.getNome());
	            System.out.println("Descrição: " + produtoExiste.getDescricao());
	            System.out.println("Categoria: " + produtoExiste.getCategoria());
	            System.out.println("Preço: " + produtoExiste.getPreco());
	            System.out.println("Peso: " + produtoExiste.getPeso());
	            System.out.println("Fabricante: " + produtoExiste.getFabricante());
	            
	    	}
	    	else
	    	{
	    		System.out.println("não tem nada aqui!");
	    	}
	    	
	    }
}
