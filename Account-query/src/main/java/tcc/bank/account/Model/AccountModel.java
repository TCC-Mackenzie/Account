package tcc.bank.account.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "account")
public class AccountModel {

    @Id
    private Integer id;

    private BigDecimal balance;

    private String status;

    public AccountModel(Integer id, BigDecimal balance, String status) {
        this.id = id;
        this.balance = balance;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
