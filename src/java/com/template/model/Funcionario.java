package com.template.model;


public class Funcionario {

    private final String nome;
    private final String matricula;
    protected final double SALARIO_FIXO = 2000.0;

    public Funcionario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalarioFixo() {
        return SALARIO_FIXO;
    }

    public double getValorExtra() {
        return 0.0;
    }

    public String getDescricaoExtras() {
        return String.format("Extras: R$ %.2f", getValorExtra());
    }

    public double getSalarioFinal() {
        return SALARIO_FIXO + getValorExtra();
    }
}