package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LossScreenController implements Initializable {

    @FXML
    private Text roomHead;
    @FXML
    private Text monst;
    @FXML
    private Text mny;
    @FXML
    private Text room;


    public void restart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void close(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) roomHead.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monst.setText("Monsters Killed: " + TwoExitRoomController.outMonsters);
        mny.setText("Money Obtained: " + TwoExitRoomController.outMoney);
        room.setText("Rooms Visited: " + TwoExitRoomController.outRooms);
    }
}
