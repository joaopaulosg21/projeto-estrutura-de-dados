package projeto.faculdade.estruturas.listaligada;

public class No<T> {
    private T valor;

    private No<T> proximo;

    public No(T value) {
        this.valor = value;
        this.proximo = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T value) {
        this.valor = value;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> next) {
        this.proximo = next;
    }

    @Override
    public String toString() {
        return "No [valor=" + valor + ", proximo=" + proximo + "]";
    }

}
