package tcc.bank.account.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.bank.account.service.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByAccountId(Integer accountId);
}
