package tcc.banco.conta.Command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateContaCommand {
    @TargetAggregateIdentifier
    private Integer codigo;

    private String status;

    public CreateContaCommand(Integer codigo, String status) {
        this.codigo = codigo;
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }
}
