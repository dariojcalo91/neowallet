CREATE TABLE accounts (
                          id UUID PRIMARY KEY,
                          owner_id VARCHAR(255) NOT NULL,
                          balance DECIMAL(19, 2) NOT NULL,
                          version BIGINT NOT NULL DEFAULT 0,
                          created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Índice para buscar rápido las cuentas de un cliente
CREATE INDEX idx_accounts_owner_id ON accounts(owner_id);
