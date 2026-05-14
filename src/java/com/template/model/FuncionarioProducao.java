package com.template.model;

public class FuncionarioProducao extends Funcionario {
    private final double valorPorPeca;
    private final int quantidadeProduzida;

    public FuncionarioProducao(String nome, String matricula, double valorPorPeca, int quantidadeProduzida) {
        super(nome, matricula);
        this.valorPorPeca = valorPorPeca;
        this.quantidadeProduzida = quantidadeProduzida;
    }

    @Override
    public double getValorExtra() {
        return this.valorPorPeca * this.quantidadeProduzida;
    }

    @Override
    public String getDescricaoExtras() {
        return String.format("Produtividade: R$ %.2f", getValorExtra());
    }
}

