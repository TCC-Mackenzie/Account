package tcc.banco.conta.Event;

import java.math.BigDecimal;

public class UpdateSaldoEvent {
    private Integer codigo;

    private BigDecimal saldo;

    public UpdateSaldoEvent(Integer codigo, BigDecimal saldo) {
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public Integer getCodigo() {
        return codigo;
    }


    public BigDecimal getSaldo() {
        return saldo;
    }
}
