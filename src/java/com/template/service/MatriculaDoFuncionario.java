package com.template.service;
import com.template.model.Funcionario;
import com.template.repository.ListaDeFuncionarios;

import java.util.List;
import java.util.Random;

/**
 * Classe responsável por gerar matrículas únicas para funcionários.
 */
public class MatriculaDoFuncionario {

    /**
     * Gera uma matrícula numérica de 4 dígitos que ainda
     * não exista na lista de funcionários.
     *
     * @return matrícula única gerada
     */
    public static String gerar() {

        Random random = new Random();
        String novaMatricula;
        boolean matriculaExiste;

        do {
            novaMatricula = String.format("%04d", random.nextInt(10000));
            String matriculaFinal = novaMatricula;
            matriculaExiste = ListaDeFuncionarios.getLista()
                    .stream()
                    .anyMatch(funcionario ->
                            funcionario.getMatricula().equals(matriculaFinal));
        } while (matriculaExiste);

        return novaMatricula;
    }
}