package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryScreenController implements Initializable {
    protected static int hPotions = 1;
    protected static int aPotions = 1;
    protected static int gApple = 1;
    protected static boolean newWeapon = false;
    @FXML
    private Text hp;
    @FXML
    private Text hPot;
    @FXML
    private Text aPot;
    @FXML
    private Text gAp;
    @FXML
    private Circle circ;
    @FXML
    private ImageView staff;
    @FXML
    private ImageView dagger;
    @FXML
    private ImageView axe;
    @FXML
    private ImageView sword;
    private static boolean select;

    public void initialize(URL url, ResourceBundle rb) {
        if (newWeapon) {
            staff.setVisible(true);
            if (select) {
                StackPane.setMargin(circ, new Insets(0, 0, 475, 510));
            }
        } else {
            select = false;
            StackPane.setMargin(circ, new Insets(0, 0, 475, -50));
            staff.setVisible(false);
        }
        hp.setText("HP: " + TwoExitRoomController.playerHealth);
        hPot.setText("" + hPotions);
        aPot.setText("" + aPotions);
        gAp.setText("" + gApple);
        dagger.setVisible(false);
        axe.setVisible(false);
        sword.setVisible(false);
        if (InitialConfigController.weap.equals("Dagger")) {
            dagger.setVisible(true);
        } else if (InitialConfigController.weap.equals("Axe")) {
            axe.setVisible(true);
        } else {
            sword.setVisible(true);
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TwoExitRoom.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void hPotion(ActionEvent actionEvent) throws IOException {
        if (hPotions > 0) {
            TwoExitRoomController.playerHealth += 10;
            hPotions--;
            hp.setText("HP: " + TwoExitRoomController.playerHealth);
            hPot.setText("" + hPotions);
        }
    }

    public void aPotion(ActionEvent actionEvent) throws IOException {
        if (aPotions > 0) {
            TwoExitRoomController.attackBonus += 10;
            aPotions--;
            hp.setText("HP: " + TwoExitRoomController.playerHealth);
            aPot.setText("" + aPotions);
        }
    }

    public void gApple(ActionEvent actionEvent) throws IOException {
        if (gApple > 0) {
            TwoExitRoomController.playerHealth += 20;
            TwoExitRoomController.attackBonus += 20;
            gApple--;
            hp.setText("HP: " + TwoExitRoomController.playerHealth);
            gAp.setText("" + gApple);
        }
    }

    public void select1(MouseEvent mouseEvent) {
        select = false;
        StackPane.setMargin(circ, new Insets(0, 0, 475, -50));
    }

    public void select2(MouseEvent mouseEvent) {
        if (newWeapon) {
            select = true;
            StackPane.setMargin(circ, new Insets(0, 0, 475, 510));
        }
    }


}
