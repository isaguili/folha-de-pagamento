package com.template;

import com.template.model.Funcionario;
import com.template.repository.ListaDeFuncionarios;
import com.template.service.FuncionarioService;
import com.template.service.MatriculaDoFuncionario;
import com.template.view.FuncionariosView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

/**
 * Controlador principal da interface gráfica da aplicação.
 * <p>
 * Gerencia o ciclo de vida dos componentes JavaFX, lida com a entrada de dados
 * do usuário para cadastro de diferentes tipos de funcionários e coordena a
 * atualização visual da lista e contadores.
 *
 */
public class MainController implements Initializable {
    @FXML
    private Button bntRemoverFuncionario;

    @FXML
    private Button btnCadastrarFuncionario;

    @FXML
    private Button btnExibirFolha;

    @FXML
    private Button btnResetarView;

    @FXML
    private ChoiceBox<String> cbTipoFuncionario;

    @FXML
    private Label lblComissao;

    @FXML
    private Label lblMatriculaFuncionario;

    @FXML
    private Label lblNome1;

    @FXML
    private Label lblNomeFuncionario;

    @FXML
    private Label lblQuantidadeFuncionarios;

    @FXML
    private Label lblQuantidadePecas;

    @FXML
    private Label lblSalarioFixo;

    @FXML
    private Label lblValorPeca;

    @FXML
    private Label lblVendas;

    @FXML
    private ListView<String> lvFuncionarios;

    @FXML
    private Spinner<Double> spinnerComissao;

    @FXML
    private Spinner<Integer> spinnerQuantidadePecas;

    @FXML
    private Spinner<Double> spinnerValorPeca;

    @FXML
    private Spinner<Double> spinnerVendas;

    @FXML
    private TextField txtMatriculaFuncionario;

    @FXML
    private TextField txtNomeFuncionario;

    @FXML
    private TextField txtSalarioFixo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Define o idioma padrão da aplicação
        Locale.setDefault(new Locale("pt", "BR"));

        configurarSppiners();
        configurarChoiceBox();
        monitorarChoiceBox();
        esconderCamposExtrasDoFormulario();
    }

    void configurarSppiners() {
        SpinnerValueFactory<Double> factoryVendas =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0, Integer.MAX_VALUE, 0);
        spinnerVendas.setValueFactory(factoryVendas);

        SpinnerValueFactory<Double> factoryComissao =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 100.0);
        spinnerComissao.setValueFactory(factoryComissao);

        SpinnerValueFactory<Double> factoryValor =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, Double.MAX_VALUE, 0.0);
        spinnerValorPeca.setValueFactory(factoryValor);

        SpinnerValueFactory<Integer> factoryProducao =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0);
        spinnerQuantidadePecas.setValueFactory(factoryProducao);

        spinnerVendas.setEditable(true);
        spinnerComissao.setEditable(true);
        spinnerValorPeca.setEditable(true);
        spinnerQuantidadePecas.setEditable(true);
    }

    void configurarChoiceBox() {
        String[] tiposDeFuncionario = {"Padrão", "Comissionado", "Produção"};

        cbTipoFuncionario.getItems().addAll(tiposDeFuncionario);
        cbTipoFuncionario.setValue("Padrão");
    }

    void monitorarChoiceBox() {
        cbTipoFuncionario.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            boolean eComissionado = "Comissionado".equals(newValue);
            boolean eProducao = "Produção".equals(newValue);

            mostrarCamposComissionado(eComissionado);
            mostrarCamposProducao(eProducao);

        });
    }

    void esconderCamposExtrasDoFormulario() {
        esconderCampos(lblVendas, spinnerVendas, lblComissao, spinnerComissao);
        esconderCampos(lblQuantidadePecas, spinnerQuantidadePecas, lblValorPeca, spinnerValorPeca);
    }

    void mostrarCamposComissionado(boolean eComissionado) {
        mostrarCampos(eComissionado,
                lblVendas, spinnerVendas, lblComissao, spinnerComissao);
    }

    void mostrarCamposProducao(boolean eProducao) {
        mostrarCampos(eProducao,
                lblQuantidadePecas, spinnerQuantidadePecas, lblValorPeca, spinnerValorPeca);
    }

    private void mostrarCampos(boolean visivel, Node... campos) {
        for (Node campo : campos) {
            campo.setVisible(visivel);
            campo.setManaged(visivel);
        }
    }

    private void esconderCampos(Node... campos) {
        for (Node campo : campos) {
            campo.setVisible(false);
            campo.setManaged(false);
        }
    }

    @FXML
    void cadastrarFuncionario() {
        String nome = txtNomeFuncionario.getText();
        String tipo = cbTipoFuncionario.getValue();

        if (nome.trim().isEmpty()) {
            mostrarErro("É obrigatório inserir um nome.");
            return;
        }

        String matricula = txtMatriculaFuncionario.getText();
        boolean matriculaExiste = verificarMatricula(matricula);

        if (matricula.trim().isEmpty()) {
            mostrarErro("Registre um número de matrícula.");
            return;
        } else if (matriculaExiste) {
            mostrarErro("Esse número de matrícula já foi registrado.");
            return;
        }

        double vendas = spinnerVendas.getValue();
        double percentual = spinnerComissao.getValue();
        double valorPeca = spinnerValorPeca.getValue();
        int quantidade = spinnerQuantidadePecas.getValue();

        try {
            Funcionario funcionario = FuncionarioService.criarFuncionario(
                    tipo, nome, matricula, vendas, percentual, valorPeca, quantidade
            );

            ListaDeFuncionarios.adicionar(funcionario);

            limparFormulario();
            FuncionariosView.atualizarContador(lblQuantidadeFuncionarios);
            mostrarConfirmacao();


        } catch (Exception error) {
            mostrarErro("Erro ao criar funcionário");
        }
    }

    private boolean verificarMatricula(String matricula) {
        return ListaDeFuncionarios.getLista()
                .stream()
                .anyMatch(funcionario ->
                        funcionario.getMatricula().equals(matricula));
    }

    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Folha de pagamento");
        alert.setHeaderText(mensagem);
        alert.setContentText("Clique em OK e tente novamente.");
        alert.showAndWait();
    }

    private void mostrarConfirmacao() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Funcionário cadastrado com sucesso!");
        alert.setContentText("Clique em OK para continuar.");
        alert.showAndWait();
    }

    void limparFormulario() {
        txtNomeFuncionario.clear();
        txtMatriculaFuncionario.clear();
        spinnerVendas.getValueFactory().setValue(0.0);
        spinnerComissao.getValueFactory().setValue(0.0);
        spinnerValorPeca.getValueFactory().setValue(0.0);
        spinnerQuantidadePecas.getValueFactory().setValue(0);
    }

    @FXML
    void atualizarListView() {
        try {
            FuncionariosView.resetar(lvFuncionarios);
            FuncionariosView.atualizarContador(lblQuantidadeFuncionarios);
            FuncionariosView.atualizar((lvFuncionarios));
        } catch (Exception error) {
            mostrarErro("Não foi possível atualizar a lista. Tente novamente.");
        }
    }

    @FXML
    public void resetarListView() {
        FuncionariosView.resetar(lvFuncionarios);
    }

    @FXML
    public void removerFuncionario() {
        try {
            int funcionarioSelecionado = lvFuncionarios.getSelectionModel().getSelectedIndex();
            ListaDeFuncionarios.remover(funcionarioSelecionado);
            atualizarListView();
        } catch (Exception error) {
            mostrarErro("Você deve selecionar o usuário na lista antes de removê-lo.");
        }
    }


}
