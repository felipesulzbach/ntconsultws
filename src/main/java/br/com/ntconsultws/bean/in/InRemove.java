package br.com.ntconsultws.bean.in;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "inRemove")
@XmlAccessorType(XmlAccessType.FIELD)
public class InRemove implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(required = false)
    private Long id;
    @XmlElement(required = false)
    private String nome;
    @XmlElement(required = false)
    private String numCpfCnpj;
    @XmlElement(required = false)
    private Date dtNascimento;
    @XmlElement(required = false)
    private String flgAtivo;

    public InRemove() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(String flgAtivo) {
        this.flgAtivo = flgAtivo;
    }
}
