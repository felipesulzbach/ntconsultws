package br.com.ntconsultws.service.exception;

import java.util.List;

import javax.ejb.ApplicationException;

import br.com.ntconsultws.bean.Mensagem;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
@ApplicationException(rollback = true)
public class ValidacaoException extends Exception {

    private static final long serialVersionUID = 1L;

    private Mensagem mensagem;
    private List<Mensagem> mensagens;

    public ValidacaoException(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public ValidacaoException(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }
}
