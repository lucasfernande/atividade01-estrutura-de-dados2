import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Estoque estoque = new Estoque(5);

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Adicionar produto\n2 - Buscar produto\n3 - Editar produto\n4 - Remover produto\n5 - Mostrar itens do estoque\n6 - Sair\n");
            System.out.print("Digite sua opção: ");
            int opc = Integer.parseInt(scan.nextLine());

            if (opc == 1) {
                System.out.print("Digite o nome do produto: ");
                String nomeProduto = scan.nextLine();
                System.out.print("Digite o código do produto: ");
                int codigoProduto = Integer.parseInt(scan.nextLine());
                System.out.print("Digite o preço do produto: ");
                double precoProduto = Double.parseDouble(scan.nextLine());

                try {
                    estoque.adicionarProduto(new Produto(nomeProduto, codigoProduto, precoProduto));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opc == 2) {
                System.out.print("Digite o código do produto: ");
                int codigoProduto = Integer.parseInt(scan.nextLine());

                try {
                    Produto produto = estoque.buscarProduto(codigoProduto);
                    System.out.println("Produto encontrado! => " + produto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opc == 3) {
                System.out.print("Digite o código do produto: ");
                int codigoProduto = Integer.parseInt(scan.nextLine());

                try {
                    estoque.editarProduto(codigoProduto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opc == 4) {
                System.out.print("Digite o código do produto: ");
                int codigoProduto = Integer.parseInt(scan.nextLine());

                try {
                    System.out.println("Produto removido: " + estoque.removerProduto(codigoProduto));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opc == 5) {
                System.out.println(estoque);
            }
            else if (opc == 6) {
                break;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        scan.close();
    }
}