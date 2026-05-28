package com.neowallet.accounts.infrastructure.config;

import com.neowallet.accounts.application.ports.output.AccountRepository;
import com.neowallet.accounts.application.services.CreateAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateAccountService createAccountService(AccountRepository accountRepository) {
        return new CreateAccountService(accountRepository);
    }
}
