package br.com.ntconsultws.bean.in;

import java.io.Serializable;

import br.com.ntconsultws.bean.ClienteBean;

public class InBusca implements Serializable {

    private static final long serialVersionUID = 1L;

    private ClienteBean clienteBean;

    public InBusca() {
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }
}
