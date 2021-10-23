package br.com.alura.aluno.dominio;

import br.com.alura.escola.dominio.aluno.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {
    @Test
    void naoDeveriaCriarCPFsComNumerosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("cpfinvalido"));
    }

    @Test
    void devePermitirCriarCPFsComNumerosValidos() {
        String numero = "478.058.900-21";
        CPF cpf = new CPF(numero);
        assertEquals(numero, cpf.toString());
    }

}