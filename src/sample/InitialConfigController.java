package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitialConfigController implements Initializable {

    @FXML
    private ChoiceBox<String> weaponChoice;
    @FXML
    private ChoiceBox<String> difficultyChoice;
    @FXML
    private Text incorrectConfig;
    @FXML
    private Text configTitleTest;
    @FXML
    private Text configNameTitle;
    @FXML
    private TextField nameText;

    private ObservableList weapons = FXCollections.observableArrayList();
    private ObservableList difficulties = FXCollections.observableArrayList();
    protected static String name;
    protected static String diff;
    protected static String weap;

    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }


    private void loadData() {
        weapons.removeAll(weapons);
        difficulties.removeAll(difficulties);
        String a = "Dagger";
        String b = "Sword";
        String c = "Axe";
        String d = "Easy";
        String e = "Medium";
        String f = "Hard";
        weapons.addAll(a, b, c);
        difficulties.addAll(d, e, f);
        weaponChoice.getItems().addAll(weapons);
        difficultyChoice.getItems().addAll(difficulties);
    }


    public void config(ActionEvent actionEvent) throws IOException {
        name = nameText.getText();
        diff = difficultyChoice.getValue();
        weap = weaponChoice.getValue();

        if (name == null || name.replaceAll("\\s", "").equals("") || diff == null || weap == null) {
            incorrectConfig.setText("Incorrect values, please try again.");
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("Initial Game Screen.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        }
    }


}
