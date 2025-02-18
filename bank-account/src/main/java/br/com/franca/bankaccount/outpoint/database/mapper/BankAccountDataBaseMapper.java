package br.com.franca.bankaccount.outpoint.database.mapper;

import br.com.franca.bankaccount.core.domain.entity.BankAccount;
import br.com.franca.bankaccount.entrypoint.rest.request.NewBankAccountRequest;
import br.com.franca.bankaccount.outpoint.database.model.BankAccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BankAccountDataBaseMapper extends OutPointMapperBase<BankAccount, BankAccountModel> {

}
