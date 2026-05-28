package com.neowallet.accounts.infrastructure.adapters.output;

import com.neowallet.accounts.application.ports.output.AccountRepository;
import com.neowallet.accounts.domain.Account;
import com.neowallet.accounts.infrastructure.adapters.output.entities.AccountEntity;
import com.neowallet.accounts.infrastructure.adapters.output.mappers.AccountPersistenceMapper;
import com.neowallet.accounts.infrastructure.adapters.output.repository.SpringDataAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component // <--- ESTO ES VITAL: Le dice a Spring "Yo soy el Bean que buscas"
@RequiredArgsConstructor
public class JpaAccountRepositoryAdapter implements AccountRepository {

    private final SpringDataAccountRepository springDataRepository;
    private final AccountPersistenceMapper mapper;

    @Override
    public Account save(Account account) {
        // 1. Transformamos el objeto de Dominio a Entidad de JPA (SQL)
        AccountEntity entity = mapper.toEntity(account);

        // 2. Guardamos físicamente en la base de datos usando Spring Data
        AccountEntity savedEntity = springDataRepository.save(entity);

        // 3. Devolvemos el objeto convertido de nuevo a Dominio
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return springDataRepository.findById(id)
                .map(mapper::toDomain);
    }
}