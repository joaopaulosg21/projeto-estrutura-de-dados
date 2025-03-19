package projeto.faculdade;

import projeto.faculdade.estruturas.listaligada.ListaLigada;

public class Palavra {
    private String palavra;

    private ListaLigada<Integer> ocorrencias;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.ocorrencias = new ListaLigada<>();
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public ListaLigada<Integer> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(ListaLigada<Integer> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Palavra outraPalavra = (Palavra) obj;
        if (palavra == null) {
            if (outraPalavra.palavra != null)
                return false;
        } else if (!palavra.equalsIgnoreCase(outraPalavra.palavra))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.palavra + " " + this.ocorrencias;
    }
}
