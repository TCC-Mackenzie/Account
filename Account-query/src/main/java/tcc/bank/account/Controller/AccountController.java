package tcc.bank.account.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcc.bank.account.Model.AccountModel;
import tcc.bank.account.Repository.AccountRepository;

@RestController
@RequestMapping(value = "")
public class AccountController {

    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "/v1.0")
    public ResponseEntity<Iterable<AccountModel>> getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }
}
