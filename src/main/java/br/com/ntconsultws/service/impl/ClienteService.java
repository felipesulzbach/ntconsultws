package br.com.ntconsultws.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ntconsultws.bean.Mensagem;
import br.com.ntconsultws.bean.in.InBusca;
import br.com.ntconsultws.bean.in.InBuscaValidacao;
import br.com.ntconsultws.bean.in.InRemove;
import br.com.ntconsultws.bean.in.InRemoveValidacao;
import br.com.ntconsultws.bean.in.InSalva;
import br.com.ntconsultws.bean.in.InSalvaValidacao;
import br.com.ntconsultws.bean.out.OutBuscar;
import br.com.ntconsultws.conversor.ConverterClienteBean;
import br.com.ntconsultws.entity.Cliente;
import br.com.ntconsultws.entity.dao.ClienteDao;
import br.com.ntconsultws.service.ClienteServiceLocal;
import br.com.ntconsultws.service.exception.ValidacaoException;
import br.com.ntconsultws.util.ValidaEnum;

@WebService(serviceName = "ClienteService", targetNamespace = "http://service.ntconsultws.com.br")
@Stateless
public class ClienteService implements ClienteServiceLocal {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteDao.class);

    @PersistenceContext(unitName = "Ntconsult-PU")
    private EntityManager entityManager;

    @Override
    @WebMethod(operationName = "buscar")
    @WebResult(name = "outBuscar")
    public OutBuscar buscar(@WebParam(name = "inBusca") InBusca in) throws ValidacaoException {
        try {
            InBuscaValidacao.create(in).validar();

            final OutBuscar out = new OutBuscar();
            out.setClienteList(ConverterClienteBean.create()
                    .converter(ClienteDao.instance().buscar(this.entityManager, Cliente.converterInToEntity(in))));
            return out;
        } catch (ValidacaoException ex) {
            throw ex;
        } catch (Exception ex) {
            final String msg = ajustarMensagemErro("Erro ao buscar.", ex);
            LOG.error(msg + ex);
            throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.ERRO_CRITICO.getValue()).withDesc(msg));
        }
    }

    @Override
    @WebMethod(operationName = "salvar")
    public void salvar(@WebParam(name = "inSalva") InSalva in) throws ValidacaoException {
        try {
            InSalvaValidacao.create(in).validar();

            final Cliente cliente = ClienteDao.instance().salvar(this.entityManager, Cliente.converterInToEntity(in));
            throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.SUCESSO.getValue())
                    .withDesc("Cliente salvo com Sucesso! " + (cliente != null ? cliente.toString() : "")));
        } catch (ValidacaoException ex) {
            throw ex;
        } catch (Exception ex) {
            final String msg = ajustarMensagemErro("Erro ao salvar.", ex);
            LOG.error(msg + ex);
            throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.ERRO_CRITICO.getValue()).withDesc(msg));
        }
    }

    @Override
    @WebMethod(operationName = "remover")
    public void remover(@WebParam(name = "inRemove") InRemove in) throws ValidacaoException {
        try {
            InRemoveValidacao.create(in).validar();

            final List<Cliente> clienteList = ClienteDao.instance().buscar(this.entityManager,
                    Cliente.converterInToEntity(in));
            if (clienteList != null && !clienteList.isEmpty()) {
                clienteList.forEach(cliente -> {
                    try {
                        ClienteDao.instance().remover(this.entityManager, cliente);
                    } catch (Exception ex) {
                        final String msg = ajustarMensagemErro("Erro ao remover.", ex);
                        LOG.error(msg + ex);
                    }
                });
                throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.SUCESSO.getValue())
                        .withDesc("Cliente's removido's com Sucesso!"));
            } else {
                throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.SUCESSO.getValue())
                        .withDesc("Nenhum Cliente encontrado para remoção!"));
            }
        } catch (ValidacaoException ex) {
            throw ex;
        } catch (Exception ex) {
            final String msg = ajustarMensagemErro("Erro ao remover.", ex);
            LOG.error(msg + ex);
            throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.ERRO_CRITICO.getValue()).withDesc(msg));
        }
    }

    private String ajustarMensagemErro(final String msg, Exception ex) {
        final StringBuilder strb = new StringBuilder();
        strb.append(msg);
        strb.append(" Causa: ");
        strb.append(ex.getCause());
        strb.append(" Mensagem: ");
        strb.append(ex.getMessage());
        return strb.toString();
    }
}
