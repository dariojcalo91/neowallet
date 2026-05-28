package com.neowallet.accounts.application.ports.output;

import com.neowallet.accounts.domain.Account;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(UUID id);
}
