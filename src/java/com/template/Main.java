package com.template;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application
{

    /**
     * Inicializa a janela principal da aplicação.
     *
     * @param stage palco principal da aplicação
     * @throws Exception caso ocorra erro ao carregar o arquivo FXML
     */
    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(loader.load(),550,800);

        stage.setTitle("Folha Flux");
        stage.setScene(scene);
        stage.show();

        Locale.setDefault(new Locale("pt", "BR"));
    }

    public static void main(String[] args)
    {
        launch();
    }
}
