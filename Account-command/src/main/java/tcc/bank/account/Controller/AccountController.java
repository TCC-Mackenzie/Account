package tcc.bank.account.Controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import tcc.bank.account.Command.CreateAccountCommand;
import tcc.bank.account.Command.UpdateBalanceCommand;
import tcc.bank.account.DTO.AccountDTO;
import tcc.bank.account.service.core.AccountService;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@RestController
public class AccountController {

    private final AccountService accountService;
    private CommandGateway commandGateway;

    public AccountController(AccountService accountService, CommandGateway commandGateway) {
        this.accountService = accountService;
        this.commandGateway = commandGateway;
    }

    @PostMapping(value = "/v1.0")
    public CompletableFuture<String> create() {
        var gerador = new Random();
        var accountId = gerador.nextInt(999999);
        while(accountService.findAccountByAccountId(accountId) != null) {
            accountId = gerador.nextInt(999999);
        }
        var account = accountService.create(accountId);
        var command = new CreateAccountCommand(account.getAccountId(), account.getStatus().getDescription());
        return commandGateway.send(command);
    }

    @PutMapping(value = "/v1.0/{id}/balance")
    public CompletableFuture<String> updateBalance(@PathVariable Integer id, @RequestBody AccountDTO dto) {
        var command = new UpdateBalanceCommand(id, dto.getBalance());
        return commandGateway.send(command);
    }
}
