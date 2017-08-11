package br.com.ntconsultws.service.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.ntconsultws.bean.Mensagem;

public abstract class ValidadorAbstrato implements Validador {

    private List<Mensagem> mensagens;
    private static final String NOT_MESSAGE_BUNDLE = "#";

    public ValidadorAbstrato() {
    }

    @Override
    public void validar() throws ValidacaoException {
        if (!isValido()) {
            throw new ValidacaoException(getMensagens());
        }
    }

    @Override
    public abstract boolean isValido();

    @Override
    public Mensagem getMensagem() {
        if (this.mensagens != null && !this.mensagens.isEmpty()) {
            return this.mensagens.get(0);
        }
        return null;
    }

    @Override
    public List<Mensagem> getMensagens() {
        if (this.mensagens == null) {
            this.mensagens = new ArrayList<Mensagem>();
        }
        return this.mensagens;
    }

    @Override
    public void adicionarMessage(String chave, String valor, String... args) {
        this.getMensagens().add(Mensagem.create().withCod(chave).withDesc(valor).withCompl(retornarArgs(args)));
    }

    protected String converterArgumentoNotMessageBundle(String argumento) {
        if (argumento != null) {
            argumento = NOT_MESSAGE_BUNDLE + argumento;
        }
        return argumento;
    }

    private String retornarArgs(String... args) {
        if (args != null) {
            return Arrays.toString(args).replaceAll("\\[|\\]|\\,", "");
        }
        return null;
    }
}
