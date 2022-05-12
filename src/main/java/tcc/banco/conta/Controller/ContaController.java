package tcc.banco.conta.Controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import tcc.banco.conta.Command.CreateContaCommand;
import tcc.banco.conta.Command.UpdateSaldoCommand;
import tcc.banco.conta.DTO.ContaDTO;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    private CommandGateway commandGateway;

    public ContaController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public CompletableFuture<String> create(@RequestBody ContaDTO dto) {
        var command = new CreateContaCommand(1, dto.getStatus());
        return commandGateway.send(command);
    }

    @PutMapping(value = "/{codigo}/saldo")
    public CompletableFuture<String> updateSaldo(@PathVariable Integer codigo, @RequestBody ContaDTO dto) {
        var command = new UpdateSaldoCommand(codigo, dto.getSaldo());
        return commandGateway.send(command);
    }
}
