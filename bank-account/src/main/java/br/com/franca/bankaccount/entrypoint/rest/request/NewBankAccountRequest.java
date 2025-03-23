package br.com.franca.bankaccount.entrypoint.rest.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record NewBankAccountRequest(
        // gerado automaticamente quando nao informado
        UUID bankAccountId,

        // gerado automaticamente quando nao informado
        String accountNumber,

        @NotEmpty(message = "AccountType cannot be null")
        String accountType,

        BigDecimal balance,

        // criar uma anotação parecida com a @Min porem para numeros decimais ou BIgDecimal
        @NotNull
        BigDecimal dailyWithdrawalLimit,

        @NotNull(message = "AccountHolderId cannot be null")
        UUID accountHolderId,

        List<UUID> transactionIds
) {
}
