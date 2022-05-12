package tcc.banco.conta.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;
import tcc.banco.conta.Command.CreateContaCommand;
import tcc.banco.conta.Command.UpdateSaldoCommand;
import tcc.banco.conta.Event.CreateContaEvent;
import tcc.banco.conta.Event.UpdateSaldoEvent;

import java.math.BigDecimal;

@Aggregate
public class ContaAggregate {
    @AggregateIdentifier
    private Integer codigo;

    private String status;

    private BigDecimal saldo;

    public ContaAggregate() { }

    @CommandHandler
    public ContaAggregate(CreateContaCommand cmd) {
        Assert.hasLength(cmd.getCodigo().toString(), "Id should not be empty or null.");
        Assert.hasLength(cmd.getStatus(), "Id should not be empty or null.");
        apply(new CreateContaEvent(cmd.getCodigo(), cmd.getStatus(), BigDecimal.ZERO));
    }

    @CommandHandler
    public void handle(UpdateSaldoCommand cmd) {
        Assert.hasLength(cmd.getCodigo().toString(), "Id should not be empty or null.");
        Assert.hasLength(cmd.getSaldo().toString(), "Balance should not be empty or null.");
        apply(new UpdateSaldoEvent(cmd.getCodigo(), cmd.getSaldo()));
    }

    @EventSourcingHandler
    public void on(CreateContaEvent event) {
        this.codigo = event.getCodigo();
        this.status = event.getStatus();
        this.saldo = event.getSaldo();
    }

    @EventSourcingHandler
    public void on(UpdateSaldoEvent event) {
        this.saldo = event.getSaldo();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
