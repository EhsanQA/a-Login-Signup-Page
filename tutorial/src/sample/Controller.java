package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {

    static ArrayList<User> users = new ArrayList<>();
    final ObservableList<String> types = FXCollections.observableArrayList("User", "Admin");
    static int index;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label fillIn;

    @FXML
    private Label chooseLoginForm;


    @FXML
    private static Button login;

    @FXML
    private Button goSignupPage;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    void loginUser(ActionEvent event) throws IOException {
        chooseLoginForm.setText("");
        fillIn.setText("");
        if (!(comboBox.getValue() == null)) {
            if (comboBox.getValue().equals("User")) {
                if (username.getText().isBlank() || password.getText().isBlank()) {
                    fillIn.setText("*Please Fill in the Fields");
                } else if (userSearcher(username.getText(), password.getText())) {
                    Parent root = FXMLLoader.load(getClass().getResource("UserLoggedIn.fxml"));
                    Scene userLoggedInScene = new Scene(root, 605, 600);
                    Stage userLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    userLoggedInStage.setTitle(users.get(index).getUserName() +"'s Page");
                    userLoggedInStage.setScene(userLoggedInScene);
                    userLoggedInStage.setResizable(false);
                    userLoggedInStage.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Incorrect Username or Password");
                    alert.show();
                }
            }
            if (comboBox.getValue().equals("Admin")) {
                if (username.getText().isBlank() || password.getText().isBlank()) {
                    fillIn.setText("*Please Fill in the Fields");

                } else if (username.getText().equals("admin") && password.getText().equals("admin")) {
                    Parent root = FXMLLoader.load(getClass().getResource("adminLoggedIn.fxml"));
                    Scene adminLoggedInScene = new Scene(root, 605, 600);
                    Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    adminLoggedInStage.setTitle("Admin Page");
                    adminLoggedInStage.setScene(adminLoggedInScene);
                    adminLoggedInStage.setResizable(false);
                    adminLoggedInStage.show();
                } else {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setContentText("Incorrect Username or Password");
                    alert2.show();
                }
            }
        }
        else {
            chooseLoginForm.setText("*Please Choose Your Login Form");
        }
    }

    static void addUser(String username, String password, String ID) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setID(ID);
        users.add(user);
    }

    public boolean userSearcher(String username, String password) {
        boolean exists = false;
        for (int i = 0; i < users.size(); i++) {
            index = i;
            if (users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    @FXML
    void registerYourSelf(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registrationForm.fxml"));
        Scene adminAddingScene = new Scene(root, 605, 600);
        Stage adminAddingStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminAddingStage.setTitle("Signing Up");
        adminAddingStage.setScene(adminAddingScene);
        adminAddingStage.setResizable(false);
        adminAddingStage.show();
    }

    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'sample.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'sample.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'sample.fxml'.";
        assert goSignupPage != null : "fx:id=\"goSignupPage\" was not injected: check your FXML file 'sample.fxml'.";
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'sample.fxml'.";

        addUser("Ehsan", "EhsanEhsan", "12345");
        addUser("Dave", "123", "555");
        comboBox.setItems(types);


    }
}
