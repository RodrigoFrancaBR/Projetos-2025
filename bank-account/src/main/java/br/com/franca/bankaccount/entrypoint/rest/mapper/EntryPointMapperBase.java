package br.com.franca.bankaccount.entrypoint.rest.mapper;

/**
 * @param <S> Source
 * @param <T> Target
 */
public interface EntryPointMapperBase<S, T> {

    T toTarget(S source);

    S toSource(T target);
}
