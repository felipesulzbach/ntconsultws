package br.com.ntconsultws.entity.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ntconsultws.entity.Cliente;

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
		if (cliente.getId() == null) {
			sql.append(" AND c.id = :id ");
			parametros.put("id", cliente.getId());
		}
		if (cliente.getNome() == null) {
			sql.append(" AND c.nome = :nome ");
			parametros.put("nome", cliente.getNome());
		}
		if (cliente.getNumCpfCnpj() == null) {
			sql.append(" AND c.num_cpf_cnpj = :numCpfCnpj ");
			parametros.put("numCpfCnpj", cliente.getNumCpfCnpj());
		}
		if (cliente.getDtNascimento() == null) {
			sql.append(" AND c.dt_nascimento = :dtNascimento ");
			parametros.put("dtNascimento", cliente.getDtNascimento());
		}
		if (cliente.getVlrCompra() == null) {
			sql.append(" AND c.vlr_compra = :vlrCompra ");
			parametros.put("vlrCompra", cliente.getVlrCompra());
		}
		if (cliente.getFlgAtivo() == null) {
			sql.append(" AND c.flgAtivo = :flgAtivo ");
			parametros.put("flgAtivo", cliente.getFlgAtivo());
		}

		final Query query = preencheParametros(em.createNativeQuery(sql.toString()), parametros);
		return query.getResultList();
	}

	public void salvar(EntityManager entityManager, Cliente cliente) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
	}

	public void remover(EntityManager entityManager, Cliente cliente) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
	}
}
