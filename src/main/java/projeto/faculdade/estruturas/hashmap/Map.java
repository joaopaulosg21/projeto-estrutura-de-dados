package projeto.faculdade.estruturas.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class Map<K, V> {
    private V[] table;

    public Map() {
        this.table = (V[]) new Object[1000];
    }

    public void put(K chave, V valor) {
        int hash = this.hash(chave);
        this.table[hash] = valor;
    }

    public V get(K chave) {
        int hash = this.hash(chave);
        return this.table[hash];
    }

    private int hash(K chave) {
        String chaveStr = chave.toString();

        int hash = 0;

        for (char c : chaveStr.toCharArray()) {
            hash += c;
        }

        return hash % 37;
    }

    public List<String[]> values() {
        List<String[]> result = new ArrayList<>();
        Arrays.stream(this.table)
                .filter(i -> i != null)
                .forEach(item -> {
                    result.add((String[]) item);
                });
        return result;
    }

}
