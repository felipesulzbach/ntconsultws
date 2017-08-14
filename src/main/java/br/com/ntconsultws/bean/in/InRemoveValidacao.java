package br.com.ntconsultws.bean.in;

import br.com.ntconsultws.service.exception.ValidadorAbstrato;
import br.com.ntconsultws.util.ValidaEnum;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
public class InRemoveValidacao extends ValidadorAbstrato {

	private final InRemove in;

	private InRemoveValidacao(InRemove in) {
		this.in = in;
	}

	public static synchronized InRemoveValidacao create(InRemove in) {
		return new InRemoveValidacao(in);
	}

	@Override
	public boolean isValido() {
		if (this.in.getFlgAtivo() != null && in.getFlgAtivo().length() > 1) {
			adicionarMessage(ValidaEnum.ERRO.getValue(), "O parametro 'FlAtivo' deve conter 0 = FALSE ou 1 = TRUE.");
			return false;
		}
		return true;
	}
}