/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ntconsultws.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.ntconsultws.bean.ClienteBean;
import br.com.ntconsultws.entity.Cliente;

/**
 *
 * @author felipe.sulzbach
 */
public class ConverterClienteBean implements Converter<Cliente, ClienteBean> {

    private ConverterClienteBean() {
    }

    public static ConverterClienteBean create() {
        return new ConverterClienteBean();
    }

    @Override
    public ClienteBean converter(Cliente in) {
        if (in == null) {
            return null;
        }
        return ClienteBean.create().withId(in.getId()).withNome(in.getNome()).withNumCpfCnpj(in.getNumCpfCnpj())
                .withDtNascimento(in.getDtNascimento()).withVlrCompra(in.getVlrCompra())
                .withFlgAtivo("1".equals(in.getFlgAtivo()) ? true : false);
    }

    @Override
    public List<ClienteBean> converter(List<Cliente> inList) {
        if (inList == null) {
            return null;
        }

        List<ClienteBean> outList = new ArrayList<ClienteBean>();
        inList.forEach(in -> outList.add(converter(in)));
        return outList;
    }

}
