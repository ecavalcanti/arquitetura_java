package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.CifradorDeSenha;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorDeSenhaComMD5 implements CifradorDeSenha {
    @Override
    public String cifrarSenha(String senha) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));

            return messageDigest.toString();
        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException("Erro ao gerar hash da senha");
        }
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(this.cifrarSenha(senha));
    }
}
