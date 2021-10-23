package br.com.alura.academico.infra.indicacao;

import br.com.alura.academico.dominio.aluno.Aluno;
import br.com.alura.academico.aplicacao.indicacao.EnviarEmaiIndicacao;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmaiIndicacao {
    @Override
    public void enviarPara(Aluno aluno) {
        // logica de envio de email com Java Mail
    }
}
