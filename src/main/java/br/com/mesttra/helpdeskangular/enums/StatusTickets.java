package br.com.mesttra.helpdeskangular.enums;

public enum StatusTickets {

    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), FINALIZADO(2, "FINALIZADO");
    private int cod;
    private String descricao;

    private StatusTickets(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusTickets toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (StatusTickets x : StatusTickets.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id de status inválido: " + cod + "\n" + "Valores válidos: 0, 1 ou 2");
    }
}
