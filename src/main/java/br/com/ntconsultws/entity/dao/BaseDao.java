package br.com.ntconsultws.entity.dao;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Query;

public abstract class BaseDao implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Query preencheParametros(final Query query, final Map<String, Object> filtros) {
        final Query queryComFiltros = query;
        if (filtros != null) {
            for (final String parm : filtros.keySet()) {
                queryComFiltros.setParameter(parm, filtros.get(parm));
            }
        }

        return queryComFiltros;
    }
}
