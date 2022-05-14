package tcc.bank.account.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;
import tcc.bank.account.Command.CreateAccountCommand;
import tcc.bank.account.Command.UpdateBalanceCommand;
import tcc.bank.account.Event.CreateAccountEvent;
import tcc.bank.account.Event.UpdateBalanceEvent;

import java.math.BigDecimal;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private Integer id;

    private String status;

    private BigDecimal balance;

    public AccountAggregate() { }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand cmd) {
        Assert.hasLength(cmd.getId().toString(), "Codigo da conta nao pode ser nulo.");
        Assert.hasLength(cmd.getStatus(), "Status da conta nao pode ser nulo.");
        apply(new CreateAccountEvent(cmd.getId(), cmd.getStatus(), BigDecimal.ZERO));
    }

    @CommandHandler
    public void handle(UpdateBalanceCommand cmd) {
        Assert.hasLength(cmd.getAccountId().toString(), "Codigo da conta nao pode ser nulo.");
        Assert.hasLength(cmd.getBalance().toString(), "Saldo da conta nao pode ser nulo.");
        apply(new UpdateBalanceEvent(cmd.getAccountId(), cmd.getBalance()));
    }

    @EventSourcingHandler
    public void on(CreateAccountEvent event) {
        this.id = event.getId();
        this.status = event.getStatus();
        this.balance = event.getBalance();
    }

    @EventSourcingHandler
    public void on(UpdateBalanceEvent event) {
        this.balance = event.getBalance();
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
