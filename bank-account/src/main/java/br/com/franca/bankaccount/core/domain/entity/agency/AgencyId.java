package br.com.franca.bankaccount.core.domain.entity.agency;

import java.util.Objects;
import java.util.UUID;

public record AgencyId(UUID id) {

    public AgencyId {
        Objects.requireNonNull(id, "id must not be null");
    }
}
