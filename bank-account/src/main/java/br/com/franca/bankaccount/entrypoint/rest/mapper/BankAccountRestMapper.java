package br.com.franca.bankaccount.entrypoint.rest.mapper;

import br.com.franca.bankaccount.core.domain.entity.BankAccount;
import br.com.franca.bankaccount.entrypoint.rest.request.NewBankAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BankAccountRestMapper extends EntryPointMapperBase<NewBankAccountRequest, BankAccount> {

}
