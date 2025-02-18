package br.com.franca.bankaccount.core.ports.in;

import br.com.franca.bankaccount.core.domain.entity.BankAccount;

import java.math.BigDecimal;

// ports são os gateways

public interface IBankAccountCorePort {

    void createAccountCore(BankAccount domain);

    void withdrawal(Long id, BigDecimal amount);
}
