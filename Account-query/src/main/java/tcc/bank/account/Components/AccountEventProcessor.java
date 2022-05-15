package tcc.bank.account.Components;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import tcc.bank.account.Event.CreateAccountEvent;
import tcc.bank.account.Event.UpdateBalanceEvent;
import tcc.bank.account.Exception.AccountNotFoundException;
import tcc.bank.account.Model.AccountModel;
import tcc.bank.account.Repository.AccountRepository;

@Component
@ProcessingGroup("amqpEvents")
public class AccountEventProcessor {

    private final AccountRepository accountRepository;

    public AccountEventProcessor(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @EventHandler
    public void on(CreateAccountEvent event) {
        var account = accountRepository.save(new AccountModel(event.getId(), event.getBalance(), event.getStatus()));
    }

    @EventHandler
    public void on(UpdateBalanceEvent event) {
        var account = accountRepository.findById(event.getAccountId()).orElseThrow(AccountNotFoundException::new);
        account.setBalance(event.getBalance());
        accountRepository.save(account);
    }
}
