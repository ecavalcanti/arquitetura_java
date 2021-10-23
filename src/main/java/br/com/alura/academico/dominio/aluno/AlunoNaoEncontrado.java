package br.com.alura.academico.dominio.aluno;

import br.com.alura.shared.dominio.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.toString());
    }
}
