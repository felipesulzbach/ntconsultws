package br.com.ntconsultws.bean.out;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;

import br.com.ntconsultws.bean.ClienteBean;

public class OutBuscar implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ClienteBean> clienteList;

    public OutBuscar() {
    }

    @XmlElements({ @XmlElement(name = "cliente", type = ClienteBean.class) })
    @XmlElementWrapper(name = "clienteList")
    public List<ClienteBean> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<ClienteBean> clienteList) {
        this.clienteList = clienteList;
    }
}
