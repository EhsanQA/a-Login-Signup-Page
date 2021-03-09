package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationForm {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addedUsername;

    @FXML
    private PasswordField addedPassword;

    @FXML
    private PasswordField reEnteredPassword;

    @FXML
    private Button backBtn;

    @FXML
    private Button addingBtn;

    @FXML
    private Label loginError;
    @FXML
    private Label successMessage;



    @FXML
    private TextField addedID;

    @FXML
    void addTheUser(ActionEvent event) throws IOException {
        loginError.setText("");
        if (addedUsername.getText().isBlank() || addedPassword.getText().isBlank() || reEnteredPassword.getText().isBlank() ||
                addedID.getText().isBlank() || addedID.getText().isBlank()) {
            loginError.setText("*Please Fill in the Fields");
        } else if (!(addedPassword.getText().equals(reEnteredPassword.getText()))) {
            loginError.setText("*Please Check Your ReEntered Password");
        } else {
            Controller.addUser(addedUsername.getText(), addedPassword.getText(), addedID.getText());
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene loginScene = new Scene(root, 605, 600);
            Stage loginStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            loginStage.setTitle("Login");
            loginStage.setScene(loginScene);
            loginStage.setResizable(false);
            loginStage.show();

        }
    }

    @FXML
    void goesBackToAdminPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 600);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Login Page");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void initialize() {
        assert addedUsername != null : "fx:id=\"addedUsername\" was not injected: check your FXML file 'adminAddsUser.fxml'.";
        assert addedPassword != null : "fx:id=\"addedPassword\" was not injected: check your FXML file 'adminAddsUser.fxml'.";
        assert reEnteredPassword != null : "fx:id=\"reEnteredPassword\" was not injected: check your FXML file 'adminAddsUser.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'adminAddsUser.fxml'.";
        assert addingBtn != null : "fx:id=\"addingBtn\" was not injected: check your FXML file 'adminAddsUser.fxml'.";
        assert addedID != null : "fx:id=\"addedID\" was not injected: check your FXML file 'adminAddsUser.fxml'.";

    }
}
