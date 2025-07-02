package criptografia;

public class MensagemSimples implements Criptografia {
    @Override
    public String cifrar(String texto) {
        return texto;
    }
}
