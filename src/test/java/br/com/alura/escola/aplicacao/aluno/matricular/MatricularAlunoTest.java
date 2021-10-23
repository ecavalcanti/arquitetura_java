package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.PublicadorDeEventos;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());

        MatricularAluno useCase = new MatricularAluno(repositorio, publicadorDeEventos);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano",
                "123.456.789-00",
                "fulano@email.com.br");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));
        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpf().toString());
        assertEquals("fulano@email.com.br", encontrado.getEmail());


    }
}