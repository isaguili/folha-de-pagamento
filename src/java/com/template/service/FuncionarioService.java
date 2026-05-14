package com.template.service;

import com.template.model.Funcionario;
import com.template.model.FuncionarioComissionado;
import com.template.model.FuncionarioProducao;

public class FuncionarioService {

    /**
     * Cria um funcionário de acordo com o tipo selecionado.
     *
     * @param tipo tipo do funcionário.
     * @param nome nome do funcionário.
     * @param matricula matrícula do funcionário.
     * @param vendas valor de vendas realizadas.
     * @param percentual percentual de comissão.
     * @param valorPeca valor pago por peça.
     * @param quantidade quantidade produzida.
     * @return funcionário criado.
     */
    public static Funcionario criarFuncionario(
            String tipo,
            String nome,
            String matricula,
            double vendas,
            double percentual,
            double valorPeca,
            int quantidade
    ) {

        switch (tipo) {

            case "Comissionado":
                return new FuncionarioComissionado(
                        nome,
                        matricula,
                        vendas,
                        percentual
                );

            case "Produção":
                return new FuncionarioProducao(
                        nome,
                        matricula,
                        valorPeca,
                        quantidade
                );

            default:
                return new Funcionario(nome, matricula);
        }
    }

}