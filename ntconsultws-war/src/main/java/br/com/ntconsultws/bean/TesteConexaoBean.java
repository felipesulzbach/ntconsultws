package br.com.ntconsultws.bean;

import java.io.Serializable;

public class TesteConexaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String driver;
	private String url;
	private String user;
	private String senha;

	private TesteConexaoBean() {
	}

	public static synchronized TesteConexaoBean create() {
		return new TesteConexaoBean();
	}

	public String getDriver() {
		return driver;
	}

	public TesteConexaoBean withDriver(final String driver) {
		this.driver = driver;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public TesteConexaoBean withUrl(final String url) {
		this.url = url;
		return this;
	}

	public String getUser() {
		return user;
	}

	public TesteConexaoBean withUser(final String user) {
		this.user = user;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public TesteConexaoBean withSenha(final String senha) {
		this.senha = senha;
		return this;
	}
}
