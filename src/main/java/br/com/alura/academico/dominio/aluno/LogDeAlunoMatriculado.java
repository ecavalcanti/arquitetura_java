package br.com.alura.academico.dominio.aluno;

import br.com.alura.shared.dominio.evento.Ouvinte;
import br.com.alura.shared.dominio.evento.Evento;
import br.com.alura.shared.dominio.evento.TipoDeEvento;

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
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
