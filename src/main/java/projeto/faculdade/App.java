package projeto.faculdade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import projeto.faculdade.estruturas.hashmap.Map;
import projeto.faculdade.estruturas.listaligada.ListaLigada;

public class App {
    public static void main(String[] args) throws Exception {
        Map<Character, ListaLigada<Palavra>> indiceGeral = new Map<>();

        BufferedReader br = new BufferedReader(
                new FileReader(new File("src/main/java/projeto/faculdade/static/texto.txt")));

        int contadorLinha = 1;

        Map<Integer, String[]> linhas = new Map<>();

        while (br.ready()) {
            String line = br.readLine();
            String[] words = line.split("[,.\\s]+");
            Arrays.stream(words)
                    .map(c -> c.toLowerCase().charAt(0))
                    .forEach(c -> {
                        indiceGeral.put(c, null);
                    });
            linhas.put(contadorLinha, words);
            contadorLinha++;
        }

        br.close();

        contadorLinha = 1;

        for (String[] linha : linhas.values()) {
            for (String str : linha) {
                char firstChar = str.toLowerCase().charAt(0);
                Palavra palavra = new Palavra(str);

                if (indiceGeral.get(firstChar) == null) {
                    palavra.getOcorrencias().add(contadorLinha);
                    ListaLigada<Palavra> linkedList = new ListaLigada<>();
                    linkedList.add(palavra);
                    indiceGeral.put(firstChar, linkedList);
                } else {
                    ListaLigada<Palavra> indicePalavras = indiceGeral.get(firstChar);
                    if (!indicePalavras.contains(palavra)) {
                        palavra.getOcorrencias().add(contadorLinha);
                        indicePalavras.add(palavra);
                    } else {
                        Palavra p = indicePalavras.buscar(palavra);
                        p.getOcorrencias().add(contadorLinha);
                    }
                }
            }
            contadorLinha++;
        }

        br = new BufferedReader(new FileReader("src/main/java/projeto/faculdade/static/entrada.txt"));
        ListaLigada<Palavra> indiceRemissivo = new ListaLigada<>();

        while (br.ready()) {
            String[] line = br.readLine().split("[,.\\s]+");

            for (String word : line) {
                char first = word.toLowerCase().charAt(0);

                Palavra p = indiceGeral.get(first).buscar(new Palavra(word));
                indiceRemissivo.add(p);
            }
        }
        br.close();

        System.out.println(indiceRemissivo);
    }
}
