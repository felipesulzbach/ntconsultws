package br.com.ntconsultws.service;

import javax.ejb.Local;

import br.com.ntconsultws.bean.in.InBusca;
import br.com.ntconsultws.bean.in.InRemove;
import br.com.ntconsultws.bean.in.InSalva;
import br.com.ntconsultws.bean.out.OutBuscar;
import br.com.ntconsultws.service.exception.ValidacaoException;

@Local
public interface ClienteServiceLocal {

    OutBuscar buscar(InBusca in) throws ValidacaoException;

    void salvar(InSalva in) throws ValidacaoException;

    void remover(InRemove in) throws ValidacaoException;
}
