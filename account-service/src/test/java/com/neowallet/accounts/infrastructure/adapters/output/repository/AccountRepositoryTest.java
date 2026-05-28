package com.neowallet.accounts.infrastructure.adapters.output.repository;

import com.neowallet.accounts.infrastructure.adapters.output.entities.AccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import java.math.BigDecimal;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Usa nuestra DB real de Docker
class AccountRepositoryTest {

    @Autowired
    private SpringDataAccountRepository repository;

    @Test
    void shouldSaveAndFindAccount() {
        // Arrange
        UUID id = UUID.randomUUID();

        AccountEntity entity = AccountEntity.builder()
                .id(id)
                .ownerId("owner-1")
                .balance(new BigDecimal("100.00"))
                .build(); // version, createdAt y updatedAt se quedan en null automáticamente

        // Act
        repository.save(entity);
        AccountEntity saved = repository.findById(id).orElseThrow();

        // Assert
        assertEquals("owner-1", saved.getOwnerId());
        assertEquals(0, new BigDecimal("100.00").compareTo(saved.getBalance()));
    }
}
