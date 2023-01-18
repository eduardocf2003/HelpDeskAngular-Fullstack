package br.com.mesttra.helpdeskangular.enums;

public enum TiposPerfil {

    GERENTE(0, "ROLE_GERENTE"), CLIENTE(1, "ROLE_CLIENTE"), SUPORTE(2, "ROLE_SUPORTE");

    private int cod;
    private String descricao;

    private TiposPerfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TiposPerfil toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (TiposPerfil x : TiposPerfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id de perfil inválido: " + cod + "\n" + "Valores válidos: 0, 1 ou 2");
    }
}
