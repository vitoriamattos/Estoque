package estoque;

import java.util.Scanner;
import java.util.ArrayList;

public class Estoque {
	static Scanner sc = new Scanner(System.in);

	static ArrayList<Double> produtoPreco = new ArrayList<Double>();
	static ArrayList<String> produtosDescricao = new ArrayList<String>();
	static int totalEstoque;
	static int opcao, sequenciaIds, i;
	static char opcaoMenu;
	static String produtos;
	static boolean pararAcao;
	static int produtoId[] = new int[10];
	static boolean finalizado = false;
	static int idProdutoAlvo;

	void pularLinhas() {

		System.out.println("");
		System.out.println("*****************");
		System.out.println("");

	}

	static void menuPrincipal() {

		System.out.println("-----------------");
		System.out.println("----BEM-VINDO----");
		System.out.println("-----------------");
		System.out.println("1. Entrada Produto");
		System.out.println("2. Saída Produto");
		System.out.println("3. Consultar Produto");
		System.out.println("0. Finalizar");
		System.out.println("Selecione a opção: ");
		opcao = sc.nextInt();

	}

	static int cadastrar() {

		System.out.println("-----------------");
		System.out.println("----CADASTRAR----");
		System.out.println("-----------------");

		do {
			totalEstoque = totalEstoque + 1;
			sequenciaIds = sequenciaIds + 1;

			if (totalEstoque > 10) {
				System.out.println("ESTOQUE CHEIO.");
				System.out.println("Adição de produto indisponível.");
				System.out.println("");

				pararAcao = false;
			} else {
				produtoId[totalEstoque] = totalEstoque;
				System.out.println("Nome do produto: ");
				produtos = sc.next();
				System.out.println("Valor do produto: ");
				double preco = sc.nextDouble();

				System.out.println("Produto adicionado com ID: " + totalEstoque);

				produtosDescricao.add(produtos);
				produtoPreco.add(preco);

				System.out.println("");
			}
			System.out.println("Deseja cadastrar novo produto [S/N]? ");
			opcaoMenu = sc.next().charAt(0);
		} while (opcaoMenu == 'S' | opcaoMenu == 's');

		return 0;
	}

	static int excluir() {

		System.out.println("-----------------");
		System.out.println("-----EXCLUIR-----");
		System.out.println("-----------------");

		System.out.println("Informe o ID do produto: ");
		idProdutoAlvo = sc.nextInt();

			int tamanhoString = produtosDescricao.get(idProdutoAlvo - 1).toString().length();

			if (tamanhoString > 0) {
				totalEstoque = totalEstoque - 1;
				produtosDescricao.remove(idProdutoAlvo);
				produtoPreco.remove(idProdutoAlvo);
			}
		}
		return 0;
	}

	static int consultar() {

		System.out.println("-----------------");
		System.out.println("----CONSULTAR----");
		System.out.println("-----------------");

		for (int i = 0; i < totalEstoque; i++) {
			System.out.println("Produto: " + (produtosDescricao.get(i)));
		}
		System.out.println("Deseja voltar ao menu inicial? [S/N]? ");
		opcaoMenu = sc.next().charAt(0);
		while (opcaoMenu == 'S' || opcaoMenu == 's') {
			break;
		}
		if (opcaoMenu == 'N' || opcaoMenu == 'n') {
			finalizado = false;
			System.out.println("Sistema encerrado.");

		}

		return 0;
	}

	public static void main(String[] args) {
		Estoque estoque = new Estoque();

		totalEstoque = 0;
		sequenciaIds = 0;

		while (finalizado == false) {
			menuPrincipal();

			switch (opcao) {
			case 1:
				cadastrar();
				break;

			case 2:
				excluir();
				break;
			case 3:
				consultar();
				break;
			case 0:
				finalizado = true;
				break;
			default:
				System.out.println("Opção inválida");
			}
		}
		sc.close();
	}

}
