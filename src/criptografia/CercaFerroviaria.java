package criptografia;

public class CercaFerroviaria extends CriptografiaDecorator {
    private int trilhos;

    public CercaFerroviaria(Criptografia componente, int trilhos) {
        super(componente);
        this.trilhos = trilhos;
    }

    @Override
    public String cifrar(String texto) {
        String textoBase = componente.cifrar(texto);
        if (trilhos <= 1) return textoBase;

        StringBuilder[] linhas = new StringBuilder[trilhos];
        for (int i = 0; i < trilhos; i++) {
            linhas[i] = new StringBuilder();
        }

        int trilho = 0;
        boolean descendo = true;

        for (char c : textoBase.toCharArray()) {
            linhas[trilho].append(c);
            if (descendo) {
                trilho++;
                if (trilho == trilhos - 1) descendo = false;
            } else {
                trilho--;
                if (trilho == 0) descendo = true;
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (StringBuilder linha : linhas) {
            resultado.append(linha);
        }

        return resultado.toString();
    }
}
