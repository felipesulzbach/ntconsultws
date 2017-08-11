package br.com.ntconsultws.bean.in;

import br.com.ntconsultws.bean.ClienteBean;
import br.com.ntconsultws.service.exception.ValidadorAbstrato;
import br.com.ntconsultws.util.ValidaEnum;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
public class InSalvaValidacao extends ValidadorAbstrato {

    private final InSalva in;

    private InSalvaValidacao(InSalva in) {
        this.in = in;
    }

    public static synchronized InSalvaValidacao create(InSalva in) {
        return new InSalvaValidacao(in);
    }

    @Override
    public boolean isValido() {
        final ClienteBean bean = this.in.getClienteBean();
        if (bean.getNome() == null || bean.getNome().isEmpty()) {
            adicionarMessage(ValidaEnum.ERRO.getValue(), "O parametro 'Nome' deve ser informado.");
            return false;
        }
        if (bean.getNumCpfCnpj() == null || bean.getNumCpfCnpj().isEmpty()) {
            adicionarMessage(ValidaEnum.ERRO.getValue(), "O parametro 'NumCpfCnpj' deve ser informado.");
            return false;
        }
        return true;
    }
}
