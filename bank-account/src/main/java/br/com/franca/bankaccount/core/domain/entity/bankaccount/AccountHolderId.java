package br.com.franca.bankaccount.core.domain.entity.bankaccount;

import java.util.Objects;
import java.util.UUID;

public record AccountHolderId(UUID id) {

    public AccountHolderId {
        Objects.requireNonNull(id, "id must not be null");
    }

    public AccountHolderId() {
        this(UUID.randomUUID());
    }
}
