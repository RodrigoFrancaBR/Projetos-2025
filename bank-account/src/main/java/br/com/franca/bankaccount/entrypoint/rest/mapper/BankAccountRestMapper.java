package br.com.franca.bankaccount.entrypoint.rest.mapper;

import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccount;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.TransactionId;
import br.com.franca.bankaccount.core.domain.util.BankAccountFactory;
import br.com.franca.bankaccount.entrypoint.rest.request.NewBankAccountRequest;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BankAccountRestMapper extends EntryPointMapperBase<NewBankAccountRequest, BankAccount> {
    @Mapping(target = "id", expression = "java(new BankAccountId(source.bankAccountId()))")
    @Mapping(target = "accountHolderId", expression = "java(new AccountHolderId(source.accountHolderId()))")
    @Mapping(target = "transactions", source = "transactionIds", qualifiedByName = "mapTransactionIds")
    @Override
    BankAccount toTarget(NewBankAccountRequest source);

    @Named("mapTransactionIds")
    List<TransactionId> map(List<UUID> value);

    default TransactionId map(UUID value) {
        return value == null ? null : new TransactionId(value);
    }
}
