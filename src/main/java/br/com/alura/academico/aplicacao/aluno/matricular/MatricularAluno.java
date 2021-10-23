package br.com.alura.academico.aplicacao.aluno.matricular;

import br.com.alura.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.academico.dominio.aluno.Aluno;
import br.com.alura.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.academico.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorio;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicadorDeEventos) {
        this.repositorio = repositorio;
        this.publicador = publicadorDeEventos;
    }

    public void executa(MatricularAlunoDto dados) {
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);
        publicador.publicar(new AlunoMatriculado(novo.getCpf()));
    }
}
