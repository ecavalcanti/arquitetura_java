package br.com.alura.academico.aplicacao.aluno.matricular;

import br.com.alura.academico.dominio.aluno.Aluno;
import br.com.alura.shared.dominio.CPF;
import br.com.alura.academico.dominio.aluno.Email;

public class MatricularAlunoDto {
    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new CPF(this.cpfAluno), this.nomeAluno, new Email(this.emailAluno));
    }
}
