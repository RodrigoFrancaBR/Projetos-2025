package br.com.franca.bankaccount.outpoint.database.adapters;

import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccount;
import br.com.franca.bankaccount.core.ports.out.BankAccountRepositoryPort;
import br.com.franca.bankaccount.outpoint.database.BankAccountRepository;
import br.com.franca.bankaccount.outpoint.database.mapper.BankAccountDataBaseMapper;
import org.springframework.stereotype.Component;

@Component
public class BankAccountRepositoryAdapter implements BankAccountRepositoryPort {

    private final BankAccountDataBaseMapper mapper;
    private final BankAccountRepository repository;

    public BankAccountRepositoryAdapter(
            BankAccountDataBaseMapper mapper,
            BankAccountRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void updateAccount(BankAccount domain) {
        //final var entity = mapper.toTarget(domain);
        //final var savedEntity = repository.save(entity);
    }

    @Override
    public BankAccount findAccount(Long id) {
//        return repository.findById(id)
//                .map(mapper::toSource)
//                .orElseThrow(() -> new IllegalArgumentException("Not found accoundId"));
        return null;
    }
}
