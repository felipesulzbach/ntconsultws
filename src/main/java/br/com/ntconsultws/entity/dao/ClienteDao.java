package br.com.ntconsultws.entity.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ntconsultws.entity.Cliente;
import br.com.ntconsultws.util.ObjectUtil;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
public class ClienteDao extends BaseDao {

    private static final long serialVersionUID = 1L;

    public ClienteDao() {
    }

    public static synchronized ClienteDao instance() {
        return new ClienteDao();
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> buscar(EntityManager em, Cliente cliente) throws Exception {
        final Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT c.* ");
        sql.append("   FROM cliente c ");
        sql.append("  WHERE 1 = 1     ");
        if (cliente.getId() != null) {
            sql.append(" AND c.id = :id ");
            parametros.put("id", cliente.getId());
        }
        if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
            sql.append(" AND c.nome = :nome ");
            parametros.put("nome", cliente.getNome());
        }
        if (cliente.getNumCpfCnpj() != null && !cliente.getNumCpfCnpj().isEmpty()) {
            sql.append(" AND c.num_cpf_cnpj = :numCpfCnpj ");
            parametros.put("numCpfCnpj", cliente.getNumCpfCnpj());
        }
        if (cliente.getDtNascimento() != null) {
            sql.append(" AND c.dt_nascimento = :dtNascimento ");
            parametros.put("dtNascimento", cliente.getDtNascimento());
        }
        if (cliente.getVlrCompra() != null) {
            sql.append(" AND c.vlr_compra = :vlrCompra ");
            parametros.put("vlrCompra", cliente.getVlrCompra());
        }
        if (cliente.getFlgAtivo() != null && !cliente.getFlgAtivo().isEmpty()) {
            sql.append(" AND c.flgAtivo = :flgAtivo ");
            parametros.put("flgAtivo", cliente.getFlgAtivo());
        }

        final Query query = preencheParametros(em.createNativeQuery(sql.toString()), parametros);
        final List<Object[]> retorno = (List<Object[]>) query.getResultList();

        final List<Cliente> entidadeLista = new ArrayList<Cliente>();
        for (Object[] obj : retorno) {
            int index = 0;
            Cliente entity = new Cliente();
            entity.setId(ObjectUtil.objLongNull(obj[index], null));
            entity.setNome(ObjectUtil.objStringNull(obj[++index], ""));
            entity.setNumCpfCnpj(ObjectUtil.objStringNull(obj[++index], ""));
            entity.setDtNascimento(ObjectUtil.objTimestampNull(obj[++index], null));
            entity.setVlrCompra(ObjectUtil.objBigDecimalNull(obj[++index], null));
            entity.setFlgAtivo(ObjectUtil.objStringNull(obj[++index], ""));
            entidadeLista.add(entity);
        }

        return entidadeLista;
    }

    public Cliente salvar(EntityManager entityManager, Cliente cliente) throws Exception {
        final Cliente clienteNovo = entityManager.merge(cliente);
        entityManager.flush();
        return clienteNovo;
    }

    public void remover(EntityManager entityManager, Cliente cliente) throws Exception {
        entityManager.remove(cliente);
        entityManager.flush();
    }
}
