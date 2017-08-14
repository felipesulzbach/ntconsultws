package br.com.ntconsultws.bean.out;

import java.io.Serializable;
import java.util.List;

import br.com.ntconsultws.bean.ClienteBean;

public class OutBuscar implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ClienteBean> clienteList;

	public OutBuscar() {
	}

	public List<ClienteBean> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<ClienteBean> clienteList) {
		this.clienteList = clienteList;
	}
}
