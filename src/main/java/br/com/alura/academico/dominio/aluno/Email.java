package br.com.alura.academico.dominio.aluno;

public class Email {

    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return endereco;
    }
}
