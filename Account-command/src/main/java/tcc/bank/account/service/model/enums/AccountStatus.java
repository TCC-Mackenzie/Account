package tcc.bank.account.service.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountStatus {
    ANALYSIS(0, "Análise"),
    ACTIVE(1, "Ativa"),
    INACTIVE(2, "Inativa");

    @JsonValue
    int id;
    String description;

    private AccountStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
