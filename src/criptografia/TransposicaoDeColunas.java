package criptografia;

import java.util.*;

public class TransposicaoDeColunas extends CriptografiaDecorator {
    private String chave;

    public TransposicaoDeColunas(Criptografia componente, String chave) {
        super(componente);
        this.chave = chave.toUpperCase();
    }

    @Override
    public String cifrar(String texto) {
        String textoBase = componente.cifrar(texto).replaceAll("\\s+", "");
        int colunas = chave.length();
        int linhas = (int) Math.ceil((double) textoBase.length() / colunas);

        char[][] matriz = new char[linhas][colunas];
        int k = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (k < textoBase.length()) {
                    matriz[i][j] = textoBase.charAt(k++);
                } else {
                    matriz[i][j] = '.';
                }
            }
        }

        List<ColunaOrdenada> colunasOrdenadas = new ArrayList<>();
        for (int i = 0; i < colunas; i++) {
            colunasOrdenadas.add(new ColunaOrdenada(i, chave.charAt(i)));
        }
        colunasOrdenadas.sort(Comparator.comparing(c -> c.letra));

        StringBuilder resultado = new StringBuilder();
        for (ColunaOrdenada coluna : colunasOrdenadas) {
            int col = coluna.indice;
            for (int i = 0; i < linhas; i++) {
                resultado.append(matriz[i][col]);
            }
        }

        return resultado.toString();
    }

    private static class ColunaOrdenada {
        int indice;
        char letra;

        public ColunaOrdenada(int indice, char letra) {
            this.indice = indice;
            this.letra = letra;
        }
    }
}
