package controller.base;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultController
{
    @FXML
    private Label result;

    @FXML
    private Label m;

    @FXML
    private Label message;

    @FXML
    private Button tryAgain;

    @FXML
    void initialize()
    {
        tryAgain.setOnAction(event ->
        {
            Stage thisStage = (Stage)tryAgain.getScene().getWindow();
            thisStage.close();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/model/result_menu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("RSA");
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

    public void setResult(Container Container)
    {
        message.setText(String.valueOf(Container.getMessage()));
        m.setText(String.valueOf(Container.getMessageToSend()));
        result.setText(String.valueOf(Container.getMessageToReceive()));
    }
}
