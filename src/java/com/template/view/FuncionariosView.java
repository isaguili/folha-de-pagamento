package com.template.view;

import com.template.model.Funcionario;
import com.template.repository.ListaDeFuncionarios;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class FuncionariosView {


    public static void atualizarContador(Label lblQuantidadeFuncionarios) {
        int total = ListaDeFuncionarios.getLista().size();
        lblQuantidadeFuncionarios.setText(String.valueOf(total));
    }


    public static void atualizar(ListView<String> lvFuncionarios){
        resetar(lvFuncionarios);
        exibirFuncionarios(lvFuncionarios);
    }


    public static void exibirFuncionarios(ListView<String> lvFuncionarios) {
        for (Funcionario funcionario : ListaDeFuncionarios.getLista()) {
            String resumo = formatarExibicao(funcionario);
            lvFuncionarios.getItems().add(resumo);
        }
    }

    private static String formatarExibicao(Funcionario funcionario) {
        return String.format(
                "Nome: %s \nMatrícula: %s \nSalário Fixo: R$ %.2f \n%s \nSalário Final: R$ %.2f",
                funcionario.getNome(),
                funcionario.getMatricula(),
                funcionario.getSalarioFixo(),
                funcionario.getDescricaoExtras(),
                funcionario.getSalarioFinal()
        );
    }


    public static void resetar(ListView<String> lvFuncionarios) {
        lvFuncionarios.getItems().clear();
    }
}
