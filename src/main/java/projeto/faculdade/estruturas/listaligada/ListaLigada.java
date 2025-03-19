package projeto.faculdade.estruturas.listaligada;

public class ListaLigada<T> {
    private No<T> inicio;

    private int tamanho;

    private No<T> ultimo;

    /*
     * public void add(T valor) {
     * No<T> no = new No<>(valor);
     * 
     * if (inicio == null) {
     * inicio = no;
     * tamanho++;
     * } else {
     * No<T> curr = inicio;
     * 
     * while (curr.getProximo() != null) {
     * curr = curr.getProximo();
     * }
     * 
     * curr.setProximo(no);
     * tamanho++;
     * }
     * }
     */

    public void add(T valor) {
        No<T> no = new No<>(valor);

        if (inicio == null) {
            inicio = no;
            ultimo = inicio;
            tamanho++;
        } else {
            ultimo.setProximo(no);
            ultimo = no;
            tamanho++;
        }
    }

    public T buscar(T valor) {
        No<T> no = new No<>(valor);

        if (no.getValor().equals(inicio.getValor())) {
            return inicio.getValor();
        }

        No<T> atual = inicio.getProximo();

        while (atual != null) {
            if (no.getValor().equals(atual.getValor())) {
                return atual.getValor();
            }
            atual = atual.getProximo();
        }

        return null;
    }

    public boolean contains(T valor) {
        if(inicio.getValor().equals(valor)) {
            return true;
        }

        No<T> atual = inicio.getProximo();

        while(atual != null) {
            if(atual.getValor().equals(valor)) {
                return true;
            }
            atual = atual.getProximo();
        }

        return false;
    }

    @Override
    public String toString() {
        return "ListaLigada [inicio=" + inicio + "]";
    }
}
