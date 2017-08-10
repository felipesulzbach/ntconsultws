package br.com.ntconsultws.ejb.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.ntconsultws.bean.Filtro;
import br.com.ntconsultws.ejb.dao.ItemDao;
import br.com.ntconsultws.ejb.dao.TokenDao;
import br.com.ntconsultws.ejb.exception.AutorizacaoException;
import br.com.ntconsultws.ejb.exception.ItemValidador;
import br.com.ntconsultws.in.Filtros;
import br.com.ntconsultws.in.TokenUsuario;
import br.com.ntconsultws.out.Item;
import br.com.ntconsultws.out.ListaItens;

@WebService(serviceName = "EstoqueWS")
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    @WebMethod(operationName = "todosOsItens")
    @WebResult(name = "itens")
    public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
        System.out.println("Chamando todosItens()");
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return new ListaItens(itensResultado);
    }

    @WebMethod(operationName = "CadastrarItem")
    public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
            @WebParam(name = "item") Item item) throws AutorizacaoException {

        if (!new TokenDao().ehValido(token)) {
            throw new AutorizacaoException("Autorizacao falhou");
        }

        System.out.println("Cadastrando " + item + ", " + token);

        new ItemValidador(item).validate();

        this.dao.cadastrar(item);

        return item;
    }
}