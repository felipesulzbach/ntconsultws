package br.com.ntconsultws.conversor;

import java.util.List;

/**
 *
 * @author Felipe Sulzbach
 * @param <E>
 *            Entrada da conversao.
 * @param <T>
 *            Saida da conversao.
 */
public interface Converter<E, T> {

    T converter(E in);

    List<T> converter(List<E> inList);

}
