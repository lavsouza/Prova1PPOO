package criptografia;

public class CifraDeCesa extends CriptografiaDecorator {
    private int deslocamento;

    public CifraDeCesa(Criptografia componente, int delocamento) {
        super(componente);
        this.deslocamento = delocamento;
    }

    @Override
    public String cifrar(String texto) {
        String textoBase = componente.cifrar(texto);
        StringBuilder resultado = new StringBuilder();

        for (char c : textoBase.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                resultado.append((char) ((c - base + deslocamento + 26) % 26 + base));
            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
}
