package br.com.mesttra.helpdeskangular.enums;

public enum PrioridadeTicket {

    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");
    private int cod;
    private String descricao;

    private PrioridadeTicket(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PrioridadeTicket toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (PrioridadeTicket x : PrioridadeTicket.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id de prioridade Inválido: " + cod + "\n" + "Valores válidos: 0, 1 ou 2");
    }
}
