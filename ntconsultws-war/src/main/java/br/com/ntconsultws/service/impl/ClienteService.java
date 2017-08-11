package br.com.ntconsultws.service.impl;

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
import br.com.ntconsultws.conversor.ConverterCliente;
import br.com.ntconsultws.conversor.ConverterClienteBean;
import br.com.ntconsultws.entity.dao.ClienteDao;
import br.com.ntconsultws.service.ClienteServiceLocal;
import br.com.ntconsultws.service.exception.ValidacaoException;
import br.com.ntconsultws.util.ValidaEnum;

@WebService(serviceName = "ClienteService", targetNamespace = "http://service.ntconsultws.com.br")
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
            out.setClienteList(ConverterClienteBean.create().converter(ClienteDao.instance().buscar(entityManager,
                    ConverterCliente.create().converter(in.getClienteBean()))));
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

            ClienteDao.instance().salvar(entityManager, ConverterCliente.create().converter(in.getClienteBean()));
            throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.SUCESSO.getValue())
                    .withDesc("Cliente's salvo's com Sucesso!"));
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

            ClienteDao.instance().remover(entityManager, ConverterCliente.create().converter(in.getClienteBean()));
            throw new ValidacaoException(Mensagem.create().withCod(ValidaEnum.SUCESSO.getValue())
                    .withDesc("Cliente's removido's com Sucesso!"));
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