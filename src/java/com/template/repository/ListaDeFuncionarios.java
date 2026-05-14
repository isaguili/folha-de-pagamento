package com.template.repository;

import com.template.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class ListaDeFuncionarios {

    public static List<Funcionario> listaFuncionarios = new ArrayList<>();

    public static List<Funcionario> getLista() {
        return listaFuncionarios;
    };

    public static void adicionar(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    public static void remover(int funcionarioSelecionado) {
        listaFuncionarios.remove(funcionarioSelecionado);
    }

}
