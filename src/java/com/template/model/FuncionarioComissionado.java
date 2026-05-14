package com.template.model;

public class FuncionarioComissionado extends Funcionario {
    private final double vendas;
    private final double percentual;

    public FuncionarioComissionado(String nome, String matricula, double vendas, double percentual) {
        super(nome, matricula);
        this.vendas = vendas;
        this.percentual = percentual;
    }

    @Override
    public double getValorExtra() {
        return this.vendas * (this.percentual / 100);
    }

    @Override
    public String getDescricaoExtras() {
        return String.format("Comissão: R$ %.2f", getValorExtra());
    }
}

