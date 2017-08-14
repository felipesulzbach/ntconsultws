package br.com.ntconsultws.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ntconsultws.bean.in.InBusca;
import br.com.ntconsultws.bean.in.InRemove;
import br.com.ntconsultws.bean.in.InSalva;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @Column(name = "DES_NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "NUM_CPF_CNPJ")
    private String numCpfCnpj;

    @Basic(optional = true)
    @Column(name = "DT_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;

    @Basic(optional = true)
    @Column(name = "VLR_COMPRA")
    private BigDecimal vlrCompra;

    @Basic(optional = true)
    @Column(name = "FLG_ATIVO")
    private String flgAtivo;

    public Cliente() {
    }

    public static Cliente converterInToEntity(final InBusca in) {
        return Cliente.create().withNome(in.getNome()).withNumCpfCnpj(in.getNumCpfCnpj())
                .withDtNascimento(in.getDtNascimento()).withVlrCompra(in.getVlrCompra()).withFlgAtivo(in.getFlgAtivo());
    }

    public static Cliente converterInToEntity(final InRemove in) {
        return Cliente.create().withId(in.getId()).withNome(in.getNome()).withNumCpfCnpj(in.getNumCpfCnpj())
                .withDtNascimento(in.getDtNascimento()).withVlrCompra(in.getVlrCompra()).withFlgAtivo(in.getFlgAtivo());
    }

    public static Cliente converterInToEntity(final InSalva in) {
        return Cliente.create().withNome(in.getNome()).withNumCpfCnpj(in.getNumCpfCnpj())
                .withDtNascimento(in.getDtNascimento()).withVlrCompra(in.getVlrCompra()).withFlgAtivo(in.getFlgAtivo());
    }

    public static synchronized Cliente create() {
        return new Cliente();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente withId(final Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente withNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumCpfCnpj() {
        return numCpfCnpj;
    }

    public void setNumCpfCnpj(String numCpfCnpj) {
        this.numCpfCnpj = numCpfCnpj;
    }

    public Cliente withNumCpfCnpj(final String numCpfCnpj) {
        this.numCpfCnpj = numCpfCnpj;
        return this;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Cliente withDtNascimento(final Date dtNascimento) {
        this.dtNascimento = dtNascimento;
        return this;
    }

    public BigDecimal getVlrCompra() {
        return vlrCompra;
    }

    public void setVlrCompra(BigDecimal vlrCompra) {
        this.vlrCompra = vlrCompra;
    }

    public Cliente withVlrCompra(final BigDecimal vlrCompra) {
        this.vlrCompra = vlrCompra;
        return this;
    }

    public String getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(String flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

    public Cliente withFlgAtivo(final String flgAtivo) {
        this.flgAtivo = flgAtivo;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((numCpfCnpj == null) ? 0 : numCpfCnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numCpfCnpj == null) {
            if (other.numCpfCnpj != null)
                return false;
        } else if (!numCpfCnpj.equals(other.numCpfCnpj))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder strb = new StringBuilder();
        strb.append("Cliente [");
        strb.append("id=");
        strb.append(id);
        strb.append(", nome=");
        strb.append(nome);
        strb.append(", numCpfCnpj=");
        strb.append(numCpfCnpj);
        strb.append(", dtNascimento=");
        strb.append(dtNascimento);
        strb.append(", vlrCompra=");
        strb.append(vlrCompra);
        strb.append(", flgAtivo=");
        strb.append(flgAtivo);
        strb.append("]");
        return strb.toString();
    }

}
