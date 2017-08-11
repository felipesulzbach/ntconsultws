package br.com.ntconsultws.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.ntconsultws.bean.ClienteBean;
import br.com.ntconsultws.entity.Cliente;

/**
 *
 * @author Felipe Sulzbach
 */
public class ConverterCliente implements Converter<ClienteBean, Cliente> {

    private ConverterCliente() {
    }

    public static ConverterCliente create() {
        return new ConverterCliente();
    }

    @Override
    public Cliente converter(ClienteBean in) {
        if (in == null) {
            return null;
        }

        Cliente out = new Cliente();
        out.setId(in.getId());
        out.setNome(in.getNome());
        out.setNumCpfCnpj(in.getNumCpfCnpj());
        out.setDtNascimento(in.getDtNascimento());
        out.setVlrCompra(in.getVlrCompra());
        out.setFlgAtivo(in.isFlgAtivo() == true ? "1" : "0");
        return out;
    }

    @Override
    public List<Cliente> converter(List<ClienteBean> inList) {
        if (inList == null) {
            return null;
        }

        List<Cliente> outList = new ArrayList<Cliente>();
        inList.forEach(in -> outList.add(converter(in)));
        return outList;
    }

}
