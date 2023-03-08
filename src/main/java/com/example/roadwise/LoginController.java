package com.example.roadwise;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import java.sql.*;

public class LoginController implements Initializable {


    public Button loginButton;
    @FXML
    public PasswordField passwordField;
    public AnchorPane rightSide;
    public AnchorPane leftSide;
    //exit
    private Scene scene;

    private Parent root;

    private StackPane rootPane;
    @FXML
    private AnchorPane scenePane;
    Stage stage;
    public void exit(ActionEvent E) throws InterruptedException {

        stage = (Stage) scenePane.getScene().getWindow();

        stage.close();
    }
    //animations
    @FXML
    private ImageView roadImage;

    @FXML
    private ImageView carImage;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        //road
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(roadImage);
        translate.setDuration(Duration.millis(20000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(-3000);
        translate.play();

        TranslateTransition transCar = new TranslateTransition();
        transCar.setNode(carImage);
        transCar.setDuration(Duration.millis(2000));
        transCar.setCycleCount(TranslateTransition.INDEFINITE);
        transCar.setByX(-20);
        transCar.setByY(6);
        transCar.setAutoReverse(true);
        transCar.play();


    }

    //login
    public void login(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public TextField usernameField;

    Connection con;
    PreparedStatement prep;

    ResultSet rs;

        public void getConnection(){
            String databaseName = "roadwi_accounts";

            try {
                String username = "roadwi_nathan";
                String password = "q12345";
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:roadwi-accounts.db.transip.me:3306"+databaseName;


                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println(conn.isValid(5));

                String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?";
                PreparedStatement prep = conn.prepareStatement(sql);
                prep.setString(1, usernameField.getText());
                prep.setString(2, passwordField.getText());

                ResultSet resultSet = prep.executeQuery();

                if (resultSet.next()) {
                    System.out.println("success");
                }
                else {
                    System.out.println("invalid");
                }



            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    public void loginCheck(ActionEvent event){
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("") || password.equals("")){
            System.out.println("blank");

        }
        else {
            getConnection();
        }
    }
}
