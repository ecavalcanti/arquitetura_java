package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNOS VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf().toString());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONES VALUES (?, ?)";
            ps = connection.prepareStatement(sql);

            for (Telefone telefone: aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            String sql = "SELECT id, nome, email FROM ALUNOS WHERE cpf = ?";
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.toString());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }
            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONES WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String ddd = rs.getString("ddd");
                String numero = rs.getString("numero");
                encontrado.adicionarTelefone(ddd, numero);
            }

            return encontrado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosMatriculados() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNOS";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                psTelefone.setLong(1, id);
                ResultSet rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    String ddd = rs.getString("ddd");
                    String numero = rs.getString("numero");
                    aluno.adicionarTelefone(ddd, numero);
                }
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
