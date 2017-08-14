package br.com.ntconsultws.bean.in;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "inBusca")
@XmlAccessorType(XmlAccessType.FIELD)
public class InBusca implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(required = false)
	private String nome;
	@XmlElement(required = false)
	private String numCpfCnpj;
	@XmlElement(required = false)
	private Date dtNascimento;
	@XmlElement(required = false)
	private BigDecimal vlrCompra;
	@XmlElement(required = false)
	private String flgAtivo;

	public InBusca() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumCpfCnpj() {
		return numCpfCnpj;
	}

	public void setNumCpfCnpj(String numCpfCnpj) {
		this.numCpfCnpj = numCpfCnpj;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public BigDecimal getVlrCompra() {
		return vlrCompra;
	}

	public void setVlrCompra(BigDecimal vlrCompra) {
		this.vlrCompra = vlrCompra;
	}

	public String getFlgAtivo() {
		return flgAtivo;
	}

	public void setFlgAtivo(String flgAtivo) {
		this.flgAtivo = flgAtivo;
	}
}
