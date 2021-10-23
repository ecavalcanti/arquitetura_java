package br.com.alura.aluno.dominio;

import br.com.alura.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {
    @Test
    void naoDeveriaCriarTelefonesComDDDENumerosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "992322322"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("81", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "992322322"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("81", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "992322322"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("81", "99232-2323"));
    }

    @Test
    void deveriaPermitirCriarTelefonesComDDDENumeroValidos() {
        String ddd = "11";
        String numero = "992342382";
        Telefone telefone = new Telefone(ddd, numero);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }
}