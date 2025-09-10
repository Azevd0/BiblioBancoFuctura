package servicos;
import java.util.List;
import java.util.Scanner;


import BibliotecaProjeto.Album;
import BibliotecaProjeto.Item;
import BibliotecaProjeto.Livro;
import BibliotecaProjeto.Revista;
import dao.BiblioDao;

public class BiblioService {
	BiblioDao itemdao = new BiblioDao();
	Scanner scan = new Scanner(System.in);
	
	public String lerCampoObrigatorio(String nomeCampo) {
	    String entrada;
	    do { System.out.print("Digite " + nomeCampo + ": ");
	        entrada = scan.nextLine().trim();
	        if (entrada.isEmpty()) {
	            System.out.println(nomeCampo + " é obrigatório. Tente novamente.\n");
	        }
	    } while (entrada.isEmpty());
	    return entrada;
	}
	
	public void newItem() {
		int tipo = -1;
		while (tipo < 1 || tipo > 3) { // equanto tipo for -1
		    System.out.println("Qual tipo de item você quer adicionar?\n1 - Livro\n2 - Álbum musical\n3 - Revista");
		    
		    if (!scan.hasNextInt()) {
		        System.out.println("Digite apenas números válidos (1, 2 ou 3).");
		        scan.next();
		        continue;
		    }
		    
		    tipo = scan.nextInt();//
		    scan.nextLine();
		    
		    if (tipo < 1 || tipo > 3) {
		        System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
		    }
		}

		Item novoItem = null;

		  String titulo = lerCampoObrigatorio("o título");
	        String categoria = lerCampoObrigatorio("a categoria");
	        String autor = lerCampoObrigatorio("o autor");
	        String ano = lerCampoObrigatorio("O ano");
		    if (itemdao.findByName(titulo) != null) { //estou validando aqui se o titulo ja existe 
	            System.out.println("Já existe um item cadastrado com o título \"" + titulo + "\"");
	            return;
	        }
	       
	        
		switch (tipo) {
		case 1:
			novoItem = new Livro(titulo, categoria, autor,ano);
			break;
		case 2:
			novoItem = new Album(titulo, categoria, autor, ano);
			break;
		case 3:
			novoItem = new Revista(titulo, categoria, autor, ano);
			break;
		default:
			System.out.println("Tipo inválido!");
			return;
		}
		Item salvo = itemdao.saveItem(novoItem);
		if(salvo != null) {
			System.out.println("Item cadastrado com sucesso");
		}
			
	}
	public void findAll() {
		List<Item> item = itemdao.listAll();
		if (item.isEmpty()) {
			System.out.println("A lista está vazia");
		}
		else {
			for (int x= 0; x<item.size();x++) {
				System.out.printf("%d° Item \n", x+1);
	            System.out.println(item.get(x).toString());

			}
		}
	}
	public void removeItem() {
		String remover = lerCampoObrigatorio("O titulo do item");
		boolean deletado = itemdao.deleteItem(remover);
		
		if(deletado) {
			System.out.println("Item \"" +remover+ "\" removido com sucesso");
		} else {
			System.out.println("Item \""+ remover+ "\" não encontrado para remoção");
		}
		
	}
	public void listByAutor() {
		System.out.println("Qual autor você procura?");
		String autor= scan.nextLine();
		List<Item> autorLista = itemdao.listByAutor(autor);
		if(autorLista.isEmpty()) {
			System.out.println("Autor não encontrado");
		} else {
			for(int x = 0; x < autorLista.size(); x++) {
				System.out.printf("Item Nº %d:\n", x+1);
				System.out.println(autorLista.get(x).toString());
			}
		}
	}
	public void listCategory() {
		System.out.println("Qual categoria você procura?");
		String cat = scan.nextLine();
		List <Item> catLista = itemdao.listByCategory(cat);
		if(catLista.isEmpty()) {
			System.out.println("Categoria não encontrada");
		} else {
			for(int x = 0; x < catLista.size(); x++) {
				System.out.printf("Item Nº %d:\n", x+1);
			    System.out.println(catLista.get(x).toString());

			}
		}
		
	}
	public void findByTitulo() {
		System.out.println("Qual item você procura");
		String titulo  = scan.nextLine();
		Item achado = itemdao.findByName(titulo );
		if(achado == null) {
			System.out.println("Item \"" +titulo + "\" não foi encontrado");
		} else {
			System.out.println("Encontrado:\n" + achado.toString() );
			}
		
	}
}






