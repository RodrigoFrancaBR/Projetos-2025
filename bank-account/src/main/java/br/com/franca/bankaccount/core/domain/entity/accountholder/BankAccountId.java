package br.com.franca.bankaccount.core.domain.entity.accountholder;

import java.util.Objects;
import java.util.UUID;

public record BankAccountId(UUID id) {

    public BankAccountId {
        Objects.requireNonNull(id, "id must not be null");
    }

    public BankAccountId() {
        this(UUID.randomUUID());
    }
}
