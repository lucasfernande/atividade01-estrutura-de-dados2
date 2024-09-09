import java.util.Scanner;

public class Estoque {
    private Object[] produtos;
    private int tamanho;

    public Estoque(int capacidade) {
        this.produtos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adicionarProduto(Object produto) throws Exception {
        if (codigoJaExiste(((Produto) produto).getCodigo())) {
            throw new Exception("Já existe um produto com esse código!");
        }

        this.aumentaCapacidade();
        if (this.tamanho < this.produtos.length) {
            this.produtos[this.tamanho] = produto;
            this.tamanho++;
        } else {
            throw new Exception("O estoque já está cheio, não é possível adicionar novos produtos");
        }
    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.produtos.length) {
            Object[] novoVetor = new Object[this.produtos.length * 2];

            for (int i = 0; i < this.produtos.length; i++) {
                novoVetor[i] = this.produtos[i];
            }
            this.produtos = novoVetor;
        }
    }

    public boolean codigoJaExiste(int codigo) {
        for (int i = 0; i < this.tamanho; i++) {
            if (((Produto) this.produtos[i]).getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Produto buscarProduto(int codigo) throws Exception {
        for (int i = 0; i < this.tamanho; i++) {
            Produto produto = (Produto) this.produtos[i];
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        throw new Exception("Não existe um produto com esse código no estoque!");
    }

    public void editarProduto(int codigo) throws Exception {
        Produto produto = this.buscarProduto(codigo);
        System.out.println("Produto encontrado! => " + produto);

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scan.nextLine();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = Double.parseDouble(scan.nextLine());

        produto.setNome(nomeProduto);
        produto.setPreco(precoProduto);
    }

    public Produto removerProduto(int codigo) throws Exception {
        Produto produtoRemovido = buscarProduto(codigo);
        int pos = indiceProduto(produtoRemovido);

        if (pos >= 0 && pos < this.tamanho) {
            for (int i = pos; i < this.tamanho - 1; i++) {
                this.produtos[i] = this.produtos[i + 1];
            }
            this.tamanho--;
            this.produtos[tamanho] = null;
        } else {
            throw new Exception("Posição inválida");
        }

        return produtoRemovido;
    }

    public int indiceProduto(Object produto) {
        int pos;
        for (pos = 0; pos < tamanho; pos++) {
            if (produtos[pos].equals(produto)) {
                break;
            }
        }
        return pos;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[\n");

        for (int i = 0; i < this.tamanho; i++) {
            s.append(this.produtos[i]);
            s.append("\n");
        }

        s.append("]");

        return s.toString();
    }
}
