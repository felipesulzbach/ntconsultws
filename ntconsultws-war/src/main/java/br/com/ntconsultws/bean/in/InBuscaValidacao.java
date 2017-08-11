package br.com.ntconsultws.bean.in;

import br.com.ntconsultws.bean.ClienteBean;
import br.com.ntconsultws.service.exception.ValidadorAbstrato;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
public class InBuscaValidacao extends ValidadorAbstrato {

    private final InBusca in;

    private InBuscaValidacao(InBusca in) {
        this.in = in;
    }

    public static synchronized InBuscaValidacao create(InBusca in) {
        return new InBuscaValidacao(in);
    }

    @Override
    public boolean isValido() {
        final ClienteBean bean = this.in.getClienteBean();
        return true;
    }
}
