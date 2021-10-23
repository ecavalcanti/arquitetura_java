package br.com.alura.academico.dominio.aluno;

import br.com.alura.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeAlunos {
    void matricular(Aluno aluno);
    Aluno buscarPorCPF(CPF cpf);
    List<Aluno> listarTodosMatriculados();
}
