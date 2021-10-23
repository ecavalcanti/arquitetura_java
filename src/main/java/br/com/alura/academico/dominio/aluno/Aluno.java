package br.com.alura.academico.dominio.aluno;

import br.com.alura.academico.dominio.exceptions.LimiteException;
import br.com.alura.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        if (telefones.size() == 2) {
            throw new LimiteException("Número máximo de telefones já atingido!");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }

    public CPF getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.toString();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
