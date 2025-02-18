package br.com.franca.bankaccount.outpoint.database;

import br.com.franca.bankaccount.outpoint.database.model.BankAccountModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccountModel, Long> {
}
