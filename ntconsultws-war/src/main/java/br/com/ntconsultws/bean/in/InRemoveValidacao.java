package br.com.ntconsultws.bean.in;

import br.com.ntconsultws.bean.ClienteBean;
import br.com.ntconsultws.service.exception.ValidadorAbstrato;

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
        final ClienteBean bean = this.in.getClienteBean();
        return true;
    }
}
