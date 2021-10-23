package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmaiIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmaiIndicacao {
    @Override
    public void enviarPara(Aluno aluno) {
        // logica de envio de email com Java Mail
    }
}
