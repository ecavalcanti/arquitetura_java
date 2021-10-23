package br.com.alura.gameficacao.aplicacao;

import br.com.alura.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.gameficacao.dominio.selo.Selo;
import br.com.alura.shared.dominio.CPF;
import br.com.alura.shared.dominio.evento.Evento;
import br.com.alura.shared.dominio.evento.Ouvinte;
import br.com.alura.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {
    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "Novato");
        repositorioDeSelos.adicionar(novato);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
