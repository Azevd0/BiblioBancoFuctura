package menu;

import java.util.Scanner;

import servicos.BiblioService;

public class ItemMenu {
	BiblioService servico = new BiblioService();
	Scanner scan = new Scanner(System.in);
	public void exibirMenu() {
		while (true) {
		    System.out.println("\n--- MENU BIBLIOTECA ---");
		    System.out.println("1 - Cadastrar item\n2 - Remover item\n3 - Listar todos os itens\n4 - Procurar por nome\n5 - Listar itens por autor\n6 - Listar por categoria\n7 - Sair");
		    System.out.print("Escolha: ");

		    int opcao = scan.nextInt();
		    scan.nextLine();

		    switch (opcao) {
		        case 1: servico.newItem(); 
		        	break;
		        case 2: servico.removeItem(); 
		        	break;
		        case 3: servico.findAll();
		        	break;
		        case 4: servico.findByTitulo(); 
		        	break;
		        case 5: servico.listByAutor();
		        	break;
		        case 6: servico.listCategory();
		        	break;
		        case 7: 
		            System.out.println("Biblioteca encerrada.");
		            return; 
		        default:
		            System.out.println("Opção inválida.");
		    	}
			}
		}
	
	}
