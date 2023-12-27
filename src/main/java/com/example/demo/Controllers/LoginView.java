package com.example.demo.Controllers;

import com.example.demo.Controllers.Utilities.ControlFields;
import com.example.demo.DAOs.AgentDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginView implements Initializable {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    @FXML
    private Button submitButton;

    public void login() throws IOException {
        Alert alert;
        if(ControlFields.verifyEmpty(usernameField.getText()) || ControlFields.verifyEmpty(passwordField.getText()))
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Il faut remplir tout les champs pour connecter !");
            alert.showAndWait();
        }
        else{

            String validateLoginType = AgentDAO.Login(usernameField.getText(),passwordField.getText());
            if(validateLoginType == null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Accès Impossible !");
                alert.showAndWait();
            }
            else  if(validateLoginType.equals("in") ) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Welcome " + usernameField.getText());
                alert.showAndWait();
                submitButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/client_manager-view.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Welcome " + usernameField.getText());
                alert.showAndWait();
                submitButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/ava-manager-view.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
