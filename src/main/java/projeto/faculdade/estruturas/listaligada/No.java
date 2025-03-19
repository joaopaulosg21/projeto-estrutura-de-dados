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
        StringBuilder result = new StringBuilder("");
        No<T> atual = this;
        while (atual != null) {
            result.append(atual.valor).append(",");
            atual = atual.proximo;
        }

        return result.toString().substring(0,result.length()-1);
    }

}
