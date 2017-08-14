package br.com.ntconsultws.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.ntconsultws.bean.in.InBusca;
import br.com.ntconsultws.bean.in.InRemove;
import br.com.ntconsultws.bean.in.InSalva;
import br.com.ntconsultws.entity.Cliente;

public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String numCpfCnpj;
	private Date dtNascimento;
	private BigDecimal vlrCompra;
	private boolean flgAtivo;

	public ClienteBean() {
	}

	public static synchronized ClienteBean create() {
		return new ClienteBean();
	}

	public static Cliente converterInToEntity(final InBusca in) {
		return Cliente.create().withId(in.getId()).withNome(in.getNome()).withNumCpfCnpj(in.getNumCpfCnpj())
				.withDtNascimento(in.getDtNascimento()).withVlrCompra(in.getVlrCompra())
				.withFlgAtivo(in.getFlgAtivo());
	}

	public static Cliente converterInToEntity(final InRemove in) {
		return Cliente.create().withId(in.getId()).withNome(in.getNome()).withNumCpfCnpj(in.getNumCpfCnpj())
				.withDtNascimento(in.getDtNascimento()).withVlrCompra(in.getVlrCompra())
				.withFlgAtivo(in.getFlgAtivo());
	}

	public static Cliente converterInToEntity(final InSalva in) {
		return Cliente.create().withId(in.getId()).withNome(in.getNome()).withNumCpfCnpj(in.getNumCpfCnpj())
				.withDtNascimento(in.getDtNascimento()).withVlrCompra(in.getVlrCompra())
				.withFlgAtivo(in.getFlgAtivo());
	}

	public Long getId() {
		return id;
	}

	public ClienteBean withId(final Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public ClienteBean withNome(final String nome) {
		this.nome = nome;
		return this;
	}

	public String getNumCpfCnpj() {
		return numCpfCnpj;
	}

	public ClienteBean withNumCpfCnpj(final String numCpfCnpj) {
		this.numCpfCnpj = numCpfCnpj;
		return this;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public ClienteBean withDtNascimento(final Date dtNascimento) {
		this.dtNascimento = dtNascimento;
		return this;
	}

	public BigDecimal getVlrCompra() {
		return vlrCompra;
	}

	public ClienteBean withVlrCompra(final BigDecimal vlrCompra) {
		this.vlrCompra = vlrCompra;
		return this;
	}

	public boolean isFlgAtivo() {
		return flgAtivo;
	}

	public ClienteBean withFlgAtivo(final boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
		return this;
	}
}
