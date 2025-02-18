package br.com.franca.bankaccount.core.adapters;

import br.com.franca.bankaccount.core.domain.entity.BankAccount;
import br.com.franca.bankaccount.core.ports.in.IBankAccountCorePort;
import br.com.franca.bankaccount.core.ports.out.BankAccountRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankAccountCoreAdapter implements IBankAccountCorePort {
    private final BankAccountRepositoryPort port;

    public BankAccountCoreAdapter(BankAccountRepositoryPort port) {
        this.port = port;
    }

    @Override
    public void createAccountCore(BankAccount domain) {
        try {
            port.updateAccount(domain);
            // auditoria de sucesso
        } catch (Exception e) {
            // auditoria de erro
            throw new RuntimeException(e);
        }
    }

    @Override
    public void withdrawal(Long id, BigDecimal amount) {
        try {
            final var account = port.findAccount(id);
            port.updateAccount(account.withdrawal(amount));
        } catch (Exception e) {
            // auditoria de erro
            throw new RuntimeException(e);
        }
    }
}
