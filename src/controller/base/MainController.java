package controller.base;

import controller.keysController.Nkey;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController
{
    @FXML
    private Label openKey;

    @FXML
    private TextField input;

    @FXML
    private Button startButton;

    @FXML
    void initialize()
    {
        Container Container = new Container();
        Nkey key = Container.getNkey();
        openKey.setText(key.toString());

        startButton.setOnAction(event ->
        {
            String inputText = input.getText();

            if(!inputText.equals(""))
            {
                int MessageToSend = Integer.parseInt(inputText);
                        if (MessageToSend < key.getN()){
                            Stage thisStage = (Stage) startButton.getScene().getWindow();
                            thisStage.close();

                            Container.perform(MessageToSend);

                            FXMLLoader fxmlLoader_ = new FXMLLoader(getClass().getResource("/model/main_menu.fxml"));
                            Scene scene = null;
                            try {
                                scene = new Scene(fxmlLoader_.load());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            Stage resultStage = new Stage();
                            resultStage.setScene(scene);

                            ResultController resultController = fxmlLoader_.getController();
                            resultController.setResult(Container);

                            resultStage.setTitle("RSA");
                            resultStage.show();
                        }
            }
        });
    }
}
