package br.com.alura.gameficacao.dominio.selo;

import br.com.alura.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeSelos {
    void adicionar(Selo selo);
    List<Selo> selosDosAlunosDeCPF(CPF cpf);
}
