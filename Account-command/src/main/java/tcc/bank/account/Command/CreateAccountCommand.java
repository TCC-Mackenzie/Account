package tcc.bank.account.Command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateAccountCommand {
    @TargetAggregateIdentifier
    private Integer id;

    private String status;

    public CreateAccountCommand(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
