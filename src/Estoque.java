public class Estoque {
    private Object[] produtos;
    private int tamanho;

    public Estoque(int capacidade) {
        this.produtos = new Object[capacidade];
        this.tamanho = 0;
    }
}
