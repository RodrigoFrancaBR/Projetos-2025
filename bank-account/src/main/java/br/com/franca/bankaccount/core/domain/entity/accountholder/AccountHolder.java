package br.com.franca.bankaccount.core.domain.entity.accountholder;

import java.util.List;

public record AccountHolder(
        AccountHolderId id,
        String name,
        String cpfCnpj,
        String email,
        String telephone,
        String address,
        List<BankAccountId> bankAccountIds// Um cliente pode ter várias contas
) {
}
