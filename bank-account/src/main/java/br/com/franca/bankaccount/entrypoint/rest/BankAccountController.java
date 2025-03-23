package br.com.franca.bankaccount.entrypoint.rest;

import br.com.franca.bankaccount.core.ports.in.IBankAccountCorePort;
import br.com.franca.bankaccount.entrypoint.rest.mapper.BankAccountRestMapper;
import br.com.franca.bankaccount.entrypoint.rest.request.NewBankAccountRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/v1/account")
public class BankAccountController implements BankAccountApi {

    private final BankAccountRestMapper mapper;
    private final IBankAccountCorePort port;

    public BankAccountController(
            BankAccountRestMapper mapper,
            IBankAccountCorePort port) {
        this.mapper = mapper;
        this.port = port;

    }

    @PostMapping
    @Override
    public ResponseEntity<Void> openAccount(@RequestBody @Valid final NewBankAccountRequest request) {
        final var domain = mapper.toTarget(request);
        port.openAccountCore(domain);
        return ResponseEntity
                .created(URI.create("/v1/account/" + 123))
                .build();
    }

    @Override
    public void withdrawal(Long id, BigDecimal amount) {
        //  port.withdrawal(id, amount);
    }
}
