package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {
    @Override
    protected void reageAo(Evento evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("DD/MM/yyyy HH:mm"));
        System.out.println(
                String.format("Aluno com CPF %s matriculado em: %s",
                        ((AlunoMatriculado) evento).getCpfDoAluno(), momentoFormatado)
        );
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
