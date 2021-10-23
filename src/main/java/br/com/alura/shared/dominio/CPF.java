package br.com.alura.shared.dominio;

public class CPF {

    private String numero;

    public CPF(String numero) {
        if (numero == null || !numero.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero;
    }
}
