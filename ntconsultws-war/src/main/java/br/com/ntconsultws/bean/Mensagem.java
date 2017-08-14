package br.com.ntconsultws.bean;

import java.io.Serializable;

/**
 * 
 * @author Felipe Sulzbach
 *
 */
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cod;
    private String desc;
    private String compl;

    public Mensagem() {
    }

    public static synchronized Mensagem create() {
        return new Mensagem();
    }

    public String getCod() {
        return cod;
    }

    public Mensagem withCod(final String cod) {
        this.cod = cod;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Mensagem withDesc(final String desc) {
        this.desc = desc;
        return this;
    }

    public String getCompl() {
        return compl;
    }

    public Mensagem withCompl(final String compl) {
        this.compl = compl;
        return this;
    }
}
