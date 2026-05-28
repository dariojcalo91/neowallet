package com.neowallet.accounts.infrastructure.adapters.output.mappers;

import com.neowallet.accounts.domain.Account;
import com.neowallet.accounts.infrastructure.adapters.output.entities.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountPersistenceMapper {

    // De Dominio a Base de Datos (Para Guardar)
    public AccountEntity toEntity(Account account) {
        if(account == null) return null;

        return AccountEntity.builder()
                .id(account.getId())
                .ownerId(account.getOwnerId())
                .balance(account.getBalance())
                .build(); // version, createdAt y updatedAt quedan en null automáticamente
    }

    // De Base de Datos a Dominio (Para Leer)
    public Account toDomain(AccountEntity entity) {
        return new Account(
                entity.getOwnerId(),
                entity.getBalance()
                // Aquí podrías necesitar un constructor en Account que acepte el UUID
        );
    }
}
