package com.neowallet.accounts.infrastructure.adapters.output.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEntity {

    @Id
    private UUID id;

    @Column(name = "owner_id", nullable = false)
    private String ownerId;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal balance;

    @Version // Controla la concurrencia de forma automática
    private Long version;

    @CreationTimestamp // Setea la fecha de creación automáticamente
    @Column(name = "created_at", updatable = false, nullable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp // Actualiza la fecha automáticamente en cada cambio
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;
}
