package com.neowallet.accounts.application.services;

import com.neowallet.accounts.application.ports.output.AccountRepository;
import com.neowallet.accounts.domain.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateAccountServiceTest {

    private final AccountRepository repository = Mockito.mock(AccountRepository.class);
    private final CreateAccountService service = new CreateAccountService(repository);

    @Test
    void shouldSaveAccountSuccessfully() {
        // Arrange
        when(repository.save(any(Account.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        Account result = service.execute("user-123", BigDecimal.valueOf(50.0));

        // Assert
        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(50.0), result.getBalance());
        verify(repository, times(1)).save(any(Account.class));
    }
}
