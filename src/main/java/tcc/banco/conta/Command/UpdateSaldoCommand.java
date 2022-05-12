package tcc.banco.conta.Command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

public class UpdateSaldoCommand {

    @TargetAggregateIdentifier
    private Integer codigo;

    private BigDecimal saldo;

    public UpdateSaldoCommand(Integer codigo, BigDecimal saldo) {
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
