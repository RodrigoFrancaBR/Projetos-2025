package br.com.franca.bankaccount.core.domain.entity.bankaccount;

import java.util.Objects;
import java.util.UUID;

public record TransactionId(UUID id) {

    public TransactionId {
        Objects.requireNonNull(id, "id must not be null");
    }

    public TransactionId() {
        this(UUID.randomUUID());
    }
}
