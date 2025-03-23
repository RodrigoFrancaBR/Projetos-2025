package br.com.franca.bankaccount.core.domain.util;

import br.com.franca.bankaccount.core.domain.entity.bankaccount.AccountHolderId;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccount;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccountId;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.TransactionId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BankAccountFactory {

    public BankAccount createBankAccount(
            BankAccountId id,
            String accountNumber,
            String accountType,
            BigDecimal balance,
            BigDecimal dailyWithdrawalLimit,
            AccountHolderId accountHolderId,
            List<TransactionId> transactions
    ) {
        return new BankAccount(id, accountNumber, accountType, balance, dailyWithdrawalLimit, accountHolderId, transactions);
    }
}
