package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Room1Controller implements Initializable {
    @FXML
    private Text gold;
    private String name;
    private String diff;
    private String weap;
    protected static int money;
    protected static int exitNum;
    @FXML
    private Button exit1;
    @FXML
    private Button exit2;
    @FXML
    private Button exit3;
    @FXML
    private Button exit4;

    public void initialize(URL url, ResourceBundle rb) {
        exit1.setVisible(true);
        exit2.setVisible(true);
        exit3.setVisible(true);
        exit4.setVisible(true);
        name = InitialConfigController.name;
        diff = InitialConfigController.diff;
        weap = InitialConfigController.weap;
        if (diff.equals("Easy")) {
            money = 1500;
        } else if (diff.equals("Medium")) {
            money = 1000;
        } else {
            money = 500;
        }
        gold.setText("Gold: " + money);
        if (TwoExitRoomController.lastIsStartingRoom) {
            if (TwoExitRoomController.lastExit == 1) {
                exit2.setVisible(false);
                exit3.setVisible(false);
                exit4.setVisible(false);
            } else if (TwoExitRoomController.lastExit == 2) {
                exit1.setVisible(false);
                exit3.setVisible(false);
                exit4.setVisible(false);
            } else if (TwoExitRoomController.lastExit == 3) {
                exit2.setVisible(false);
                exit1.setVisible(false);
                exit4.setVisible(false);
            } else {
                exit2.setVisible(false);
                exit1.setVisible(false);
                exit3.setVisible(false);
            }
        }
    }

    public void exit1(ActionEvent actionEvent) throws IOException {
        exitNum = 1;
        nextScreen(actionEvent);
    }

    public void exit2(ActionEvent actionEvent) throws IOException {
        exitNum = 2;
        nextScreen(actionEvent);
    }

    public void exit3(ActionEvent actionEvent) throws IOException {
        exitNum = 3;
        nextScreen(actionEvent);
    }

    public void exit4(ActionEvent actionEvent) throws IOException {
        exitNum = 4;
        nextScreen(actionEvent);
    }

    public void nextScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TwoExitRoom.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

}
