package br.com.alura;

import br.com.alura.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.gameficacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        RepositorioDeSelos repositorioDeSelos = new RepositorioDeSelosEmMemoria();
        publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(repositorioDeSelos));

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicadorDeEventos);
        matricularAluno.executa(new MatricularAlunoDto(nome, cpf, email));
    }
}
