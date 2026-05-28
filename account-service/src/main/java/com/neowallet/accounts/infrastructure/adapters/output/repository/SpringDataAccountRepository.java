package com.neowallet.accounts.infrastructure.adapters.output.repository;

import com.neowallet.accounts.infrastructure.adapters.output.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

// JpaRepository ya trae métodos como save, findById, delete, etc.
public interface SpringDataAccountRepository extends JpaRepository<AccountEntity, UUID> {
}
