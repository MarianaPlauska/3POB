package crud;

import java.util.*;
import java.util.ArrayList;


public class Aplicacao {

   public void IncluirProd() {
       Scanner sc = new Scanner(System.in);

       int id;
       String codBarras, descricao, sku, nome, categoria, fabricante;
       double preco, peso;
       
       //Pegando dados:
       System.out.println("Diga o ID do produto:");
       id = sc.nextInt();
       sc.nextLine();

       System.out.println("Código de barras do produto:");
       codBarras = sc.nextLine();

       System.out.println("Informe o SKU do produto:");
       sku = sc.nextLine();

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

       Produto produto = new Produto(id, codBarras, sku, nome, descricao, categoria, preco, peso, fabricante);

       produto.add(produto);

       System.out.println("Produto adicionado com sucesso!");
       
       sc.close();
   }

   
public void AlterarProd() {
       Scanner sc = new Scanner(System.in);
       
       int id;
       String codBarras, descricao, sku, nome, categoria, fabricante;
       double preco, peso;
       
       System.out.println("Informe o ID do produto que deseja alterar:");
       id = sc.nextInt();
      
       
      

       System.out.println("Produto alterado com sucesso!");
       
      
   }

   public void excluirProd() {
       Scanner sc = new Scanner(System.in);

       int id;
       
       System.out.println("Informe o ID do produto que deseja excluir:");
       id = sc.nextInt();
       
      

       System.out.println("Produto excluído com sucesso!");
   }
   
   
   public void listarProduto() {
       Scanner scanner = new Scanner(System.in);
      

   }
   public static void main(String[] args) {
	   ArrayList<Produto> lproduto = new ArrayList();
	   
       Aplicacao aplicacao = new Aplicacao();
       Scanner sc = new Scanner(System.in);

       while (true) 
       {
    	   System.out.println("==Menu==");
           System.out.println("Selecione uma opção:");
           System.out.println("1 - Incluir produto");
           System.out.println("2 - Alterar produto");
           System.out.println("3 - Excluir produto");
           System.out.println("0 - Sair");

           int opcao = sc.nextInt();
           sc.nextLine();

           switch (opcao) {
               case 1:
                   aplicacao.IncluirProd();
                   break;
               case 2:
                   aplicacao.AlterarProd();
                   break;
               case 3:
                   aplicacao.excluirProd();
                   break;
               
               default:
                   System.out.println("Essa opção não condiz com o menu");
                   break;
           }
       }
   }
}

