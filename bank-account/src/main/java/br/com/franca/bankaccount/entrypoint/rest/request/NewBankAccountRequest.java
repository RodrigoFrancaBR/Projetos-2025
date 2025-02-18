package br.com.franca.bankaccount.entrypoint.rest.request;

import br.com.franca.bankaccount.core.domain.CpfOrCnpj;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record NewBankAccountRequest(
        @NotNull( message = "Balance cannot be null")
        BigDecimal balance,

        @NotBlank(message = "Nome do titular é obrigatório")
        String titular,

        @NotBlank(message = "CPF/CNPJ é obrigatório")
        @CpfOrCnpj
        String document,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        @Pattern(regexp = "\\d{10,11}", message = "Telefone deve ter 10 ou 11 dígitos")
        String telefone,

        @NotNull(message = "Renda mensal é obrigatória")
        @Positive(message = "Renda mensal deve ser um valor positivo")
        BigDecimal rendaMensal,

        @NotBlank(message = "Endereço é obrigatório")
        String endereco,

        @NotBlank(message = "Tipo de conta é obrigatório")
        @Pattern(regexp = "corrente|poupanca|salario", message = "Tipo de conta deve ser: corrente, poupanca ou salario")
        String tipoConta
) {
}
