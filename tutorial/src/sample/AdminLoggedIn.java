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
import javafx.stage.Stage;

public class AdminLoggedIn {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addUserBtn;

    @FXML
    private Button logOut;

    @FXML
    void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene logOutScene = new Scene(root, 605, 600);
        Stage logOutStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        logOutStage.setTitle("Login");
        logOutStage.setScene(logOutScene);
        logOutStage.setResizable(false);
        logOutStage.show();
    }

    @FXML
    void registerUser(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminAddsUser.fxml"));
        Scene adminAddingScene = new Scene(root, 605, 600);
        Stage adminAddingStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminAddingStage.setTitle("Adding a User");
        adminAddingStage.setScene(adminAddingScene);
        adminAddingStage.setResizable(false);
        adminAddingStage.show();
    }

    @FXML
    void initialize() {
        assert addUserBtn != null : "fx:id=\"addUserBtn\" was not injected: check your FXML file 'adminLoggedIn.fxml'.";
        assert logOut != null : "fx:id=\"logOut\" was not injected: check your FXML file 'adminLoggedIn.fxml'.";

    }
}
