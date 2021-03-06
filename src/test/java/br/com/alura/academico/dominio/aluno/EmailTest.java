package br.com.alura.academico.dominio.aluno;

import br.com.alura.academico.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    void deveCriarEmailsComEnderecosValidos() {
        String endereco = "teste@test.com.br";
        Email email = new Email(endereco);
        assertEquals(endereco, email.toString());
    }

}