package br.com.franca.bankaccount.outpoint.database.mapper;

import br.com.franca.bankaccount.core.domain.entity.bankaccount.AccountHolderId;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccountId;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.DomainId;

import java.util.UUID;

/**
 * @param <S> Source
 * @param <T> Target
 */
public interface OutPointMapperBase<S, T> {

    T toTarget(S source);
    // S toSource(T target);
}
