package br.com.alura.gameficacao.infra.selo;

import br.com.alura.shared.dominio.CPF;
import br.com.alura.gameficacao.dominio.selo.Selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements br.com.alura.gameficacao.dominio.selo.RepositorioDeSelos {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDosAlunosDeCPF(CPF cpf) {
        return this.selos.stream().filter(selo -> selo.getCpfDoAluno().equals(cpf))
                .collect(Collectors.toList());
    }
}
