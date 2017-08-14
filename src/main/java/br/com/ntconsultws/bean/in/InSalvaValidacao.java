package br.com.ntconsultws.bean.in;

import br.com.ntconsultws.service.exception.ValidadorAbstrato;
import br.com.ntconsultws.util.TextUtil;
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
        if (!TextUtil.isParmetroInformado(this.in.getNome())) {
            adicionarMessage(ValidaEnum.ERRO.getValue(), "O parametro 'Nome' deve ser informado.");
            return false;
        }
        if (!TextUtil.isParmetroInformado(this.in.getNumCpfCnpj())) {
            adicionarMessage(ValidaEnum.ERRO.getValue(), "O parametro 'NumCpfCnpj' deve ser informado.");
            return false;
        } else if (TextUtil.removeNotNumbers(this.in.getNumCpfCnpj()).length() != this.in.getNumCpfCnpj().length()) {
            adicionarMessage(ValidaEnum.ERRO.getValue(), "O parametro 'NumCpfCnpj' deve conter apenas números.");
            return false;
        }
        if (this.in.getFlgAtivo() != null && in.getFlgAtivo().length() > 1) {
            adicionarMessage(ValidaEnum.ERRO.getValue(), "O parametro 'FlAtivo' deve conter 0 = FALSE ou 1 = TRUE.");
            return false;
        }
        return true;
    }
}
