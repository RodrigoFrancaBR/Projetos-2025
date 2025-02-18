package br.com.franca.bankaccount.core.ports.out;

import br.com.franca.bankaccount.core.domain.entity.BankAccount;

public interface BankAccountRepositoryPort {

    void updateAccount(BankAccount domain);

    BankAccount findAccount(Long id);
}
