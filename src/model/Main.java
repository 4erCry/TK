package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("RSA");
        Parent root = FXMLLoader.load(getClass().getResource("/model/main_menu.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}