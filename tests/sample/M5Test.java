package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class M5Test extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        TwoExitRoomController.end();
        Parent mainNode = FXMLLoader.load(Main.class.getResource("WelcomeScreen.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testReturn() {
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
        clickOn("#inventoryBtn");
        clickOn("#backBtn");
        Text text1 = lookup("#roomHead").query();
        assertEquals(text1.getText(), "Room 2");

    }

    @Test
    public void testDaggerInventory() throws InterruptedException {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
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
        clickOn("#exit1");
        clickOn("#inventoryBtn");
        Object obj = lookup("#sword").query();
        assertNotNull(obj);


    }

    @Test
    public void testSwordInventory() {
        Text text = lookup("#titleText").query();
        assertEquals(text.getText(), "Dungeon Crawler");
        clickOn("#welScreenButton");
        sleep(1500);
        clickOn("#nameText");
        write("Thook");
        clickOn("#difficultyChoice");
        clickOn("Hard");
        clickOn("#weaponChoice");
        clickOn("Sword");
        clickOn("#confirmButton");
        sleep(1500);
        clickOn("#exit1");
        clickOn("#inventoryBtn");
        Object obj = lookup("#sword").query();
        assertNotNull(obj);

    }

    @Test
    public void testAxeInventory() {
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
        clickOn("#inventoryBtn");
        Object obj = lookup("#sword").query();
        assertNotNull(obj);
    }

    @Test
    public void testPotionUse() {
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
        sleep(1500);
        while (InventoryScreenController.hPotions != 0) {
            while (TwoExitRoomController.monsterHealth > 0) {
                clickOn("#attackBtn");
                clickOn("#hitBtn");
                sleep(1500);
            }
            int h = TwoExitRoomController.playerHealth;
            int x = (int) (Math.round(Math.random())) + 1;
            if (x == 1) {
                clickOn("#exit1");
            } else {
                clickOn("#exit2");
            }
            clickOn("#inventoryBtn");
            clickOn("#hPotBtn");
        }
    }

    @Test
    public void testHealthPotion() {
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
        sleep(1500);
        clickOn("#inventoryBtn");
        assertTrue(InventoryScreenController.hPotions > 0);

    }


    @Test
    public void testHealthBoost() {
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
        sleep(1500);
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        int h = TwoExitRoomController.playerHealth;
        int x = (int) (Math.round(Math.random())) + 1;
        if (x == 1) {
            clickOn("#exit1");
        } else {
            clickOn("#exit2");
        }
        clickOn("#inventoryBtn");
        clickOn("#hPotBtn");
        assertTrue(TwoExitRoomController.playerHealth > h);
    }

    @Test
    public void testAttackBoost() {
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
        sleep(1500);
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        int h = TwoExitRoomController.playerHealth;
        int x = (int) (Math.round(Math.random())) + 1;
        if (x == 1) {
            clickOn("#exit1");
        } else {
            clickOn("#exit2");
        }
        clickOn("#inventoryBtn");
        clickOn("#aPotBtn");
        assertTrue(TwoExitRoomController.attackBonus > 0);
    }

    @Test
    public void testSecondWeapon() {
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
        sleep(1500);
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        int x = (int) (Math.round(Math.random())) + 1;
        if (x == 1) {
            clickOn("#exit1");
        } else {
            clickOn("#exit2");
        }
        clickOn("#inventoryBtn");
        assertNotNull("#staff");
    }


    @Test
    public void testSwitchWeapon() {
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
        sleep(1500);
        while (TwoExitRoomController.monsterHealth > 0) {
            clickOn("#attackBtn");
            clickOn("#hitBtn");
            sleep(1500);
        }
        int x = (int) (Math.round(Math.random())) + 1;
        if (x == 1) {
            clickOn("#exit1");
        } else {
            clickOn("#exit2");
        }
        clickOn("#inventoryBtn");
        clickOn("#staff");
        assertNotNull("#staff");
    }
}