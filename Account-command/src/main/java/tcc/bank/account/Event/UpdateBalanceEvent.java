package tcc.bank.account.Event;

import java.math.BigDecimal;

public class UpdateBalanceEvent {
    private Integer accountId;

    private BigDecimal balance;

    public UpdateBalanceEvent(Integer accountId, BigDecimal balance) {
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
