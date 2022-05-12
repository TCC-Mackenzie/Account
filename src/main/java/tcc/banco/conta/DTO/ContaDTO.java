package tcc.banco.conta.DTO;

import java.math.BigDecimal;

public class ContaDTO {
    private String status;

    private BigDecimal saldo;

    public ContaDTO() { }

    public ContaDTO(String status, BigDecimal saldo) {
        this.status = status;
        this.saldo = saldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
