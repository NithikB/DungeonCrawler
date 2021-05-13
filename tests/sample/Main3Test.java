package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.service.query.EmptyNodeQueryException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Main3Test extends ApplicationTest {

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
    public void testRoom1Exit1() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit1");
        Text text1 = lookup("#RoomHead").query();
        assertEquals(text1.getText(), "Room 2");

    }

    @Test
    public void testRoom1Exit2() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit2");
        Text text1 = lookup("#RoomHead").query();
        assertEquals(text1.getText(), "Room 3");
    }

    @Test
    public void testRoom1Exit3() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit3");
        Text text1 = lookup("#RoomHead").query();
        assertEquals(text1.getText(), "Room 4");
    }

    @Test
    public void testRoom1Exit4() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit4");
        Text text1 = lookup("#RoomHead").query();
        assertEquals(text1.getText(), "Room 5");
    }

    @Test
    public void testRoom2Exit1() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit4");
        sleep(1500);
        clickOn("#exit1");
        Text text1 = lookup("#RoomHead").query();
        assertEquals(text1.getText(), "Room 6");

    }

    @Test
    public void testRoom2Exit2() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit4");
        sleep(1500);
        clickOn("#exit2");
        Text text1 = lookup("#RoomHead").query();
        assertEquals(text1.getText(), "Room 7");
    }

    @Test
    public void testExitRoom() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit4");
        sleep(1500);
        boolean bool = true;
        while (bool) {
            int x = (int) (Math.round(Math.random())) + 1;
            if (x == 1) {
                clickOn("#exit1");
            } else {
                clickOn("#exit2");
            }
            try {
                Text text1 = lookup("#gold").query();
                assertNotNull(text1.getText());
            } catch (EmptyNodeQueryException e) {
                bool = false;
                break;
            }
        }
        clickOn("#continueButton");
        Text text2 = lookup("#roomHead").query();
        assertEquals(text2.getText(), "CONGRATULATIONS BRAVE ADVENTURER");
    }

    @Test
    public void testExitGame() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit4");
        sleep(1500);
        boolean bool = true;
        while (bool) {
            int x = (int) (Math.round(Math.random())) + 1;
            if (x == 1) {
                clickOn("#exit1");
            } else {
                clickOn("#exit2");
            }
            try {
                Text text1 = lookup("#gold").query();
                assertNotNull(text1.getText());
            } catch (EmptyNodeQueryException e) {
                bool = false;
                break;
            }
        }
        clickOn("#continueButton");
        clickOn("#exitButton");
    }

    @Test
    public void testRestartGame() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit4");
        sleep(1500);
        boolean bool = true;
        while (bool) {
            int x = (int) (Math.round(Math.random())) + 1;
            if (x == 1) {
                clickOn("#exit1");
            } else {
                clickOn("#exit2");
            }
            try {
                Text text1 = lookup("#gold").query();
                assertNotNull(text1.getText());
            } catch (EmptyNodeQueryException e) {
                bool = false;
                break;
            }
        }
        clickOn("#continueButton");
        clickOn("#restartButton");
        Text text2 = lookup("#titleText").query();
        assertEquals(text2.getText(), "Dungeon Crawler");
    }

    @Test
    public void test2ExitRoom() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit4");
        sleep(1500);
        Button text1 = lookup("#exit1").query();
        assertEquals(text1.getText(), "Exit 1");
        Button text2 = lookup("#exit2").query();
        assertEquals(text2.getText(), "Exit 2");
    }

}