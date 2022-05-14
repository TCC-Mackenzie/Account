package tcc.bank.account.Command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

public class UpdateBalanceCommand {

    @TargetAggregateIdentifier
    private Integer accountId;

    private BigDecimal balance;

    public UpdateBalanceCommand(Integer idAccount, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
