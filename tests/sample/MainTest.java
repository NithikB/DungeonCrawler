package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("WelcomeScreen.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testWelcomeScreenTitle() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
    }

    @Test
    public void testWelcomeScreenButtonTitle() {
        Node button = lookup("#welScreenButton").query();
        assertNotNull(button);
    }

    @Test
    public void testWelcomeScreenButton() {
        clickOn("#welScreenButton");
        sleep(1500);
        Text text = lookup("#configTitleTest").query();
        assertEquals(text.getText(), "Configure The Game");
    }

    @Test
    public void testWelcomeScreenButtonToNameTitle() {
        clickOn("#welScreenButton");
        sleep(1500);
        Text text1 = lookup("#configTitleTest").query();
        assertEquals(text1.getText(), "Configure The Game");
        clickOn("#nameText");
        write("Thook");
        TextField text = lookup("#nameText").query();
        assertEquals(text.getText(), "Thook");
    }

    @Test
    public void testDifficulty() {
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        sleep(1500);
        ChoiceBox text = lookup("#difficultyChoice").query();
        assertEquals(text.getValue(), "Hard");

    }

    @Test
    public void testNameNull() {
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#incorrectConfig").query();
        assertEquals(text.getText(), "Incorrect values, please try again.");
    }

    @Test
    public void testNameWhiteSpace() {
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("    ");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#incorrectConfig").query();
        assertEquals(text.getText(), "Incorrect values, please try again.");
    }

    @Test
    public void testWeapon() {
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        sleep(1500);
        ChoiceBox text = lookup("#weaponChoice").query();
        assertEquals(text.getValue(), "Axe");

    }

    @Test
    public void testGoldLevelEasy() {
        //valid inputs
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Easy");
        clickOn("#weaponChoice");
        clickOn("Sword");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#gold").query();
        assertEquals(text.getText(), "Gold: 1500");
    }

    @Test
    public void testGoldLevelMedium() {
        //valid inputs
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Medium");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#gold").query();
        assertEquals(text.getText(), "Gold: 1000");
    }

    @Test
    public void testGoldLevelHard() {
        //valid inputs
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Dagger");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#gold").query();
        assertEquals(text.getText(), "Gold: 500");
    }

    @Test
    public void testDifficultyNull() {
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#incorrectConfig").query();
        assertEquals(text.getText(), "Incorrect values, please try again.");
    }

    @Test
    public void testWeaponNull() {
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#incorrectConfig").query();
        assertEquals(text.getText(), "Incorrect values, please try again.");
    }

    @Test
    public void testGameScreenExits() {
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Axe");
        clickOn("#confirmButton");
        sleep(1500);
        Text text = lookup("#Exit1").query();
        assertEquals(text.getText(), "Exit 1");
        Text text2 = lookup("#Exit2").query();
        assertEquals(text2.getText(), "Exit 2");
        Text text3 = lookup("#Exit3").query();
        assertEquals(text3.getText(), "Exit 3");
        Text text4 = lookup("#Exit4").query();
        assertEquals(text4.getText(), "Exit 4");
    }

}