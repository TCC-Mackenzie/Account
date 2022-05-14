package tcc.bank.account.Controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import tcc.bank.account.Command.CreateAccountCommand;
import tcc.bank.account.Command.UpdateBalanceCommand;
import tcc.bank.account.DTO.AccountDTO;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "")
public class AccountController {

    private CommandGateway commandGateway;

    public AccountController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(value = "/v1.0")
    public CompletableFuture<String> create(@RequestBody AccountDTO dto) {
        var command = new CreateAccountCommand(1, dto.getStatus());
        return commandGateway.send(command);
    }

    @PutMapping(value = "/v1.0/{id}/balance")
    public CompletableFuture<String> updateBalance(@PathVariable Integer id, @RequestBody AccountDTO dto) {
        var command = new UpdateBalanceCommand(id, dto.getBalance());
        return commandGateway.send(command);
    }
}
