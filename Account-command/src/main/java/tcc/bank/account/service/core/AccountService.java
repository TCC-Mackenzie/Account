package tcc.bank.account.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.bank.account.DTO.AccountDTO;
import tcc.bank.account.service.model.Account;
import tcc.bank.account.service.model.enums.AccountStatus;
import tcc.bank.account.service.repository.AccountRepository;

import java.math.BigDecimal;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(Integer accountId) {
        var account = new Account();
        account.setAccountId(accountId);
        account.setStatus(AccountStatus.ANALYSIS);
        account.setBalance(BigDecimal.valueOf(0));
        return accountRepository.save(account);
    }

    public Account findAccountByAccountId(Integer accountId) {
        return accountRepository.findAccountByAccountId(accountId);
    }
}
