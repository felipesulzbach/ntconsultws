package br.com.ntconsultws.util;

public enum ValidaEnum {

    SUCESSO("1111"),
    ERRO("0000"),
    ERRO_CRITICO("CR00");

    private final String value;

    ValidaEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}