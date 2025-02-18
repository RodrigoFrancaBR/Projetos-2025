package br.com.franca.bankaccount.entrypoint.rest.response;

import java.math.BigDecimal;

public record BankAccountResponse(
        String titular,
        String document,
        String email,
        String telefone,
        BigDecimal rendaMensal,
        String endereco,
        String tipoConta
) {
}
