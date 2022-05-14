package tcc.bank.account.Event;

import java.math.BigDecimal;

public class CreateAccountEvent {
    private Integer id;

    private String status;

    private BigDecimal balance;

    public CreateAccountEvent(Integer id, String status, BigDecimal balance) {
        this.id = id;
        this.status = status;
        this.balance = balance;
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
