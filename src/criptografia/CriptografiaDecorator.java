package criptografia;

public abstract class CriptografiaDecorator implements Criptografia {
    protected Criptografia componente;

    public CriptografiaDecorator(Criptografia componente) {
        this.componente = componente;
    }
}
