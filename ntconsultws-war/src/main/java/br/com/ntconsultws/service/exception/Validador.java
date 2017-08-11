package br.com.ntconsultws.service.exception;

import java.util.List;

import br.com.ntconsultws.bean.Mensagem;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
public interface Validador {

    public void validar() throws ValidacaoException;

    public boolean isValido();

    public Mensagem getMensagem();

    public List<Mensagem> getMensagens();

    public void adicionarMessage(String chave, String valor, String... args);
}
