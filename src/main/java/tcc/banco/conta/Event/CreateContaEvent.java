package tcc.banco.conta.Event;

import java.math.BigDecimal;

public class CreateContaEvent {
    private Integer codigo;

    private String status;

    private BigDecimal saldo;

    public CreateContaEvent(Integer codigo, String status, BigDecimal saldo) {
        this.codigo = codigo;
        this.status = status;
        this.saldo = saldo;
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
