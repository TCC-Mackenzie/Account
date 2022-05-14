package tcc.bank.account.DTO;

import java.math.BigDecimal;

public class AccountDTO {
    private String status;

    private BigDecimal balance;

    public AccountDTO() { }

    public AccountDTO(String status, BigDecimal balance) {
        this.status = status;
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
