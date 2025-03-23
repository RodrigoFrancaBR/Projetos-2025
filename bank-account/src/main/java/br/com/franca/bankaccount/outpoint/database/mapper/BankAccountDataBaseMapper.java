package br.com.franca.bankaccount.outpoint.database.mapper;

import br.com.franca.bankaccount.core.domain.entity.bankaccount.AccountHolderId;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.AccountType;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccount;
import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccountId;
import br.com.franca.bankaccount.outpoint.database.model.BankAccountModel;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface BankAccountDataBaseMapper extends OutPointMapperBase<BankAccount, BankAccountModel> {

    UUID map(BankAccountId id);

    UUID map(AccountHolderId accountHolderId);

    default String map(AccountType accountType) {
        if (accountType == null) {
            throw new IllegalArgumentException("accountType must not be null");
        }
        return accountType.name().toLowerCase();
    }

    //@Mapping(target = "id", source = "id.id")
    // @Mapping(target = "id", source = "id.id")
    // @Mapping(target = "accountHolderId", source = "accountHolderId.id")
//    @Mapping(target = "accountType", source = "accountType", qualifiedByName = "mapAccountTypeToString")
//    @Override
//    BankAccountModel toTarget(S bankAccount);

//    @Named("mapAccountTypeToString")
//    default String mapAccountTypeToString(AccountType accountType) {
//        return accountType.name().toLowerCase();
//    }

    //BankAccountId map(UUID value);

//    default UUID bankAccountIdToId(BankAccountId bankAccountId) {
//        return bankAccountId.id();
//    }
//
//    default UUID accountHolderIdToId(AccountHolderId accountHolderId) {
//        return accountHolderId.id();
//    }
}
