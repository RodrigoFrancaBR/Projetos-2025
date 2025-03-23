package br.com.franca.bankaccount.core.domain.entity.agency;

public record Agency(
        AgencyId id,
        String name,
        String cnpj,
        String email,
        String telephone,
        String address
) {
}



