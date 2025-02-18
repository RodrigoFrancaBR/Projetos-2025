package br.com.franca.bankaccount.outpoint.database.mapper;

/**
 * @param <S> Source
 * @param <T> Target
 */
public interface OutPointMapperBase<S, T> {

    T toTarget(S source);

    S toSource(T target);
}
