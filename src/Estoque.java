public class Estoque {
    private Object[] produtos;
    private int tamanho;

    public Estoque(int capacidade) {
        this.produtos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adicionarProduto(Object produto) throws Exception {
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
