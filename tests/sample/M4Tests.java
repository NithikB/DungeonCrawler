package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class M4Tests extends ApplicationTest {

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
    public void testMonster() {
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
        Node button = lookup("#attackBtn").query();
        assertNotNull(button);

    }

    @Test
    public void testPlayerHealth() throws InterruptedException {
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
        clickOn("#attackBtn");
        clickOn("#hitBtn");
        assertTrue(TwoExitRoomController.playerHealth <= 100);

    }

    @Test
    public void testMonsterHealth() {
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
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        assertTrue(TwoExitRoomController.monsterHealth == 0);

    }

    @Test
    public void testDeathRestart() {
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
        TwoExitRoomController.playerHealth = 10;
        if (TwoExitRoomController.playerHealth > 0) {
            if (TwoExitRoomController.monsterHealth > 0) {
                clickOn("#attackBtn");
                clickOn("#hitBtn");
                sleep(1500);
            } else {
                clickOn("exit2");
            }
        } else {
            clickOn("#restartButton");
            sleep(1500);
            Text text1 = lookup("#titleText").query();
            assertEquals(text1.getText(), "Dungeon Crawler");

        }
    }

    @Test
    public void testDeathExit() {
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
        TwoExitRoomController.playerHealth = 10;
        if (TwoExitRoomController.playerHealth > 0) {
            if (TwoExitRoomController.monsterHealth > 0) {
                clickOn("#attackBtn");
                clickOn("#hitBtn");
                sleep(1500);
            } else {
                clickOn("exit2");
            }
        } else {
            clickOn("#exitButton");
        }
    }

    @Test
    public void testGold() {
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
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        assertTrue(TwoExitRoomController.money > 500);
    }

    @Test
    public void testRetreat() {
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
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#exit1");
        clickOn("#prevBtn");
        Text text1 = lookup("#roomHead").query();
        assertEquals(text1.getText(), "Room 2");

    }

    @Test
    public void testRetreatReturn() {
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
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        clickOn("#exit1");
        clickOn("#prevBtn");
        Node button = lookup("#exit2").query();
        assertNotNull(button);
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
        clickOn("#exit1");
        int counter = 0;
        int y = TwoExitRoomController.monsterHealth;
        int x = 0;
        do {
            if (TwoExitRoomController.monsterHealth > 0) {
                x = TwoExitRoomController.monsterHealth;
                clickOn("#attackBtn");
                clickOn("#hitBtn");
                sleep(1500);
            } else {
                clickOn("exit2");
                counter++;
            }
        }
        while (counter < 5 && y != x);

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
        clickOn("#exit1");
        int counter = 0;
        int x = TwoExitRoomController.monsterHealth;
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
            counter++;
        }
        assertTrue(x == counter * 50);
    }
}