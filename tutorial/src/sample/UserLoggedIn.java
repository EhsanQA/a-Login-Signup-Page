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
import javafx.stage.Stage;

public class UserLoggedIn {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label helloer;

    @FXML
    private Label yourPasswordIs;

    @FXML
    private Label yourUsernameIs;

    @FXML
    private Label yourIDIs;

    @FXML
    private Button LogOut;

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
    void initialize() {
        assert helloer != null : "fx:id=\"helloer\" was not injected: check your FXML file 'UserLoggedIn.fxml'.";
        assert yourPasswordIs != null : "fx:id=\"yourPasswordIs\" was not injected: check your FXML file 'UserLoggedIn.fxml'.";
        assert yourUsernameIs != null : "fx:id=\"yourUsernameIs\" was not injected: check your FXML file 'UserLoggedIn.fxml'.";
        assert yourIDIs != null : "fx:id=\"yourIDIs\" was not injected: check your FXML file 'UserLoggedIn.fxml'.";
        assert LogOut != null : "fx:id=\"LogOut\" was not injected: check your FXML file 'UserLoggedIn.fxml'.";
        helloer.setText("Hello " + Controller.users.get(Controller.index).getUserName());
        yourUsernameIs.setText("Your Username is: " + Controller.users.get(Controller.index).getUserName());
        yourPasswordIs.setText("Your Password is: " + Controller.users.get(Controller.index).getPassword());
        yourIDIs.setText("Your ID is: " + Controller.users.get(Controller.index).getID());

    }
}
