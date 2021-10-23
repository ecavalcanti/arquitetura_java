package br.com.alura.academico.infra.aluno;

import br.com.alura.academico.dominio.aluno.Aluno;
import br.com.alura.academico.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.shared.dominio.CPF;
import br.com.alura.academico.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().toString().equals(cpf.toString()))
                .findFirst()
                .orElseThrow(()->new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosMatriculados() {
        return this.matriculados;
    }
}
