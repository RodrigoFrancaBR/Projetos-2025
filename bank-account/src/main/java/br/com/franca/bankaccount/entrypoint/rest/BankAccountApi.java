package br.com.franca.bankaccount.entrypoint.rest;

import br.com.franca.bankaccount.entrypoint.rest.request.NewBankAccountRequest;
import br.com.franca.bankaccount.entrypoint.rest.response.BankAccountResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

/**
 * Com base em funcionalidades reais de uma conta bancária, como ficaria uma Api rest em spring
 */
@Tag(name = "Conta Bancária", description = "Endpoints para operações em contas bancárias")
public interface BankAccountApi {

    @Operation(summary = "Criar uma nova conta bancária", description = "Cria uma conta com os dados informados.")
    ResponseEntity<Void> createAccount(NewBankAccountRequest request);

    @Operation(summary = "Sacar um valor do saldo da conta bancária", description = "Saque o valor informado do saldo da conta bancaria.")
    void withdrawal(Long id, BigDecimal amount);

}
